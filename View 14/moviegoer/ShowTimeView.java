package view.moviegoer;

import controller.FileReadWriteController;
import controller.IOController;
import controller.ViewController;
import model.Movie;
import model.SeatMap;
import model.Show;

import java.io.IOException;
import java.util.*;

import static controller.IOController.*;

public class ShowTimeView extends ViewController {
    private Movie movie;

    ShowTimeView(Movie movie) {
        this.movie = movie;
    }
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    private void displayMenu() throws IOException, ClassNotFoundException {
        Date today = new Date();
        Date tomorrow = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);
        Date afterTomorrow = new Date(new Date().getTime() + 2* 24 * 60 * 60 * 1000);
        Date dateChosen = null;
        ArrayList<Show> showTimeList = new ArrayList<Show>();

        if (movie.getShowingStatus() == 2 || movie.getShowingStatus() == 3) {
            System.out.println("1. " + IOController.formatTimeMMdd(today) + " (today)");
            System.out.println("2. " + IOController.formatTimeMMdd(tomorrow) + " (tomorrow)");
            System.out.println("3. " + IOController.formatTimeMMdd(afterTomorrow) + " (after tomorrow)");
            System.out.println("Please choose a date:");
            switch (IOController.getChoice(1, 3)) {
                case 1:
                    dateChosen = today;
                    break;
                case 2:
                    dateChosen = tomorrow;
                    break;
                default:
                    dateChosen = afterTomorrow;
                    break;
            }
            IOController.printTitle("Showtime on " + IOController.formatTimeMMdd(dateChosen));

            HashMap<Movie, ArrayList<Show>> movieShowTime = FileReadWriteController.readShowTime();

            if (movieShowTime.get(movie).size() != 0) {
                for (Show s : movieShowTime.get(movie)) {
                    if (dateEquals(s.getTime(), dateChosen))
                        showTimeList.add(s);
                }
            }

            if (showTimeList.isEmpty()) {
                System.out.println("No showtime on that day.");
                System.out.println("Press ENTER to go back");
                getString();
                return;
            }

            int index = 0;
            for (Show s : showTimeList) {
                System.out.println(++index + ": " + s);
            }

            System.out.println("Please choose a showtime (enter 0 to go back):");

            System.out.println();
            int choice = getChoice(0, showTimeList.size());
            if (choice == 0) {
                return;
            }

            Show showtime = showTimeList.get(choice - 1);
            displayShowtimeDetailMenu(showtime);
        }
        else {
            System.out.println("You are not allowed to book this movie");
        }
    }

    private void displayShowtimeDetailMenu(Show showtime) throws IOException, ClassNotFoundException {
        printTitle(showtime.toString());
        System.out.println("1. Check seat availability");
        System.out.println("2. Book seat");
        System.out.println("3. Check price");
        System.out.println("4. Go back");

        int choice = IOController.getChoice(1, 4);
        switch (choice) {
            case 1:
                changeView(this, new CheckSeat(showtime.getSeatMap()));
                displayShowtimeDetailMenu(showtime);
                break;
            case 2:
                changeView(this, new CheckSeat(showtime.getSeatMap()));
//                displayBookSeatMenu(showtime);
                break;
            case 3:
//                displayPrice(showtime);
                break;
            case 4:
                deleteView();
                break;
        }
    }
}
