

import java.util.ArrayList;
import java.util.Random;

public class TrafficGeneratorNorthWest implements TrafficGenerator, Runnable {

    private int printDelay;
    private String format;
    private Grid grid;
    private int[] rowsToDrawIn;
    private int[] columnsToDrawIn;
    private Report generatorReport;
    private boolean exit;


    public TrafficGeneratorNorthWest(int printDelay, Grid grid, int[] rowsToDrawIn, int[] columnsToDrawIn) {
        this.printDelay = printDelay;
        this.format = " ";
        this.grid = grid;
        this.rowsToDrawIn = rowsToDrawIn;
        this.columnsToDrawIn = columnsToDrawIn;
        this.generatorReport = new Report("TrafficGeneratorNorthWest");
        this.exit = false;
    }

    public Vehicle newVehicle() {
        return new Vehicle(randomFormat(), randomSpeed(), startingPositionX(format), startingPositionY(format));
    }

    public String randomFormat() {
        String formatResult;
        ArrayList<String> formats = new ArrayList<>();
        formats.add("north");
        formats.add("west");
        formatResult = formats.get(new Random().nextInt(formats.size()));
        format = formatResult;
        return formatResult;
    }

    public int randomSpeed(){
        return (int) (Math.random() * (800 - this.printDelay)) + this.printDelay; //limit of delay/ speed of cars?
    }

    public int startingPositionX(String format) {
        if(format.equals("west")) {
            return (int) (Math.random() * (this.rowsToDrawIn[1]-this.rowsToDrawIn[0]) + this.rowsToDrawIn[0]);
        } else {
            return 0;
        }
    }

    public int startingPositionY(String format) {
        if (format.equals("north")) {
            return (int) (Math.random() * (this.columnsToDrawIn[1]-this.columnsToDrawIn[0])+ this.columnsToDrawIn[0]);
        } else {
            return  0;
        }
    }

    public void buildTraffic() {
        Vehicle newVehicle = newVehicle();
        generatorReport.addVehicleSpeedToReport(newVehicle.getSpeed());
        if(format.equals("north")) {
            MoveVehicleNorth moveVehicleNorth = new MoveVehicleNorth(grid, newVehicle);
            Thread nVehicleThread = new Thread(moveVehicleNorth);
            nVehicleThread.start();
        } else if (format.equals("west")) {
            MoveVehicleWest moveVehicleWest = new MoveVehicleWest(grid, newVehicle);
            Thread wVehicleThread = new Thread(moveVehicleWest);
            wVehicleThread.start();
        }
    }

    public Report getReport() {
        return generatorReport;
    }

    @Override
    public void run() {
        while(!exit) {
            try {
                Thread.sleep(printDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.buildTraffic();
        }
    }

    public void stop() {
        exit = true;
    }

    //MAIN METHODS FOR TESTING

    //MAIN + BUILD TRAFFIC - 1 CARS

    public static void main (String[] args) {
        Grid grid = new Grid(10, 20);
        PrintGrid printGrid = new PrintGrid(grid, 2000, 20);
        Thread gridThread = new Thread(printGrid);
        gridThread.start();
        int[] r = {0, 9};
        int[] c = {0, 19};
        TrafficGeneratorNorthWest trafficGen = new TrafficGeneratorNorthWest(200, grid, r, c);
        trafficGen.buildTraffic();
    }
}
