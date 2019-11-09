package view;

import java.util.Scanner;

import controller.*;

public class AdminView extends ViewController {
    Scanner sc = new Scanner(System.in);
    private static boolean loggedIn;

    /**
     * Allocates a {@code StaffView} object and initializes it.
     */
    public AdminView() {
        loggedIn = false;
    }

    /**
     * {@inheritDoc}
     */
   
    protected void initialize() {
        login();
    }
    /**
     * This method is to prompt user to login by entering username and password
     */
    private void login() {
        while(true) {
            System.out.println("Please login to access staff system.");

            System.out.println("Please enter your username: ");
            LoginController.getUsername();
            System.out.println("Please enter your password: ");
            LoginController.getPassword();

            //Test views
            System.out.println("Login successful!");
            displayMenu();
            if (true) {
                loggedIn = true;
                System.out.println("Login successful!");
                displayMenu();
            } else {
                System.out.println("Invalid username or password.");
                deleteView();
            }
        }
    }

    private void displayMenu() {
        while(true) {
            System.out.println("Staff");
            System.out.println("Welcome, please make a selection:");
            System.out.println("1. Configure system settings");
            System.out.println("2. Modify movie listing");
            System.out.println("3. Modify cinema showtime and movies to be shown");
            System.out.println("4. Logout");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    configSystemSettingMenu();
                    break;
                case 2:
                    modifyMovieListingMenu();
                    break;
                case 3:
                    modifyMovieShowtimeMenu();
                    break;
                case 4:
                    logOut();
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }

    }

    public int modifyMovieListingMenu() {
        System.out.println("Please make a selection:");
        System.out.println("1. Create movie listing");
        System.out.println("2. Edit movie listing");
        System.out.println("3. Remove movie listing");
        System.out.println("4. Return");
        Scanner sc = new Scanner (System.in);
         int choice  = sc.nextInt();
         return choice;
    }

//        switch(choice) {
//            case 1:
//
//                break;
//            case 2:
//
//                break;
//            case 3:
//
//                break;
//            case 4:
//                return;
//            default:
//                System.out.println("Invalid selection.");
//        }
//    }

    private void modifyMovieShowtimeMenu() {

        int choice = sc.nextInt();

        switch(choice) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                return;
            default:
                System.out.println("Invalid selection.");
        }
    }

    private void configSystemSettingMenu() {

    }

    private void logOut() {
        loggedIn = false;
        System.out.println("You have logged out.");
        deleteView();
    }
}