package ir.asran.exchangeFanoutnoMissing;

import com.rabbitmq.client.*;

import java.io.IOException;

public class ReceiveLogs {

    public static void main(String[] argv) throws Exception {

        try {

            Connection conn = RabbitMQConnection.getConnection();
            Channel channel = conn.createChannel();


            Consumer consumer1 = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" Message Received Queue 1 '" + message + "'");
                }
            };
            channel.basicConsume(FanoutExchange.QUEUE_NAME_1, true, consumer1);



            Consumer consumer2 = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" Message Received Queue 2 '" + message + "'");
                }
            };
            channel.basicConsume(FanoutExchange.QUEUE_NAME_2, true, consumer2);



            Consumer consumer3 = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" Message Received Queue 3 '" + message + "'");
                }
            };
            channel.basicConsume(FanoutExchange.QUEUE_NAME_3, true, consumer3);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


}

