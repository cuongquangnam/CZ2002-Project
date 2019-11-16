package view.admin;

import controller.*;
import model.Cinema;
import model.Movie;
import model.Show;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static controller.IOController.*;

public class UpdateShowView extends ViewController {
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    private void displayMenu() throws IOException, ClassNotFoundException {
        IOController.printTitle("Edit a show");
        int show_index = 0;
        String cineplex_name = null;
        Cinema cinema = null;
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
        System.out.println("Please enter the index number of the movie you want to edit show\n" +
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

        System.out.println("Please enter the index number of the showtime you want to edit\n" +
                "Enter 0 to go back");
        choice = getChoice(0, showList.size());
        if(choice == 0)
            return;
        else
            show_index = choice - 1;

        System.out.println("Select the field to update");
        System.out.println("1. Cinema");
        System.out.println("2. Time");
        System.out.println("Enter 0 to go back");
        choice = IOController.getChoice(0, 2);
        switch(choice) {
            case 0:
                return;
            case 1:
                System.out.println("List of cineplexes:");
                System.out.println("1. Cineplex A");
                System.out.println("2. Cineplex B");
                System.out.println("3. Cineplex C");
                System.out.println("Please enter the index number of the cineplex you want to update show in\n" +
                        "Enter 0 to go back");
                choice = getChoice(0, 3);
                switch (choice) {
                    case 0:
                        deleteView();
                        break;
                    case 1:
                        cineplex_name = "Cineplex A";
                        break;
                    case 2:
                        cineplex_name = "Cineplex B";
                        break;
                    case 3:
                        cineplex_name = "Cineplex C";
                        break;
                }
                ArrayList<Cinema> cinemaList = ShowController.getCinemaList(cineplex_name, FileReadWriteController.readCinemaList());
                System.out.println("List of cinemas in " + cineplex_name + ":");
                index = 1;
                for (Cinema c : cinemaList) {
                    System.out.println(index + ". " + c.getCinemaCode());
                    index++;
                }
                System.out.println("Please enter the index number of the cinema you want to update show in\n" +
                        "Enter 0 to go back");
                choice = getChoice(0, cinemaList.size());
                if (choice == 0)
                    return;
                else
                    cinema = cinemaList.get(choice - 1);
                ShowController.updateShowCinema(movie, show_index, cinema);
                break;
            case 2:
                Date time = IOController.readTimeMMddHHmm("Enter the new time for the show",
                        "Format: MM-DD HH:MM (e.g. 12-25 09:30)");
                ShowController.updateShowDateTime(movie, show_index, time);
                break;
        }
        System.out.println("Update show successfully!");
        getString("Press ENTER to return");
    }
}
