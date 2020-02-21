package ir.marej.exchangeDirectniMissing;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQConnection {

    public static Connection getConnection(){

        Connection conn = null;

        try{

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("test");
            factory.setUsername("admin");
            factory.setPassword("pass");

            conn = factory.newConnection();

        }catch(Exception e){

            e.printStackTrace();

        }

        return conn;

    }

}