

public class MoveVehicleSouth implements MoveVehicle, Runnable {

    private Grid currentGrid;
    private Vehicle vehicle;
    private int distance;

    public MoveVehicleSouth(Grid grid, Vehicle vehicle) {
        this.currentGrid = grid;
        this.vehicle = vehicle;
        this.distance = 0;
    }

    public int direction() {
        return currentGrid.getHeight();
    }

    public String setForm() {
        return "-";
    }

    @Override
    public void run() {
        while(distance < direction()) {
            try {
                Thread.sleep(vehicle.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentGrid.enterPosition(vehicle.getPositionX(), vehicle.getPositionY(), this.setForm());
            //REFACTOR
            if(vehicle.getPositionX() < direction()-1) {
                currentGrid.leavePosition(vehicle.getPositionX() + 1, vehicle.getPositionY());
            }
            vehicle.setPositionX(vehicle.getPositionX() - 1);
            distance++;
        }
        try {
            Thread.sleep(vehicle.getSpeed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        currentGrid.leavePosition(vehicle.getPositionX() + 1, vehicle.getPositionY());
    }
}
