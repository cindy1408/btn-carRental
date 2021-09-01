package com.btn;

public class Main {

    public static void main(String[] args) {

        CarManagement garage = new CarManagement();
        Rental company = new Rental();
        CarRentalDB database = new CarRentalDB();
        Customers newCustomer = new Customers();

        Start start = new Start();

        start.welcome(garage, company, database, newCustomer);


    }
}