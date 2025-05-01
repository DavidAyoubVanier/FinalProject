package org.example;

public class Car extends Vehicle {
    private int trunkSize;

    public Car(String plateNumber, String model, double rate, int trunkSize) {
        super(plateNumber, model, rate);
        this.trunkSize = trunkSize;
    }

    public int getTrunkSize() {
        return trunkSize;
    }

    public void setTrunkSize(int trunkSize) {
        this.trunkSize = trunkSize;
    }

    @Override
    public String toString() {
        return "Car{" +
                "trunkSize=" + trunkSize +
                '}' + super.toString();
    }
}
