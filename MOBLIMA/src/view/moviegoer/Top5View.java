package view.moviegoer;

import controller.IOController;
import controller.MovieListingController;
import controller.ReviewController;
import controller.ViewController;
import model.Movie;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class shows the top 5 movies menu
 */
public class Top5View extends ViewController {
    public static int choice = 1;
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
     * This method shows the main menu of this view
     */
    private void displayMenu(){
            switch (choice) {
                case 1:
                    rankingBySales();
                    break;
                case 2:
                    rankingByRating();
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
            IOController.getString("Press ENTER to return");
    }

    /**
     * This method shows the top 5 movies ranking by ticket sales
     */
    private void rankingBySales() {
        IOController.printTitle("Top 5 Movies By Ticket Sales");
        ArrayList<Movie> movieList = MovieListingController.getTop5MovieListing("Sales");
        int i = 1;
        for(Movie movie : movieList) {
            System.out.println(i + ". " + movie.getMovieTitle() + "   (" + movie.getStringShowingStatus() + ")   [Sales: " + movie.getSales() + "]");
            i++;
        }
    }

    /**
     * This method shows the top 5 movies ranking by overall rating
     */
    private void rankingByRating(){
        IOController.printTitle("Top 5 Movies By Overall Rating");
        ArrayList<Movie> movieList = MovieListingController.getTop5MovieListing("Rating");
        int i = 1;
        for(Movie movie : movieList) {
            System.out.print(i + ". " + movie.getMovieTitle() + "   (" + movie.getStringShowingStatus() + ")   [Rating: ");
            if(ReviewController.getNumRating(movie) > 1)
                System.out.print(ReviewController.getMovieRating(movie));
            else
                System.out.print("NA");
            System.out.println("]");
            i++;
        }
    }
}
