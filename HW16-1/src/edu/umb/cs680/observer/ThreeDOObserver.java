package edu.umb.cs680.observer;

public class ThreeDOObserver implements Observer<StockEvent> {

    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        System.out.println("ThreeDOObserver: " + event.getTicker() + " " + event.getQoute());
        
    }
    
}
