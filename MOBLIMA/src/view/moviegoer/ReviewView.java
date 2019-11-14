package view.moviegoer;

import controller.IOController;
import controller.ReviewController;
import controller.ViewController;
import model.Movie;
import model.Review;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class shows the menu of viewing movie review
 */
public class ReviewView extends ViewController {
    private Movie movie;

    /**
     * Allocates an {@code ReviewView} object and initializes it.
     * @param movie
     */
    public ReviewView(Movie movie) {
        this.movie = movie;
    }

    /**
     * {@inheritDoc}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    /**
     * This method shows the main menu of this view
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void displayMenu() throws IOException, ClassNotFoundException {
        IOController.printTitle("Review");
        if (movie.getShowingStatus() == 1) {
            System.out.println("Not allowed to comment on coming soon movies");
            System.out.println("Press ENTER to return");
            IOController.getString();
            deleteView();
        }
        System.out.println("1. Write a review");
        System.out.println("2. View all reviews");
        System.out.println("3. Go back");
        int choice = IOController.getChoice(1, 3);
        switch (choice) {
            case 1:
                addReviewMenu();
                break;
            case 2:
                listReviewMenu();
                break;
            case 3:
                deleteView();
                break;
        }
        deleteView();
    }

    /**
     * This method shows the add review menu
     */
    private void addReviewMenu() {
        IOController.printTitle("Write Review");
        String name = IOController.getString("Please enter your name:");
        System.out.println("Please enter your rating: (integer between 1 and 5)");
        int rating = IOController.getChoice(1, 5);
        String content = IOController.getString("Please enter your comments:");
        Review review = new Review(this.movie, rating, content, name);

        try {
            ReviewController.addNewReview(movie, review);
            System.out.println("Successfully created review for " + movie.getMovieTitle());
        }
        catch (IOException ex) {
            System.out.println("Failed to create review for " + movie.getMovieTitle());
        }
    }

    /**
     * This method is to list all reviews of the movie.
     */
    private void listReviewMenu() {
        IOController.printTitle("Reviews for " + movie.getMovieTitle());
        ArrayList<Review> reviewList = ReviewController.getReviewList(movie);

        if (reviewList != null){
            int index = 0;
            for (Review r : reviewList) {
                System.out.println(++index + " Name:     " + r.getName());
                System.out.println("  Date:     " + IOController.formatTimeMMddHHmm(r.getDate()));
                System.out.println("  Rating:   " + r.getRating());
                System.out.println("  Comments: " + IOController.breakLines(r.getContent(), 59, 12));
                System.out.println();
            }
        }
        else{
            System.out.println("Currently no review.");
        }
        IOController.getString("Press ENTER to go back.", "");
    }
}
