package view.moviegoer;

import controller.*;
import model.Movie;
import model.Show;

import java.io.IOException;
import java.util.*;

import static controller.IOController.*;

/**
 * This class handles the showtime display for the moviegoers
 */
public class ShowTimeView extends ViewController {

    /**
     * The movie that has its showtime viewed by user
     */
    private Movie movie;

    /**
     * Constructor
     * @param movie The movie that has its showtime viewed by user
     */
    ShowTimeView(Movie movie) {
        this.movie = movie;
    }

    /**
     * {@inheritDoc}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    /**
     * This method displays the showtime menu to user
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void displayMenu() throws IOException, ClassNotFoundException {
        while(true) {
            printTitle("View showtimes");
            Date today = new Date();
            Date tomorrow = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);
            Date afterTomorrow = new Date(new Date().getTime() + 2 * 24 * 60 * 60 * 1000);
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

                if (movieShowTime.get(movie) != null && movieShowTime.get(movie).size() != 0) {
                    for (Show s : movieShowTime.get(movie)) {
                        if (dateEquals(s.getTime(), dateChosen))
                            showTimeList.add(s);
                    }
                }

                if (movieShowTime.get(movie) == null || showTimeList.isEmpty()) {
                    System.out.println("No showtime on that day.");
                    System.out.println("Press ENTER to go back");
                    getString();
                    return;
                }

                int index = 0;
                for (Show s : showTimeList) {
                    System.out.println(++index + ": " + s + "  (3D: " + s.getCinema().is3D() + ", Platinum: " + s.getCinema().isPlatinum() + ")");
                }

                System.out.println("Please choose a showtime (enter 0 to go back):");

                System.out.println();
                int choice = getChoice(0, showTimeList.size());
                if (choice == 0) {
                    return;
                }

                Show showtime = showTimeList.get(choice - 1);
                displayShowtimeDetailMenu(showtime, choice - 1);
            } else {
                System.out.println("You are not allowed to book this movie");
                System.out.println("Press ENTER to go back");
                getString();
                return;
            }
        }
    }

    /**
     * This method displays the price of the movie checked by user
     * @param showTime The showtime selected by user
     */
    private void displayPrice(Show showTime) {
        IOController.printTitle("Check price");
        System.out.println("Base price of this movie: " + showTime.getMovie().getBasePrice());
        System.out.println("Platinum cinema: " + showTime.getCinema().isPlatinum() + "   (+" + TicketPriceController.getPlatinumPrice() + " for each ticket if true)");
        System.out.println("3D: " + showTime.getCinema().is3D() + "   (+"+ TicketPriceController.get3DPrice() + " for each ticket if true)");
        System.out.println("Blockbuster: " + showTime.getMovie().isBlockBuster() + "   (+"+ TicketPriceController.getBlockBusterPrice() + " for each ticket if true)");
        System.out.println("Weekend: " + (showTime.getTime().getDay() == 6 || showTime.getTime().getDay() == 0) + "   (+" + TicketPriceController.getWeekendPrice() + " for each ticket if true)");
        System.out.println("Holiday: " + HolidayController.checkHoliday(showTime.getTime()) + "   (+"+ TicketPriceController.getHolidayPrice() + " for each ticket if true)");
        System.out.println("Senior: " + TicketPriceController.getSeniorPrice() + " for each ticket if ticket belongs to senior");
        getString("Press ENTER to return");
    }

    /**
     * This method displays the options user can take after select a showtime
     * @param showtime The showtime selected by user
     * @param i_showtime Index of showtime selected by user in the list of the movie's showtime
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void displayShowtimeDetailMenu(Show showtime, int i_showtime) throws IOException, ClassNotFoundException {
        printTitle(showtime.toString());
        System.out.println("1. Check seat availability");
        System.out.println("2. Book seat");
        System.out.println("3. Check price");
        System.out.println("4. Go back");

        int choice = IOController.getChoice(1, 4);
        switch (choice) {
            case 1:
                changeView(this, new CheckSeat(showtime.getSeatMap()));
                displayShowtimeDetailMenu(showtime, i_showtime);
                break;
            case 2:
                changeView(this, new CheckSeat(showtime.getSeatMap()));
                changeView(this, new BookingView(showtime, i_showtime));
                break;
            case 3:
                displayPrice(showtime);
                break;
            case 4:
                deleteView();
                break;
        }
    }
}
