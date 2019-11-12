package view.moviegoer;

import controller.IOController;
import controller.MovieListingController;
import controller.ViewController;
import model.Movie;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class represents the search or list movies view
 */
public class SearchListMovieView extends ViewController {
    /**
     * {@inheritDoc}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    /**
     * This method is used to display the main menu of this view
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void displayMenu() throws IOException, ClassNotFoundException {
        while(true) {
            IOController.printTitle("Search or list movies");
            System.out.println("Please make a selection:");
            System.out.println("1. Search movie by name");
            System.out.println("2. List all movies");
            System.out.println("3. Return");

            int choice = IOController.getChoice(1,3);

            switch (choice) {
                case 1:
                    searchMovieByNameMenu();
                    break;
                case 2:
                    listAllMovieMenu();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid selection.");
            }
        }
    }

    /**
     * This method is used to display search movies by name menu
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void searchMovieByNameMenu() throws IOException, ClassNotFoundException {
        String enter;
        ArrayList<Movie> movieList = MovieListingController.getAllMovie();
        String movieName = IOController.getString("Enter name of the movie you want to search:");
        for (Movie m : movieList) {
            if((m.getMovieTitle().toUpperCase()).equals(movieName.toUpperCase())) {
                System.out.println("Title: " + m.getMovieTitle());
                System.out.print("Showing Status: ");
                if(m.getShowingStatus() == 1)
                    System.out.println("Coming Soon");
                else if(m.getShowingStatus() == 2)
                    System.out.println("Preview");
                else if(m.getShowingStatus() == 3)
                    System.out.println("Now Showing");
                else if(m.getShowingStatus() == 4)
                    System.out.println("End of Showing");
                System.out.println("Director: " + m.getDirector());
                System.out.println("Sypnosis: " + m.getSypnosis());
                System.out.println("Casts: " + m.getCast());
                System.out.println("Base Price: " + m.getBasePrice());
                System.out.println("Blockbuster: " + m.isBlockBuster());
                enter = IOController.getString("Press ENTER to continue");
                return;
            }
        }
        System.out.println("There is no movie with that name!");
        enter = IOController.getString("Press ENTER to continue");

    }

    /**
     * This method is used to display list all movies menu
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
        String enter = IOController.getString("Press ENTER to continue");
    }
}
