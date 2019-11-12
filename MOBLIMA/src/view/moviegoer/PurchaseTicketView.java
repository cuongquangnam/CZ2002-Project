package view.moviegoer;

import controller.MovieListingController;
import controller.ViewController;
import controller.IOController;
import model.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import static controller.IOController.*;

public class PurchaseTicketView extends ViewController {
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    private void displayMenu() throws IOException, ClassNotFoundException {
        while(true) {
            IOController.printTitle("Purchase ticket");
            listAllMovieMenu();
            Movie m = displayMovieDetails();
            displayShowTime(m);
            displayOptions();
        }


    }

    private void displayShowTime(Movie movie) {
//        Date today = new Date();
//        Date tomorrow = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);
//        Date afterTomorrow = new Date(new Date().getTime() + 2* 24 * 60 * 60 * 1000);
//        Date dateChosen;
//
//        if (movie.getShowingStatus() == 2 || movie.getShowingStatus() == 3) {
//            System.out.println("1. " + formatTimeMMdd(today) + " (today)");
//            System.out.println("2. " + formatTimeMMdd(tomorrow) + " (tomorrow)");
//            System.out.println("3. " + formatTimeMMdd(afterTomorrow) + " (after tomorrow)");
//            System.out.println("Please choose a date:");
//            switch (readChoice(1, 3)) {
//                case 1:
//                    dateChosen = today;
//                    break;
//                case 2:
//                    dateChosen = tomorrow;
//                    break;
//                default:
//                    dateChosen = afterTomorrow;
//                    break;
//            }
//            printHeader("Showtime on " + formatTimeMMdd(dateChosen));
//
//            ArrayList<Showtime> showtimeList = new ArrayList<>();
//            showtimeList.sort(Comparator.comparing(o -> o.getCinema().getCineplex().toString()));
//
//            if (getMovieShowtime(movie) != null) {
//                for (Showtime s : getMovieShowtime(movie)) {
//                    if (dateEquals(s.getTime(), dateChosen)) showtimeList.add(s);
//                }
//            }
//
//            if (showtimeList.isEmpty()) {
//                printMenu("No showtime on that day.",
//                        "Press ENTER to go back");
//                readString();
//                return;
//            }
//
//            int index = 0;
//            for (Showtime s : showtimeList) {
//                System.out.println(++index + ": " + s);
//            }
//
//            System.out.println("Please choose a showtime (enter 0 to go back):");
//
//            System.out.println();
//            int choice = readChoice(0, showtimeList.size());
//            if (choice == 0) {

//                return;
//            }
//
//            Showtime showtime = showtimeList.get(choice - 1);
//            displayShowtimeDetailMenu(showtime);
//        }
//        else {
//            System.out.println("You are not allowed to book this movie");
//        }


    }
    private void displayOptions() {
        System.out.println("Please select an option:");
        System.out.println("1. Check seat availability");
        System.out.println("2. Purchase ticket");
        System.out.println("3. Check price");
        System.out.println("4. Return");
        int choice = getChoice(1, 4);

        switch (choice) {
            case 1:
                checkSeatMenu();
                break;
            case 2:
                purchaseTicketMenu();
                break;
            case 3:
                checkPriceMenu();
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid selection.");
        }
    }

    private void checkPriceMenu() {
        double basePrice = showtime.getCinema().getBasePrice();
        Movie movie = showtime.getMovie();
        printTitle("Ticket price for " + movie.getMovieTitle() + " (" + (showtime.getCinema().is3D() ? "3D" : "Digital") + ")");
        System.out.printf("                    Weekdays        Weekends\n" +
                "Regular Citizens    %-8.2f        %-8.2f\n" +
                "Senior Citizens     %-8.2f        %-8.2f\n" +
                "Students            %-8.2f        %-8.2f\n\n", basePrice, basePrice * 1.2, basePrice * 0.5, basePrice * 0.5 * 1.2, basePrice * 0.75, basePrice * 0.75 * 1.2);
        System.out.println("Note that price may change on holidays.");
        System.out.println("Please refer to the price when making payment.");
        System.out.println();
        readString("Press ENTER to go back");
    }

    private void purchaseTicketMenu() {
    }

    private void checkSeatMenu() {
    }

    private Movie displayMovieDetails() throws IOException, ClassNotFoundException {
            ArrayList<Movie> movieList = MovieListingController.getAllMovie();
            System.out.println("Please enter the index number of the movie you want to purchase ticket\n" +
                    "Enter 0 to go back");
            int choice = getChoice(0, movieList.size());
            if (choice == 0)
                deleteView();
            else {
                System.out.println("Title: " + movieList.get(choice - 1).getMovieTitle());
                System.out.print("Showing Status: ");
                if(movieList.get(choice - 1).getShowingStatus() == 1)
                    System.out.println("Coming Soon");
                else if(movieList.get(choice - 1).getShowingStatus() == 2)
                    System.out.println("Preview");
                else if(movieList.get(choice - 1).getShowingStatus() == 3)
                    System.out.println("Now Showing");
                else if(movieList.get(choice - 1).getShowingStatus() == 4)
                    System.out.println("End of Showing");
                System.out.println("Director: " + movieList.get(choice - 1).getDirector());
                System.out.println("Sypnosis: " + movieList.get(choice - 1).getSypnosis());
                System.out.println("Casts: " + movieList.get(choice - 1).getCast());
                System.out.println("Base Price: " + movieList.get(choice - 1).getBasePrice());
                System.out.println("Blockbuster: " + movieList.get(choice - 1).isBlockBuster());
            }
            return movieList.get(choice - 1);
    }

    private void listAllMovieMenu() throws IOException, ClassNotFoundException {
        ArrayList<Movie> movieList = MovieListingController.getAllMovie();
        int i = 1;
        for (Movie m : movieList) {
            System.out.print(i + ". " + m.getMovieTitle() + "      ");
            if(m.getShowingStatus() == 1)
                System.out.println("(Coming Soon)");
            else if(m.getShowingStatus() == 2)
                System.out.println("(Preview)");
            else if(m.getShowingStatus() == 3)
                System.out.println("(Now Showing)");
            else if(m.getShowingStatus() == 4)
                System.out.println("(End of Showing)");
            i++;
        }
    }
}
