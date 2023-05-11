package edu.umb.cs680.hw13;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PriceComparatorTest {

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
        Collections.sort(carList, Comparator.comparing(Car::getPrice, Comparator.naturalOrder()));
        assertEquals(10000f, carList.get(0).getPrice());
        assertEquals(20000f, carList.get(1).getPrice());
        assertEquals(23000f, carList.get(2).getPrice());
        assertEquals(40000f, carList.get(3).getPrice());
    }


    @Test
    public void assertReverseOrderPriceComparatorTest() {
        Collections.sort(carList, Comparator.comparing(Car::getPrice, Comparator.reverseOrder()));
        assertEquals(10000f, carList.get(3).getPrice());
        assertEquals(20000f, carList.get(2).getPrice());
        assertEquals(23000f, carList.get(1).getPrice());
        assertEquals(40000f, carList.get(0).getPrice());
    }

    @Test
    public void assertReverseOrderPriceComparatorLETest() {
        Collections.sort(carList, (Car c1, Car c2) -> (int)(c2.getPrice() - c1.getPrice()));
        assertEquals(10000f, carList.get(3).getPrice());
        assertEquals(20000f, carList.get(2).getPrice());
        assertEquals(23000f, carList.get(1).getPrice());
        assertEquals(40000f, carList.get(0).getPrice());
    }

    @Test
    public void assertNaturalOrderPriceComparatorLETest() {
        Collections.sort(carList, (Car c1, Car c2) -> (int)(c1.getPrice() - c2.getPrice()));
        assertEquals(10000f, carList.get(0).getPrice());
        assertEquals(20000f, carList.get(1).getPrice());
        assertEquals(23000f, carList.get(2).getPrice());
        assertEquals(40000f, carList.get(3).getPrice());
    }

    @Test
    public void assertSamePriceCarListComparatorTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Volkswagon", "Beetle",30000, 2018,23000f));
        cars.add(new Car("Mustang", "GT",31000, 2020,23000f));
        Collections.sort(cars, Comparator.comparing(Car::getPrice, Comparator.naturalOrder()));
        assertEquals(23000f, cars.get(0).getPrice());
        assertEquals(23000f, cars.get(1).getPrice());
    }

    @Test
    public void assertCarListEmpty() {
        List<Car> noCars = new ArrayList<>();
        Collections.sort(noCars, Comparator.comparing(Car::getPrice, Comparator.naturalOrder()));
        assertTrue(noCars.isEmpty());
    }

}
