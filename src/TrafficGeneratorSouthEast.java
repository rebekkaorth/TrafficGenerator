

import java.util.ArrayList;
import java.util.Random;

public class TrafficGeneratorSouthEast implements TrafficGenerator, Runnable{

    private int printDelay;
    private String format;
    private Grid grid;
    private int[] rowsToDrawIn;
    private int[] columnsToDrawIn;


    public TrafficGeneratorSouthEast(int printDelay, Grid grid, int[] rowsToDrawIn, int[] columnsToDrawIn) {
        this.printDelay = printDelay;
        this.format = " ";
        this.grid = grid;
        this.rowsToDrawIn = rowsToDrawIn;
        this.columnsToDrawIn = columnsToDrawIn;
    }

    public Vehicle newVehicle() {
        return new Vehicle(randomFormat(), randomSpeed(), startingPositionX(format), startingPositionY(format));
    }

    public String randomFormat() {
        String formatResult;
        ArrayList<String> formats = new ArrayList<>();
        formats.add("south");
        formats.add("east");
        formatResult = formats.get(new Random().nextInt(formats.size()));
        format = formatResult;
        return formatResult;
    }

    public int randomSpeed(){
        return (int) (Math.random() * (300 - this.printDelay)) + this.printDelay; //limit of delay/ speed of cars?
    }

    public int startingPositionX(String format) {
        if(format.equals("east")) {
            return (int) (Math.random() * (this.rowsToDrawIn[1]-this.rowsToDrawIn[0]) + this.rowsToDrawIn[0]);
        } else {
            return this.rowsToDrawIn[1];
        }
    }

    public int startingPositionY(String format) {
        if (format.equals("south")) {
            return (int) (Math.random() * (this.columnsToDrawIn[1]-this.columnsToDrawIn[0])+ this.columnsToDrawIn[0]);
        } else {
            return  this.columnsToDrawIn[1];
        }
    }

    public void buildTraffic() {
        Vehicle newVehicle = newVehicle();
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

    @Override
    public void run() {
        for(;;) {
            try {
                Thread.sleep(printDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.buildTraffic();
        }
    }

    /*public static void main (String[] args) {
        Grid grid = new Grid(10, 20);
        TrafficGeneratorNorthWest trafficGen = new TrafficGeneratorNorthWest(20, grid); //needs fixing
        Thread trafficGenThread = new Thread(trafficGen);
        trafficGenThread.start();
    }*/



    //MAIN METHODS FOR TESTING

    //MAIN + BUILD TRAFFIC - 2 CARS

    /*public static void main (String[] args) {
        TrafficGeneratorNorthWest trafficGen = new TrafficGeneratorNorthWest(2000); //needs fixing
        trafficGen.buildTraffic();
    }*/

    /*public void buildTraffic() {
        Grid grid = new Grid(10, 20);
        PrintGrid printGrid = new PrintGrid(grid, 2000, 20);
        Thread gridThread = new Thread(printGrid);
        gridThread.start();
        Vehicle nVehicle = new Vehicle("-", 200, 0, 5);
        MoveVehicle moveVehicleNorth = new MoveVehicle(grid, nVehicle);
        Thread nVehicleThread = new Thread(moveVehicleNorth);
        nVehicleThread.start();
        Vehicle wVehicle = new Vehicle("o", 200,5, 0);
        MoveVehicle moveVehicleWest = new MoveVehicle(grid, wVehicle);
        Thread wVehicleThread = new Thread(moveVehicleWest);
        wVehicleThread.start();
    }*/
}
