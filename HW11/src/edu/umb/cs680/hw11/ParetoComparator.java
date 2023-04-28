package edu.umb.cs680.hw11;

import java.util.Comparator;

public class ParetoComparator implements Comparator<Car> {

    public int compare(Car c1, Car c2) {

        if ((c1.getPrice() >= c2.getPrice() && c1.getMileage() <= c2.getMileage() && c1.getYear() >= c2.getYear()) && (c1.getPrice() > c2.getPrice() || c1.getMileage() < c2.getMileage() || c1.getYear() > c2.getYear())) {
            return -1;
        } else if ((c2.getPrice() >= c1.getPrice() && c2.getMileage() <= c1.getMileage() && c2.getYear() >= c1.getYear()) && (c2.getPrice() > c1.getPrice() || c2.getMileage() < c1.getMileage() || c2.getYear() > c1.getYear())) {
            return 1;
        } else {
            return 0;
        }
    }
    
}
