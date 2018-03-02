/**
 * Main method for Specifications - Level 2.
 * One grid is printed for 2000 times every 20ms.
 * One traffic generator creates vehicles that either drive from west to east or from north to south.
 * One traffic generator creates vehicles that either drive from eas to west of from south to north.
 * Both generator create vehicles on their one threads with random directions, random speed and random starting
 * positions.
 * After the grid was printed for 2000 times a statistic report is printed to the console.
 */

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

    /*public static void main(String[] args) {
        Statistic stats = new Statistic();
        Grid newGrid = new Grid(20, 10);
        PrintGrid printGrid = new PrintGrid(newGrid, 2000, 20);
        Thread gridThread = new Thread(printGrid);
        gridThread.start();
        int[] rowsToDrawNW = {0, 9};
        int[] columnsToDrawNW = {0, 5};
        TrafficGeneratorNorthWest trafficGeneratorNorthWest = new TrafficGeneratorNorthWest(850, newGrid, rowsToDrawNW, columnsToDrawNW);
        Thread trafficThreadOne = new Thread(trafficGeneratorNorthWest);
        trafficThreadOne.start();
        int[] rowsToDrawSE = {10, 19};
        int[] columnsToDrawSE = {6, 9};
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
    }*/
}
