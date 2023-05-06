package edu.umb.cs680.distance;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CarDistanceMatrixTest {

@Test
public void testDistanceMatrix() {
    List<Car> cars = new ArrayList<>();
    //list of 5 cars
    cars.add(new Car("Toyota", "RAV4", 50000, 2020, 100000));
    cars.add(new Car("Honda", "Civic", 25000, 2018, 20000));
    cars.add(new Car("Ford", "Mustang", 40000, 2019, 50000));
    cars.add(new Car("Chevrolet", "Camaro", 35000, 2018, 40000));
    cars.add(new Car("Tesla", "Model S", 20000, 2021, 80000));

    //values converted into min-max normalisation
    List<List<Double>> points = new ArrayList<>();
    for (Car car : cars) {
        int mileage = car.getMileage();
        int year = car.getYear();
        float price = car.getPrice();
    
        int minMileage = 0;
        int maxMileage = 100000;
        double nMileage = (double) (mileage - minMileage) / (maxMileage - minMileage);
    
        int minYear = 2000;
        int maxYear = 2025;
        double nYear = (double) (year - minYear) / (maxYear - minYear);
    
        int minPrice = 0;
        int maxPrice = 1000000;
        double nPrice = (double) (price - minPrice) / (maxPrice - minPrice);
    
        List<Double> point = Arrays.asList(nMileage, nYear, nPrice);
        points.add(point);
    }

    //distance.matrix test with two or more metrics - manhattan & cosine
    List<List<Double>> manhattanMetric = Distance.matrix(points, new Manhattan());
    List<List<Double>> cosineMetric = Distance.matrix(points, new Cosine());

    assertEquals(cars.size(), manhattanMetric.size()); //test metrics dimensions
    assertEquals(cars.size(), manhattanMetric.get(0).size());
    assertEquals(cars.size(), cosineMetric.size());
    assertEquals(cars.size(), cosineMetric.get(0).size());

    for (int i = 0; i < cars.size(); i++) {
        assertEquals(0, manhattanMetric.get(i).get(i)); // test diagonal values 0
    }

    for (int i = 0; i < cars.size(); i++) { //test symmetric both metrics
        for (int j = i + 1; j < cars.size(); j++) {
            assertEquals(manhattanMetric.get(i).get(j), manhattanMetric.get(j).get(i));
            assertEquals(cosineMetric.get(i).get(j), cosineMetric.get(j).get(i));
        }
    }
}
}
