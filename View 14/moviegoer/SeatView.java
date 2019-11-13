package view.moviegoer;

import controller.ViewController;
import model.Seat;

import java.io.IOException;

public class SeatView extends ViewController {
    public void initialize() throws IOException, ClassNotFoundException {
        System.out.println("                    -------Screen------");
        System.out.println("     1  2  3  4  5  6  7  8     9 10 11 12 13 14 15 16");
        for (int row = 0; row <= 8; row++) {
            System.out.print(row + 1 + "   ");
            for (int col = 0; col <= 16; col++) {
                if (seats[row][col] == null) System.out.print("   ");
                else System.out.print(seats[row][col]);
            }
            System.out.println();
        }
        System.out.println();
        readString("Press ENTER to continue:");
    }
}
