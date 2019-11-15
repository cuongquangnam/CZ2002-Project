package model;

import java.io.Serializable;

/**
 * This class contains all information of a seat - including its row number, column number,
 * {@code Show} and whether it is booked
 */
public class Seat implements Serializable{
    private final int row;
    private final int col;
    private boolean isSenior;
    private boolean booked;

    /**
     * Allocates a {@code Seat} object and initializes it specified by its row number, column
     * number and showtime.
     * @param row This it the row number of the seat
     * @param col This is the column number of the seat
     */
    public Seat(int row, int col) {
        this.row = row;
        this.col = col;
        isSenior = false;
        booked = false;
    }


    /**
     * This method is to get column number.
     * @return Column number
     */
    public int getCol() {
        return col;
    }

    /**
     * This method is to get row number.
     * @return Row number
     */
    public int getRow() {
        return row;
    }

    /**
     * This method is to get a boolean value which indicates whether the seat is booked.
     * @return true if the seat is booked, false if the seat is not booked
     */
    public boolean isBooked() {
        return booked;
    }

    public void setSenior() {
        this.isSenior = true;
    }
    public boolean isSenior() {
        return isSenior;
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
