ackage view.admin;

import controller.MovieListingController;
import controller.ViewController;

import java.io.IOException;
import java.util.ArrayList;

import static controller.IOController.*;
import static controller.IOController.getBoolean;

public class CreateMovieView extends ViewController {
    
	//View to to guide the user through the movie creation process and provide correct inputs.
	
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    /**
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void displayMenu() throws IOException, ClassNotFoundException {
        String movieTitle; // To store the title of the new movie
        int showingStatus; // To store the showing status of the new movie
        String sypnosis; // To store the sypnosis of the new movie
        String director; // To store the director of the new movie
        ArrayList<String> cast = new ArrayList <String>(); // To store the list of cast of the new movie
        String each_cast; // To store each cast of the new movie
        double basePrice; // To store the base price of the new movie
        boolean isBlockBuster; // To store if the new movie is a blockbuster.

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
        getString("Press ENTER to return");
    }
}
