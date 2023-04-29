package edu.umb.cs680.hw13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ParetoComparator {

    public static void main (String args[]) {

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Volkswagon", "Beetle", 2000, 2020, 10000f));
        carList.add(new Car("BMW", "E6", 1500, 2018, 15000f));
        carList.add(new Car("Mustang", "GT", 100, 2015, 19000f));
        carList.add(new Car("Porsche", "FS", 200, 2022, 17000f));

        Collections.sort(carList, (Car c1, Car c2) -> {
            int result = 0;
        if ((c1.getPrice() >= c2.getPrice() && c1.getMileage() <= c2.getMileage() && c1.getYear() >= c2.getYear()) && (c1.getPrice() > c2.getPrice() || c1.getMileage() < c2.getMileage() || c1.getYear() > c2.getYear())) {
            result = -1;
        } else if ((c2.getPrice() >= c1.getPrice() && c2.getMileage() <= c1.getMileage() && c2.getYear() >= c1.getYear()) && (c2.getPrice() > c1.getPrice() || c2.getMileage() < c1.getMileage() || c2.getYear() > c1.getYear())) {
            result = 1;
        } else {
            result = 0;
        }
        return result;
        });

        
        //set domination count for carList
        for (Car car: carList) {
            car.setDominationCount(carList);
        }

        System.out.println("Sorting in reverse order: \n");
        //sort in reverse order (descending order)
        Collections.sort(carList, Comparator.comparing(Car::getDominationCount, Comparator.reverseOrder()));
        // print in descending order
        for (Car car: carList) {
            System.out.println(car.getMake() + ": " + car.getDominationCount());
        }

        System.out.println("Sorting in natural order: \n");
        //sort in natural order (ascending order)
        Collections.sort(carList, Comparator.comparing(Car::getDominationCount, Comparator.naturalOrder()));
        // print in natural order
        for (Car car: carList) {
            System.out.println(car.getMake() + ": " + car.getDominationCount());
        }
    }
}

