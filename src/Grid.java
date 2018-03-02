/**
 * Class the creates a grid as a two dimensional array.
 * Enables vehicles to "block" and "unblock" positions in the grid
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Grid {

    /**
     * fields of the grid class
     */
    private Square [][] gridLayout;
    private int width;
    private int height;
    private ReentrantLock positionLock = new ReentrantLock();
    private Condition positionFree = positionLock.newCondition();

    /**
     * constructor that sets the sizes for the two dimensions of the grid
     * @param height
     * @param width
     */
    public Grid(int height, int width) {
        this.width = width;
        this.height = height;
        this.gridLayout = new Square[height][width];
        this.buildGrid();
    }

    /**
     * returns the two dimensional array
     * @return gridLayout
     */
    public Square[][] getGridLayout() {
        return gridLayout;
    }

    /**
     * returns the size of the second dimension of the array
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * returns the size of the first dimension of the array
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * fills the two dimensional array with Square objects
     */
    private void buildGrid() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                Square squareInGrid = new Square();
                this.gridLayout[i][j] = squareInGrid;
            }
        }
    }

    /**
     * Enables vehicles to fill Squares with their shape and "block" them
     * @param positionX
     * @param positionY
     * @param form
     */
    public void enterPosition(int positionX, int positionY, String form) {
        positionLock.lock();
        try {
            while(!gridLayout[positionX][positionY].getSpace().equals(" ")) {  //test if the Square is "filled" or not
                positionFree.await(); //so vehicles waits until the position is free again
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            positionLock.unlock();
        }
            gridLayout[positionX][positionY].setSpace(form); //vehicle "fills" the Square at its position with its form
    }

    /**
     * Enables vehicles to "leave" their position in the grid and sets the Square to an empty string again.
     * @param positionX
     * @param positionY
     */
    public void leavePosition(int positionX, int positionY) {
        positionLock.lock();
        try {
            gridLayout[positionX][positionY].emptySpace(); //sets the Square the vehicle was in to empty again
            positionFree.signalAll(); //signals all other threads that the position is free again
        } finally {
            positionLock.unlock();
        }
    }
}

