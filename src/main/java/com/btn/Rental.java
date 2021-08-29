package com.btn;

import java.util.List;

public class Rental {

    public void bookCar(Car car, List<Car> rentedCar, List<Car> availableCar){
        car.setRent(Rent.RESERVED);
        availableCar.remove(car);
        rentedCar.add(car);
        System.out.println(car + " has successfully been booked!");
    }

    public void returnCar(Car car, List<Car> rentedCar, List<Car> availableCar){
        car.setRent(Rent.AVAILABLE);
        rentedCar.remove(car);
        availableCar.add(car);
        System.out.println(car + " has successfully been returned! Thank you!");
    }

}

