import java.util.ArrayList;

public class Report {

    private ArrayList<Integer> vehicleSpeeds;
    private String nameOfGenerator;
    private int maxTime;
    private int minTime;

    public Report(String nameOfGenerator) {
        this.vehicleSpeeds = new ArrayList<>();
        this.nameOfGenerator = nameOfGenerator;
        maxTime = Integer.MIN_VALUE;
        minTime = Integer.MAX_VALUE;
    }

    public void addVehicleSpeedToReport (int speed) {
        vehicleSpeeds.add(speed);
    }

    public String getNameOfGenerator () {
        return nameOfGenerator;
    }

    public int getMaxTime () {
        for (int speed : vehicleSpeeds) {
            if (speed > maxTime) {
                maxTime = speed;
            }
        }
        return maxTime;
    }

    public int getMinTime () {
        for(int speed : vehicleSpeeds) {
            if(speed < minTime) {
                minTime = speed;
            }
        }
        return minTime;
    }

    public double meanSpeed() {
        double sum = 0.0;
        for(double a : vehicleSpeeds){
            sum += a;
        }
        return (sum/vehicleSpeeds.size());
    }

    public double variance() {
        double mean = meanSpeed();
        double temp = 0;
        for(double m : vehicleSpeeds) {
            temp += (m-mean)*(m-mean);
        }
        return temp/(vehicleSpeeds.size());
    }
}
