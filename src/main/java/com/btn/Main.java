package com.btn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hey group 5! :D");

        // This is where we put our scanner/ user input/ fetch database

        // save each car into ArrayList
        // save total cars into

//        Car newCar = new Car(1234, "Tesla", "LSH3912S", Rent.AVAILABLE);
//        Car newCar2 = new Car(1213, "Toyota", "LSH3912S", Rent.AVAILABLE);
//
//        System.out.println(newCar);

        // STARTS HERE

        Scanner scanner = new Scanner(System.in);
        System.out.println("Here are the following options: \n1.add a car to full list\n2.remove a car from full list\n3.Lists of available cars\n4.Current rented cars");
        int userOption = scanner.nextInt();

        switch (userOption){
            case 1:

                System.out.println("What is the car model?");
                scanner.nextLine();
                String carModel = scanner.nextLine();


                System.out.println("What is the car plate number?");
                String carPlateNumber = scanner.nextLine();

                System.out.println("Is it currently available? y/n");
                String carAvailability = scanner.nextLine();

                Rent carRent;
                if(carAvailability.trim().equalsIgnoreCase("y")){
                    carRent = Rent.AVAILABLE;
                } else {
                    carRent = Rent.NOTAVAILABLE;
                }

                Car addCar = new Car(carModel, carPlateNumber, carRent);

                System.out.println(addCar);

//                double carPrice = scanner.nextDouble();

//                if(carRent.equals(Rent.AVAILABLE)){
//                    // add to list o
//                } else {
//                    // add to list of rented cars
//                    Rental.addNewCar(addCar, carPrice);
//                }
//                CarManagement.addNewCar(addCar, carPrice);
//
//                System.out.println("You've just added: ");

//
//                System.out.println("You want to add a car");
                break;
            case 2:
                System.out.println("You want to remove a car from full list");
                break;
            case 3:
                System.out.println("You want a list of available cars");
                break;
            case 4:
                System.out.println("You want a list of rented cars");
            default:
                System.out.println("Please pick between option 1 and 4. ");
        }






    }
}
