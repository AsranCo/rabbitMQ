package ir.asran.exchangeDirectniMissing;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class EmitLogDirect {

    private final static String MESSAGE_1 = "First Direct Message Example";

    private final static String MESSAGE_2 = "Second Direct Message Example";


    public void publish(){

        try{

            Connection conn = RabbitMQConnection.getConnection();

            if(conn != null){

                Channel channel = conn.createChannel();

                channel.basicPublish(DirectExchange.EXCHANGE_NAME, DirectExchange.ROUTING_KEY_1, null, MESSAGE_1.getBytes());
                System.out.println(" Message Sent '" + MESSAGE_1 + "'");

                channel.basicPublish(DirectExchange.EXCHANGE_NAME, DirectExchange.ROUTING_KEY_2, null, MESSAGE_2.getBytes());
                System.out.println(" Message Sent '" + MESSAGE_2 + "'");


                channel.close();
                conn.close();

            }

        }catch(Exception e){

            e.printStackTrace();

        }

    }

}


