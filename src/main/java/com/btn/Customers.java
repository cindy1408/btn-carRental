package com.btn;

import java.util.Objects;

public class Customers {
    private String firstName;
    private String lastName;
    private String drivingLicence;

    public Customers(String firstName, String lastName, String drivingLicence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.drivingLicence = drivingLicence;
    }

    public Customers(){};

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return Objects.equals(firstName, customers.firstName) && Objects.equals(lastName, customers.lastName) && Objects.equals(drivingLicence, customers.drivingLicence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, drivingLicence);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", drivingLicence='" + drivingLicence + '\'' +
                '}';
    }
}
