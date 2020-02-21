package ir.marej.exchangeFanoutnoMissing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import ir.marej.oneQueueoneConsumer.Consumer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmitLog {
    private static Logger logger = LogManager.getLogger(EmitLog.class);

    private final static String MESSAGE = "Hello Fanout Example";

    public static void main(String[] argv) throws Exception {

        try (
                Connection conn = RabbitMQConnection.getConnection();


                Channel channel = conn.createChannel()) {

            channel.basicPublish(FanoutExchange.EXCHANGE_NAME, FanoutExchange.ROUTING_KEY, null, MESSAGE.getBytes());

            logger.info(" Message Sent '" + MESSAGE + "'");


        }


    }
}