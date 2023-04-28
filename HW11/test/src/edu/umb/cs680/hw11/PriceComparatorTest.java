package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PriceComparatorTest {

    public static List<Car> cars;

    @BeforeAll
    public static void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("Volkswagon", "Beetle",30000, 2018,23000f));
        cars.add(new Car("BMW", "E6",20000, 2021,40000f));
        cars.add(new Car("Mustang", "Cobra",15000, 2016,20000f));
        cars.add(new Car("Wagon", "HatchBack",36000, 2022,10000f));
    }
    
    @Test
    public void assertCarSortPriceDescendingOrder() {
       Car c1 = new Car("Volkswagon", "Beetle",30000, 2018,2000f);
       Car c2 = new Car("BMW", "E6",20000, 2021,3000f);
       Car c3 = new Car("Mustang", "Cobra",15000, 2016,4000f);
       Car c4 = new Car("Wagon", "HatchBack",36000, 2022,5000f);

       ArrayList<Car> actual = new ArrayList<>(Arrays.asList(c1, c2, c3, c4));
       Collections.sort(actual, new PriceComparator().reversed());
       ArrayList<Car> expected = new ArrayList<>(Arrays.asList(c4, c3, c2, c1));
       assertEquals(expected, actual);

    }

    @Test
    public void assertCarSortPriceAscendingOrder() {
       Car c1 = new Car("Volkswagon", "Beetle",30000, 2018,5000f);
       Car c2 = new Car("BMW", "E6",20000, 2021,4000f);
       Car c3 = new Car("Mustang", "Cobra",15000, 2016,3000f);
       Car c4 = new Car("Wagon", "HatchBack",36000, 2022,2000f);

       ArrayList<Car> actual = new ArrayList<>(Arrays.asList(c1, c2, c3, c4));
       Collections.sort(actual, new PriceComparator());
       ArrayList<Car> expected = new ArrayList<>(Arrays.asList(c4, c3, c2, c1));
       assertEquals(expected, actual);

    }

    @Test
    public void assertPriceComparatorCar() {
        Collections.sort(cars, new PriceComparator());
        assertEquals(10000f, cars.get(0).getPrice());
        assertEquals(20000f, cars.get(1).getPrice());
        assertEquals(23000f, cars.get(2).getPrice());
        assertEquals(40000f, cars.get(3).getPrice());
    }

    @Test
    public void assertReversePriceComparatorCar() {
        Collections.sort(cars, new PriceComparator().reversed());
        assertEquals(10000f, cars.get(3).getPrice());
        assertEquals(20000f, cars.get(2).getPrice());
        assertEquals(23000f, cars.get(1).getPrice());
        assertEquals(40000f, cars.get(0).getPrice());
    }

}
