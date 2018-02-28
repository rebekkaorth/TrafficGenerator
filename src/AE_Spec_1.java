

class AE_Spec_1 {

    public static void main(String[] args) {
        Grid newGrid = new Grid(10, 20);
        PrintGrid printGrid = new PrintGrid(newGrid, 2000, 20);
        Thread gridThread = new Thread(printGrid);
        gridThread.start();
        int[] rowsToDrawNW = {0, 10};
        int[] columnsToDrawNW = {0,20};
        TrafficGeneratorNorthWest trafficGeneratorNorthWest = new TrafficGeneratorNorthWest(100, newGrid, rowsToDrawNW, columnsToDrawNW);
        Thread trafficThreadOne = new Thread(trafficGeneratorNorthWest);
        trafficThreadOne.start();
    }
}