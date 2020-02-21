package ir.marej.exchangeDirectniMissing;

public class Demo {

    public static void main(String args[]){

        try{

            DirectExchange ex = new DirectExchange();

            ex.createExchangeAndQueue();

            EmitLogDirect produce = new EmitLogDirect();

            produce.publish();

            ReceiveLogsDirect receive = new ReceiveLogsDirect();

            receive.receive();

        }catch(Exception e){

            e.printStackTrace();

        }

    }

}