package com.btn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarManagement {
    public List<Car> rentedCars = new ArrayList<>();
    public List<Car> availableCars = new ArrayList<>();


    public CarManagement(List<Car> rentedCars, List<Car> availableCars) {
        this.rentedCars = rentedCars;
        this.availableCars = availableCars;

    }
    public CarManagement(){

    };


    public List<Car> getRentedCars() {
        return rentedCars;
    }

    public void setRentedCars(List<Car> rentedCars) {
//        this.rentedCars.add(rentedCars);
    }

    public List<Car> getAvailableCars() {
        return availableCars;
    }

    public void setAvailableCars(List<Car> availableCars) {
//        this.availableCars.add(availableCars);
    }

    public void addCarToCompany(Car newCar, List<Car> car){
        car.add(newCar);
        System.out.println("You've successfully added a car into our database");
    }

    public void removeCarFromCompany(Car car, List<Car> car){
        availableCars.remove(car);
    }

}
