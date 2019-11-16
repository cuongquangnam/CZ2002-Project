package view.admin;

import controller.IOController;
import controller.ViewController;
import view.moviegoer.Top5View;

import java.io.IOException;

public class Top5SettingView extends ViewController {
    //View to help user choose how he would like to configure the top 5 movies.
    
    @Override
    public void initialize() {
        displayMenu();
    }
//Ranking by sales or by rating
    private void displayMenu() {
        while (true) {
            IOController.printTitle("View Top 5 Movies");
            System.out.println("Please make a selection:");
            System.out.println("1. Ranking by ticket sales");
            System.out.println("2. Ranking by overall rating");
            System.out.println("3. Return");

            int choice = IOController.getChoice(1,3);

            switch (choice) {
                case 1:
                    Top5View.choice = 1;
                    System.out.println("Top 5 movies is now ranked by ticket sales!");
                    IOController.getString("Press ENTER to return");
                    break;
                case 2:
                    Top5View.choice = 2;
                    System.out.println("Top 5 movies is now ranked by overall rating!");
                    IOController.getString("Press ENTER to return");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid selection.");
            }
        }
    }
}
