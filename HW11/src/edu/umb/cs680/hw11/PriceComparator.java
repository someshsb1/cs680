package edu.umb.cs680.hw11;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {

    @Override
    public int compare(Car c1, Car c2) {
        
        float p1 = c1.getPrice();
        float p2 = c2.getPrice();

        if (p1 < p2) {
            return -1;
        } else if (p1 > p2) {
            return 1;
        } else {
            return 0;
        }
    }
    
}
