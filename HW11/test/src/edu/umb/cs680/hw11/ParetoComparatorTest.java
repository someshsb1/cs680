package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ParetoComparatorTest {

    public static List<Car> cars;

    @BeforeAll
    public static void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("Volkswagon", "Beetle",30000, 2018,23000f));
        cars.add(new Car("BMW", "E6",20000, 2021,40000f));
        cars.add(new Car("Mustang", "Cobra",15000, 2016,20000f));
        cars.add(new Car("Wagon", "HatchBack",36000, 2022,10000f));
        for (Car car: cars) {
            car.setDominationCount(cars);
        }
    }
    


    @Test
    public void assertParetoComparatorCar() {
    
        Collections.sort(cars, new ParetoComparator());
        assertEquals(0, cars.get(0).getDominationCount());
        assertEquals(0, cars.get(1).getDominationCount());
        assertEquals(0, cars.get(2).getDominationCount());
        assertEquals(3, cars.get(3).getDominationCount());
    }

    @Test
    public void assertReverseParetoComparatorCar() {
        
        Collections.sort(cars, new ParetoComparator().reversed());
        assertEquals(0, cars.get(3).getDominationCount());
        assertEquals(0, cars.get(2).getDominationCount());
        assertEquals(0, cars.get(1).getDominationCount());
        assertEquals(3, cars.get(0).getDominationCount());
    }

    @Test
    public void assertSameYearCarsParetoComparator() {
        Car c1 = new Car("Volkswagon", "Beetle",30000, 2018,23000f);
        Car c2 = new Car("BMW", "E6",20000, 2018,40000f);
        Car c3 = new Car("Mustang", "Cobra",15000, 2018,20000f);
        Car c4 = new Car("Wagon", "HatchBack",36000, 2018,10000f);

        List<Car> cars = Arrays.asList(c1, c2, c3, c4);
        for (Car car1: cars) {
            car1.setDominationCount(cars);
        }
        Collections.sort(cars, new ParetoComparator());
        assertEquals(0, cars.get(0).getDominationCount());
        assertEquals(0, cars.get(1).getDominationCount());
        assertEquals(1, cars.get(2).getDominationCount());
        assertEquals(3, cars.get(3).getDominationCount());
    }

    @Test
    public void assertSamePriceCarsParetoComparator() {
        Car c1 = new Car("Volkswagon", "Beetle",30000, 2018,40000f);
        Car c2 = new Car("BMW", "E6",20000, 2016,40000f);
        Car c3 = new Car("Mustang", "Cobra",15000, 2022,40000f);
        Car c4 = new Car("Wagon", "HatchBack",36000, 2020,40000f);

        List<Car> cars = Arrays.asList(c1, c2, c3, c4);
        for (Car car1: cars) {
            car1.setDominationCount(cars);
        }
        Collections.sort(cars, new ParetoComparator());
        assertEquals(0, cars.get(0).getDominationCount());
        assertEquals(0, cars.get(1).getDominationCount());
        assertEquals(1, cars.get(2).getDominationCount());
        assertEquals(2, cars.get(3).getDominationCount());
    }

    @Test
    public void assertSameMileageCarsParetoComparator() {
        Car c1 = new Car("Volkswagon", "Beetle",30000, 2018,23000f);
        Car c2 = new Car("BMW", "E6",30000, 2016,40000f);
        Car c3 = new Car("Mustang", "Cobra",30000, 2022,20000f);
        Car c4 = new Car("Wagon", "HatchBack",30000, 2020,15000f);

        List<Car> cars = Arrays.asList(c1, c2, c3, c4);
        for (Car car1: cars) {
            car1.setDominationCount(cars);
        }
        Collections.sort(cars, new ParetoComparator());
        assertEquals(0, cars.get(0).getDominationCount());
        assertEquals(1, cars.get(1).getDominationCount());
        assertEquals(2, cars.get(2).getDominationCount());
        assertEquals(2, cars.get(3).getDominationCount());
    }
}