package view.admin;

import controller.*;
import model.Cinema;
import model.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static controller.IOController.*;

public class CreateShowView extends ViewController {
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    private void displayMenu() throws IOException, ClassNotFoundException {
        IOController.printTitle("Create a show");
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
        System.out.println("Please enter the index number of the movie you want to create show\n" +
                "Enter 0 to go back");
        int choice = getChoice(0, movieList.size());
        if (choice == 0)
            return;
        else
            movie = movieList.get(choice - 1);

        IOController.printTitle("Create show for " + movie.getMovieTitle());
        System.out.println("List of cineplexes:");
        System.out.println("1. Cineplex A");
        System.out.println("2. Cineplex B");
        System.out.println("3. Cineplex C");
        System.out.println("Please enter the index number of the cineplex you want to create show in\n" +
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
        int index = 1;
        for(Cinema c: cinemaList) {
            System.out.println(index + ". " + c.getCinemaCode());
            index++;
        }
        System.out.println("Please enter the index number of the cinema you want to create show in\n" +
                "Enter 0 to go back");
        choice = getChoice(0, cinemaList.size());
        if(choice == 0)
            return;
        else
            cinema = cinemaList.get(choice - 1);

        Date time = IOController.readTimeMMddHHmm("Enter the time for the show",
                "Format: MM-DD HH:MM (e.g. 12-25 09:30)");

        ShowController.createShow(time, cinema, movie, cineplex_name);
        System.out.println("Showtime created for " + movie.getMovieTitle() + ":\n" +
                            "Cineplex: " + cineplex_name +
                            "\nCinema: " + cinema.getCinemaCode() +
                            "\nTime: " + formatTimeMMddHHmm(time));
        System.out.println("Press ENTER to return");
        getString();
    }
}
