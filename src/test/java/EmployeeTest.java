import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {

    @Test
    public void testViewAvailableVehiclesForEmployee() {
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Car("A001", "Toyota Corolla", 100.0, 15));
        fleet.add(new Motorcycle("B002", "Yamaha YZF-R1", 75.0, 950));
        fleet.get(1).rent();

        Employee employee = new Employee("EM001", "Jaden");

        String expected = "Toyota Corolla [A001] - $100.0 per day (Available) [Trunk: 15 cu ft], " +
                "Yamaha YZF-R1 [B002] - $75.0 per day (Rented) [Engine Capacity: 950cc]";
        String result = employee.viewAvailableVehicles(fleet);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testViewAvailableVehiclesWhenFleetIsEmpty() {
        Employee employee = new Employee("EM02","George");
        List<Vehicle> fleet = new ArrayList<>();

        String expected = "Fleet is empty.";
        String result = employee.viewAvailableVehicles(fleet);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testViewAvailableVehiclesWithAvailableAndRented() {
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Car("A001", "Toyota Corolla", 100.0, 15));
        fleet.add(new Motorcycle("B002", "Yamaha YZF-R1", 75.0, 950));
        fleet.get(1).rent();

        Employee employee = new Employee("EM01", "John");

        String expected = "Toyota Corolla [A001] - $100.0 per day (Available) [Trunk: 15 cu ft], " +
                "Yamaha YZF-R1 [B002] - $75.0 per day (Rented) [Engine Capacity: 950cc]";
        String result = employee.viewAvailableVehicles(fleet);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testViewAvailableVehiclesEmptyFleet() {
        Employee employee = new Employee("EM01", "John");

        String expected = "Fleet is empty.";
        String result = employee.viewAvailableVehicles(null);
        Assertions.assertEquals(expected, result);
    }


}
