

public class PrintGrid implements Runnable {

    private Grid gridToPrint;
    private int gridDrawCount;
    private int maxNumDraw;
    private int delay;

    public PrintGrid(Grid gridToPrint, int maxNumDraw, int delay) {
        this.gridToPrint = gridToPrint;
        this.maxNumDraw = maxNumDraw;
        this.gridDrawCount = 0;
        this.delay = delay;
    }

    private void incrementGridDrawCount() {
        this.gridDrawCount++;
    }

    public String printGrid () {
        //printing the grid to the console
        StringBuilder gridPrint = new StringBuilder();
        for (int m = 0; m < 41; m++) {
            gridPrint.append("-");
        }
        gridPrint.append("\r\n");
        for (int i = 0; i < gridToPrint.getHeight(); i++) {
            for (int j = 0; j < gridToPrint.getWidth(); j++) {
                gridPrint.append(gridToPrint.getGridLayout()[i][j].getSingleSquare());
            }
            gridPrint.append("|");
            gridPrint.append("\r\n");
        }
        for (int m = 0; m < 41; m++) {
            gridPrint.append("-");
        }
        gridPrint.append("\r\n");
        return gridPrint.toString();
    }

    @Override
    public void run() {
        while(gridDrawCount < maxNumDraw) {
            try{
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.incrementGridDrawCount();
            System.out.println(gridDrawCount);
            System.out.println(this.printGrid());
        }
    }

    //MAIN METHOD FOR TESTING
    /*public static void main (String [] args){
        Thread thread = new Thread(new PrintGrid(new Grid(10,20),20, 20));
        thread.start();
    }*/
}
