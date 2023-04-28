package edu.umb.cs680.hw11;

import java.util.Comparator;

public class MileageComparator implements Comparator<Car> {

    public int compare(Car c1, Car c2) {

        int m1 = c1.getMileage();
        int m2 = c2.getMileage();

        if (m1 < m2) {
            return -1;
        } else if (m1 > m2) {
            return 1;
        } else {
            return 0;
        }
    }
    
}
