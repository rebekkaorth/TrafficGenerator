

interface TrafficGenerator {

    void buildTraffic();

    //HELPER METHODS RANDOM GENERATION OF VEHICLES

    //GENERATE VEHICLE
    Vehicle newVehicle();

    //FORMAT
    //set the format - in order to be able to give it to the startingPosition methods
    String randomFormat();

    //SPEED
    int randomSpeed();

    //POSITION
    int startingPositionX (String format);

    int startingPositionY(String format);

    Report getReport();

    void stop();
}

