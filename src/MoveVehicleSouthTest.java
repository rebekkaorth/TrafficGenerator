import org.junit.Test;

import static org.junit.Assert.*;

public class MoveVehicleSouthTest {

    MoveVehicleSouth vehicle;

    @Test
    public void direction() {
        Grid grid = new Grid(10, 20);
        Vehicle v = new Vehicle("south", 200, 0, 5);
        vehicle = new MoveVehicleSouth(grid, v);
        assertEquals(10, vehicle.direction());
    }

    @Test
    public void setForm() {
        Grid grid = new Grid(10, 20);
        Vehicle v = new Vehicle("south", 200, 0, 5);
        vehicle = new MoveVehicleSouth(grid, v);
        assertEquals("-", vehicle.setForm());
    }
}