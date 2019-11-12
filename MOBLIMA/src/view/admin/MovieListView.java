package view.admin;

import java.io.IOException;
import java.util.ArrayList;

import controller.ViewController;
import controller.MovieListingController;
import model.Movie;

import static controller.IOController.*;

public class MovieListView extends ViewController {

	public void initialize() throws IOException, ClassNotFoundException {
		displayMenu();
	}

	/**
	 * This method is used to display Create new movie listing menu
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void createMovieListingMenu() throws IOException, ClassNotFoundException {
		String movieTitle;
		int showingStatus;
		String sypnosis;
		String director;
		ArrayList<String> cast = new ArrayList <String>();
		String each_cast;
		double basePrice;
		boolean isBlockBuster;

		printTitle("Add a movie to the list of movies");

		movieTitle = getString("Enter the title of the movie");

		showingStatus = getInt("Choose the showing status of the movie\n" +
									"1. Coming Soon\n" +
									"2. Preview\n" +
									"3. Now Showing");

		sypnosis = getString("Enter the sypnosis");

		director = getString("Enter the Director");

		System.out.println("Enter the cast members (atleast 2)");
		System.out.println("Enter 0 when done");
		int count = 0;
		do {
			each_cast = getString();
			if(each_cast != null && !each_cast.equals("0")) {
				cast.add(each_cast);
				count++;
			}
		}while(!each_cast.equals("0") || count < 2);

		basePrice = getDouble("Enter the base Price of the movie");

		isBlockBuster = getBoolean("Enter true if the movie is block buster else enter false");

		MovieListingController.createNewMovie(movieTitle, showingStatus, sypnosis, director, cast, basePrice, isBlockBuster);
	}

	private void updateMovieListingMenu() {

	}

	private void removeMovieListingMenu() {

	}

	/**
	 * This method is used to list all movies
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void listAllMovieMenu() throws IOException, ClassNotFoundException {
		ArrayList<Movie> movieList = MovieListingController.getAllMovie();
		if(movieList.size() == 0)
			System.out.println("There is no movie yet!");
		else {
			int i = 1;
			System.out.println("List of movies:");
			for (Movie m : movieList) {
				System.out.println(i + ". " + m.getMovieTitle() + " " + m.getShowingStatus());
				i++;
			}
		}
	}

	/**
	 * This method is used to display the modifying menu
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void displayMenu() throws IOException, ClassNotFoundException {
		while (true) {
			printTitle("Modify movie listing");
			System.out.println("Please make a selection:");
			System.out.println("1. Create movie listing");
			System.out.println("2. Edit movie listing");
			System.out.println("3. Remove movie listing");
			System.out.println("4. View movie details");
			System.out.println("5. Return");

			int choice = getChoice(1, 5);

			switch (choice) {
				case 1:
					createMovieListingMenu();
					break;
				case 2:
						//	    			updateMovieListingMenu();
					break;
				case 3:
						//					removeMovieListingMenu();
					break;
				case 4:
					viewMovieDetailsMenu();
					break;
				case 5:
					return;
				default:
					System.out.println("Invalid selection.");
			}
		}
	}

	/**
	 * This method is used to show the movie detail to the admin
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void viewMovieDetailsMenu() throws IOException, ClassNotFoundException {
		ArrayList<Movie> movieList = MovieListingController.getAllMovie();
		printTitle("View movie details");
		listAllMovieMenu();
		System.out.println("Please enter the index number of the movie you want to view details\n" +
							"Enter 0 to go back");
		int choice = getChoice(0, movieList.size());
		if (choice == 0)
			return;
		else {
			System.out.println("Title: " + movieList.get(choice - 1).getMovieTitle());
            System.out.print("Showing Status: ");
            if(movieList.get(choice - 1).getShowingStatus() == 1)
                System.out.println("Coming Soon");
            else if(movieList.get(choice - 1).getShowingStatus() == 2)
                System.out.println("Preview");
            else if(movieList.get(choice - 1).getShowingStatus() == 3)
                System.out.println("Now Showing");
            else if(movieList.get(choice - 1).getShowingStatus() == 4)
                System.out.println("End of Showing");
			System.out.println("Director: " + movieList.get(choice - 1).getDirector());
			System.out.println("Sypnosis: " + movieList.get(choice - 1).getSypnosis());
			System.out.println("Casts: " + movieList.get(choice - 1).getCast());
			System.out.println("Base Price: " + movieList.get(choice - 1).getBasePrice());
			System.out.println("Blockbuster: " + movieList.get(choice - 1).isBlockBuster());
		}
		String end = getString("Press ENTER to continue");
	}


}