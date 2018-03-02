/**
 * interface for moving vehicles in directions
 */

public interface MoveVehicle {

    /**
     * returns the size of one of the dimensions of the array depending on the direction of the vehicle
     * @return gridWidth / gridHeight
     */
    int direction();

    /**
     * sets the form of the vehicle depending on the direction of the vehicle
     * this form is given to the grid to "fill" the Square at the vehicles position in the grid  with its form
     * @return
     */
   String setForm();

}

