package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RentalLog {
    private Vehicle vehicle;
    private Customer customer;
    private LocalDate rentDate;
    private LocalDate returnDate;

    public RentalLog(Vehicle vehicle, Customer customer, LocalDate rentDate, LocalDate returnDate) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return customer + " rented " + vehicle + " from " + rentDate + " to " + returnDate;
    }

    // Shows the rental time
    public long getDuration() {
        return ChronoUnit.DAYS.between(rentDate, returnDate);
    }
}