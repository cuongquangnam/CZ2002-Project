package view;

import controller.ViewController;
import view.moviegoer.*;

import java.io.IOException;
import java.util.Scanner;

import static controller.IOController.getChoice;
import static controller.IOController.printTitle;

public class MovieGoerView extends ViewController {
    Scanner sc = new Scanner(System.in);

    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    private void displayMenu() throws IOException, ClassNotFoundException {
        while(true) {
            printTitle("Moviegoer");
            System.out.println("Welcome, please make a selection:");
            System.out.println("1. Search or list movies");
            System.out.println("2. View movie details");
            System.out.println("3. Purchase ticket");
            System.out.println("4. View booking history");
            System.out.println("5. View Top 5 ranking movie");
            System.out.println("6. Return");

            int choice = getChoice(1,6);

            switch (choice) {
                case 1:
                    changeView(this, new SearchListMovieView());
                    break;
                case 2:
                    changeView(this, new MovieDetailsView());
                    break;
                case 3:
                    changeView(this, new PurchaseTicketView());
                    break;
                case 4:
                    changeView(this, new BookingHistoryView());
                    break;
                case 5:
                    changeView(this, new Top5View());
                    break;
                case 6:
                    deleteView();
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }
    }

    private void checkSeatMenu() {
        while(true) {
            System.out.println("Please input cineplex name you want to check:");
            String input = sc.next();
            if(input.equals("0"))
                return;
            //Get movie showing in cineplex

            System.out.println("Please input movie name you want to check:");
            input = sc.next();
            if(input.equals("0"))
                return;
            //Get showtime of movie in all cinemas of cineplex

            System.out.println("Please input timeslot you want to check:");
            input = sc.next();
            if(input.equals("0"))
                return;
            //Get the seating

        }
    }

}
