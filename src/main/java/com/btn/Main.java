package com.btn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        CarManagement garage = new CarManagement();
        CarRentalDB fullListCar = new CarRentalDB();
        Rental company = new Rental();
        CarRentalDB database = new CarRentalDB();

        Car car1 = new Car("", "Tesla", "LB971 3GB", 60, Rent.AVAILABLE);
        Car car2 = new Car("", "BMW", "KJ121 6GB", 45, Rent.AVAILABLE);
        Car car3 = new Car("", "Honda", "LK719 8GB", 40, Rent.AVAILABLE);
        Car car4 = new Car("", "Toyota", "JA9812 5GB", 40, Rent.NOTAVAILABLE);
        Car car5 = new Car("", "Mini", "KAH134 9GB", 15, Rent.NOTAVAILABLE);

        garage.availableCars.add(car1);
        garage.availableCars.add(car2);
        garage.availableCars.add(car3);
        garage.rentedCars.add(car4);
        garage.rentedCars.add(car5);


        Scanner scanner = new Scanner(System.in);

        System.out.println("Here are the following options: \n1.add a car to the full list\n2.remove a car from full list\n3.Lists of available cars\n4.Current rented cars 5.Full list of cars.");

        int userOption = scanner.nextInt();

        switch (userOption){
            case 1:
                System.out.println("What is the car model?");
                scanner.nextLine();
                String carModel = scanner.nextLine();


                System.out.println("What is the car plate number?");
                String carPlateNumber = scanner.nextLine();

                System.out.println("Price per day?");
                double dailyRentPrice = scanner.nextInt();

                System.out.println("Is it currently available? y/n");
                String carAvailability = scanner.nextLine();

                Rent carRent;
                if(carAvailability.trim().equalsIgnoreCase("y")){
                    carRent = Rent.AVAILABLE;
                } else {
                    carRent = Rent.NOTAVAILABLE;
                }


                Car addCar = new Car(carPlateNumber, carModel, carPlateNumber, dailyRentPrice, carRent );

                try{
                    File carDB = new File("src/carDB.txt");
                    FileWriter myWriter = new FileWriter("carDB.txt", true);
                    myWriter.write(String.valueOf(addCar) + "\n");
//                    System.out.println(addCar + " has been successfully added to our database.");
                    myWriter.close();
                } catch (IOException e){
                    System.out.println("An Error has occurred!");
                    e.printStackTrace();
                }

                garage.addCarToCompany(addCar, garage.availableCars);
                System.out.println(garage.availableCars);

                break;
            case 2:

                System.out.println("You want to remove a car");
                garage.removeCarFromCompany(car2, garage.availableCars);
                System.out.println(garage.availableCars);

                break;
            case 3:
                System.out.println("You want a list of available cars");
                System.out.println(garage.availableCars);
                break;
            case 4:
                System.out.println("You want a list of rented cars");
                System.out.println(garage.rentedCars);
                break;
            case 5:
                System.out.println("You want to book a car?");
                company.bookCar(car1, garage.rentedCars, garage.availableCars);
                car1.setRent(Rent.NOTAVAILABLE);
                System.out.println(garage.rentedCars);
                System.out.println(garage.availableCars);
                break;
            case 6:
                System.out.println("You want to return a car?");
                company.returnCar(car1, garage.rentedCars, garage.availableCars);
                car1.setRent(Rent.AVAILABLE);
                System.out.println(garage.availableCars);
                break;
            case 7:
                System.out.println("You want a full list of cars");
                database.fullCollection(garage.rentedCars, garage.availableCars);
                break;
            case 8:
                System.out.println("You want to add a car to the full list");
                database.fullCollection(garage.rentedCars, garage.availableCars);
                garage.addCarToCompany(car4, database.fullCollection(garage.rentedCars, garage.availableCars));
            case 9:
                System.out.println("You want to remove a car to the full list");
                database.fullCollection(garage.rentedCars, garage.availableCars);
                garage.removeCarFromCompany(car4, database.fullCollection(garage.rentedCars, garage.availableCars));

            default:
                System.out.println("Please pick between option 1 and 4. ");
        }






    }
}