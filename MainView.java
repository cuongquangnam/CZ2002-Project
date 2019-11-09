package view;


import java.util.Scanner;

import controller.ViewController;

public class MainView extends ViewController{
    public void initialize() {
        while(true) {
            Scanner sc = new Scanner(System.in);
            // initialize MainController

            // Main interface
            System.out.println("MOvie Booking and LIsting Management Application (MOBLIMA)");
            System.out.println("Welcome, please make a selection:");
            System.out.println("1. Moviegoer Menu");
            System.out.println("2. Staff Menu");
            System.out.println("3. Exit application");

            int choice = sc.nextInt();

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