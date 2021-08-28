package com.btn;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRentalDB {


    public List<Car> fullCollection(List<Car> rentedCars, List<Car> availableCars) {
        List<Car> fullCollection = Stream.concat(rentedCars.stream(), availableCars.stream()).collect(Collectors.toList());
        System.out.println(fullCollection);
        return fullCollection;
    }











    public void printFullListCars(){
        try {
            BufferedReader in = new BufferedReader(new FileReader("carDB.txt"));
            String line;
            while ((line = in.readLine()) != null){
                System.out.println(line);
            }
            in.close();
        } catch (IOException e){
            System.out.println("There was an issue reading the files");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRentalDB that = (CarRentalDB) o;
        return Objects.equals(scanner, that.scanner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scanner);
    }

    @Override
    public String toString() {
        return "CarRentalDB{" +
                "scanner=" + scanner +
                '}';
    }

    Scanner scanner = new Scanner(System.in);

    // Add a car to the full list
    public void addCarToRental(List<Car> car, Car newCar){
        System.out.println("What is the car model?");
        scanner.nextLine();
        car.add(newCar);

        System.out.println("ADD CAR TO FULL LIST");
    };


    public void removeCarFromRental(List<Car> car, String plateNumber){

        System.out.println("REMOVE CAR FROM FULL LIST");
    };


}
