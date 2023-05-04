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
