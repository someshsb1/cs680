package edu.umb.cs680.hw11;

import java.util.Comparator;

public class YearComparator implements Comparator<Car> {
    
    public int compare(Car c1, Car c2) {

        int y1 = c1.getYear();
        int y2 = c2.getYear();

        if (y1 < y2) {
            return -1;
        } else if (y1 > y2) {
            return 1;
        } else {
            return 0;
        }
    }
}
