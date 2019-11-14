package model;

import java.io.Serializable;

public class SeatMap implements Serializable {
    private Seat[][] seats;

    public SeatMap() {
        seats = new Seat[9][17];
        initializeSeat();
    }

    private void initializeSeat() {
        for (int row = 0; row <= 3; row++) {
            for (int col = 2; col <= 16; col++) {
                if (col == 8) continue;
                seats[row][col] = new Seat(row, col);
            }
        }

        for (int row = 4; row <= 7; row++) {
            for (int col = 0; col <= 16; col++) {
                if (col == 8) continue;
                seats[row][col] = new Seat(row, col);
            }
        }

        for (int col = 0; col <= 16; col++) {
            if (col == 8 || col == 9 || col == 10) continue;
            seats[8][col] = new Seat(8, col);
        }
    }
    public Seat[][] getSeats() {
        return seats;
    }
    public Seat getSeatAt(int row, int col) {
        if (row < 1 || row > 9 || col < 1 || col > 16) return null;

        if (col >= 9) col++;

        return seats[row - 1][col - 1];
    }
}
