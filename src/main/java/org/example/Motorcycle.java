package org.example;

public class Motorcycle extends Vehicle {
    private int engineCapacity;

    public Motorcycle(String plateNumber, String model, double rate, int engineCapacity) {
        super(plateNumber, model, rate);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + " [Engine Capacity: " + engineCapacity + "cc]";
    }
}