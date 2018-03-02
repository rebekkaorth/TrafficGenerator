/**
 * Square class that the grid is filled with
 */

public class Square {

    /**
     * fields of the Square class
     */
    private String square; //border of one square
    private String space;

    /**
     * constructor of the Square class
     */
    public Square() {
        this.space = " ";
        this.square = "|";
    }

    /**
     * returns on single square
     * @return squareBlock
     */
    public String getSingleSquare (){
        String squareBlock = square + space;
        return squareBlock;
    }

    /**
     * sets the space of the square
     * returns the its space
     * @param space
     * @return space
     */
    public String setSpace(String space) {
        this.space = space;
        return space;
    }

    /**
     * returns the space
     * @return space
     */
    public String getSpace() {
        return space;
    }

    /**
     * sets the space to an empty string
     */
    public void emptySpace() {
        this.space = " ";
    }
}
