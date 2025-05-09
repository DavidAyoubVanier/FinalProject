import org.example.Car;
import org.example.Customer;
import org.example.Motorcycle;
import org.example.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    @Test
    public void testViewAvailableVehiclesForCustomer() {
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Car("A001", "Toyota Corolla", 100.0, 15));
        fleet.add(new Motorcycle("B002", "Yamaha YZF-R1", 75.0, 950));
        fleet.get(1).rent();

        Customer customer = new Customer("CU01", "John");

        String expected = "Toyota Corolla [A001] - $100.0 per day (Available) [Trunk: 15 cu ft]";
        String result = customer.viewAvailableVehicles(fleet);
        Assertions.assertEquals(expected, result);
    }
}
