package ir.marej.exchangeDirectniMissing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class DirectExchange {

    public static String EXCHANGE_NAME = "direct_logs";

    public static final String SEVERITY_QUEUE_I = "info_logs";
    public static final String SEVERITY_QUEUE_E = "error_logs";


    public static String ROUTING_KEY_1 = "direct-key-1";
    public static String ROUTING_KEY_2 = "direct-key-2";


    public void createExchangeAndQueue() {

        try {

            Connection conn = RabbitMQConnection.getConnection();

            if (conn != null) {

                Channel channel = conn.createChannel();

                channel.exchangeDeclare(EXCHANGE_NAME, ExchangeType.DIRECT.getExchangeName(), false);

                channel.queueDeclare(SEVERITY_QUEUE_I, false, false, false, null);
                channel.queueBind(SEVERITY_QUEUE_I, EXCHANGE_NAME, ROUTING_KEY_1);

                channel.queueDeclare(SEVERITY_QUEUE_E, false, false, false, null);
                channel.queueBind(SEVERITY_QUEUE_E, EXCHANGE_NAME, ROUTING_KEY_2);


                channel.close();
                conn.close();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}