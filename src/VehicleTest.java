import org.junit.Test;
import static org.junit.Assert.*;


public class VehicleTest {

    private Vehicle testVehicle;

    @Test
    public void getFormat() {
        testVehicle = new Vehicle("north", 200, 7, 0);
        assertEquals("north", testVehicle.getDirection());
    }

    @Test
    public void getSpeed() {
        testVehicle = new Vehicle("north", 200, 7, 0);
        assertEquals(200, testVehicle.getSpeed());
    }

    @Test
    public void getPositionX() {
        testVehicle = new Vehicle("north", 200, 7, 0);
        assertEquals(7, testVehicle.getPositionX());
    }

    @Test
    public void getPositionY() {
        testVehicle = new Vehicle("north", 200, 7, 0);
        assertEquals(0, testVehicle.getPositionY());
    }

}