package edu.umb.cs680.observer;

public class StockEvent {
    
    private String ticker;
    private double qoute;

    public StockEvent(String ticker, double qoute) {
        this.ticker = ticker;
        this.qoute = qoute;
    }

    public String getTicker() {
        return ticker;
    }

    public double getQoute() {
        return qoute;
    }
}
