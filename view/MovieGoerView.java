package view;

import java.util.Scanner;

public class MovieGoerView extends BaseView {
    Scanner sc = new Scanner(System.in);

    protected void initialize() {
        while(true) {
            System.out.println("Moviegoer");
            System.out.println("Welcome, please make a selection:");
            System.out.println("1. Search or list movies");
            System.out.println("2. View movie details");
            System.out.println("3. Check seat availability");
            System.out.println("4. Purchase ticket");
            System.out.println("5. View booking history");
            System.out.println("6. View Top 5 ranking movie");
            System.out.println("7. Return");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    searchOrListMovieMenu();
                    break;
                case 2:
                    viewMovieDetailsMenu();
                    break;
                case 3:
                    checkSeatMenu();
                    break;
                case 4:
                    purchaseTicketMenu();
                    break;
                case 5:
                    viewBookingHistoryMenu();
                    break;
                case 6:
                    viewTop5Menu();
                    break;
                case 7:
                    deleteView();
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }
    }

    private void searchOrListMovieMenu() {
        while(true) {
            System.out.println("Please make a selection:");
            System.out.println("1. Search movie by name");
            System.out.println("2. List all movies");
            System.out.println("3. Return");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid selection.");
            }
        }
    }

    private void viewMovieDetailsMenu() {
        while(true) {
            System.out.println("Please input movie name to view details or input 0 to return to previous screen:");
            String input = sc.next();
            if(input.equals("0"))
                return;
            //Show details
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

    private void purchaseTicketMenu() {
    }

    private void viewBookingHistoryMenu() {
    }

    private void viewTop5Menu() {
    }
}
