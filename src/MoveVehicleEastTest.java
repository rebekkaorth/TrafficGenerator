import org.junit.Test;

import static org.junit.Assert.*;

public class MoveVehicleEastTest {

    MoveVehicleEast vehicle;

    @Test
    public void direction() {
        Grid grid = new Grid(10, 20);
        Vehicle v = new Vehicle("east", 200, 0, 5);
        vehicle = new MoveVehicleEast(grid, v);
        assertEquals(20, vehicle.direction());
    }

    @Test
    public void setForm() {
        Grid grid = new Grid(10, 20);
        Vehicle v = new Vehicle("east", 200, 0, 5);
        vehicle = new MoveVehicleEast(grid, v);
        assertEquals("o", vehicle.setForm());
    }
}