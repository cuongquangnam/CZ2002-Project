package controller;

import model.Movie;
import model.Review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class handles all the write/view movie review
 */
public class ReviewController {
    /**
     * The hashmap with movie as key and list of review as value
     */
    private static HashMap<Movie, ArrayList<Review>> reviewList;

    static {
        try {
            reviewList = FileReadWriteController.readReviewList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method adds new review to file
     * @param movie The reviewed movie
     * @param review The review
     * @throws IOException
     */
    public static void addNewReview(Movie movie, Review review) throws IOException {
        if(reviewList.get(movie) == null) reviewList.put(movie, new ArrayList<>());
        reviewList.get(movie).add(review);
        FileReadWriteController.writeReviewList(reviewList);
    }

    /**
     * This method return the movie rating
     * @param movie The movie
     * @return The rating of the movie
     */
    public static double getMovieRating(Movie movie) {
        ArrayList<Review> reviewList = getReviewList(movie);
        if (reviewList == null || reviewList.isEmpty()) return 0;
        else {
            double sum = 0;
            for (Review review : reviewList)
                sum += review.getRating();
            return IOController.round(sum / reviewList.size(), 1);
        }
    }

    /**
     * This method returns the number of reviews of a movie
     * @param movie The movie
     * @return Number of reviews of the movie
     */
    public static int getNumRating(Movie movie) {
        ArrayList<Review> reviewList = getReviewList(movie);
        if (reviewList == null || reviewList.isEmpty()) return 0;
        else {
            return reviewList.size();
        }
    }

    /**
     * This method returns the review list of a movie
     * @param movie The movie
     * @return The list of reviews of the movie
     */
    public static ArrayList<Review> getReviewList(Movie movie) {
        return reviewList.get(movie);
    }
}
