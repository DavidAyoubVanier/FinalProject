import org.example.Car;
import org.example.Customer;
import org.example.Vehicle;
import org.example.VehicleRentalSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;

public class VehicleRentalSystemTest {

    @Test
    public void testAddVehicle() {
        VehicleRentalSystem system = new VehicleRentalSystem();
        Vehicle car = new Car("A005", "Honda Civic", 50.0, 15);
        Customer customer = new Customer("CU03", "Charles");
        system.addVehicle(car);

        boolean expected = true;
        boolean result = car.isAvailable();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testReturnVehicle() {
        VehicleRentalSystem system = new VehicleRentalSystem();
        Vehicle car = new Car("A005", "Honda Civic", 50.0, 15);
        Customer customer = new Customer("CU03", "Charles");
        system.addVehicle(car);
        system.rentVehicle(customer, "A005", LocalDate.now(), LocalDate.now().plusDays(3));

        String result = system.returnVehicle("A005");
        String expected = "Returned: Honda Civic [A005] - $50.0 per day (Available) [Trunk: 15 cu ft]";

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testReturnVehicleNotRented() {
        VehicleRentalSystem system = new VehicleRentalSystem();
        Vehicle car = new Car("A005", "Honda Civic", 50.0, 15);
        system.addVehicle(car);

        String result = system.returnVehicle("A005");
        String expected = "Vehicle not found or already available.";

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testReturnVehicleNotExisting() {
        VehicleRentalSystem system = new VehicleRentalSystem();
        Vehicle car = new Car("A005", "Honda Civic", 50.0, 15);
        system.addVehicle(car);

        String result = system.returnVehicle("D006");
        String expected = "Vehicle not found or already available.";

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testReturnVehicleWhenNotRented() {
        VehicleRentalSystem system = new VehicleRentalSystem();
        Vehicle car = new Car("A005", "Honda Civic", 50.0, 15);

        String expected = "Vehicle not found or already available.";
        String result = system.returnVehicle("A005");

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testRentVehicle() {
        VehicleRentalSystem system = new VehicleRentalSystem();
        Vehicle car = new Car("A005", "Honda Civic", 50.0, 15);
        system.addVehicle(car);
        Customer customer = new Customer("CU03", "Charles");

        String result = system.rentVehicle(customer, "A005", LocalDate.now(), LocalDate.now().plusDays(1));
        String expected = "Rented: Honda Civic [A005] - $50.0 per day (Rented) [Trunk: 15 cu ft]";

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testRentVehicleNotAvailable() {
        VehicleRentalSystem system = new VehicleRentalSystem();
        Vehicle car = new Car("A005", "Honda Civic", 50.0, 15);
        Customer customer = new Customer("CU03", "Charles");
        car.setAvailable(false);

        String expected = "Vehicle not available.";
        String result = system.rentVehicle(customer, "A005", LocalDate.now(), LocalDate.now().plusDays(1));

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testRentVehicleNonExisting() {
        VehicleRentalSystem system = new VehicleRentalSystem();
        Vehicle car = new Car("A005", "Honda Civic", 50.0, 15);
        Customer customer = new Customer("CU03", "Charles");

        String expected = "Vehicle not available.";
        String result = system.rentVehicle(customer, "D006", LocalDate.now(), LocalDate.now().plusDays(1));

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testRentVehicleEmptyFleet() {
        VehicleRentalSystem system = new VehicleRentalSystem();
        Customer customer = new Customer("CU03", "Charles");

        String expected = "Vehicle not available.";
        String result = system.rentVehicle(customer, "D006", LocalDate.now(), LocalDate.now().plusDays(1));

        Assertions.assertEquals(expected, result);
    }
}
