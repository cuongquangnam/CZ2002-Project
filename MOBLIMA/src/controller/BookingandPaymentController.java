package controller;

import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class contains static methods to handle booking and payment
 */
public class BookingandPaymentController {
    /**
     * The booking history
     */
    private static ArrayList<Booking> bookingHistory;

    static {
        try {
            bookingHistory = FileReadWriteController.readBookingHistory();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method creates a new booking and write it to the file
     * @param booking_dt    The date of booking
     * @param movie The selected movie
     * @param show  The selected showtime
     * @param seats The list of selected seats
     * @param TID   The transaction ID
     * @param name  The name of customer
     * @param mobileNumber  The mobile number of customer
     * @param emailID   The email of customer
     * @throws IOException when file not found
     */
    public static void createNewBooking(Date booking_dt, Movie movie, Show show, ArrayList <Seat> seats, String TID,  String name,  String mobileNumber, String emailID) throws IOException {
        Booking booking  = new Booking( booking_dt,  movie,  show,  seats,  TID,   name,   mobileNumber,  emailID);
        bookingHistory.add(booking);
        FileReadWriteController.writeBookingHistory(bookingHistory);
    }

    /**
     * This method calculates the ticket price and return it
     * @param seats The list of selected seats
     * @param show  The selected showtime
     * @param cinema The cinema showing
     * @return The price of ticket
     */
    public static double calculateTicketPrice(ArrayList<Seat> seats, Show show, Cinema cinema) {
        return TicketCostService.calculateTicketPriceSeat(seats, show, cinema);
    }

    /**
     * This method return all the booking in the history
     * @return The list of booking
     */
    public static ArrayList<Booking> getAllBooking() {
        return bookingHistory;
    }
}
