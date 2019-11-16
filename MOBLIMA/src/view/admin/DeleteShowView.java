package view.admin;

import controller.*;
import model.Movie;
import model.Show;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static controller.IOController.*;
import static controller.IOController.getChoice;

public class DeleteShowView extends ViewController {
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    private void displayMenu() throws IOException, ClassNotFoundException {
        printTitle("Delete a show");
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
        System.out.println("Please enter the index number of the movie you want to delete show\n" +
                "Enter 0 to go back");
        int choice = getChoice(0, movieList.size());
        if (choice == 0)
            return;
        else
            movie = movieList.get(choice - 1);

        HashMap<Movie, ArrayList<Show>> movieShowList = FileReadWriteController.readShowTime();
        if(movie.getShowingStatus() == 1 || movie.getShowingStatus() == 4) {
            System.out.println("You are not allowed to set showtime for this movie");
            System.out.println("Press ENTER to go back");
            getString();
            return;
        }
        else if(movieShowList.get(movie) == null || movieShowList.get(movie).size() == 0) {
            System.out.println("There is no show for this movie");
            System.out.println("Press ENTER to return");
            getString();
            return;
        }
        ArrayList <Show> showList = movieShowList.get(movie);
        int index = 1;
        for(Show show: showList) {
            System.out.println(index + ". " + show.getCineplex() + ", " + show.getCinema().getCinemaCode() + ", " + IOController.formatTimeMMddHHmm(show.getTime()));
            index++;
        }

        System.out.println("Please enter the index number of the showtime you want to delete\n" +
                "Enter 0 to go back");
        choice = getChoice(0, showList.size());
        if (choice == 0)
            return;
        else
            ShowController.deleteShow(movie, choice - 1);

        System.out.println("Successfully delete show!");
        getString("Press ENTER to return");
    }
}
