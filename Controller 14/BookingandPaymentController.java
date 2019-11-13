package com.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.models.Booking;
import com.models.Movie;
import com.models.Seat;
import com.models.Show;

public class BookingandPaymentController {
	
	public static void createNewBooking(Date booking_dt, Movie movie, Show show, ArrayList <Seat> seat, String TID,  String name,  String mobileNumber, String emailID)
	{
		for(Seat s : seat) {
			show.getSeatmap().setSeatArr(s.getSeatRow(), s.getSeatColumn());
		}
		Booking booking  = new Booking( booking_dt,  movie,  show,  seat,  TID,   name,   mobileNumber,  emailID);
		System.out.println(booking);
		
	}
	
		
			
		
		

		
}
