/**
 * moves vehicles form south to north
 */

public class MoveVehicleSouth implements MoveVehicle, Runnable {

    /**
     * fields of the MoveVehicleSouth class
     */
    private Grid currentGrid;
    private Vehicle vehicle;
    private int distance;

    /**
     * constructor of the MoveVehicleSouth class
     * gets the grid the vehicle moves in and the vehicle it moves
     * sets the distance (= distance the vehicle travelled) to 0
     * @param grid
     * @param vehicle
     */
    public MoveVehicleSouth(Grid grid, Vehicle vehicle) {
        this.currentGrid = grid;
        this.vehicle = vehicle;
        this.distance = 0;
    }

    /**
     * Gets the size of first dimension of the array (-> grid)
     * Represents the maximum distance the vehicle can "travel"
     * @return currentGrid.getHeight()
     */
    public int direction() {
        return currentGrid.getHeight();
    }

    /**
     * sets the form of the vehicle to "-" (based on its direction "south")
     * @return "-"
     */
    public String setForm() {
        return "-";
    }

    /**
     * lets the vehicle enter and leave positions as long as the vehicle has not travelled the its maximum distance.
     * it lets the vehicle leave its last position on the grid when it has travelled through the whole grid.
     */
    @Override
    public void run() {
        while(distance < direction()) {
            try {
                Thread.sleep(vehicle.getSpeed()); //delay of the vehicle leaving and entering position
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentGrid.enterPosition(vehicle.getPositionX(), vehicle.getPositionY(), this.setForm());
            if(vehicle.getPositionX() < direction()-1) { //tests if vehicle has already left its initial position
                //the vehicle leaves it old position only when it could enter its new position
                currentGrid.leavePosition(vehicle.getPositionX() + 1, vehicle.getPositionY());
            }
            vehicle.setPositionX(vehicle.getPositionX() - 1); //next position of the vehicle is set
            distance++;
        }
        try {
            Thread.sleep(vehicle.getSpeed()); //leaving of the final position needs to be delayed as before
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //vehicle leaves final position in grid
        currentGrid.leavePosition(vehicle.getPositionX() + 1, vehicle.getPositionY());
    }
}
