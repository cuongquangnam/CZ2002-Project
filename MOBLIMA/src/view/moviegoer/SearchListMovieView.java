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
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    /**
     * This method is used to display the main menu of this view
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void displayMenu() throws IOException, ClassNotFoundException {
        while (true) {
            IOController.printTitle("Search or list movies");
            System.out.println("Please make a selection:");
            System.out.println("1. Search movie by name");
            System.out.println("2. List all movies");
            System.out.println("3. View top 5 movies");
            System.out.println("4. Return");

            int choice = IOController.getChoice(1, 4);

            switch (choice) {
                case 1:
                    changeView(this, new SearchMovieByNameView());
                    break;
                case 2:
                    changeView(this, new ListAllMovieView());
                    break;
                case 3:
                    changeView(this, new Top5View());
                    break;
                case 4:
                    deleteView();
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }
    }
}
