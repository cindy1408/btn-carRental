package com.btn;

import java.util.List;

public class Rental {

    public void bookCar(Car car, List<Car> rentedCar, List<Car> availableCar){
        availableCar.remove(car);
        rentedCar.add(car);
        System.out.println("Your car has been booked");
    }

    public void returnCar(Car car, List<Car> rentedCar, List<Car> availableCar){
        rentedCar.remove(car);
        availableCar.add(car);
        System.out.println("Your car has been successfully returned");
    }

}

