package view.moviegoer;

import controller.*;
import model.*;
import view.MainView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static controller.IOController.*;

public class PaymentView extends ViewController {
    private int i_showtime;
    private Show showTime;
    private ArrayList<Seat> bookSeats;
    private Customer customer;
    private String TID;
    private Date today;
    private double ticketPrice;
    private double GST;
    private double totalPrice;

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    PaymentView(Customer customer, ArrayList<Seat> bookSeats, String TID, Show showTime, int i_showtime, Date today) {
        this.customer = customer;
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
        int senior = 0;
        for(int i = 0; i < bookSeats.size(); i++) {
            if(bookSeats.get(i).isSenior())
                senior++;
        }
        ticketPrice = BookingandPaymentController.calculateTicketPrice(showTime.getMovie(), bookSeats, showTime, showTime.getCinema());
        GST = round((ticketPrice + 2) * 0.07, 2);
        totalPrice = round(ticketPrice + 2 + GST, 2);
        printTitle("Payment");
        System.out.println("Transaction ID: " + TID);
        System.out.println("Platinum cinema: " + showTime.getCinema().isPlatinum() + "   (+" + TicketPriceController.getPlatinumPrice() + " for each ticket if true)");
        System.out.println("3D: " + showTime.getCinema().is3D() + "   (+"+ TicketPriceController.get3DPrice() + " for each ticket if true)");
        System.out.println("Blockbuster: " + showTime.getMovie().isBlockBuster() + "   (+"+ TicketPriceController.getBlockBusterPrice() + " for each ticket if true)");
        System.out.println("Senior Ticket(s): " + senior + "   ("+ TicketPriceController.getSeniorPrice() + " for each ticket if true)");
        System.out.println("Number of Ticket(s): " + bookSeats.size());
        System.out.println("Base price of movie: " + showTime.getMovie().getBasePrice());
        System.out.println("Ticket price: " + ticketPrice);
        System.out.println("Booking fee: 2.0");
        System.out.println("GST: " + GST);
        System.out.println("Grand total: " + totalPrice);

        System.out.println("1. Confirm payment");
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

        BookingandPaymentController.createNewBooking(today, showTime.getMovie(), showTime, bookSeats, TID, customer.getName(), customer.getMobile(),
                customer.getEmail());
        ShowController.updateSeatMap(showTime.getMovie(), i_showtime, showTime);
        MovieListingController.updateSales(showTime.getMovie(), bookSeats.size());
        System.out.println("Payment has been made. We wish you a great day!");

        changeView(this, new MainView());
    }

}
