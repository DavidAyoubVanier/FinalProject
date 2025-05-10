import org.example.Car;
import org.example.Customer;
import org.example.RentalLog;
import org.example.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalLogTest {

    @Test
    public void testGetDurationNormalCase() {
        Vehicle car = new Car("A007", "Kia Optima", 55.0, 16);
        Customer customer = new Customer("Emma", "CU04");
        LocalDate rentDate = LocalDate.of(2024, 4, 10);
        LocalDate returnDate = LocalDate.of(2024, 4, 15);

        RentalLog log = new RentalLog(car, customer, rentDate, returnDate);
        long expected = 5;
        long result = log.getDuration();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetDurationSameDay() {
        Vehicle car = new Car("A007", "Kia Optima", 55.0, 16);
        Customer customer = new Customer("Emma", "CU04");
        LocalDate date = LocalDate.of(2024, 6, 1);

        RentalLog log = new RentalLog(car, customer, date, date);
        long expected = 0;
        long result = log.getDuration();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetDurationLeapYear() {
        Vehicle car = new Car("A007", "Kia Optima", 55.0, 16);
        Customer customer = new Customer("Emma", "CU04");
        LocalDate rentDate = LocalDate.of(2024, 2, 28);
        LocalDate returnDate = LocalDate.of(2024, 3, 1);

        RentalLog log = new RentalLog(car, customer, rentDate, returnDate);
        long expected = 2;
        long result = log.getDuration();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testToString() {
        Vehicle car = new Car("A007", "Kia Optima", 55.0, 16);
        Customer customer = new Customer("Emma", "CU04");
        LocalDate rentDate = LocalDate.of(2024, 4, 10);
        LocalDate returnDate = LocalDate.of(2024, 4, 15);

        RentalLog log = new RentalLog(car, customer, rentDate, returnDate);
        String expected = customer + " rented " + car + " from 2024-04-10 to 2024-04-15";
        String result = log.toString();

        Assertions.assertEquals(expected, result);
    }
}