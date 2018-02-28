public class Vehicle {

    //fields
    String direction;
    private int speed;
    private int positionX;
    private int positionY;

    public Vehicle(String direction, int speed, int positionX, int positionY) {
        this.direction = direction;
        this.speed = speed;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public String getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
