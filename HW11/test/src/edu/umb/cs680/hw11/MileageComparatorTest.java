package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MileageComparatorTest {

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
    public void assertCarMileagePriceDescendingOrder() {
       Car c1 = new Car("Volkswagon", "Beetle",30000, 2018,2000f);
       Car c2 = new Car("BMW", "E6",20000, 2021,3000f);
       Car c3 = new Car("Mustang", "Cobra",15000, 2016,4000f);
       Car c4 = new Car("Wagon", "HatchBack",36000, 2022,5000f);

       ArrayList<Car> actual = new ArrayList<>(Arrays.asList(c1, c2, c3, c4));
       Collections.sort(actual, new MileageComparator().reversed());
       ArrayList<Car> expected = new ArrayList<>(Arrays.asList(c4, c1, c2, c3));
       assertEquals(expected, actual);

    }

    @Test
    public void assertCarSortMileageAscendingOrder() {
       Car c1 = new Car("Volkswagon", "Beetle",3000, 2018,5000f);
       Car c2 = new Car("BMW", "E6",2000, 2021,4000f);
       Car c3 = new Car("Mustang", "Cobra",1500, 2016,3000f);
       Car c4 = new Car("Wagon", "HatchBack",1000, 2022,2000f);

       ArrayList<Car> actual = new ArrayList<>(Arrays.asList(c1, c2, c3, c4));
       Collections.sort(actual, new MileageComparator());
       ArrayList<Car> expected = new ArrayList<>(Arrays.asList(c4, c3, c2, c1));
       assertEquals(expected, actual);

    }

    @Test
    public void assertMileageComparatorCar() {
        Collections.sort(cars, new MileageComparator());
        assertEquals(15000, cars.get(0).getMileage());
        assertEquals(20000, cars.get(1).getMileage());
        assertEquals(30000, cars.get(2).getMileage());
        assertEquals(36000, cars.get(3).getMileage());
    }

    @Test
    public void assertReverseMileageComparatorCar() {
        Collections.sort(cars, new MileageComparator().reversed());
        assertEquals(15000, cars.get(3).getMileage());
        assertEquals(20000, cars.get(2).getMileage());
        assertEquals(30000, cars.get(1).getMileage());
        assertEquals(36000, cars.get(0).getMileage());
    }

}