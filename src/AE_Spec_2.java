

public class AE_Spec_2 {
    public static void main(String[] args) {
        Statistic stats = new Statistic();
        Grid newGrid = new Grid(10, 20);
        PrintGrid printGrid = new PrintGrid(newGrid, 2000, 20);
        Thread gridThread = new Thread(printGrid);
        gridThread.start();
        int[] rowsToDrawNW = {0, 4};
        int[] columnsToDrawNW = {0, 9};
        TrafficGeneratorNorthWest trafficGeneratorNorthWest = new TrafficGeneratorNorthWest(850, newGrid, rowsToDrawNW, columnsToDrawNW);
        Thread trafficThreadOne = new Thread(trafficGeneratorNorthWest);
        trafficThreadOne.start();
        int[] rowsToDrawSE = {5, 9};
        int[] columnsToDrawSE = {10, 19};
        TrafficGeneratorSouthEast trafficGeneratorSouthEast = new TrafficGeneratorSouthEast(900, newGrid, rowsToDrawSE, columnsToDrawSE);
        Thread trafficThreadTwo = new Thread(trafficGeneratorSouthEast);
        trafficThreadTwo.start();
        try {
            gridThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        trafficGeneratorNorthWest.stop();
        trafficGeneratorSouthEast.stop();
        stats.addGenerators(trafficGeneratorNorthWest.getReport());
        stats.addGenerators(trafficGeneratorSouthEast.getReport());
        System.out.println(stats.printStatistics());
    }
}
