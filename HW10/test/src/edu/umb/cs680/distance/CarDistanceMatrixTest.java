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
    cars.add(new Car("Toyota", "RAV4", 50000, 2020, 100000f));
    cars.add(new Car("Honda", "Civic", 25000, 2018, 20000f));
    cars.add(new Car("Ford", "Mustang", 40000, 2019, 50000f));
    cars.add(new Car("Chevrolet", "Camaro", 35000, 2018, 40000f));
    cars.add(new Car("Tesla", "Model S", 20000, 2021, 80000f));

    //instead hardcoding the values, implementing the way to accept dynamic values
    double maxM = Double.MAX_VALUE;
    double minM = Double.MIN_VALUE;
    double maxY = Double.MAX_VALUE;
    double minY = Double.MIN_VALUE;
    double maxP = Float.MAX_VALUE;
    double minP = Float.MIN_VALUE;

    for (Car c: cars) {
        double mileage = c.getMileage();
        double price = c.getPrice();
        double year = c.getYear();

        maxM = Math.max(maxM, mileage);
        minM = Math.min(minM, mileage);
        maxY = Math.max(maxY, year);
        minY = Math.min(minY, year);
        maxP = Math.max(maxP, price);
        minP = Math.min(minP, price);
    }

    List<List<Double>> points = new ArrayList<>();
    //min-max normalisation conversion of above values
    for (Car c: cars) {
        double mileage = c.getMileage();
        double price = c.getPrice();
        double year = c.getYear();

        double nMileage = (double) (mileage - minM) / (maxM - minM);
        double nPrice = (double) (price - minP) / (maxP - minP);
        double nYear = (double) (year - minY) / (maxY - minY);

        List<Double> p = Arrays.asList(nMileage, nPrice, nYear);
        points.add(p);
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
