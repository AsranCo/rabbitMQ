package ir.asran.exchangeDirectniMissing;

import com.rabbitmq.client.*;

import java.io.IOException;

public class ReceiveLogsDirect {

    public void receive(){

        try{

            Connection conn = RabbitMQConnection.getConnection();

            if(conn != null){

                Channel channel = conn.createChannel();

                Consumer consumer1 = new DefaultConsumer(channel) {

                    @Override

                    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                        String message = new String(body, "UTF-8");

                        System.out.println(" Message Received Queue 1 '" + message + "'");

                    }

                };

                channel.basicConsume(DirectExchange.SEVERITY_QUEUE_I, true, consumer1);


                Consumer consumer2 = new DefaultConsumer(channel) {

                    @Override

                    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                        String message = new String(body, "UTF-8");

                        System.out.println(" Message Received Queue 2 '" + message + "'");

                    }

                };

                channel.basicConsume(DirectExchange.SEVERITY_QUEUE_E, true, consumer2);



//                channel.close();
//
//                conn.close();

            }

        }catch(Exception e){

            e.printStackTrace();

        }

    }

}
