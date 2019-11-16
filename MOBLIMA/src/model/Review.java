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
    private final Date DATE;
    /**
     * Rating given
     */
    private final int RATING;
    /**
     * The content of the review
     */
    private final String CONTENT;
    /**
     * The reviewed movie
     */
    private final Movie MOVIE;
    /**
     * Name of reviewer
     */
    private final String NAME;

    /**
     * The maximum rating the reviewer can give
     */
    private static final int MAXRATING = 5;

    /**
     * The minimum rating the reviewer can give
     */
    private static final int MINRATING = 1;

    /**
     * Allocates a {@code Review} object and initializes it. The object is specified by the Movie being
     * reviewed, rating, review content and NAME of the reviewer.
     * @param MOVIE The reviewed MOVIE
     * @param RATING The RATING reviewer gives
     * @param CONTENT The CONTENT of the review
     * @param NAME The NAME of reviewer
     */
    public Review(Movie MOVIE, int RATING, String CONTENT, String NAME) {
        if(RATING > MAXRATING) this.RATING = MAXRATING;
        else if (RATING < MINRATING) this.RATING = MINRATING;
        else this.RATING = RATING;

        this.DATE = new Date();
        this.CONTENT = CONTENT;
        this.MOVIE = MOVIE;
        this.NAME = NAME;
    }

    /**
     * This method is to get the {@code Movie} reviewed.
     * @return The reviewed MOVIE
     */
    public Movie getMovie() {
        return MOVIE;
    }

    /**
     * This method is to get the CONTENT of the review.
     * @return The CONTENT of the review
     */
    public String getContent() {
        return CONTENT;
    }

    /**
     * This method is to get the RATING reviewer gives.
     * @return The given RATING
     */
    public int getRating() {
        return RATING;
    }

    /**
     * This method is to get the reviewer's NAME.
     * @return Name of reviewer
     */
    public String getName() { return NAME; }

    /**
     * This method is to get the time when the review is made.
     * @return The time when the review is made
     */
    public Date  getDate() { return DATE; }
}

