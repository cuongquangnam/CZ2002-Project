package model;

import java.io.Serializable;

/**
 * This class contains all information of a seat - including its row number, column number,
 * {@code Show} and whether it is booked
 */
public class Seat implements Serializable{
    private final int ROW;
    private final int COL;
    private boolean booked;

    /**
     * Allocates a {@code Seat} object and initializes it specified by its row number, column
     * number and showtime.
     * @param row This it the row number of the seat
     * @param col This is the column number of the seat
     */
    public Seat(int ROW, int COL) {
        this.row = ROW;
        this.col = COL;
        isSenior = false;
        booked = false;
    }


    /**
     * This method is to get column number.
     * @return Column number
     */
    public int getCol() {
        return COL;
    }

    /**
     * This method is to get row number.
     * @return Row number
     */
    public int getRow() {
        return ROW;
    }

    /**
     * This method is to get a boolean value which indicates whether the seat is booked.
     * @return true if the seat is booked, false if the seat is not booked
     */
    public boolean isBooked() {
        return booked;
    }

    /**
     * This method is to book the seat by setting {@code booked} as true
     */
    public void bookSeat() {
        booked = true;
    }

    @Override
    public String toString() {
        if (!booked) return "[ ]";
        else return "[*]";
    }
}
