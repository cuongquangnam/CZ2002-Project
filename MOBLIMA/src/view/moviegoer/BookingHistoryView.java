package view.moviegoer;

import controller.BookingandPaymentController;
import controller.IOController;
import controller.ViewController;
import model.Booking;

import java.io.IOException;
import java.util.ArrayList;

import static controller.IOController.getString;

/**
 * This class is used to display the menu of viewing booking history
 */
public class BookingHistoryView extends ViewController {
    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    /**
     * This method is used to display main menu of viewing booking history
     */
    private void displayMenu() throws IOException, ClassNotFoundException {
        while(true) {
            IOController.printTitle("View booking history");
            ArrayList<Booking> bookingHistory = BookingandPaymentController.getAllBooking();

            if (bookingHistory == null || bookingHistory.isEmpty()) {
                System.out.println("No history to show");
                getString("Press ENTER to return");
                deleteView();
            }
            else {
                for (Booking record : bookingHistory) {
                    System.out.println(record);
                }
                getString("Press ENTER to go back");
                deleteView();
            }
        }
    }
}
