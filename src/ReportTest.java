import org.junit.Test;
import static org.junit.Assert.*;

public class ReportTest {

    Report report;

    @Test
    public void getNameOfGenerator() {
        report = new Report("test");
        assertEquals("test", report.getNameOfGenerator());
    }

    @Test
    public void getMinTime() {
        report = new Report ("test");
        report.addVehicleSpeedToReport(100);
        report.addVehicleSpeedToReport(200);
        report.addVehicleSpeedToReport(234);
        report.addVehicleSpeedToReport(546);
        report.addVehicleSpeedToReport(332);

        assertEquals(100, report.getMinTime());
    }

    @Test
    public void getMaxTime() {
        report = new Report ("test");
        report.addVehicleSpeedToReport(100);
        report.addVehicleSpeedToReport(200);
        report.addVehicleSpeedToReport(234);
        report.addVehicleSpeedToReport(546);
        report.addVehicleSpeedToReport(332);

        assertEquals(546, report.getMaxTime());
    }

    @Test
    public void meanSpeed() {
        report = new Report ("test");
        report.addVehicleSpeedToReport(100);
        report.addVehicleSpeedToReport(200);
        report.addVehicleSpeedToReport(234);
        report.addVehicleSpeedToReport(546);
        report.addVehicleSpeedToReport(332);

        assertEquals(282,4 , report.meanSpeed());
    }

    @Test
    public void variance() {
        report = new Report ("test");
        report.addVehicleSpeedToReport(100);
        report.addVehicleSpeedToReport(200);
        report.addVehicleSpeedToReport(234);
        report.addVehicleSpeedToReport(546);
        report.addVehicleSpeedToReport(332);

        assertEquals(22.869,44, report.variance());
    }
}