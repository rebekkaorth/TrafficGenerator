import java.util.ArrayList;
import java.util.Random;

public class TrafficGeneratorSouthEast implements TrafficGenerator, Runnable{

    private boolean exit;
    private int printDelay;
    private String format;
    private Grid grid;
    private int[] rowsToDrawIn;
    private int[] columnsToDrawIn;
    private Report generatorReport;


    public TrafficGeneratorSouthEast(int printDelay, Grid grid, int[] rowsToDrawIn, int[] columnsToDrawIn) {
        this.printDelay = printDelay;
        this.format = " ";
        this.grid = grid;
        this.rowsToDrawIn = rowsToDrawIn;
        this.columnsToDrawIn = columnsToDrawIn;
        this.generatorReport = new Report("TrafficGeneratorSouthEast");
        this.exit = false;
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
        return (int) (Math.random() * (800 - this.printDelay)) + this.printDelay; //limit of delay/ speed of cars?
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

    public void stop(){
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
        TrafficGeneratorSouthEast trafficGen = new TrafficGeneratorSouthEast(2000, grid, r, c);
        trafficGen.buildTraffic();
    }
}
