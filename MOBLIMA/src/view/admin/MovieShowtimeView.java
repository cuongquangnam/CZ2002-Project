package view.admin;

import controller.ViewController;

import java.io.IOException;

import static controller.IOController.getChoice;
import static controller.IOController.printTitle;

public class MovieShowtimeView extends ViewController {
    //View to guide the user through the show modification process and take input as to how he/she wants to modify the shows related to a movie.
    /**
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }
    
    /**
     * @throws IOException
     * @throws ClassNotFoundException
     */
    //Transfer control to the right view which is qualified to guide the user based on his/her choice.
    private void displayMenu() throws IOException, ClassNotFoundException {
        while (true) {
            printTitle("Modify movie shows");
            System.out.println("Please make a selection:");
            System.out.println("1. Create a show");
            System.out.println("2. Edit a show");
            System.out.println("3. Remove a show");
            System.out.println("4. Return");

            int choice = getChoice(1, 4);

            switch (choice) {
                case 1:
                    changeView(this, new CreateShowView());
                    break;
                case 2:
                    changeView(this, new UpdateShowView());
                    break;
                case 3:
                    changeView(this, new DeleteShowView());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid selection.");
            }
        }
    }
}
