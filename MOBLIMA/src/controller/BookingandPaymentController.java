package controller;

import model.Booking;
import model.Movie;
import model.Seat;
import model.Show;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class BookingandPaymentController {

    public static void createNewBooking(Date booking_dt, Movie movie, Show show, ArrayList <Seat> seats, String TID,  String name,  String mobileNumber, String emailID, boolean isSenior)
    {
        for(Seat s : seats) {
//            show.getSeatmap().setSeatArr(s.getSeatRow(), s.getSeatColumn());
            show.getSeatMap().setSeat(s);
        }
        Booking booking  = new Booking( booking_dt,  movie,  show,  seats,  TID,   name,   mobileNumber,  emailID, isSenior);
        System.out.println(booking);

    }
}
