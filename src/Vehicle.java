/**
 * Vehicle class
 */

public class Vehicle {

    /**
     * fields of the Vehicle class
     */
    String direction;
    private int speed;
    private int positionX;
    private int positionY;

    /**
     * constructor of the Vehicle class
     * @param direction
     * @param speed
     * @param positionX
     * @param positionY
     */
    public Vehicle(String direction, int speed, int positionX, int positionY) {
        this.direction = direction;
        this.speed = speed;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    /**
     * returns the direction of the vehicle
     * @return direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * returns the speed of the vehicle
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * sets the position of the vehicle in the first dimension of the grid
     * @param positionX
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * sets the position of the vehicle in the second dimension of the grid
     * @param positionY
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * returns the position of the vehicle in the first dimension of the grid
     * @return positionX
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * returns the position of the vehicle in the second dimension of the grid
     * @return positionY
     */
    public int getPositionY() {
        return positionY;
    }
}
