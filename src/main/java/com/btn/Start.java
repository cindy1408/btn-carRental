package com.btn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Start {
    Scanner scanner = new Scanner(System.in);

    public void restart(CarManagement garage, Rental company, CarRentalDB database, Customers newCustomer){
        System.out.println("Is there anything else you would like to do?y/n");
        String help = scanner.nextLine();
        if(help.equalsIgnoreCase("y")){
            welcome(garage, company, database, newCustomer);
        } else {
            System.exit(0);
        }
    }


    public void welcome(CarManagement garage, Rental company, CarRentalDB database, Customers newCustomer) {

        System.out.println("Please state if you are: \n1. an employee (Car management)\n2. a customer(Car rental)");
        int userIdentity = scanner.nextInt();
        if( userIdentity == 1 ){
            System.out.println("Here are the following options: \n1.add new car to rent out\n2.remove an available car? y/n\n3.Lists of available cars\n4.Current rented cars\n5.Full list\n6.Exit");
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
                    scanner.nextLine();
                    String carAvailability = scanner.nextLine();

                    Rent carRent;
                    if (carAvailability.trim().equalsIgnoreCase("y")) {
                        carRent = Rent.AVAILABLE;
                    } else {
                        carRent = Rent.UNAVAILABLE;
                    }

                    Car addCar = new Car(carPlateNumber, carModel, carPlateNumber, dailyRentPrice, carRent);
                    if(addCar.getRent().equals(Rent.AVAILABLE)){
                        garage.availableCars.add(addCar);
                    } else {
                        garage.rentedCars.add(addCar);
                    }
                    try {
                        File carDB = new File("src/carDB.txt");
                        FileWriter myWriter = new FileWriter("carDB.txt", true);
                        myWriter.write(String.valueOf(addCar) + "\n");
//                    System.out.println(addCar + " has been successfully added to our database.");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("An Error has occurred!");
                        e.printStackTrace();
                    }
                    System.out.println(garage.availableCars);
                    restart(garage, company, database, newCustomer);
                case 2:
                    System.out.println("You want to remove a car? y/n");
                    scanner.nextLine();
                    String userInput = scanner.nextLine();
                    if (userInput.equalsIgnoreCase("y")) {
                        System.out.println("Here is a list of available cars, which do you want to remove? car id");
                        System.out.println(garage.availableCars);
                        String carId = scanner.nextLine();

                        for (int i = 0; i < garage.availableCars.size(); i++) {
                            Car individualCar = garage.availableCars.get(i);
                            if (individualCar.getId().contains(carId)) {
                                garage.removeCarFromCompany(individualCar, garage.availableCars);
                                individualCar.setRent(Rent.UNAVAILABLE);
                                System.out.println(individualCar + " has been successfully removed!");
                                System.out.println(garage.availableCars);
                            } else {

                            }
                        }
                    } else {
                        System.out.println("No problem, see you soon!");
                    }
                    restart(garage, company, database, newCustomer);

                case 3:
                    System.out.println("You want a list of available cars");
                    System.out.println(garage.availableCars);
                    restart(garage, company, database, newCustomer);

                case 4:
                    System.out.println("You want a list of rented cars");
                    System.out.println(garage.rentedCars);
                    restart(garage, company, database, newCustomer);
                case 5:
                    System.out.println("You want a full list of cars");
                    database.fullCollection(garage.rentedCars, garage.availableCars);
                    System.out.println("Is there anything else you would like to do?y/n");
                    String help3 = scanner.nextLine();
                    if(help3.equalsIgnoreCase("y")){
                        welcome(garage, company, database, newCustomer);
                    } else {
                        break;
                    }
                    restart(garage, company, database, newCustomer);
                case 6:
                    System.out.println("Thank you for your time.");
                    break;
                default:
                    System.out.println("Please enter a valid number.");
                    restart(garage, company, database, newCustomer);
            }
        } else {
            System.out.println("Here are the following options: \n1.Book a car\n2.Return a car\n3.Exit");
            int userOption = scanner.nextInt();
            switch (userOption){
                case 1:
                    System.out.println("You want to book a car? y/n");
                    scanner.nextLine();
                    String user = scanner.nextLine();
                    if (user.equalsIgnoreCase("y")) {

                        System.out.println("Please enter your first name");
                        String firstName = scanner.nextLine();

                        System.out.println("Please enter your last name");
                        String lastName = scanner.nextLine();

                        System.out.println("Please enter your driving licence");
                        String drivingLicience = scanner.nextLine();

                        Customers customer = new Customers(firstName, lastName, drivingLicience);

                        System.out.println("Here are the list of our current available cars");
                        System.out.println(garage.availableCars);
                        System.out.println("Please enter your desired car id");
                        String bookCar = scanner.nextLine();
                        for (int i = 0; i < garage.availableCars.size(); i++) {
                            Car individualCar = garage.availableCars.get(i);
                            if (individualCar.getId().contains(bookCar)) {
                                company.bookCar(individualCar, garage.rentedCars, garage.availableCars);
                                System.out.println("Thank you " + customer.getFirstName());

                                try {
                                    File carDB = new File("src/carDB.txt");
                                    FileWriter myWriter = new FileWriter("carDB.txt", true);
                                    myWriter.write(String.valueOf(individualCar) + " RESERVED BY " + customer + "\n");
                                    myWriter.close();
                                } catch (IOException e) {
                                    System.out.println("An Error has occurred!");
                                    e.printStackTrace();
                                }
                            }
                        }

                    } else {
                        System.out.println("No problem, have a lovely day!");
                    }
                    restart(garage, company, database, newCustomer);

                case 2:
                    System.out.println("You want to return a car?");
                    scanner.nextLine();
                    String userAns = scanner.nextLine();
                    if (userAns.equalsIgnoreCase("y")) {
                        System.out.println("Here's a list of rented cars");
                        System.out.println(garage.rentedCars);
                        System.out.println("Please enter your rented car id");
                        String carId = scanner.nextLine();
                        for (int i = 0; i < garage.rentedCars.size(); i++) {
                            Car individualCar = garage.rentedCars.get(i);
                            if (individualCar.getId().contains(carId)) {
                                company.returnCar(individualCar, garage.rentedCars, garage.availableCars);
                                System.out.println(garage.availableCars);
                            }
                        }
                    } else {
                        System.out.println("No problem, happy renting!");
                    }

                    restart(garage, company, database, newCustomer);

                case 3:
                    System.out.println("Thank you for your time.");
                    break;
                default:
                    System.out.println("Please pick between option 1 and 3.");
                    restart(garage, company, database, newCustomer);
            }
        }

    }
}
