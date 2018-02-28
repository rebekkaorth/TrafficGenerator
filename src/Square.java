

public class Square {
    //fields
    private String square;
    private String space;

    public Square() {
        this.space = " ";
        this.square = "|";
    }

    public String getSingleSquare (){
        String squareBlock = square + space;
        return squareBlock;
    }

    public String setSpace(String space) {
        this.space = space;
        return space;
    }

    public String getSpace() {
        return space;
    }

    public void emptySpace() {
        this.space = " ";
    }
}
