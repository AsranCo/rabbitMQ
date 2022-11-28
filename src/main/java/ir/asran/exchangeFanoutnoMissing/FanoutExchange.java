package ir.asran.exchangeFanoutnoMissing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class FanoutExchange {
    public static String EXCHANGE_NAME = "fanout_logs";

    public static String QUEUE_NAME_1 = "fanout-queue-1";

    public static String QUEUE_NAME_2 = "fanout-queue-2";

    public static String QUEUE_NAME_3 = "fanout-queue-3";

    public static String ROUTING_KEY = "";

    public void createExchangeAndQueue(){

        try{

            Connection conn = RabbitMQConnection.getConnection();

            if(conn != null){

                Channel channel = conn.createChannel();

                channel.exchangeDeclare(EXCHANGE_NAME, "fanout", false);


                channel.queueDeclare(QUEUE_NAME_1, false, true, false, null);
                channel.queueBind(QUEUE_NAME_1, EXCHANGE_NAME, ROUTING_KEY);

                channel.queueDeclare(QUEUE_NAME_2, false, true, false, null);
                channel.queueBind(QUEUE_NAME_2, EXCHANGE_NAME, ROUTING_KEY);

                channel.queueDeclare(QUEUE_NAME_3, false, true, false, null);
                channel.queueBind(QUEUE_NAME_3, EXCHANGE_NAME, ROUTING_KEY);


                channel.close();
                conn.close();

            }

        }catch(Exception e){

            e.printStackTrace();

        }

    }

}
