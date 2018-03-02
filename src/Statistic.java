import java.util.ArrayList;

public class Statistic {

    private ArrayList<Report> allGenerators;

    public Statistic() {
        this.allGenerators = new ArrayList<>();
    }

    public void addGenerators(Report report){
        allGenerators.add(report);
    }

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

    public ArrayList<Report> getAllGenerators() {
        return allGenerators;
    }
}
