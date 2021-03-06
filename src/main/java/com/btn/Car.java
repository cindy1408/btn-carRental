package com.btn;

import java.util.Objects;

public class Car {
    private String id;
    private String model;
    private String plateNumber;
    private double dailyRentPrice;
    private Rent rent;

    public Car(String id, String model, String plateNumber, double dailyRentPrice, Rent rent) {
        this.id = plateNumber;
        this.model = model;
        this.plateNumber = plateNumber;
        this.dailyRentPrice = dailyRentPrice;
        this.rent = rent;
    }

    public Car(){

    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public double getDailyRentPrice(){ return dailyRentPrice; }

    public void setDailyRentPrice(double dailyRentPrice){this.dailyRentPrice = dailyRentPrice;}

    public Rent getRent(){ return rent; };

    public void setRent(Rent rent){this.rent = rent;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.dailyRentPrice, dailyRentPrice) == 0 && Objects.equals(id, car.id) && Objects.equals(model, car.model) && Objects.equals(plateNumber, car.plateNumber) && rent == car.rent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, plateNumber, dailyRentPrice, rent);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", dailyRentPrice='" + dailyRentPrice + '\'' +
                ", rent='" + rent + '\'' +
                '}';
    }
}

