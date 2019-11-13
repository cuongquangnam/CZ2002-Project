package view.admin;

import controller.IOController;
import controller.MovieListingController;
import controller.ViewController;

import java.io.IOException;

import static controller.IOController.getString;
import static controller.IOController.printTitle;

public class DeleteMovieView extends ViewController {
    @Override
    public void initialize(){
        displayMenu();
    }

    private void displayMenu() {
        printTitle("Delete movie listing");
        String movieTitle = IOController.getString("Enter the title of the movie to delete");
        MovieListingController.deleteMovie(movieTitle);
        System.out.println("Successfully delete movie!");
        getString("Press ENTER to continue");
        try {
            deleteView();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
