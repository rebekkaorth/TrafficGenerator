

public class MoveVehicleEast implements MoveVehicle, Runnable {

    private Grid currentGrid;
    private Vehicle vehicle;
    private int distance;

    public MoveVehicleEast(Grid grid, Vehicle vehicle) {
        this.currentGrid = grid;
        this.vehicle = vehicle;
        this.distance = 0;
    }

    public int direction() {
        return currentGrid.getWidth();
    }

    public String setForm() {
        return "o";
    }

    @Override
    public void run() {
        while (distance < direction()) {
            try {
                Thread.sleep(vehicle.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentGrid.enterPosition(vehicle.getPositionX(), vehicle.getPositionY(), this.setForm());
            if (vehicle.getPositionY() < direction()-1) {
                currentGrid.leavePosition(vehicle.getPositionX(), vehicle.getPositionY() + 1);
            }
            vehicle.setPositionY(vehicle.getPositionY() - 1);
            distance++;
        }
        try {
            Thread.sleep(vehicle.getSpeed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        currentGrid.leavePosition(vehicle.getPositionX(), vehicle.getPositionY() + 1);
    }
}
