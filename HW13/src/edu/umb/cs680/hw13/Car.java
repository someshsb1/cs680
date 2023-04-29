package edu.umb.cs680.hw13;

import java.util.List;

public class Car {

    private String make, model;
    private int mileage, year;
    private float price;
    private int dominationCounts;
    
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
            if ((car.getPrice() < this.getPrice() && car.getMileage() < this.getMileage()) || (car.getPrice() < this.getPrice() && car.getYear() > this.getYear())) {
                this.dominationCounts++;
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
  
    }
    
}