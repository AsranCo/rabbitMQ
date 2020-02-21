package ir.marej.exchangeDirect;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLogDirect {

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("test");
        factory.setUsername("admin");
        factory.setPassword("pass");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);


            String severityI = "info-key";
            String messageI = " Hello World!";

            String severityE = "error-key";
            String messageE = "Hello World!";


            channel.basicPublish(EXCHANGE_NAME, severityI, null, messageI.getBytes("UTF-8"));
            channel.basicPublish(EXCHANGE_NAME, severityE, null, messageE.getBytes("UTF-8"));
            }
    }

}

