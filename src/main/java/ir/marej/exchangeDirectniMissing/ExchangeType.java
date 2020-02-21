package ir.marej.exchangeDirectniMissing;

public enum ExchangeType {

    DIRECT("direct"),
    FANOUT("fanout"),
    RPC("rpc");


    private final String exchangeName;

    ExchangeType(String exchangeName) {

        this.exchangeName = exchangeName;

    }

    public String getExchangeName() {

        return this.exchangeName;

    }

}