package com.views;

import java.util.ArrayList;

import com.controllers.IOController;
import com.controllers.MovieListingController;

public class UpdateMovieView extends View {

	@Override
	public void start() {
		String movieTitle = IOController.readString("Enter the title of the movie to update");
		System.out.println("Select the field to update");
		System.out.println("1. Movie title");
		System.out.println("2. Showing status");
		System.out.println("3. Sypnosis");
		System.out.println("4. Director");
		System.out.println("5. Cast");
		System.out.println("6.Blockbuster or not");
		int choice = IOController.readChoice(1, 6);
		switch(choice)
		{
		case 1:
			String nmovieTitle = IOController.readString("Enter the new title of the movie ");
			MovieListingController.updateMovieTitle(movieTitle, nmovieTitle);
		case 2:
			int nshowingStatus = IOController.readChoice(1, 3);
			MovieListingController.updateShowingStatus(movieTitle, nshowingStatus);
		case 3:
			String nsypnosis = IOController.readString("Enter the new sypnosis of the movie ");
			MovieListingController.updateSypnosis(movieTitle, nsypnosis);
			
		case 4:
			String ndirector = IOController.readString("Enter the new director of the movie ");
			MovieListingController.updateDirector(movieTitle, ndirector);
			
		case 5:
			ArrayList <String> cast = new ArrayList <String>();
			System.out.println("Enter the cast of the movie (atleast 2) folowed by a '0' when done");
			String Cast = "";
			while (!Cast.equals("0"))
			{
			Cast =  IOController.readString("");
			cast.add(Cast);
			} 
			MovieListingController.updateCast(movieTitle, cast);
			
//		case 6:
//			System.
//			boolean isBlockbuster = 
//			MovieListingController.updateIsBlockbuster(movieTitle);
			
		
		}
		
	}

}
