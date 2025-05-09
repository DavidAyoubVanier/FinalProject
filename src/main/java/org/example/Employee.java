package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Employee extends User {
    public Employee(String id, String name) {
        super(id, name);
    }
    @Override
    public String viewAvailableVehicles(List<Vehicle> fleet) {
        return fleet.stream()
                .map(Vehicle::toString)
                .collect(Collectors.joining(", "));
    }

    public void viewRentalLogs(List<RentalLog> logs) {
        logs.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
