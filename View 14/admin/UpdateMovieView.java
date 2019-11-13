package view.admin;

import controller.IOController;
import controller.MovieListingController;
import controller.ViewController;

import java.io.IOException;
import java.util.ArrayList;

public class UpdateMovieView extends ViewController {
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    private void displayMenu() {
        IOController.printTitle("Edit movie listing");
        String movieTitle = IOController.getString("Enter the title of the movie to update:");
        System.out.println("Select the field to update");
        System.out.println("1. Movie title");
        System.out.println("2. Showing status");
        System.out.println("3. Sypnosis");
        System.out.println("4. Director");
        System.out.println("5. Cast");
        System.out.println("6. Blockbuster or not");
        int choice = IOController.getChoice(1, 6);
        switch(choice)
        {
            case 1:
                String nmovieTitle = IOController.getString("Enter the new title of the movie ");
                MovieListingController.updateMovieTitle(movieTitle, nmovieTitle);
                break;
            case 2:
                int nshowingStatus = IOController.getChoice(1, 3);
                MovieListingController.updateShowingStatus(movieTitle, nshowingStatus);
                break;
            case 3:
                String nsypnosis = IOController.getString("Enter the new sypnosis of the movie ");
                MovieListingController.updateSypnosis(movieTitle, nsypnosis);
                break;
            case 4:
                String ndirector = IOController.getString("Enter the new director of the movie ");
                MovieListingController.updateDirector(movieTitle, ndirector);
                break;
            case 5:
                ArrayList <String> cast = new ArrayList<String>();
                System.out.println("Enter the cast of the movie (atleast 2) followed by a '0' when done");
                String Cast = "";
                while (!Cast.equals("0"))
                {
                    Cast =  IOController.getString("");
                    cast.add(Cast);
                }
                MovieListingController.updateCast(movieTitle, cast);
                break;
            case 6:
                boolean isBlockbuster = IOController.getBoolean("Enter true if the movie is block buster else enter false");
                MovieListingController.updateIsBlockbuster(movieTitle, isBlockbuster);
                break;
        }
    }
}
