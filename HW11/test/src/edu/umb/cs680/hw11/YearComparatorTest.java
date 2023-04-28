package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class YearComparatorTest {

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
    public void assertCarSortYearDescendingOrder() {
       Car c1 = new Car("Volkswagon", "Beetle",30000, 2018,2000f);
       Car c2 = new Car("BMW", "E6",20000, 2021,3000f);
       Car c3 = new Car("Mustang", "Cobra",15000, 2016,4000f);
       Car c4 = new Car("Wagon", "HatchBack",36000, 2022,5000f);

       ArrayList<Car> actual = new ArrayList<>(Arrays.asList(c1, c2, c3, c4));
       Collections.sort(actual, new YearComparator().reversed());
       ArrayList<Car> expected = new ArrayList<>(Arrays.asList(c4, c2, c1, c3));
       assertEquals(expected, actual);

    }

    @Test
    public void assertCarSortYearAscendingOrder() {
       Car c1 = new Car("Volkswagon", "Beetle",3000, 2018,5000f);
       Car c2 = new Car("BMW", "E6",2000, 2021,4000f);
       Car c3 = new Car("Mustang", "Cobra",1500, 2016,3000f);
       Car c4 = new Car("Wagon", "HatchBack",1000, 2022,2000f);

       ArrayList<Car> actual = new ArrayList<>(Arrays.asList(c1, c2, c3, c4));
       Collections.sort(actual, new YearComparator());
       ArrayList<Car> expected = new ArrayList<>(Arrays.asList(c3, c1, c2, c4));
       assertEquals(expected, actual);

    }

    @Test
    public void assertYearComparatorCar() {
        Collections.sort(cars, new YearComparator());
        assertEquals(2016, cars.get(0).getYear());
        assertEquals(2018, cars.get(1).getYear());
        assertEquals(2021, cars.get(2).getYear());
        assertEquals(2022, cars.get(3).getYear());
    }

    @Test
    public void assertReverseYearComparatorCar() {
        Collections.sort(cars, new YearComparator().reversed());
        assertEquals(2016, cars.get(3).getYear());
        assertEquals(2018, cars.get(2).getYear());
        assertEquals(2021, cars.get(1).getYear());
        assertEquals(2022, cars.get(0).getYear());
    }

}