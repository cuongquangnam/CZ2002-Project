package view.admin;

import controller.IOController;
import controller.MovieListingController;
import controller.ViewController;
import model.Movie;

import java.io.IOException;
import java.util.ArrayList;

import static controller.IOController.getChoice;

public class UpdateMovieView extends ViewController {
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    private void displayMenu() throws IOException, ClassNotFoundException {
        IOController.printTitle("Edit movie listing");

        Movie movie = new Movie();
        ArrayList<Movie> movieList = MovieListingController.getAllMovie();
        if(movieList.size() == 0)
            System.out.println("There is no movie yet!");
        else {
            int i = 1;
            System.out.println("List of movies:");
            for (Movie m : movieList) {
                System.out.println(i + ". " + m.getMovieTitle() + "   (" + m.getStringShowingStatus() + ")");
                i++;
            }
        }
        System.out.println("Please enter the index number of the movie you want to edit listing\n" +
                "Enter 0 to go back");
        int choice = getChoice(0, movieList.size());
        if (choice == 0)
            return;
        else
            movie = movieList.get(choice - 1);

        String movieTitle = movie.getMovieTitle();
        System.out.println("Select the field to update");
        System.out.println("1. Movie title");
        System.out.println("2. Showing status");
        System.out.println("3. Synopsis");
        System.out.println("4. Director");
        System.out.println("5. Cast");
        System.out.println("6. Blockbuster or not");
        choice = IOController.getChoice(1, 6);
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
                String nsypnosis = IOController.getString("Enter the new synopsis of the movie ");
                MovieListingController.updateSypnosis(movieTitle, nsypnosis);
                break;
            case 4:
                String ndirector = IOController.getString("Enter the new director of the movie ");
                MovieListingController.updateDirector(movieTitle, ndirector);
                break;
            case 5:
                ArrayList <String> cast = new ArrayList<String>();
                System.out.println("Enter the cast of the movie (at least 2) followed by a '0' when done");
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
