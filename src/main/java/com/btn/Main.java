package com.btn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        CarManagement garage = new CarManagement();
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

        System.out.println("Here are the following options: \n1.add new car to rent out\n2.remove a car if not rented\n3.Lists of available cars\n4.Current rented cars\n 5.Book a car\n6.Return a car\n7.Full list\n8.Add new Car\n9.A car no longer in use?\n");

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

                System.out.println("You want to remove a car? y/n");
                scanner.nextLine();
                String userInput = scanner.nextLine();
                if(userInput.equalsIgnoreCase("y")){
                    System.out.println("Here is a list of cars, which do you want to remove? car id");
                    System.out.println(garage.availableCars);
                    String carId = scanner.nextLine();

                    for(int i = 0; i < garage.availableCars.size(); i++){
                        Car individualCar = garage.availableCars.get(i);
                        if(individualCar.getId().contains(carId)){
                            garage.removeCarFromCompany(individualCar, garage.availableCars);
                            individualCar.setRent(Rent.NOTAVAILABLE);
                            System.out.println(individualCar + " has been successfully removed!");
                            System.out.println(garage.availableCars);
                        } else {

                        }
                    }
                } else {
                    System.out.println("No problem, see you soon!");
                }

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
                System.out.println("You want to book a car? y/n");
                scanner.nextLine();
                String user = scanner.nextLine();
                if(user.equalsIgnoreCase("y")){
                    System.out.println("Here are the list of our current available cars");
                    System.out.println(garage.availableCars);
                    System.out.println("Please enter your desired car id");
                    String bookCar = scanner.nextLine();
                    for(int i = 0; i < garage.availableCars.size(); i++){
                        Car individualCar = garage.availableCars.get(i);
                        if(individualCar.getId().contains(bookCar)){
                            company.bookCar(individualCar, garage.rentedCars, garage.availableCars);
                        }
                    }
                } else {
                    System.out.println("No problem, have a lovely day!");
                }

                break;
            case 6:
                System.out.println("You want to return a car?");
                scanner.nextLine();
                String userAns = scanner.nextLine();
                if(userAns.equalsIgnoreCase("y")){
                    System.out.println("Here's a list of rented cars");
                    System.out.println(garage.rentedCars);
                    System.out.println("Please enter your rented car id");
                    String carId = scanner.nextLine();
                    for(int i = 0; i < garage.rentedCars.size(); i++){
                        Car individualCar = garage.rentedCars.get(i);
                        if(individualCar.getId().contains(carId)){
                            company.returnCar(individualCar, garage.rentedCars, garage.availableCars);
                            System.out.println(garage.availableCars);
                        }
                    }

                } else {
                    System.out.println("No problem, happy renting!");
                }
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