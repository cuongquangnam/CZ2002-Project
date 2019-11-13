package model;

import java.io.Serializable;

public class Seat implements Serializable{
    private final int row;
    private final int col;
    private final Show showtime;
    private boolean booked;


    public Seat(int row, int col, Show showtime) {
        this.row = row;
        this.col = col;
        this.showtime = showtime;
        booked = false;
    }


    public Show getShowtime() {
        return showtime;
    }


    public int getCol() {
        return col;
    }


    public int getRow() {
        return row;
    }


    public boolean isBooked() {
        return booked;
    }


    public void bookSeat() {
        booked = true;
    }

    @Override
    public String toString() {
        if (!booked) return "[ ]";
        else return "[*]";
    }
}
