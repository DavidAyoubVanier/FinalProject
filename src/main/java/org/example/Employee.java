package org.example;

import java.util.List;

public class Employee extends User {
    public Employee(String id, String name) {
        super(id, name);
    }
    @Override
    public void viewAvailableVehicles(List<Vehicle> fleet) {
        fleet.forEach(System.out::println);
    }

    public void viewRentalLogs(List<RentalLog> logs) {
        logs.forEach(System.out::println);
    }
}
