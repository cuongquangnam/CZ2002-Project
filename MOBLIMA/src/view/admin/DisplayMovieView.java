package view.admin;

import controller.IOController;
import controller.MovieListingController;
import controller.ViewController;
import model.Movie;

import java.io.IOException;
import java.util.ArrayList;

import static controller.IOController.*;

public class DisplayMovieView extends ViewController {
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    private void displayMenu() throws IOException, ClassNotFoundException {
        ArrayList<Movie> movieList = MovieListingController.getAllMovie();
        printTitle("View movie details");
        listAllMovieMenu();
        System.out.println("Please enter the index number of the movie you want to view details\n" +
                "Enter 0 to go back");
        int choice = getChoice(0, movieList.size());
        if (choice == 0)
            return;
        else {
            System.out.println("Title: " + movieList.get(choice - 1).getMovieTitle());
            System.out.print("Showing Status: ");
            if(movieList.get(choice - 1).getShowingStatus() == 1)
                System.out.println("Coming Soon");
            else if(movieList.get(choice - 1).getShowingStatus() == 2)
                System.out.println("Preview");
            else if(movieList.get(choice - 1).getShowingStatus() == 3)
                System.out.println("Now Showing");
            else if(movieList.get(choice - 1).getShowingStatus() == 4)
                System.out.println("End of Showing");
            System.out.println("Director: " + movieList.get(choice - 1).getDirector());
            System.out.println("Synopsis: " + IOController.breakLines(movieList.get(choice - 1).getSypnosis(), 51, 10));
            System.out.println("Casts: " + movieList.get(choice - 1).getCast());
            System.out.println("Base Price: " + movieList.get(choice - 1).getBasePrice());
            System.out.println("Blockbuster: " + movieList.get(choice - 1).isBlockBuster());
        }
        getString("Press ENTER to continue");
        deleteView();
    }

    private void listAllMovieMenu(){
        ArrayList<Movie> movieList = MovieListingController.getAllMovie();
        if(movieList.size() == 0)
            System.out.println("There is no movie yet!");
        else {
            int i = 1;
            System.out.println("List of movies:");
            for (Movie m : movieList) {
                System.out.println(i + ". " + m.getMovieTitle() + "   (" + m.getStringShowingStatus() + ")");
                i++;
            }
        }
    }
}
