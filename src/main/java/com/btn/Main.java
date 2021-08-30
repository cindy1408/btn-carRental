package com.btn;

public class Main {

    public static void main(String[] args) {

        CarManagement garage = new CarManagement();
        Rental company = new Rental();
        CarRentalDB database = new CarRentalDB();
        Customers newCustomer = new Customers();

//        Car car1 = new Car("", "Tesla", "LB971 3GB", 60, Rent.AVAILABLE);
//        Car car2 = new Car("", "BMW", "KJ121 6GB", 45, Rent.AVAILABLE);
//        Car car3 = new Car("", "Honda", "LK719 8GB", 40, Rent.AVAILABLE);
//        Car car4 = new Car("", "Toyota", "JA9812 5GB", 40, Rent.UNAVAILABLE);
//        Car car5 = new Car("", "Mini", "KAH134 9GB", 15, Rent.UNAVAILABLE);
//
//        garage.availableCars.add(car1);
//        garage.availableCars.add(car2);
//        garage.availableCars.add(car3);
//        garage.rentedCars.add(car4);
//        garage.rentedCars.add(car5);

        Start start = new Start();

        start.welcome(garage, company, database, newCustomer);


    }
}