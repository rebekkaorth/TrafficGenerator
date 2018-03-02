/**
 * prints the reports of each traffic generator to the console
 */

import java.util.ArrayList;

public class Statistic {

    /**
     * field of the Statistic class
     */
    private ArrayList<Report> allGenerators;

    /**
     * constructor of the Statistic class
     * creates an array list for all reports of all traffic generators
     */
    public Statistic() {
        this.allGenerators = new ArrayList<>();
    }

    /**
     * adds a report to the array list
     * @param report
     */
    public void addGenerators(Report report){
        allGenerators.add(report);
    }

    /**
     * creates a String of all items of all reports of all traffic generators
     * @return statisticsString
     */
    public String printStatistics() {
        StringBuilder statisticBuilder = new StringBuilder();
        for(Report r: allGenerators) {
            statisticBuilder.append("name of generator: ");
            statisticBuilder.append(r.getNameOfGenerator());
            statisticBuilder.append("\r\n");
            statisticBuilder.append("minimal time: ");
            statisticBuilder.append(r.getMinTime());
            statisticBuilder.append(" ms");
            statisticBuilder.append("\r\n");
            statisticBuilder.append("maximal time: ");
            statisticBuilder.append(r.getMaxTime());
            statisticBuilder.append(" ms");
            statisticBuilder.append("\r\n");
            statisticBuilder.append("mean: ");
            statisticBuilder.append(r.meanSpeed());
            statisticBuilder.append(" ms");
            statisticBuilder.append("\r\n");
            statisticBuilder.append("variance: ");
            statisticBuilder.append(r.variance());
            statisticBuilder.append(" ms");
            statisticBuilder.append("\r\n");
            statisticBuilder.append("\r\n");
        }
        String statisticsString = statisticBuilder.toString();
        return statisticsString;
    }

    /**
     * returns the array list with all reports of all traffic generators
     * @return allGenerators
     */
    public ArrayList<Report> getAllGenerators() {
        return allGenerators;
    }
}
