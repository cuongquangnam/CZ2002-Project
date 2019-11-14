package view.admin;

import controller.MovieListingController;
import controller.ViewController;

import java.io.IOException;
import java.util.ArrayList;

import static controller.IOController.*;
import static controller.IOController.getBoolean;

public class CreateMovieView extends ViewController {
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    private void displayMenu() throws IOException, ClassNotFoundException {
        String movieTitle;
        int showingStatus;
        String sypnosis;
        String director;
        ArrayList<String> cast = new ArrayList <String>();
        String each_cast;
        double basePrice;
        boolean isBlockBuster;

        printTitle("Create movie listing");

        movieTitle = getString("Enter the title of the movie");

        showingStatus = getInt("Choose the showing status of the movie\n" +
                "1. Coming Soon\n" +
                "2. Preview\n" +
                "3. Now Showing");

        sypnosis = getString("Please enter synopsis of the movie: ");

        director = getString("Please enter director of the movie: ");

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

        basePrice = getDouble("Please enter the base price of the movie");

        isBlockBuster = getBoolean("Enter true if the movie is block buster else enter false");

        MovieListingController.createNewMovie(movieTitle, showingStatus, sypnosis, director, cast, basePrice, isBlockBuster);
        System.out.println("A movie listing is created!");
        getString("Press ENTER to continue");
        deleteView();
    }
}
