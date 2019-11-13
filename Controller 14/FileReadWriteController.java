package controller;

import model.Cinema;
import model.Movie;
import model.Review;
import model.Show;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;



public class FileReadWriteController {


    static String FILENAME_CINEMA = "src/data/cinemaList.dat";
    static String FILENAME_SHOWTIME = "src/data/movieShowTime.dat";
    static String FILENAME_MOVIE = "src/data/movieListing.dat";
    static String FILENAME_REVIEWLIST = "src/data/reviewListing.dat";




    static ArrayList <Movie> movieList = new ArrayList <Movie>();
    static HashMap<String, ArrayList<Cinema>> cinemaList = new HashMap<String, ArrayList<Cinema>>();
    static ArrayList<Show> movieShowtime = new  ArrayList<Show>();
    static HashMap<Movie, ArrayList<Review>> reviewList = new HashMap<Movie, ArrayList<Review>>();






    //Read MOVIELIST
    @SuppressWarnings("unchecked")
    public static ArrayList <Movie> readMovieList() throws IOException, ClassNotFoundException{
        if (DataController.readSerializedObject(FILENAME_MOVIE) == null) movieList = new ArrayList<>();
        else {
            movieList = (ArrayList<Movie>)DataController.readSerializedObject(FILENAME_MOVIE);
            // sort listing by movie status
            //Collections.sort(movieListing, Comparator.comparing(o -> o.getMovieStatus().toString()));
        }
        return movieList;
    }




    //Read CINEMALIST
    @SuppressWarnings("unchecked")
    public static HashMap<String, ArrayList<Cinema>> readCinemaList() throws IOException{
        if (DataController.readSerializedObject(FILENAME_CINEMA) == null) cinemaList = new HashMap<>();
        else {
            cinemaList = (HashMap<String, ArrayList<Cinema>>)DataController.readSerializedObject(FILENAME_CINEMA);
            // sort listing by movie status
            //Collections.sort(movieListing, Comparator.comparing(o -> o.getMovieStatus().toString()));

        }
        return cinemaList;
    }




    //Read SHOWLIST
    @SuppressWarnings("unchecked")
    public static ArrayList<Show> readShowTime() throws IOException{
        if (DataController.readSerializedObject(FILENAME_SHOWTIME) == null) movieShowtime = new ArrayList<>();
        else {
            movieShowtime = (ArrayList<Show>)DataController.readSerializedObject(FILENAME_SHOWTIME);
            // sort listing by movie status
            //Collections.sort(movieListing, Comparator.comparing(o -> o.getMovieStatus().toString()));
        }
        return movieShowtime;
    }

    public static HashMap<Movie, ArrayList<Review>> readReviewList() throws IOException, ClassNotFoundException {
        if (DataController.readSerializedObject(FILENAME_REVIEWLIST) == null) reviewList = new HashMap<>();
        else
            reviewList =  (HashMap<Movie, ArrayList<Review>>) DataController.readSerializedObject(FILENAME_REVIEWLIST);
        return reviewList;
    }



    public static void writeMovieList(ArrayList <Movie> movieList) throws IOException
    {
        DataController.writeSerializedObject(FILENAME_MOVIE, movieList);
    }

    public static void writeCinemaList(HashMap<String, ArrayList<Cinema>> cinemaList) throws IOException
    {
        DataController.writeSerializedObject(FILENAME_CINEMA, cinemaList);
    }

    public static void writeMovieShowList(HashMap<Movie, ArrayList<Show>> movieShowTime) throws IOException
    {
        DataController.writeSerializedObject(FILENAME_SHOWTIME, movieShowTime);
    }

    public static void writeReviewList(HashMap<Movie, ArrayList<Review>> reviewList) throws IOException {
        DataController.writeSerializedObject(FILENAME_REVIEWLIST, reviewList);
    }





}
