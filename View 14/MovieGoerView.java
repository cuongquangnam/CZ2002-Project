package view;

import controller.ViewController;
import view.moviegoer.*;

import java.io.IOException;

import static controller.IOController.getChoice;
import static controller.IOController.printTitle;

/**
 * This class represents the main moviegoer view
 */
public class MovieGoerView extends ViewController {
    /**
     * {@inheritDoc}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    /**
     * This method shows the main menu of this view
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void displayMenu() throws IOException, ClassNotFoundException {
        while(true) {
            printTitle("Moviegoer");
            System.out.println("Welcome, please make a selection:");
            System.out.println("1. Search or list movies");
            System.out.println("2. View booking history");
            System.out.println("3. Return");

            int choice = getChoice(1,3);

            switch (choice) {
                case 1:
                    changeView(this, new SearchListMovieView());
                    break;
                case 2:
                    changeView(this, new BookingHistoryView());
                    break;
                case 3:
                    deleteView();
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }
    }
}
