import org.junit.Test;
import static org.junit.Assert.*;

public class TrafficGeneratorSouthEastTest {

    TrafficGeneratorSouthEast testGenerator;

    @Test
    public void randomFormat() {
        Grid grid = new Grid(10,20);
        int[] r = {0,10};
        int[] c = {0, 20};
        testGenerator = new TrafficGeneratorSouthEast(200, grid, r, c);
        String format = "south";
        String formatTwo = "east";
        String formatResult = testGenerator.randomFormat();
        assertTrue("wrong format", format.equals(formatResult) || formatTwo.equals(formatResult));
    }

    @Test
    public void randomSpeed() {
        Grid grid = new Grid(10,20);
        int[] r = {0,10};
        int[] c = {0, 20};
        testGenerator = new TrafficGeneratorSouthEast(200, grid, r, c);
        int min = 200;
        int max = 800;
        assertTrue("wrong format", min <= testGenerator.randomSpeed() && testGenerator.randomSpeed() <= max);
    }

    @Test
    public void startingPositionX() {
        Grid grid = new Grid(10,20);
        int[] r = {0,10};
        int[] c = {0, 20};
        testGenerator = new TrafficGeneratorSouthEast(200, grid, r, c);
        int min = 0;
        int max = 10;
        assertTrue("wrong format", min <= testGenerator.startingPositionX("south")
                && testGenerator.startingPositionX("south") <= max);
    }

    @Test
    public void startingPositionY() {
        Grid grid = new Grid(10,20);
        int[] r = {0,10};
        int[] c = {0, 20};
        testGenerator = new TrafficGeneratorSouthEast(200, grid, r, c);
        int min = 0;
        int max = 20;
        assertTrue("wrong format", min <= testGenerator.startingPositionY("south")
                && testGenerator.startingPositionY("south") <= max);
    }
}