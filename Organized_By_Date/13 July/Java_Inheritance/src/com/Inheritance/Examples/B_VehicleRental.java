package com.Inheritance.Examples;

class Vehicle {

    protected String vehicleNumber;
    protected String model;
    protected double rentalRatePerDay;
    protected boolean isAvailable;

    Vehicle(String vehicleNumber, String model, double rentalRatePerDay, boolean isAvailable) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.rentalRatePerDay = rentalRatePerDay;
        this.isAvailable = isAvailable;
    }

    void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Model: " + model);
        System.out.println("Rental Rate Per Day: ₹" + rentalRatePerDay);
        System.out.println("Available: " + isAvailable);
    }
}

class Car extends Vehicle {

    Car(String vehicleNumber, String model, double rentalRatePerDay, boolean isAvailable) {
        super(vehicleNumber, model, rentalRatePerDay, isAvailable);
    }

    void bookCar() {
        System.out.println("Car booked successfully.");
    }
}

public class B_VehicleRental {

    public static void main(String[] args) {

        Car car = new Car("DL01AB1234", "Hyundai i20", 1500, true);

        car.displayDetails();
        car.bookCar();
    }
}