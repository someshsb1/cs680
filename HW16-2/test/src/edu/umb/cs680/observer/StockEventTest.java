package edu.umb.cs680.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StockEventTest {

    @Test
    public void assertGetTickerValue() {
        StockEvent test = new StockEvent("test", 10);
        assertEquals("test", test.getTicker());
    }

    @Test
    public void assertGetQouteValue() {
        StockEvent test = new StockEvent("test", 10);
        assertEquals(10, test.getQoute());
    }
    

    //StockQuoteObservable randomly changes its quote value periodically and notifies the quote change to its observers.
    @Test
    public void testPeriodicStockQouteValueChange() {

        StockQuoteObservable observable = new StockQuoteObservable();
        //LEs to implement update() and passes the LEs to addObserver() and removeObserver().
        Observer<StockEvent> qouteUpdateLineChart = (sender, event) -> { System.out.println("LineChart Observer :" + event); };
        Observer<StockEvent> qouteUpdateTable = (sender, event) -> { System.out.println("Table Observer :" + event); };
        Observer<StockEvent> qouteUpdate3Do = (sender, event) -> { System.out.println("3DO Observer :" + event); };
        
        observable.addObserver(qouteUpdateLineChart);
        observable.addObserver(qouteUpdateTable);
        observable.addObserver(qouteUpdate3Do);

        for (int i = 0; i < 10; i++) {
            String t = "test";
            Double q = Math.random() * 100;
            observable.changeQoute(t, q);
        }

        observable.removeObserver(qouteUpdateLineChart);
        observable.removeObserver(qouteUpdateTable);
        observable.removeObserver(qouteUpdate3Do);

    }
}
