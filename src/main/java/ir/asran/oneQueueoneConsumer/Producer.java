package ir.asran.oneQueueoneConsumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Producer {
    private static Logger logger = LogManager.getLogger(Producer.class);

    public static void main(String[] args) {


        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("test");
        factory.setUsername("admin");
        factory.setPassword("pass");

        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare("test-1q1c", false, false, false, null);
//            channel.queueDeclare("test-file", false, false, false, null);

            try (Stream<Path> walk = Files.walk(Paths.get("/home/ali/Template/target/total"))) {

                List<String> listFiles = walk.filter(Files::isRegularFile)
                        .map(x -> x.toString())
//                      .filter(p -> p.toString().endsWith(".csv"))
                        .filter(p -> !p.toString().contains(".processing"))
                        .filter(p -> !p.toString().contains(".processed"))

                        .collect(Collectors.toList());
                logger.info("Start load record on queue");
                long start = System.nanoTime();
                //send record to queue

                for (String filePath : listFiles) {
                    File file = new File(filePath);
                    File processingFile = new File(filePath + ".processing");// rename to indicate that processing file
                    File processedFile = new File(filePath + ".processed");// rename to indicate that processed file

                    if (!processingFile.exists() && !processedFile.exists()
                            && !filePath.endsWith(".processing") && !filePath.endsWith(".processed")) {

                        if (file.renameTo(processingFile)) {//if renamed successfully
                            BufferedReader reader = Files.newBufferedReader(Paths.get(processingFile.getAbsolutePath()));
                            String line;
                            while ((line = reader.readLine()) != null) {
                                try {
                                    channel.basicPublish("", "test-1q1c", null, line.getBytes());


                                } catch (Exception e) {
                                    e.printStackTrace();
                                    logger.error(e.getMessage());
                                }
                            }

                            //finished reading a file
                            processingFile.renameTo(processedFile);
                            // processingFile.delete();// delete .processing file
                        }


                    }

                }

                long end = System.nanoTime();
                logger.info("Published  messages individually in: " +  Duration.ofNanos(end - start).toMillis() + " ms");

//                System.out.format("Published  messages individually in %,d ms%n",  Duration.ofNanos(end - start).toMillis());

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}