package controller;

import model.Movie;
import model.Review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReviewController {
    private static HashMap<Movie, ArrayList<Review>> reviewList;

    static {
        try {
            reviewList = FileReadWriteController.readReviewList();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addNewReview(Movie movie, Review review) throws IOException {
        if(reviewList.get(movie) == null) reviewList.put(movie, new ArrayList<>());
        reviewList.get(movie).add(review);
        FileReadWriteController.writeReviewList(reviewList);
    }

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

    public static int getNumRating(Movie movie) {
        ArrayList<Review> reviewList = getReviewList(movie);
        if (reviewList == null || reviewList.isEmpty()) return 0;
        else {
            return reviewList.size();
        }
    }

    public static ArrayList<Review> getReviewList(Movie movie) {
        return reviewList.get(movie);
    }
}
