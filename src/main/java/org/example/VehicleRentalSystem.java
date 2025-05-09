package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {
    private List<Vehicle> fleet = new ArrayList<>();
    private List<RentalLog> logs = new ArrayList<>();


    public void addVehicle(Vehicle v) {
        fleet.add(v);
    }

    public void rentVehicle(Customer c, String plate, LocalDate rentDate, LocalDate returnDate) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getPlateNumber().equals(plate) && vehicle.isAvailable()) {
                if (vehicle.rent()) {
                    logs.add(new RentalLog(vehicle, c, rentDate, returnDate));
                    System.out.println("Rented: " + vehicle);
                    return;
                }
            }
        }
        System.out.println("Vehicle not available.");
    }

    public void returnVehicle(String plate) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getPlateNumber().equals(plate) && !vehicle.isAvailable()) {
                vehicle.returnVehicle();
                System.out.println("Returned: " + vehicle);
                return;
            }
        }
        System.out.println("vehicle not found or already available.");
    }

    public void saveFleetToFile() {
        // TODO writes information about the fleet to an external file
    }

    public void loadFleetFromFile() {
        // TODO reads and prints information about the fleet from a file
    }

    // getters
}
