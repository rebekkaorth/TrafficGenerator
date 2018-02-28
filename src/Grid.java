

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Grid {

    //fields
    private Square [][] gridLayout;
    private int width;
    private int height;
    private ReentrantLock positionLock = new ReentrantLock();
    private Condition positionFree = positionLock.newCondition();

    public Grid(int height, int width) {
        this.width = width;
        this.height = height;
        this.gridLayout = new Square[height][width];
        this.buildGrid();
    }

    public Square[][] getGridLayout() {
        return gridLayout;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void buildGrid() {
        //"filling" the grid with Square-objects
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                Square squareInGrid = new Square();
                this.gridLayout[i][j] = squareInGrid;
            }
        }
    }

    //changes the position of the vehicle
    public void enterPosition(int positionX, int positionY, String form) {
        positionLock.lock();
        try {
            while(!gridLayout[positionX][positionY].getSpace().equals(" ")) {
                positionFree.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            positionLock.unlock();
        }
            gridLayout[positionX][positionY].setSpace(form);
    }

    //leaves the current position and signals other vehicles
    public void leavePosition(int positionX, int positionY) {
        positionLock.lock();
        try {
            gridLayout[positionX][positionY].emptySpace();
            positionFree.signalAll();
        } finally {
            positionLock.unlock();
        }
    }
}

