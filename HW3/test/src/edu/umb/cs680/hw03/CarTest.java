package edu.umb.cs680.hw03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CarTest {
    
    @Test
    public void verifyCarEqualityWithMakeModelYear() {
        Car car1 = new Car("Toyota", "RA4", 30000, 2018, 22000f);
        Car car2 = new Car("Toyota", "RA4", 20000, 2018, 29000f);

        String[] expected = {"Toyota", "RA4", "2018"};
        String[] actual1 = carToStringArray(car1);
        String[] actual2 = carToStringArray(car2);

        assertArrayEquals(expected, actual1);
        assertArrayEquals(expected, actual2);
        
    }

    private String[] carToStringArray(Car car) {
        String[] cArr = {car.getMake(), car.getModel(), Integer.toString(car.getYear())};
        return cArr;
    }

}
