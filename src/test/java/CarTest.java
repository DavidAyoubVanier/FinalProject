import org.example.Car;
import org.example.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void testRent() {
        Car car = new Car("A004", "Audi R8", 150.0, 4);
        Assertions.assertTrue(car.isAvailable());

        car.rent();

        Assertions.assertFalse(car.isAvailable());
    }

    @Test
    public void testDoubleRent() {
        Car car = new Car("A004", "Audi R8", 150.0, 4);

        car.rent();
        Assertions.assertFalse(car.isAvailable());
        // Attempt to rent again
        car.rent(); // Checks is there's an effect, shouldn't change anything or crash
        Assertions.assertFalse(car.isAvailable());
    }

    @Test
    public void testReturnVehicle() {
        Car car = new Car("A004", "Audi R8", 150.0, 4);
        car.rent();
        car.returnVehicle();

        Assertions.assertTrue(car.isAvailable());
    }

    @Test
    public void testToStringAvailable() {
        Car car = new Car("A004", "Audi R8", 150.0, 4);
        String expected = "Audi R8 [A004] - $150.0 per day (Available) [Trunk: 4 cu ft]";
        Assertions.assertEquals(expected, car.toString());
    }

    @Test
    public void testToStringRented() {
        Car car = new Car("A004", "Audi R8", 150.0, 4);
        car.rent(); // changes availability
        String expected = "Audi R8 [A004] - $150.0 per day (Rented) [Trunk: 4 cu ft]";
        Assertions.assertEquals(expected, car.toString());
    }


}
