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
        LineChartObserver lineChartObserver = new LineChartObserver();
        TableObserver tableObserver = new TableObserver();
        ThreeDOObserver threeDoObserver = new ThreeDOObserver();

        stockQuoteObservable.addObserver(lineChartObserver);
        stockQuoteObservable.addObserver(tableObserver);
        stockQuoteObservable.addObserver(threeDoObserver);

        for (int i = 0; i < 10; i++) {
            String t = "test";
            Double q = Math.random() * 100;
            stockQuoteObservable.changeQoute(t, q);
        }
    }
}
