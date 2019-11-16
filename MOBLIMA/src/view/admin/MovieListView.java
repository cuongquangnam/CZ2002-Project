package view.admin;

import java.io.IOException;

import controller.ViewController;

import static controller.IOController.*;

public class MovieListView extends ViewController {
//View to guide the user through  modifying the movie list process and provide correct input as to how the user would like to modify the list.
	
	public void initialize() throws IOException, ClassNotFoundException {
		displayMenu();
	}

	/**
	 * This method is used to display the modifying menu
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	//Transfer control to the correct view which is designed to guide the user based on the choice of the user.
	private void displayMenu() throws IOException, ClassNotFoundException {
		while (true) {
			printTitle("Modify movie listing");
			System.out.println("Please make a selection:");
			System.out.println("1. Create movie listing");
			System.out.println("2. Edit movie listing");
			System.out.println("3. Remove movie listing");
			System.out.println("4. View movie details");
			System.out.println("5. Return");

			int choice = getChoice(1, 5);

			switch (choice) {
				case 1:
					changeView(this, new CreateMovieView());
					break;
				case 2:
					changeView(this, new UpdateMovieView());
					break;
				case 3:
					changeView(this, new DeleteMovieView());
					break;
				case 4:
					changeView(this, new DisplayMovieView());
					break;
				case 5:
					return;
				default:
					System.out.println("Invalid selection.");
			}
		}
	}

}
