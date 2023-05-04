package edu.umb.cs680.hw11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {

    private String make, model;
    private int mileage, year;
    private float price;
    private int dominationCounts = 0;
    
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

    public void setDominationCount(List<Car> cars) {
        for (Car car: cars) {
            if (car == this) {
                continue;
            }
            if ((car.getPrice() >= this.getPrice() && car.getMileage() <= this.getMileage() && car.getYear() <= this.getYear())) {
                if ((car.getPrice() > this.getPrice() || car.getYear() < this.getYear() || car.getMileage() < this.getMileage())) {
                    this.dominationCounts++;
                }
            }
        }
    }

    public int getDominationCount() {
        return dominationCounts;
        
    }

    public static void main(String[] args) {

        //Printing the car information using car getter methods.
        Car car = new Car("Toyota", "RAV4",30000, 2018,23000f);
        System.out.println("\nCar Information: \n");
        System.out.println("\nMake : "+car.getMake()+"\n"+"Model : "+car.getModel()+"\n"+"Mileage : "+car.getMileage()+"\n"+"Year : "+car.getYear()+"\n"+"Price : "+car.getPrice() + "\n");


        //List of cars to sort using comparators.
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Volkswagon", "Beetle",30000, 2018,23000f));
        cars.add(new Car("BMW", "E6",20000, 2021,40000f));
        cars.add(new Car("Mustang", "Cobra",15000, 2016,20000f));
        cars.add(new Car("Wagon", "HatchBack",36000, 2022,10000f));

        //Sorting based on the Car Price Comparator
        Collections.sort(cars, new PriceComparator());
        System.out.println("\nList of cars sorted by price: \n");
        for (Car car1: cars) {
            System.out.println(car1.getMake() + " " + car1.getModel() + " " + car1.getPrice());
        }

        //Sorting based on the Car Mileage Comparator
        Collections.sort(cars, new MileageComparator());
        System.out.println("\nList of cars sorted by Mileage: \n");
        for (Car car1: cars) {
            System.out.println(car1.getMake() + " " + car1.getModel() + " " + car1.getMileage());
        }
        //Sorting based on the Year Comparator
        Collections.sort(cars, new YearComparator());
        System.out.println("\nList of cars sorted by year: \n");
        for (Car car1: cars) {
            System.out.println(car1.getMake() + " " + car1.getModel() + " " + car1.getYear());
        }

        //List of used cars to sort using the domination technique to identify best car to purchase.
        List<Car> usedCars = new ArrayList<>();

        usedCars.add(new Car("Toyota", "RAV4",30000, 2018,23000f));
        usedCars.add(new Car("BMW", "E6",20000, 2021,40000f));
        usedCars.add(new Car("Mustang", "Cobra",100000, 2016,20000f));
        usedCars.add(new Car("Wagon", "HatchBack",36000, 2022,10000f));

        //set domination counts for all cars by calling setDominationCount() on the cars,
        for (Car car1: usedCars) {
            car1.setDominationCount(cars);
        }
        //then call sort
        Collections.sort(usedCars, new ParetoComparator());
        System.out.println("\nPareto Comparison of cars: \n");
        for (Car car1: usedCars) {
            System.out.println("\nDomination Count: " + car1.getDominationCount() + "\nMake: " +car1.getMake() + "\nModel: " + car1.getModel() + "\nYear: " + car1.getYear() + "\nMileage: " + car1.getMileage() + "\nPrice: " + car1.getPrice());
        }

    }
    
}