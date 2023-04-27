package edu.umb.cs680.hw03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {

    private String make, model;
    private int mileage, year;
    private float price;
    
    public Car(String make, String model, int mileage, int year, float price) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;

    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public static void main(String[] args) {
        
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Toyota", "RAV4", 50000, 2020, 100000));
        cars.add(new Car("Honda", "Civic", 25000, 2018, 20000));
        cars.add(new Car("Ford", "Mustang", 40000, 2019, 50000));
        cars.add(new Car("Chevrolet", "Camaro", 35000, 2018, 40000));
        cars.add(new Car("Tesla", "Model S", 20000, 2021, 80000));
        
        List<List<Double>> points = new ArrayList<>();
        for (Car car : cars) {
            int mileage = car.getMileage();
            int year = car.getYear();
            float price = car.getPrice();
        
            int minMileage = 0;
            int maxMileage = 100000;
            double nMileage = (double) (mileage - minMileage) / (maxMileage - minMileage);
        
            int minYear = 2000;
            int maxYear = 2025;
            double nYear = (double) (year - minYear) / (maxYear - minYear);
        
            int minPrice = 0;
            int maxPrice = 1000000;
            double nPrice = (double) (price - minPrice) / (maxPrice - minPrice);
        
            List<Double> point = Arrays.asList(nMileage, nYear, nPrice);
            points.add(point);
            System.out.println(points);
        }
        
    }
    }
    
