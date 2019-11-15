package view.moviegoer;

import controller.ViewController;
import model.SeatMap;

import java.io.IOException;

import static controller.IOController.getString;
import static controller.IOController.printTitle;

/**
 * This class is used to check the seat availability
 */
public class CheckSeat extends ViewController {
    /**
     * The seat mapping
     */
    private SeatMap seatMap;

    /**
     * Constructor
     * @param seatMap
     */
    public CheckSeat (SeatMap seatMap) {
        this.seatMap = seatMap;
    }

    /**
     * {@inheritDoc}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    /**
     * This method will display the seating map
     */
    private void displayMenu() {
        printTitle("Check seat");
        System.out.println("                    -------Screen-------");
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
        getString("Press ENTER to continue");
    }
}
