package org.example;

import java.util.List;

public class Customer extends User {
    public Customer(String id, String name) {
        super(id, name);
    }

    @Override
    public void viewAvailableVehicles(List<Vehicle> fleet) {
        fleet.stream()
                .filter(Vehicle::isAvailable)
                .forEach(System.out::println);
    }
}
