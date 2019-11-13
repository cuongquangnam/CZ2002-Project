package com.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import com.controllers.BookingandPaymentController;


import com.controllers.FileReadWriteController;
import com.controllers.IOController;

import com.models.Movie;
import com.models.Seat;
import com.models.Show;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
public class NewBookingView extends View {
	

	@Override
	public void start() {

	
	try {
		ArrayList<Movie> movieList = FileReadWriteController.readMovieList();
		HashMap<Movie, ArrayList<Show>> showList = FileReadWriteController.readShowTime();
	    int counterM =1;
	    int counterS =1;
		
	    //Display all the movies
	    for(Movie m: movieList)
			{
				System.out.println(counterM + "." + m.getMovieTitle());
				counterM++;
			}
	    
	    System.out.println("Enter the movie to make a booking for");
		int movieChoice = IOController.readChoice(0, movieList.size());
		
		ArrayList <Show> shows = showList.get(movieList.get(movieChoice-1));
		
		System.out.println("Enter a show to make a booking for");
		//Display all the shows for the movie
		for(Show show: shows)
		{
			System.out.println(counterS + "." + show.toString());
			counterS++;
		}
		
		int showChoice = IOController.readChoice(0, shows.size());
		int noOfSeatsAvailable = 5;
		ArrayList <Seat> bookSeats = new ArrayList<Seat>();
		System.out.println("Enter number of seats you want to book for");
		int noSeats = IOController.readChoice(1, noOfSeatsAvailable);
		for(int i =0; i<noSeats; i++)
		{
		String seatRow = IOController.readString("Enter seat row");
		String seatColumn = IOController.readString("Enter seat column");
		Seat seat = new Seat(seatRow, seatColumn);
		bookSeats.add(seat);
		}
		String name = IOController.readString("Enter your name");
		String mobile = IOController.readString("Enter your mobile number");
		String emailID = IOController.readEmail("Enter your email");
		
		String pattern = "MM/dd/yyyy HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);

				// Get the today date using Calendar object.
				Date today = Calendar.getInstance().getTime();        
				// Using DateFormat format method we can create a string 
				// representation of a date with the defined format.
				String todayAsString = df.format(today);

				// Print the result!
				System.out.println("Date and time of booking is: " + todayAsString);
				String TID = shows.get(showChoice-1).getCinema().getCinemaCode();
				TID = TID + todayAsString;       //New line added (14 NOV, 1:08 AM)
		BookingandPaymentController.createNewBooking(today, movieList.get(movieChoice-1), shows.get(showChoice-1),bookSeats, TID, name, mobile, emailID); 
		
	} catch (ClassNotFoundException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
	
	
	
	}
}
