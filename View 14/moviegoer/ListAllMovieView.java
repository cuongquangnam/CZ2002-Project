package view.moviegoer;

import controller.IOController;
import controller.MovieListingController;
import controller.ReviewController;
import controller.ViewController;
import model.Movie;

import java.io.IOException;
import java.util.ArrayList;

import static controller.IOController.*;

/**
 * This class is used to display the menu of list all movies
 */
public class ListAllMovieView extends ViewController {
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
            IOController.printTitle("List all movies");
            ArrayList<Movie> movieList = MovieListingController.getAllMovie();
            if(movieList.size() == 0)
                System.out.println("There is no movie yet!");
            else {
                int i = 1;
                for (Movie m : movieList) {
                    System.out.print(i + ". " + m.getMovieTitle() + "   (" + m.getStringShowingStatus() + ")   [Rating: ");
                    if(ReviewController.getNumRating(m) > 1)
                        System.out.print(ReviewController.getMovieRating(m));
                    else
                        System.out.print("NA");
                    System.out.println("]");
                    i++;
                }
            }
            Movie m = movieDetailsView();
            displayOptions(m);
        }
    }

    /**
     * This method is used to display details of movie
     * @return The {@param Movie} which is shown details
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private Movie movieDetailsView() throws IOException, ClassNotFoundException {
            ArrayList<Movie> movieList = MovieListingController.getAllMovie();
            System.out.println("Please enter the index number of the movie you want to view details\n" +
                    "Enter 0 to go back");
            int choice = getChoice(0, movieList.size());
            if (choice == 0)
                deleteView();
            else {
                IOController.printTitle("Movie details");
                System.out.println(movieList.get(choice - 1).toString());
            }
            return movieList.get(choice - 1);
    }

    /**
     * This method is used to show different options after select a movie
     * @param m
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void displayOptions(Movie m) throws IOException, ClassNotFoundException {
        System.out.println("Please select an option:");
        System.out.println("1. View showtime");
        System.out.println("2. View/write reviews and ratings");
        System.out.println("3. Return");
        int choice = IOController.getChoice(1,3);

        switch (choice) {
            case 1:
                //changeView(this, new ShowTimeView(m));;
                break;
            case 2:
                changeView(this, new ReviewView(m));
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid selection.");
        }
    }
}
