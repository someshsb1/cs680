package edu.umb.cs680.hw13;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class YearComparatorTest {

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
    public void assertNaturalOrderYearComparatorTest() {
        Collections.sort(carList, Comparator.comparing(Car::getYear, Comparator.naturalOrder()));
        assertEquals(2016, carList.get(0).getYear());
        assertEquals(2018, carList.get(1).getYear());
        assertEquals(2021, carList.get(2).getYear());
        assertEquals(2022, carList.get(3).getYear());
    }

    @Test
    public void assertReverseOrderYearComparatorTest() {
        Collections.sort(carList, Comparator.comparing(Car::getYear, Comparator.reverseOrder()));
        assertEquals(2016, carList.get(3).getYear());
        assertEquals(2018, carList.get(2).getYear());
        assertEquals(2021, carList.get(1).getYear());
        assertEquals(2022, carList.get(0).getYear());
    }

    @Test
    public void assertSameYearCarListComparatorTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Volkswagon", "Beetle",30000, 2018,23000f));
        cars.add(new Car("Mustang", "GT",31000, 2018,13000f));
        Collections.sort(cars, Comparator.comparing(Car::getYear, Comparator.naturalOrder()));
        assertEquals(2018, cars.get(0).getYear());
        assertEquals(2018, cars.get(1).getYear());
    }

    @Test
    public void assertCarListEmpty() {
        List<Car> noCars = new ArrayList<>();
        Collections.sort(noCars, Comparator.comparing(Car::getYear, Comparator.naturalOrder()));
        assertTrue(noCars.isEmpty());
    }

}