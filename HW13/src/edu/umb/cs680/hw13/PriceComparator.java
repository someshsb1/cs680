package edu.umb.cs680.hw13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PriceComparator {

    public static void main (String args[]) {

        // Car c1 = new Car("Volkswagon", "Beetle", 2000, 2020, 10000f);
        // Car c2 = new Car("BMW", "E6", 1500, 2018, 15000f);

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Volkswagon", "Beetle", 2000, 2020, 10000f));
        carList.add(new Car("BMW", "E6", 1500, 2018, 15000f));

        //compare() method defined as lambda expression and passed to the Collections.sort()
        Collections.sort(carList, (Car c1, Car c2) -> {
            float p1 = c1.getPrice();
            float p2 = c2.getPrice();
            if (p1 < p2) {
                return -1;
            } else if (p2 < p1) {
                return 1;
            } else {
                return 0;
            }
        });

        Collections.sort(carList, Comparator.comparing(Car::getPrice, Comparator.naturalOrder()));
        // Sorting with natural order (ascending order)
        System.out.println("\nSorting in natural order \n");
        for (Car car: carList) {
            System.out.println(car.getMake() + " : " + car.getPrice());
        }

        Collections.sort(carList, Comparator.comparing(Car::getPrice, Comparator.reverseOrder()));
        // Sorting with reverse order (descending order)
        System.out.println("\nSorting in reverse order \n");
        for (Car car: carList) {
            System.out.println(car.getMake() + " : " + car.getPrice());
        }
    }
}

    

