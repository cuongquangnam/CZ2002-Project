package com.views;

import java.io.IOException;
import java.util.ArrayList;

import com.controllers.IOController;
import com.controllers.MovieListingController;

public class CreateMovieView extends View {

	@Override
	public void start() {
		 String movieTitle = IOController.readString("Please enter title of the movie: ");
		 System.out.println("Please enter the showing status of the movie: ");
		 System.out.println("1. Coming Soon");
		 System.out.println("2. Now Showing");
		 System.out.println("3. Not Showing");
		int showingStatus = IOController.readChoice (1,3);
		String sypnosis = IOController.readString("Please enter sysnosis of the movie: ");
		String director = IOController.readString("Please enter director of the movie: ");
		
		ArrayList <String> cast = new ArrayList();
		String Cast ="";
		System.out.println("Enter the cast of the movie (atleast 2) folowed by a '0' when done");
		
		while (!Cast.equals("0"))
		{
		Cast =  IOController.readString("");
		cast.add(Cast);
		} 
		
		double basePrice = IOController.readDouble("Please enter the base price of the movie");
		
		try {
			MovieListingController.createMovie(movieTitle, showingStatus, sypnosis, director, cast, basePrice);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		intent(this, new StaffHomePageView());
		
	}
	
	

}
