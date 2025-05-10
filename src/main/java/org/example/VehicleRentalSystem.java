package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleRentalSystem {
    private List<Vehicle> fleet = new ArrayList<>();
    private List<RentalLog> logs = new ArrayList<>();


    // Adds a vehicle to the fleet
    public void addVehicle(Vehicle v) {
        fleet.add(v);
    }

    // Rents a vehicle afer checking its plate number and availability
    public String rentVehicle(Customer c, String plate, LocalDate rentDate, LocalDate returnDate) {
        for (Vehicle v : fleet) {
            if (v.getPlateNumber().equals(plate) && v.isAvailable()) {
                if (v.rent()) {
                    logs.add(new RentalLog(v, c, rentDate, returnDate));
                    return "Rented: " + v;
                }
            }
        }
        return "Vehicle not available.";
    }

    // Returns a vehicle after checking its plate number and availability
    public String returnVehicle(String plate) {
        for (Vehicle v : fleet) {
            if (v.getPlateNumber().equals(plate) && !v.isAvailable()) {
                v.returnVehicle();
                return "Returned: " + v;
            }
        }
        return "Vehicle not found or already available.";
    }

    // Writes vehicle information to an external file
    public void saveFleetToFile(String filename) {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            for (Vehicle v : fleet) {
                String line = v.getClass().getSimpleName() + ", " +
                        v.getPlateNumber() + ", " +
                        v.getModel() + ", " +
                        v.getRate() + ", " +
                        v.isAvailable();
                if (v instanceof Car) {
                    Car car = (Car) v;
                    line += "," + car.getTrunkSize();
                }
                else if (v instanceof Motorcycle){
                    Motorcycle motorcycle = (Motorcycle) v;
                    line += "," + motorcycle.getEngineCapacity();
                }

                fileWriter.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving fleet: " + e.getMessage());
        }
    }

    // Receives vehicle information from an external file
    public void loadFleetFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                String type = data[0];
                String plate = data[1];
                String model = data[2];
                double rate = Double.parseDouble(data[3]);
                boolean available = Boolean.parseBoolean(data[4]);
                Vehicle v;
                if (type.equals("Car")) {
                    int trunkSize = Integer.parseInt(data[5]);
                    v = new Car(plate, model, rate, 500);
                } else {
                    int engineCapacity = Integer.parseInt(data[5]);
                    v = new Motorcycle(plate, model, rate, engineCapacity);
                }
                v.setAvailable(available);
                fleet.add(v);
            }
        } catch (IOException e) {
            System.out.println("Error loading fleet: " + e.getMessage());
        }
    }

    public List<Vehicle> getFleet() {
        return fleet;
    }

    public List<RentalLog> getLogs() {
        return logs;
    }
}