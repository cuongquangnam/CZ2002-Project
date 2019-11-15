package view.moviegoer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

import controller.IOController;
import controller.ViewController;
import model.Customer;
import model.Seat;
import model.Show;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class shows the view when moviegoers book tickets
 */
public class BookingView extends ViewController {

    /**
     * The selected showtime
     */
    private Show showTime;

    /**
     * Index of the selected showtime
     */
    private int i_showtime;

    /**
     * Constructor
     * @param showTime The selected showtime
     * @param i_showtime Index of the selected showtime
     */
    public BookingView(Show showTime, int i_showtime) {
        this.showTime = showTime;
        this.i_showtime = i_showtime;
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
     * This method displays the menu when users book ticket
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void displayMenu() throws IOException, ClassNotFoundException {
        int noOfSeatsAvailable = 5;
        ArrayList <Seat> bookSeats = new ArrayList<Seat>();
        System.out.println("Enter number of seats you want to book for (max 5)");
        int noSeats = IOController.getChoice(1, noOfSeatsAvailable);
        int i = 0;
        while(i < noSeats)
        {
            System.out.println("Enter seat row (1 - 9):");
            int seatRow = IOController.getChoice(1, 9);
            System.out.println("Enter seat column (1 - 16):");
            int seatColumn = IOController.getChoice(1, 16);
            Seat seat = showTime.getSeatMap().getSeatAt(seatRow, seatColumn);
            if (showTime.getSeatMap().getSeatAt(seatRow, seatColumn) == null) {
                System.out.println("No such seat. Please choose another one.");
                continue;
            }
            else if (showTime.getSeatMap().getSeatAt(seatRow, seatColumn).isBooked()) {
                System.out.println("The seat has been booked. Please choose another one.");
                continue;
            }
            else {
                boolean isSenior = IOController.getBoolean("Is this ticket for a Senior Citizen?" +
                                                            " Enter true if yes, false if no (validation will be done upon entering cinema)");
                if(isSenior)
                    seat.setSenior();
                i++;
                bookSeats.add(seat);
            }
        }
        String name = IOController.getString("Enter your name");
        String mobile = IOController.getString("Enter your mobile number");
        String emailID = IOController.getEmail("Enter your email");

        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);

        // Get the today date using Calendar object.
        Date today = Calendar.getInstance().getTime();
        // Using DateFormat format method we can create a string
        // representation of a date with the defined format.
        String todayAsString = df.format(today);

        // Print the result!
        System.out.println("Date and time of booking is: " + todayAsString);
        String TID = showTime.getCinema().getCinemaCode() + IOController.formatTimeYYYYMMddHHmm(today);
        Customer customer = new Customer(name, mobile, emailID);
        changeView(this, new PaymentView(customer, bookSeats, TID, showTime, i_showtime, today));

    }
}
