package view;


import controller.IOController;
import controller.ViewController;

import java.io.IOException;
import java.util.Scanner;

import static controller.IOController.printTitle;

public class MainView extends ViewController {
    public void initialize() throws IOException, ClassNotFoundException {
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
                    System.out.println("Bye, hope to see you again!");
                    deleteView();
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }
    }

}
