import org.example.Car;
import org.example.Customer;
import org.example.Motorcycle;
import org.example.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    @Test
    public void testViewAvailableVehicles_withAvailableVehicles() {
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Car("A001", "Toyota Corolla", 100.0, 15));
        fleet.add(new Motorcycle("B002", "Yamaha YZF-R1", 75.0, 950));

        Customer customer = new Customer("CU01", "John");

        String expected = "Toyota Corolla [A001] - $100.0 per day (Available) [Trunk: 15 cu ft], " +
                "Yamaha YZF-R1 [B002] - $75.0 per day (Available) [Engine Capacity: 950cc]";
        String result = customer.viewAvailableVehicles(fleet);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testViewAvailableVehiclesWithAvailableAndRented() {
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Car("A001", "Toyota Corolla", 100.0, 15));
        fleet.add(new Motorcycle("B002", "Yamaha YZF-R1", 75.0, 950));
        fleet.get(1).rent();

        Customer customer = new Customer("CU01", "John");

        String expected = "Toyota Corolla [A001] - $100.0 per day (Available) [Trunk: 15 cu ft]";
        String result = customer.viewAvailableVehicles(fleet);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testViewAvailableVehicles_noAvailableVehicles() {
        List<Vehicle> fleet = new ArrayList<>();
        Customer customer = new Customer("CU01", "John");
        Car car = new Car("A002", "BMW X5", 150.0, 34);
        car.setAvailable(false);
        Motorcycle motorcycle = new Motorcycle("B001", "Suzuki SV650", 85.0, 645);
        motorcycle.setAvailable(false);
        fleet.add(car);
        fleet.add(motorcycle);

        String expected = "No available vehicles.";
        String result = customer.viewAvailableVehicles(fleet);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testViewAvailableVehicles_withNullFleet() {
        Customer customer = new Customer("CU01", "John");

        String expected = "Our fleet is currently empty.";
        String result = customer.viewAvailableVehicles(null);
        Assertions.assertEquals(expected, result);
    }
}
