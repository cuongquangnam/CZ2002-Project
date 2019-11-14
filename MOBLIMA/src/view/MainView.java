package view;


import controller.IOController;
import controller.ViewController;

import java.io.IOException;

import static controller.IOController.printTitle;

/**
 * This class represents the main view of the program
 */
public class MainView extends ViewController {
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    /**
     * This mothod shows main menu of this view
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void displayMenu() throws IOException, ClassNotFoundException {
        while(true) {
            // Main interface
            printTitle("MOvie Booking and LIsting Management Application (MOBLIMA)");
            System.out.println("Welcome, please make a selection:");
            System.out.println("1. Moviegoer Menu");
            System.out.println("2. Staff Menu");
            System.out.println("3. Exit application");

            int choice = IOController.getChoice(1,3);

            switch (choice) {
                case 1:
                    changeView(this, new MovieGoerView());
                    break;
                case 2:
                    changeView(this, new AdminView());
                    break;
                case 3:
                    System.out.println("See you again!");
                    deleteView();
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }
    }

}
