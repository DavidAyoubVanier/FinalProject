import org.example.Motorcycle;
import org.example.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MotorcycleTest {

    @Test
    public void testRent() {
        Motorcycle motorcycle = new Motorcycle("B005", "KTM RC390", 50.0, 370);
        Assertions.assertTrue(motorcycle.isAvailable());

        motorcycle.rent();

        Assertions.assertFalse(motorcycle.isAvailable());
    }

    @Test
    public void testDoubleRent() {
        Motorcycle motorcycle = new Motorcycle("B005", "KTM RC390", 50.0, 370);

        motorcycle.rent();
        Assertions.assertFalse(motorcycle.isAvailable());

        // Try to rent again
        motorcycle.rent(); // Checks is there's an effect, shouldn't change anything or crash
        Assertions.assertFalse(motorcycle.isAvailable());
    }

    @Test
    public void testReturnVehicle() {
        Motorcycle motorcycle = new Motorcycle("B005", "KTM RC390", 50.0, 370);
        motorcycle.rent();
        motorcycle.returnVehicle();

        Assertions.assertTrue(motorcycle.isAvailable());
    }

    @Test
    public void testToStringAvailable() {
        Motorcycle motorcycle = new Motorcycle("B005", "KTM RC390", 50.0, 370);
        String expected = "KTM RC390 [B005] - $50.0 per day (Available) [Engine Capacity: 370cc]";
        Assertions.assertEquals(expected, motorcycle.toString());
    }

    @Test
    public void testToStringRented() {
        Motorcycle motorcycle = new Motorcycle("B005", "KTM RC390", 50.0, 370);
        motorcycle.rent();
        String expected = "KTM RC390 [B005] - $50.0 per day (Rented) [Engine Capacity: 370cc]";
        Assertions.assertEquals(expected, motorcycle.toString());
    }
}
