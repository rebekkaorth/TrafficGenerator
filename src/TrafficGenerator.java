/**
 * interface for traffic generators
 */

interface TrafficGenerator {

    /**
     * builds vehicles and their own threads and calls move vehicle objects the move the created vehicles
     */
    void buildTraffic();

    /**
     * creates a new vehicle with random direction, random speed and random starting position
     * @return Vehicle
     */
    Vehicle newVehicle();

    //FORMAT
    //set the format - in order to be able to give it to the startingPosition methods

    /**
     * returns a random direction for the vehicle
     * @return direction
     */
    String randomDirection();

    /**
     * returns random speed for the vehicle
     * @return speed
     */
    int randomSpeed();

    /**
     * returns the random starting position for the first dimension of the array
     * either it is a random number between 0 and the height/ width of the grid or 0 depending on the direction of the
     * vehicle
     * @param format
     * @return startingPositionX
     */
    int startingPositionX (String format);

    /**
     * returns the random starting position for the second dimension of the array
     * either it is a random number between 0 and the height/ width of the grid or 0 depending on the direction fo the
     * vehicle
     * @param format
     * @return startingPositionY
     */
    int startingPositionY(String format);

    /**
     * returns the report the traffic generator creates
     * @return report
     */
    Report getReport();

    /**
     * stops the traffic generator thread
     */
    void stop();
}

