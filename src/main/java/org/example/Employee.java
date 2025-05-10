package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Employee extends User {
    public Employee(String id, String name) {
        super(id, name);
    }

    // Shows employees everything in the fleet
    @Override
    public String viewAvailableVehicles(List<Vehicle> fleet) {
        if (fleet == null || fleet.isEmpty()) {
            return "Fleet is empty.";
        }
        String result = fleet.stream()
                .map(Vehicle::toString)
                .collect(Collectors.joining(", "));

        return result.isEmpty() ? "Fleet is empty." : result;
    }

    // Shows employees all the rents and returns
    public void viewRentalLogs(List<RentalLog> logs) {
        logs.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
