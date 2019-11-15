package model;

import controller.FileReadWriteController;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * This class contains all information of a review - including the
 * review's date, rating, review's content, reviewed {@code Movie} and name of reviewer
 */
public class Review implements Serializable {

    /**
     * The hashmap with Movie objects as keys and list of reviews as values
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
     * Date of review
     */
    private final Date date;
    /**
     * Rating given
     */
    private final int rating;
    /**
     * The content of the review
     */
    private final String content;
    /**
     * The reviewed movie
     */
    private final Movie movie;
    /**
     * Name of reviewer
     */
    private final String name;

    /**
     * The maximum rating the reviewer can give
     */
    private static final int maxRating = 5;

    /**
     * The minimum rating the reviewer can give
     */
    private static final int minRating = 1;

    /**
     * Allocates a {@code Review} object and initializes it. The object is specified by the Movie being
     * reviewed, rating, review content and name of the reviewer.
     * @param movie The reviewed movie
     * @param rating The rating reviewer gives
     * @param content The content of the review
     * @param name The name of reviewer
     */
    public Review(Movie movie, int rating, String content, String name) {
        if(rating > maxRating) this.rating = maxRating;
        else if (rating < minRating) this.rating = minRating;
        else this.rating = rating;

        this.date = new Date();
        this.content = content;
        this.movie = movie;
        this.name = name;
    }

    /**
     * This method is to get the {@code Movie} reviewed.
     * @return The reviewed movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * This method is to get the content of the review.
     * @return The content of the review
     */
    public String getContent() {
        return content;
    }

    /**
     * This method is to get the rating reviewer gives.
     * @return The given rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * This method is to get the reviewer's name.
     * @return Name of reviewer
     */
    public String getName() { return name; }

    /**
     * This method is to get the time when the review is made.
     * @return The time when the review is made
     */
    public Date  getDate() { return date; }
}

