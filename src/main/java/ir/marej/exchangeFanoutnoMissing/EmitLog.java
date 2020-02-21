package ir.marej.exchangeFanoutnoMissing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLog {

    private final static String MESSAGE = "Hello Fanout Example";
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
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {


            channel.exchangeDeclare(EXCHANGE_NAME, "fanout", false);

            channel.queueDeclare(QUEUE_NAME_1, true, false, false, null);

            channel.queueBind(QUEUE_NAME_1, EXCHANGE_NAME, ROUTING_KEY);

            channel.queueDeclare(QUEUE_NAME_2, true, false, false, null);

            channel.queueBind(QUEUE_NAME_2, EXCHANGE_NAME, ROUTING_KEY);

            channel.queueDeclare(QUEUE_NAME_3, true, false, false, null);

            channel.queueBind(QUEUE_NAME_3, EXCHANGE_NAME, ROUTING_KEY);


            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, MESSAGE.getBytes());

            System.out.println(" Message Sent '" + MESSAGE + "'");


        }

    }
}