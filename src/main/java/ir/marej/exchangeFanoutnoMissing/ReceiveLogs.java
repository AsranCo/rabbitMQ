package ir.marej.exchangeFanoutnoMissing;

import com.rabbitmq.client.*;

import java.io.IOException;

public class ReceiveLogs {
    public static String EXCHANGE_NAME = "fanout_logs";
    public static String QUEUE_NAME_1 = "fanout-queue-1";
    public static String QUEUE_NAME_2 = "fanout-queue-2";
    public static String QUEUE_NAME_3 = "fanout-queue-3";
    public static String ROUTING_KEY = "";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("test");
        factory.setUsername("admin");
        factory.setPassword("pass");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        Consumer consumer1 = new DefaultConsumer(channel) {

            @Override

            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body, "UTF-8");

                System.out.println(" Message Received Queue 1 '" + message + "'");

            }

        };

        channel.basicConsume(QUEUE_NAME_1, true, consumer1);

        Consumer consumer2 = new DefaultConsumer(channel) {

            @Override

            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body, "UTF-8");

                System.out.println(" Message Received Queue 2 '" + message + "'");

            }

        };

        channel.basicConsume(QUEUE_NAME_2, true, consumer2);

        Consumer consumer3 = new DefaultConsumer(channel) {

            @Override

            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body, "UTF-8");

                System.out.println(" Message Received Queue 3 '" + message + "'");

            }

        };
        channel.basicConsume(QUEUE_NAME_3, true, consumer3);
    }
}