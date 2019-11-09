package view;

import java.util.Scanner;

import controller.MovieListingController;

public class MovieListView {
	
	  Scanner sc = new Scanner(System.in);
	  

	    public void initialize() {
	    		MovieListingController movielisting = new MovieListingController();
	        
	            System.out.println("Add a movie to the list of movies");
	           
	            System.out.println("Enter the title of the movie");
	            movielisting.inputMovieTitle();
//	            System.out.println("Choose the showing status of the movie");
//	            
//	            System.out.println("1. Coming Soon");
//	            System.out.println("2. Preview");
//	            System.out.println("3. Now Showing");
//	            movielisting.inputShowingStatus();
//	            System.out.println("Enter the sypnosis");
//	            movielisting.inputSypnosis();
//	            System.out.println("Enter the Director");
//	            movielisting.inputDirector();
//	            System.out.println("Enter the cast members (atleast 2)");
//	            System.out.println("Enter 0 when done");
//	            movielisting.inputCast();
//	            
//	            
//	            System.out.println("Enter the base Price of the movie");
//	            movielisting.inputBasePrice();
//	            System.out.println("Enter true if the movie is 3D else enter false");
//	            movielisting.inputIs3D();
//	            System.out.println("Enter true if the movie is block buster else enter false");
//	            movielisting.inputIsBlockBuster();
//	           
//	    
//	            
	           
	          

}
}