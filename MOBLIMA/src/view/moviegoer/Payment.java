package view.moviegoer;

import controller.FileReadWriteController;
import controller.ShowController;
import controller.ViewController;
import model.*;
import view.MainView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static controller.IOController.getChoice;
import static controller.IOController.printTitle;

public class Payment extends ViewController {
    private int i_showtime;
    private Show showTime;
    private ArrayList<Seat> bookSeats;
    private Customer customer;
    private String TID;
    private double basePrice;
    private double GST;
    private double totalPrice;

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    Payment(Customer customer, ArrayList<Seat> bookSeats, String TID, Show showTime, int i_showtime) {
        this.customer = customer;
        this.bookSeats = bookSeats;
        this.TID = TID;
        this.showTime = showTime;
        this.i_showtime = i_showtime;
//        computeTotalPrice();
    }


//    /**
//     * This method is to compute the total price.
//     */
//    private void computeTotalPrice() {
//        if (customer.isSeniorCitizen()) basePrice /= 2;
//        GST = round((basePrice + 2) * 0.07, 2);
//        totalPrice = round(basePrice + 2 + GST, 2);
//    }

    /**
     * This method is to display the main menu of payment.
     */
    private void displayMenu() throws IOException, ClassNotFoundException {
        printTitle("Payment");
        System.out.println("Transaction ID: " + TID);
        System.out.println("Ticket price: " + basePrice);
        System.out.println("Booking fee: 2.0");
        System.out.println("GST: " + GST);
        System.out.println("Grand total: " + totalPrice);
        if (customer.isSeniorCitizen()) {
            System.out.println("(50% off for senior citizen)");
        }

        System.out.println("1. Confirm payment");
        System.out.println("2. Cancel");

        int choice = getChoice(1, 2);
        switch (choice) {
            case 1:
                logBooking();
                break;
            case 2:
                deleteView();
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

        //save data customer
        ShowController.updateSeatMap(showTime.getMovie(), i_showtime, showTime);
        System.out.println("Payment has been made. We wish you a great day!");

        changeView(this, new MainView());
    }
}
