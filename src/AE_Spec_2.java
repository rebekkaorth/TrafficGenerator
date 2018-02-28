

public class AE_Spec_2 {
    public static void main(String[] args) {
        Grid newGrid = new Grid(10, 20);
        PrintGrid printGrid = new PrintGrid(newGrid, 2000, 2000);
        Thread gridThread = new Thread(printGrid);
        gridThread.start();
        int[] rowsToDrawNW = {0, 4};
        int[] columnsToDrawNW = {0,9};
        TrafficGeneratorNorthWest trafficGeneratorNorthWest = new TrafficGeneratorNorthWest(2000, newGrid, rowsToDrawNW, columnsToDrawNW);
        Thread trafficThreadOne = new Thread(trafficGeneratorNorthWest);
        trafficThreadOne.start();
        int[] rowsToDrawSE = {5, 9};
        int[] columnsToDrawSE = {10,19};
        TrafficGeneratorSouthEast trafficGeneratorSouthEast = new TrafficGeneratorSouthEast(2000, newGrid, rowsToDrawSE, columnsToDrawSE);
        Thread trafficThreadTwo = new Thread(trafficGeneratorSouthEast);
        trafficThreadTwo.start();
    }
}
