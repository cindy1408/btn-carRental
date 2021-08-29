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

    public void setRentedCars(Car rentedCars) {
        this.rentedCars.add(rentedCars);
    }


    public List<Car> getAvailableCars() {
        return availableCars;
    }

    public void setAvailableCars(Car availableCars) {
        this.availableCars.add(availableCars);
    }

    public void addCarToCompany(Car newCar, List<Car> car){
        car.add(newCar);
        System.out.println("You've successfully added a car into our database");
    }

    public void removeCarFromCompany(Car newCar, List<Car> car){
        car.remove(newCar);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarManagement that = (CarManagement) o;
        return Objects.equals(rentedCars, that.rentedCars) && Objects.equals(availableCars, that.availableCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentedCars, availableCars);
    }

    @Override
    public String toString() {
        return "CarManagement{" +
                "rentedCars=" + rentedCars +
                ", availableCars=" + availableCars +
                '}';
    }
}
