import static org.junit.Assert.*;

public class SquareTest {

    private Square testSquare;


    @org.junit.Test
    public void buildSquare() {
        testSquare = new Square();
        assertEquals("| ", testSquare.getSingleSquare());

    }

    @org.junit.Test
    public void setSpace() {
        testSquare = new Square();
        assertEquals("-", testSquare.setSpace("-"));
    }
}