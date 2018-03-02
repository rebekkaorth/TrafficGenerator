import org.junit.Test;

import static org.junit.Assert.*;

public class StatisticTest {

    Statistic stat;

    @Test
    public void addGenerators() {
        stat = new Statistic();
        stat.addGenerators(new Report("test"));
        assertTrue("no reports", 0 < stat.getAllGenerators().size());
    }
}