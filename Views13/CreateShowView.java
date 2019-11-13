package com.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.controllers.FileReadWriteController;
import com.controllers.*;
import com.controllers.MovieListingController;

import com.models.Cinema;
import com.models.Movie;
import com.models.Show;


public class CreateShowView extends View {
	
	@Override
	public void start() {
		
		
			
		String movieTitle = IOController.readString("Enter the title of the movie to create a show for");
		
		
		
		String cineplex_name = IOController.readString("Enter the Cineplex to create the show in");
		int cinema_name = IOController.readChoice(1,3);
	    
		Cinema cin = ShowController.whichCinema(cineplex_name, cinema_name);
		 
		try {
			Movie m = ShowController.whichMovie(movieTitle);
			System.out.println("Hi5");
			String time = IOController.readString("Enter the time of the show ");
			
			ShowController.createShow(time, cin, m, cineplex_name);
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	}

	 
	



