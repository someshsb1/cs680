package edu.umb.cs680.hw13;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ParetoComparatorTest {

    public static List<Car> carList;

    @BeforeAll
    public static void setUp() {
        carList = new ArrayList<>();
        carList.add(new Car("Volkswagon", "Beetle",30000, 2018,23000f));
        carList.add(new Car("BMW", "E6",20000, 2021,40000f));
        carList.add(new Car("Mustang", "Cobra",15000, 2016,20000f));
        carList.add(new Car("Wagon", "HatchBack",36000, 2022,10000f));
        for (Car car: carList) {
            car.setDominationCount(carList);
        }
    }
    
    @Test
    public void assertNaturalOrderParetoComparatorTest() {
        Collections.sort(carList, Comparator.comparing(Car::getDominationCount, Comparator.naturalOrder()));
        assertEquals(0, carList.get(0).getDominationCount());
        assertEquals(0, carList.get(1).getDominationCount());
        assertEquals(0, carList.get(2).getDominationCount());
        assertEquals(3, carList.get(3).getDominationCount());
    }

    @Test
    public void assertNaturalOrderParetoComparatorLETest() {
        Collections.sort(carList, (Car c1, Car c2) -> c1.getDominationCount() - c2.getDominationCount());
        assertEquals(0, carList.get(0).getDominationCount());
        assertEquals(0, carList.get(1).getDominationCount());
        assertEquals(0, carList.get(2).getDominationCount());
        assertEquals(3, carList.get(3).getDominationCount());
    }

    @Test
    public void assertReverseOrderParetoComparatorLETest() {
        Collections.sort(carList, (Car c1, Car c2) -> c2.getDominationCount() - c1.getDominationCount());
        assertEquals(0, carList.get(3).getDominationCount());
        assertEquals(0, carList.get(2).getDominationCount());
        assertEquals(0, carList.get(1).getDominationCount());
        assertEquals(3, carList.get(0).getDominationCount());
    }

    @Test
    public void assertReverseOrderParetoComparatorTest() {
        Collections.sort(carList, Comparator.comparing(Car::getDominationCount, Comparator.reverseOrder()));
        assertEquals(0, carList.get(3).getDominationCount());
        assertEquals(0, carList.get(2).getDominationCount());
        assertEquals(0, carList.get(1).getDominationCount());
        assertEquals(3, carList.get(0).getDominationCount());
    }
    @Test
    public void assertSameMileageAndYearCarListComparatorTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Volkswagon", "Beetle",30000, 2018,23000f));
        cars.add(new Car("Mustang", "GT",30000, 2018,10000f));
        Collections.sort(cars, Comparator.comparing(Car::getDominationCount, Comparator.naturalOrder()));
        assertEquals(0, cars.get(0).getDominationCount());
        assertEquals(0, cars.get(1).getDominationCount());
    }

    @Test
    public void assertCarListEmpty() {
        List<Car> noCars = new ArrayList<>();
        Collections.sort(noCars, Comparator.comparing(Car::getDominationCount, Comparator.naturalOrder()));
        assertTrue(noCars.isEmpty());
    }

}