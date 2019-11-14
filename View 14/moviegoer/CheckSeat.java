package view.moviegoer;

import controller.ViewController;
import model.SeatMap;

import java.io.IOException;

import static controller.IOController.getString;

public class CheckSeat extends ViewController {
    private SeatMap seatMap;

    public CheckSeat (SeatMap seatMap) {
        this.seatMap = seatMap;
    }
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    private void displayMenu() {
        System.out.println("                    -------Screen------");
        System.out.println("     1  2  3  4  5  6  7  8     9 10 11 12 13 14 15 16");
        for (int row = 0; row <= 8; row++) {
            System.out.print(row + 1 + "   ");
            for (int col = 0; col <= 16; col++) {
                if (seatMap.getSeats()[row][col] == null) System.out.print("   ");
                else System.out.print(seatMap.getSeats()[row][col]);
            }
            System.out.println();
        }
        System.out.println();
        getString("Press ENTER to continue:");
    }
}
