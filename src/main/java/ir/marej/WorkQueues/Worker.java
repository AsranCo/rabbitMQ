//package ir.marej.WorkQueues;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//import com.rabbitmq.client.QueueingConsumer;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
//
//public class Worker {
//    private final static String QUEUE_NAME = "task_queues";
//
//    public static void main(String[] argv) throws IOException, InterruptedException, TimeoutException {
//
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("test");
//        factory.setUsername("admin");
//        factory.setPassword("pass");
//        Connection connection = factory.newConnection();
//        Channel channel = connection.createChannel();
//
//        //Message durability
//        boolean durable = true;
//        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
//        System.out.println("Waiting for messages. To exit press CTRL+C");
//
//        //Fair dispatch
//        channel.basicQos(1);
//
//        QueueingConsumer consumer = new QueueingConsumer(channel);
//
//        //Message acknowledgment
//        boolean autoAck = false;
//        channel.basicConsume(QUEUE_NAME, autoAck, consumer);
//
//        while (true) {
//            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//            String message = new String(delivery.getBody());
//
//            System.out.println(" [x] Received '" + message + "'");
//            //Message acknowledgment
//            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
//            System.out.println(" [x] Done");
//
//            Thread.sleep(3000);
//        }
//
//    }
//}
