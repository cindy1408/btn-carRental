package com.btn;

import java.sql.*;

public class CarRentalDB {
    // Note 0 is Rent.available 1 = Rent.Unavailable and 2 = Rent.Reserved.

    public void carRentalDB_AddingNewCar(String carId, String model, String plateNumber, double dailyRentPrice, Rent rent, String customer, String drivingLicence) {
        String jdbcURL = "jdbc:mysql://localhost:3306/CarRentalDB";
        String username = "root";
        String password = "L1Gx2.fr023N.";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            int rentString = 0;
            if (rent.equals(Rent.AVAILABLE)) {
                rentString = 0;
            } else if (rent.equals(Rent.UNAVAILABLE)) {
                rentString = 1;
            } else {
                rentString = 2;
            }
            String sql1 = "INSERT INTO car (id, model, plateNumber, dailyRentPrice, rent, customer, drivingLicence)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statements = connection.prepareStatement(sql1);
            statements.setString(1, carId);
            statements.setString(2, model);
            statements.setString(3, plateNumber);
            statements.setDouble(4, dailyRentPrice);
            statements.setInt(5, rentString);
            statements.setString(6, customer);
            statements.setString(7, drivingLicence);

            int rows = statements.executeUpdate();
            if (rows > 0) {
                System.out.println("Your data has been successfully added");
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void carRentalDB_retrieveFullData() {
        String jdbcURL = "jdbc:mysql://localhost:3306/CarRentalDB";
        String username = "root";
        String password = "L1Gx2.fr023N.";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            String sql = "SELECT * FROM Car";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                String carId = result.getString(1);
                String model = result.getString(2);
                String plateNumber = result.getString(3);
                double dailyRentPrice = result.getDouble(4);
                int rawRent = result.getInt(5);
                String customer = result.getString(6);

                Rent rentData = Rent.AVAILABLE;
                switch (rawRent) {
                    case 0:
                        rentData = Rent.AVAILABLE;
                        break;
                    case 1:
                        rentData = Rent.UNAVAILABLE;
                        break;
                    case 2:
                        rentData = Rent.RESERVED;
                }
                System.out.println("id = " + carId + " " + "model = " + model + " " + "plateNumber = " + plateNumber + " " + "dailyRentPrice = " + dailyRentPrice + " " + "rent = " + rentData + " " + "customer = " + customer);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String carRentalDB_retrieveData(Rent rent) {
        String jdbcURL = "jdbc:mysql://localhost:3306/CarRentalDB";
        String username = "root";
        String password = "L1Gx2.fr023N.";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            String sql = "SELECT * FROM Car";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int rawRent = 0;
            Rent rentData = Rent.AVAILABLE;
            if (rent.equals(Rent.AVAILABLE)) {
                rawRent = 0;
                rentData = Rent.AVAILABLE;
            } else {
                rawRent = 1;
                rentData = Rent.UNAVAILABLE;
            }

            while (result.next()) {
                String carId = result.getString(1);
                String model = result.getString(2);
                String plateNumber = result.getString(3);
                String dailyRentPrice = result.getString(4);
                int DataRawRent = result.getInt(5);
                String customer = result.getString(6);

                if (rawRent == DataRawRent) {
                    System.out.println("id = " + carId + " " + "model = " + model + " " + "plateNumber = " + plateNumber + " " + "dailyRentPrice = " + dailyRentPrice + " " + "rent = " + rentData + " " + "customer = " + customer);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "";
    }


    public void carRentalDB_returnRental(String carId) {
        String jdbcURL = "jdbc:mysql://localhost:3306/CarRentalDB";
        String username = "root";
        String password = "L1Gx2.fr023N.";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            String sql = "SELECT * FROM Car";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                String dataCarId = result.getString(1);

                if (dataCarId.equals(carId)) {
                    String updateSql = "UPDATE Car SET rent=? ,customer=?, drivingLicence=? WHERE id=?";
                    PreparedStatement statements = connection.prepareStatement(updateSql);
                    statements.setInt(1, 0);
                    statements.setString(2, null);
                    statements.setString(3, null);
                    statements.setString(4, carId);
                    int rows = statements.executeUpdate();
                    if (rows > 0) {
                        System.out.println("The database has been updated");
                    }
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void carRentalDB_deleteRental(String carId) {
        String jdbcURL = "jdbc:mysql://localhost:3306/CarRentalDB";
        String username = "root";
        String password = "L1Gx2.fr023N.";

        try{
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "DELETE FROM Car WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, carId);

            int row = statement.executeUpdate();
            if(row > 0){
                System.out.println("The car has been deleted successfully.");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void carRentalDB_updateCustomer(String carId, String customer, String drivingLicence) {
        String jdbcURL = "jdbc:mysql://localhost:3306/CarRentalDB";
        String username = "root";
        String password = "L1Gx2.fr023N.";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            String sql = "SELECT * FROM Car";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                String dataCarId = result.getString(1);

                if (dataCarId.equals(carId)) {
                    String updateSql = "UPDATE Car SET rent=?, customer=?, drivingLicence=? WHERE id=?";
                    PreparedStatement statements = connection.prepareStatement(updateSql);
                    statements.setInt(1, 1);
                    statements.setString(2, customer);
                    statements.setString(3, drivingLicence);
                    statements.setString(4, carId);

                    int rows = statements.executeUpdate();
                    if (rows > 0) {
                        System.out.println("The database has been updated");
                    }
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}