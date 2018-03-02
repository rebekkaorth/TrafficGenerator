/**
 * traffic generator for vehicles that either drive form south to north or from east to west
 */

import java.util.ArrayList;
import java.util.Random;

public class TrafficGeneratorSouthEast implements TrafficGenerator, Runnable{

    /**
     * fields of the TrafficGeneratorSouthEast class
     */
    private boolean exit;
    private int printDelay;
    private String format;
    private Grid grid;
    private int[] rowsToDrawIn;
    private int[] columnsToDrawIn;
    private Report generatorReport;


    /**
     * constructor of the TrafficGeneratorNorthWest class
     * @param printDelay
     * @param grid
     * @param rowsToDrawIn
     * @param columnsToDrawIn
     */
    public TrafficGeneratorSouthEast(int printDelay, Grid grid, int[] rowsToDrawIn, int[] columnsToDrawIn) {
        this.printDelay = printDelay;
        this.format = " ";
        this.grid = grid;
        this.rowsToDrawIn = rowsToDrawIn;
        this.columnsToDrawIn = columnsToDrawIn;
        this.generatorReport = new Report("TrafficGeneratorSouthEast");
        this.exit = false;
    }

    /**
     * returns a new vehicle object
     * @return new Vehicle
     */
    public Vehicle newVehicle() {
        return new Vehicle(randomDirection(), randomSpeed(), startingPositionX(format), startingPositionY(format));
    }

    /**
     * returns the direction of the vehicle - either north or west
     * @return formatResult
     */
    public String randomDirection() {
        String formatResult;
        ArrayList<String> formats = new ArrayList<>();
        formats.add("south");
        formats.add("east");
        formatResult = formats.get(new Random().nextInt(formats.size()));
        format = formatResult;
        return formatResult;
    }

    /**
     * returns the random speed of the vehicle - speed can be between 800ms and the print delay of the traffic
     * generator
     * @return speed
     */
    public int randomSpeed(){
        return (int) (Math.random() * (800 - this.printDelay)) + this.printDelay; //limit of delay/ speed of cars?
    }

    /**
     * returns a random starting position in the first dimension of the grid
     * when the direction is east: the starting position is between 0 and the height of the grid
     * when the direction is south: the starting position is 0
     * @param format
     * @return startingPositionX
     */
    public int startingPositionX(String format) {
        if(format.equals("east")) {
            return (int) (Math.random() * (this.rowsToDrawIn[1]-this.rowsToDrawIn[0]) + this.rowsToDrawIn[0]);
        } else {
            return this.rowsToDrawIn[1];
        }
    }

    /**
     * returns a random starting position in the second dimension of the gird
     * when the direction is south: the starting position is between 0 and the width of the grid
     * when direction is east: the starting position is 0
     * @param format
     * @return startingPositionY
     */
    public int startingPositionY(String format) {
        if (format.equals("south")) {
            return (int) (Math.random() * (this.columnsToDrawIn[1]-this.columnsToDrawIn[0])+ this.columnsToDrawIn[0]);
        } else {
            return  this.columnsToDrawIn[1];
        }
    }

    /**
     * builds new vehicles and gives them to MoveVehicle objects depending on the direction of the vehicle
     * creates new threads for each vehicle
     */
    public void buildTraffic() {
        Vehicle newVehicle = newVehicle();
        generatorReport.addVehicleSpeedToReport(newVehicle.getSpeed());
        if(format.equals("south")) {
            MoveVehicleSouth moveVehicleSouth = new MoveVehicleSouth(grid, newVehicle);
            Thread nVehicleThread = new Thread(moveVehicleSouth);
            nVehicleThread.start();
        } else if (format.equals("east")) {
            MoveVehicleEast moveVehicleEast = new MoveVehicleEast(grid, newVehicle);
            Thread wVehicleThread = new Thread(moveVehicleEast);
            wVehicleThread.start();
        }
    }

    /**
     * returns the report of the traffic generator
     * @return generatorReport
     */
    public Report getReport() {
        return generatorReport;
    }

    /**
     * builds traffic after printDelay has past
     */
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

    /**
     * sets the boolean exit to true to stop thread
     */
    public void stop(){
        exit = true;
    }

    //MAIN METHODS FOR TESTING

    //MAIN + BUILD TRAFFIC - 1 CARS

    /*public static void main (String[] args) {
        Grid grid = new Grid(10, 20);
        PrintGrid printGrid = new PrintGrid(grid, 2000, 20);
        Thread gridThread = new Thread(printGrid);
        gridThread.start();
        int[] r = {0, 9};
        int[] c = {0, 19};
        TrafficGeneratorSouthEast trafficGen = new TrafficGeneratorSouthEast(200, grid, r, c);
        trafficGen.buildTraffic();
    }*/

    /*public static void main (String[] args) {
        Grid grid = new Grid(10, 20);
        PrintGrid printGrid = new PrintGrid(grid, 2000, 20);
        Thread gridThread = new Thread(printGrid);
        gridThread.start();
        int[] r = {0, 9};
        int[] c = {0, 19};
        TrafficGeneratorSouthEast trafficGen = new TrafficGeneratorSouthEast(200, grid, r, c);
        trafficGen.buildTraffic();
    }

    public void buildTraffic() {
        Vehicle newVehicleOne = new Vehicle("south", 200, 9, 15);
        Vehicle newVehicleTwo = new Vehicle("east", 200, 5, 19);
        MoveVehicleSouth moveVehicleSouth = new MoveVehicleSouth(grid, newVehicleOne);
        Thread nVehicleThread = new Thread(moveVehicleSouth);
        nVehicleThread.start();
        MoveVehicleEast moveVehicleEast = new MoveVehicleEast(grid, newVehicleTwo);
        Thread wVehicleThread = new Thread(moveVehicleEast);
        wVehicleThread.start();
    }*/
}
