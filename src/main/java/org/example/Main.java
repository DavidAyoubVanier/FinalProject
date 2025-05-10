package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // VehicleRentalSystem object
        VehicleRentalSystem system = new VehicleRentalSystem();

        // Some vehicles
        Car car = new Car("A008", "Hyundai Elantra", 70.0, 14);
        Motorcycle motorcycle = new Motorcycle("B007", "Kawasaki Z650", 65.0, 650);

        // Add the vehicles to the fleet
        system.addVehicle(car);
        system.addVehicle(motorcycle);

        // Some customers and employees
        Customer customer = new Customer("CU04", "Nick");
        Employee employee = new Employee("EM06", "Matthew");

        // Display available vehicles
        System.out.println("Available vehicles for customers:");
        System.out.println(customer.viewAvailableVehicles(system.getFleet()));

        System.out.println("\nAvailable vehicles for employees:");
        System.out.println(employee.viewAvailableVehicles(system.getFleet()));

        // Rent a vehicle
        System.out.println("\nRenting a vehicle...");
        LocalDate rentDate = LocalDate.of(2024, 5, 1);
        LocalDate returnDate = LocalDate.of(2024, 5, 5);
        System.out.println(system.rentVehicle(customer, "A008", rentDate, returnDate));

        // Return a vehicle
        system.returnVehicle("A008");
        System.out.println("\nAvailable vehicles after returning the vehicle:");
        System.out.println(customer.viewAvailableVehicles(system.getFleet()));

        // Some rental logs and durations
        RentalLog log = new RentalLog(car, customer, rentDate, returnDate);
        System.out.println("\nRental Log:");
        System.out.println(log);
        System.out.println("Rental Duration: " + log.getDuration() + " days");
    }
}