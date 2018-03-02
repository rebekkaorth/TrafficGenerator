import org.junit.Test;

import static org.junit.Assert.*;

public class MoveVehicleNorthTest {

    MoveVehicleNorth vehicle;

    @Test
    public void direction() {
        Grid grid = new Grid(10, 20);
        Vehicle v = new Vehicle("north", 200, 0, 5);
        vehicle = new MoveVehicleNorth(grid, v);
        assertEquals(10, vehicle.direction());
    }

    @Test
    public void setForm() {
        Grid grid = new Grid(10, 20);
        Vehicle v = new Vehicle("north", 200, 0, 5);
        vehicle = new MoveVehicleNorth(grid, v);
        assertEquals("-", vehicle.setForm());
    }
}