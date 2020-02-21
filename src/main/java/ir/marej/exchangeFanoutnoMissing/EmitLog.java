package ir.marej.exchangeFanoutnoMissing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLog {

    private final static String MESSAGE = "Hello Fanout Example";

    public static void main(String[] argv) throws Exception {

        try (
                Connection conn = RabbitMQConnection.getConnection();


                Channel channel = conn.createChannel()) {

            channel.basicPublish(FanoutExchange.EXCHANGE_NAME, FanoutExchange.ROUTING_KEY, null, MESSAGE.getBytes());

            System.out.println(" Message Sent '" + MESSAGE + "'");


        }


    }
}