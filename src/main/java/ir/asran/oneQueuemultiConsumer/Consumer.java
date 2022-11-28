package ir.asran.oneQueuemultiConsumer;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

//@Component
public class Consumer implements Runnable {
    private static Logger logger = LogManager.getLogger(Consumer.class);


    private String name;
    public Consumer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("test");
            factory.setUsername("admin");
            factory.setPassword("pass");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare("test-1p2c", true, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '"+this.name+ " " + message + "'");
            };

            channel.basicConsume("test-1q2c", true, deliverCallback, consumerTag -> {
            });

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }



    }

}
