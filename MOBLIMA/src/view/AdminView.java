package view;
import view.admin.MovieListView;
import controller.*;
import view.admin.MovieShowtimeView;
import view.admin.SystemSettingView;

import java.io.IOException;

import static controller.IOController.printTitle;

public class AdminView extends ViewController {
    private static boolean loggedIn;

    /**
     * Allocates an {@code AdminView} object and initializes it.
     */
    public AdminView() {
        loggedIn = false;
    }


    public void initialize() throws IOException, ClassNotFoundException {
        login();
    }
    /**
     * This method is to prompt user to login by entering username and password
     */
    private void login() throws IOException, ClassNotFoundException {
        while(true) {
            System.out.println("Please login to access staff system.");

            System.out.println("Please enter your username: ");
            String username = LoginController.getUsername();
            System.out.println("Please enter your password: ");
            String password = LoginController.getPassword();

            //Authentication function
            if (LoginController.isUserValid(username, password)) {
                loggedIn = true;
                System.out.println("Login successful!");
                displayMenu();
            } else {
                System.out.println("Invalid username or password.");
                deleteView();
            }
        }
    }

    private void displayMenu() throws IOException, ClassNotFoundException {
        while(true) {
            printTitle("Staff");
            System.out.println("Welcome, please make a selection:");
            System.out.println("1. Configure system settings");
            System.out.println("2. Modify movie listing");
            System.out.println("3. Modify cinema showtime and movies to be shown");
            System.out.println("4. Logout");

            int choice = IOController.getChoice(1,4);

            switch (choice) {
                case 1:
                    changeView(this, new SystemSettingView());
                    break;
                case 2:
                    changeView(this, new MovieListView());
                    break;
                case 3:
                    changeView(this, new MovieShowtimeView());
                    break;
                case 4:
                    logOut();
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }

    }

    private void logOut() throws IOException, ClassNotFoundException {
        loggedIn = false;
        System.out.println("You have logged out.");
        deleteView();
    }
}