/**
 * Main method for specifications - Level 1.
 * One grid is printed for 2000 times every 20ms on its own thread.
 * One traffic generator creates vehicles with random direction (north-south // west - east), random speed,
 * random start position. Each on one thread.
 */
public class AE_Spec_1 {

    public static void main(String[] args) {
        Grid newGrid = new Grid(10, 20);
        PrintGrid printGrid = new PrintGrid(newGrid, 2000, 20);
        Thread gridThread = new Thread(printGrid);
        gridThread.start();
        int[] rowsToDrawNW = {0, 10};
        int[] columnsToDrawNW = {0,20};
        TrafficGeneratorNorthWest trafficGeneratorNorthWest = new TrafficGeneratorNorthWest(800, newGrid, rowsToDrawNW, columnsToDrawNW);
        Thread trafficThreadOne = new Thread(trafficGeneratorNorthWest);
        trafficThreadOne.start();
    }
}