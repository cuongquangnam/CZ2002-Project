package view.moviegoer;

import controller.IOController;
import controller.MovieListingController;
import controller.ReviewController;
import controller.ViewController;
import model.Movie;

import java.io.IOException;
import java.util.ArrayList;

import static controller.IOController.getString;
import static controller.IOController.printTitle;

/**
 * This class shows the search movie by name menu
 */
public class SearchMovieByNameView extends ViewController {
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
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void displayMenu() throws IOException, ClassNotFoundException {
        while (true) {
            IOController.printTitle("Search Movie by Title");
            String input = getString("Please enter the title of the movie:");
            ArrayList<Movie> searchResult = MovieListingController.getMovieByTitle(input);
            if (searchResult.isEmpty()) {
                System.out.println("0 result has been found\n" +
                                        "Press ENTER to return");
                getString();
                deleteView();
            }
            else {
                System.out.println(searchResult.size() + " results have been found:");
                int i = 1;
                for (Movie movie : searchResult) {
                    if(movie.getShowingStatus() != 4) {
                        System.out.print(i + ". " + movie.getMovieTitle() + "   (" + movie.getStringShowingStatus() + ")   [Rating: ");
                        if (ReviewController.getNumRating(movie) > 1)
                            System.out.print(ReviewController.getMovieRating(movie));
                        else
                            System.out.print("NA");
                        System.out.println("]");
                        i++;
                    }
                }
                System.out.println("Please enter the index number of the movie you want to view details");
                System.out.println("Press 0 to return");
                int choice = IOController.getChoice(0, i);
                if (choice == 0) deleteView();
                else {
                    printTitle("Movie details");
                    System.out.println(searchResult.get(choice - 1).toString());
                }
                displayOptions(searchResult.get(choice - 1));
            }
        }
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
                changeView(this, new ShowTimeView(m));;
                break;
            case 2:
                changeView(this, new ReviewView(m));
                break;
            case 3:
                deleteView();
            default:
                System.out.println("Invalid selection.");
        }
    }
}
