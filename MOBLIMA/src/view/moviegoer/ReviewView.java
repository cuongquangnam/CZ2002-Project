package view.moviegoer;

import controller.IOController;
import controller.ReviewController;
import controller.ViewController;
import model.Movie;
import model.Review;

import java.io.IOException;
import java.util.ArrayList;

public class ReviewView extends ViewController {
    private Movie movie;
    public ReviewView(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

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
                addReview();
                break;
            case 2:
                listReview();
                break;
            case 3:
                deleteView();
                break;
        }
        deleteView();
    }

    private void addReview() throws IOException, ClassNotFoundException {
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
        finally {
            initialize();
        }
    }

    /**
     * This method is to list all reviews of the movie.
     */
    private void listReview() throws IOException, ClassNotFoundException {
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
        initialize();
    }
}
