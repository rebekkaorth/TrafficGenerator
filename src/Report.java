/**
 * report class
 * each traffic generator creates one report
 */

import java.util.ArrayList;

public class Report {

    /**
     * fields of the report class
     */
    private ArrayList<Integer> vehicleSpeeds;
    private String nameOfGenerator;
    private int maxTime;
    private int minTime;

    /**
     * constructor of the report class
     * gets the name of the traffic generator
     * creates an array list which stores speeds of all vehicles created by the traffic generator
     * @param nameOfGenerator
     */
    public Report(String nameOfGenerator) {
        this.vehicleSpeeds = new ArrayList<>();
        this.nameOfGenerator = nameOfGenerator;
        maxTime = Integer.MIN_VALUE;
        minTime = Integer.MAX_VALUE;
    }

    /**
     * gets the speed of one vehicle and adds it to the array list
     * @param speed
     */
    public void addVehicleSpeedToReport (int speed) {
        vehicleSpeeds.add(speed);
    }

    /**
     * returns the name of the generator the report gets when it is initialized
     * @return
     */
    public String getNameOfGenerator () {
        return nameOfGenerator;
    }

    /**
     * returns the highest speed of all speeds in the array list
     * @return maxTime
     */
    public int getMaxTime () {
        for (int speed : vehicleSpeeds) {
            if (speed > maxTime) {
                maxTime = speed;
            }
        }
        return maxTime;
    }

    /**
     * returns the lowest speed of all speeds in the array list
     * @return minTime
     */
    public int getMinTime () {
        for(int speed : vehicleSpeeds) {
            if(speed < minTime) {
                minTime = speed;
            }
        }
        return minTime;
    }

    /**
     * returns the mean speed
     * @return mean
     */
    public double meanSpeed() {
        double sum = 0.0;
        for(double a : vehicleSpeeds){
            sum += a;
        }
        return (sum/vehicleSpeeds.size());
    }

    /**
     * returns the variance
     * @return variance
     */
    public double variance() {
        double mean = meanSpeed();
        double temp = 0;
        for(double m : vehicleSpeeds) {
            temp += (m-mean)*(m-mean);
        }
        return temp/(vehicleSpeeds.size());
    }
}
