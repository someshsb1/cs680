package edu.umb.cs680.observer;

import java.util.HashMap;
import java.util.Map;

public class StockQuoteObservable extends Observable<StockEvent>{
    
    private Map<String, Double> stocQoutekMap = new HashMap<>();

    public void changeQoute(String t, double q) {
        stocQoutekMap.put(t, q);
        notifyObservers(new StockEvent(t, q)); //Update a map with t and q; notifyObservers(new StockEvent(t, q));
    }

    public static void main(String args[]) {
        
        StockQuoteObservable stockQuoteObservable = new StockQuoteObservable();
        Observer<StockEvent> lineChart = (sender, event) -> {
            System.out.println("Line Chart Observer, Ticker:" + event.getTicker() + "Quote :" + event.getQoute());
        };

        Observer<StockEvent> table = (sender, event) -> {
            System.out.println("Line Chart Observer, Ticker:" + event.getTicker() + "Quote :" + event.getQoute());
        };

        Observer<StockEvent> threeDO = (sender, event) -> {
            System.out.println("Line Chart Observer, Ticker :" + event.getTicker() + ", Quote :" + event.getQoute());
        };
        stockQuoteObservable.addObserver(lineChart);
        stockQuoteObservable.addObserver(table);
        stockQuoteObservable.addObserver(threeDO);


        for (int i = 0; i < 10; i++) {
            String t = "test";
            Double q = Math.random() * 100;
            stockQuoteObservable.changeQoute(t, q);
        }
    }
}
