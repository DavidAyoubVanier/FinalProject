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


    public void addVehicle(Vehicle v) {
        fleet.add(v);
    }

    public void rentVehicle(Customer c, String plate, LocalDate rentDate, LocalDate returnDate) {
        for (Vehicle v : fleet) {
            if (v.getPlateNumber().equals(plate) && v.isAvailable()) {
                if (v.rent()) {
                    logs.add(new RentalLog(v, c, rentDate, returnDate));
                    System.out.println("Rented: " + v);
                    return;
                }
            }
        }
        System.out.println("Vehicle not available.");
    }

    public void returnVehicle(String plate) {
        for (Vehicle v : fleet) {
            if (v.getPlateNumber().equals(plate) && !v.isAvailable()) {
                v.returnVehicle();
                System.out.println("Returned: " + v);
                return;
            }
        }
        System.out.println("vehicle not found or already available.");
    }

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

    // getters
}
