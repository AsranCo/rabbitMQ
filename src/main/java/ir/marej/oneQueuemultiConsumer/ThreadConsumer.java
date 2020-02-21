package ir.marej.oneQueuemultiConsumer;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadConsumer {
    private static Logger logger = LogManager.getLogger(ThreadConsumer.class);

    public static void main(String[] args) {

        int nThreads=5;
        try {

            ExecutorService threadPool = Executors.newFixedThreadPool(nThreads+1);
            //Consumers
            for (int i = 0 ;i<nThreads;++i){
                threadPool.execute(new Consumer("Consumer " + String.valueOf(i+1)));
            }

            threadPool.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("An InterruptedException was caught: " + e.getMessage());
        }
    }
}
