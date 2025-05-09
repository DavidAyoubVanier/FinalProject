package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Customer extends User {
    public Customer(String id, String name) {
        super(id, name);
    }

    @Override
    public String viewAvailableVehicles(List<Vehicle> fleet) {
        return fleet.stream()
                .filter(Vehicle::isAvailable)
                .map(Vehicle::toString)
                .collect(Collectors.joining(", "));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
