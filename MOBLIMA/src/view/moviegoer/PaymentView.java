package view.moviegoer;

import controller.*;
import model.*;
import view.MainView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static controller.IOController.*;

/**
 * This class handles the displayed menu when user
 */
public class PaymentView extends ViewController {
    /**
     * Index of the show in list of show
     */
    private int i_showtime;
    /**
     * The show
     */
    private Show showTime;
    /**
     * The list of booked seats
     */
    private ArrayList<Seat> bookSeats;
    /**
     * Name of customer
     */
    private String name;
    /**
     * Mobile number of customer
     */
    private String mobile;
    /**
     * Email of customer
     */
    private String emailID;
    /**
     * The transaction ID
     */
    private String TID;
    /**
     * The time of booking
     */
    private Date today;
    /**
     * The base price of ticket after all modifiers
     */
    private double ticketPrice;
    /**
     * The GST
     */
    private double GST;
    /**
     * Total price of GST and ticketPrice
     */
    private double totalPrice;

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    /**
     * Constructor
     * @param name Name of customer
     * @param mobile Mobile number of customer
     * @param emailID Email of customer
     * @param bookSeats The booked seats
     * @param TID The transaction ID
     * @param showTime The show
     * @param i_showtime The index of the show in list
     * @param today The time of booking
     */
    PaymentView(String name,String mobile,String emailID, ArrayList<Seat> bookSeats, String TID, Show showTime, int i_showtime, Date today) {
        this.name = name;
        this.mobile = mobile;
        this.emailID = emailID;
        this.bookSeats = bookSeats;
        this.TID = TID;
        this.showTime = showTime;
        this.i_showtime = i_showtime;
        this.today = today;
    }


    /**
     * This method is to display the main menu of payment.
     */
    private void displayMenu() throws IOException, ClassNotFoundException {
        ArrayList<Date> holidayList = null;

        {
            try {
                holidayList = FileReadWriteController.readHolidayList();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int senior = 0;
        for(int i = 0; i < bookSeats.size(); i++) {
            if(bookSeats.get(i).isSenior())
                senior++;
        }
        ticketPrice = BookingandPaymentController.calculateTicketPrice(bookSeats, showTime, showTime.getCinema());
        GST = round((ticketPrice + 2) * 0.07, 2);
        totalPrice = round(ticketPrice + 2 + GST, 2);
        printTitle("Payment");
        System.out.println("Transaction ID: " + TID);
        System.out.println("Platinum cinema: " + showTime.getCinema().isPlatinum() + "   (+" + TicketPriceController.getPlatinumPrice() + " for each ticket if true)");
        System.out.println("3D: " + showTime.getCinema().is3D() + "   (+"+ TicketPriceController.get3DPrice() + " for each ticket if true)");
        System.out.println("Blockbuster: " + showTime.getMovie().isBlockBuster() + "   (+"+ TicketPriceController.getBlockBusterPrice() + " for each ticket if true)");
        System.out.println("Weekend: " + (showTime.getTime().getDay() == 6 || showTime.getTime().getDay() == 0)  + "   (+"+ TicketPriceController.getWeekendPrice() + " for each ticket if true)");
        System.out.println("Holiday: " + HolidayController.checkHoliday(showTime.getTime()) + "   (+"+ TicketPriceController.getHolidayPrice() + " for each ticket if true)\n");
        System.out.println("Senior Ticket(s): " + senior + "   ("+ TicketPriceController.getSeniorPrice() + " for each ticket if true)");
        System.out.println("Number of Ticket(s): " + bookSeats.size() + "\n");
        System.out.println("Base price of movie: " + showTime.getMovie().getBasePrice());
        System.out.println("Ticket price: " + ticketPrice);
        System.out.println("Booking fee: 2.0");
        System.out.println("GST: " + GST);
        System.out.println("Grand total: " + totalPrice);

        System.out.println("\n1. Confirm payment");
        System.out.println("2. Cancel");

        int choice = getChoice(1, 2);
        switch (choice) {
            case 1:
                logBooking();
                break;
            case 2:
                System.out.println("You have cancelled the booking");
                getString("Press ENTER to return to main menu");
                changeView(this, new MainView());
                break;
        }
    }

    /**
     * This method is to log booking into booking history.
     */
    private void logBooking() throws IOException, ClassNotFoundException {
        for(Seat seat : bookSeats) {
            showTime.getSeatMap().setSeat(seat);
        }

        BookingandPaymentController.createNewBooking(today, showTime.getMovie(), showTime, bookSeats, TID, name, mobile, emailID);
        ShowController.updateSeatMap(showTime.getMovie(), i_showtime, showTime);
        MovieListingController.updateSales(showTime.getMovie(), bookSeats.size());
        System.out.println("Payment has been made. We wish you a great day!");

        changeView(this, new MainView());
    }

}
