package edu.umb.cs680.hw13;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MileageComparatorTest {

    public static List<Car> carList;

    @BeforeAll
    public static void setUp() {
        carList = new ArrayList<>();
        carList.add(new Car("Volkswagon", "Beetle",30000, 2018,23000f));
        carList.add(new Car("BMW", "E6",20000, 2021,40000f));
        carList.add(new Car("Mustang", "Cobra",15000, 2016,20000f));
        carList.add(new Car("Wagon", "HatchBack",36000, 2022,10000f));
    }

    @Test
    public void assertNaturalOrderMileageComparatorTest() {
        Collections.sort(carList, Comparator.comparing(Car::getMileage, Comparator.naturalOrder()));
        assertEquals(15000, carList.get(0).getMileage());
        assertEquals(20000, carList.get(1).getMileage());
        assertEquals(30000, carList.get(2).getMileage());
        assertEquals(36000, carList.get(3).getMileage());
    }

    @Test
    public void assertNaturalOrderMileageComparatorLETest() {
        Collections.sort(carList, (Car c1, Car c2) -> c1.getMileage() - c2.getMileage() );
        assertEquals(15000, carList.get(0).getMileage());
        assertEquals(20000, carList.get(1).getMileage());
        assertEquals(30000, carList.get(2).getMileage());
        assertEquals(36000, carList.get(3).getMileage());
    }

    @Test
    public void assertReverseOrderMileageComparatorLETest() {
        Collections.sort(carList, (Car c1, Car c2) -> c2.getMileage() - c1.getMileage() );
        assertEquals(15000, carList.get(3).getMileage());
        assertEquals(20000, carList.get(2).getMileage());
        assertEquals(30000, carList.get(1).getMileage());
        assertEquals(36000, carList.get(0).getMileage());
    }

    @Test
    public void assertReverseOrderMileageComparatorTest() {
        Collections.sort(carList, Comparator.comparing(Car::getMileage, Comparator.reverseOrder()));
        assertEquals(15000, carList.get(3).getMileage());
        assertEquals(20000, carList.get(2).getMileage());
        assertEquals(30000, carList.get(1).getMileage());
        assertEquals(36000, carList.get(0).getMileage());
    }

    @Test
    public void assertSameMileageCarListComparatorTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Volkswagon", "Beetle",30000, 2018,23000f));
        cars.add(new Car("Mustang", "GT",30000, 2020,25000f));
        Collections.sort(cars, Comparator.comparing(Car::getMileage, Comparator.naturalOrder()));
        assertEquals(30000, cars.get(0).getMileage());
        assertEquals(30000, cars.get(1).getMileage());
    }

    @Test
    public void assertCarListEmpty() {
        List<Car> noCars = new ArrayList<>();
        Collections.sort(noCars, Comparator.comparing(Car::getMileage, Comparator.naturalOrder()));
        assertTrue(noCars.isEmpty());
    }

}