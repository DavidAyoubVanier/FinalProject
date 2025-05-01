package org.example;

import java.util.Objects;

public abstract class Vehicle implements Rentable, Comparable<Vehicle> {
    private String plateNumber;
    private String model;
    private double rate;
    private boolean available;

    public Vehicle(String plateNumber, String model, double rate) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.rate = rate;
        this.available = true;
    }

    @Override
    public boolean rent() {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean returnVehicle() {
        available = true;
        return true;
    }

    @Override
    public int compareTo(Vehicle other) {
        return Double.compare(this.rate, other.rate);
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(rate, vehicle.rate) == 0 && available == vehicle.available && Objects.equals(plateNumber, vehicle.plateNumber) && Objects.equals(model, vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, model, rate, available);
    }

    @Override
    public String toString() {
        return model + " [" + plateNumber + "] - $" + rate + " per day (" +
                (available ? "Available" : "Rented") + ")";
    }
}
