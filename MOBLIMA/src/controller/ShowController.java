package controller;

import model.Cinema;
import model.Movie;
import model.Show;

import java.io.IOException;
import java.util.*;

/**
 * This class contains static methods to handle show of movie
 */
public class ShowController
{

    /**
     * This method is used to create a new show
     * @param dateTime Time of show
     * @param cinema Cinema of show
     * @param movie Movie of show
     * @param cineplex Cineplex of show
     * @throws IOException
     */
    public static void createShow(Date dateTime, Cinema cinema, Movie movie, String cineplex) throws IOException
    {
        HashMap<Movie, ArrayList<Show>> movieShowList = FileReadWriteController.readShowTime();
        ArrayList <Show> s = new ArrayList<Show>();

        Show show  = new Show(cineplex, movie, dateTime, cinema);
        if(movieShowList.get(movie) != null) {
            s = movieShowList.get(movie);
            movieShowList.remove(movie);
        }
        s.add(show);
        movieShowList.put(movie, s);
        FileReadWriteController.writeMovieShowList(movieShowList);
    }

    /**
     * This method is used to update time of show
     * @param movie Movie of show
     * @param show_index Index in list of show
     * @param time Time of show
     * @throws IOException
     */
    public static void updateShowDateTime(Movie movie, int show_index, Date time) throws IOException
    {
        HashMap<Movie, ArrayList<Show>> movieShowList = FileReadWriteController.readShowTime();
        ArrayList <Show> s =movieShowList.get(movie);
        movieShowList.remove(movie, s);
        Show show = s.get(show_index);
        s.remove(show_index);
        show.setTime(time);
        s.add(show_index, show);
        movieShowList.put(movie, s);
        FileReadWriteController.writeMovieShowList(movieShowList);

    }

    /**
     * This method updates the cinema and cineplex of show
     * @param movie Movie of show
     * @param show_index Index in list of show
     * @param cinema Cinema of show
     * @throws IOException
     */
    public static void updateShowCinema(Movie movie, int show_index, Cinema cinema) throws IOException
    {
        HashMap<Movie, ArrayList<Show>> movieShowList = FileReadWriteController.readShowTime();
        ArrayList <Show> s =movieShowList.get(movie);
        movieShowList.remove(movie, s);
        Show show = s.get(show_index);
        s.remove(show_index);
        show.setCinema(cinema);
        show.setCineplex(cinema.getCineplex());
        s.add(show_index, show);
        movieShowList.put(movie, s);
        FileReadWriteController.writeMovieShowList(movieShowList);

    }

    /**
     * This method updates the seat map of show
     * @param movie Movie of show
     * @param show_index Index in list of the old show
     * @param newShowTime The show which updated seat map
     * @throws IOException
     */
    public static void updateSeatMap(Movie movie, int show_index, Show newShowTime) throws IOException
    {
        HashMap<Movie, ArrayList<Show>> movieShowList = FileReadWriteController.readShowTime();
        ArrayList <Show> s = movieShowList.get(movie);
        movieShowList.remove(movie, s);
        Show show = s.get(show_index);
        s.remove(show);
        s.add(show_index, newShowTime);
        movieShowList.put(movie, s);
        FileReadWriteController.writeMovieShowList(movieShowList);
    }

    /**
     * This method deletes the selected show
     * @param movie The movie the show belongs to
     * @param show_index The index of the show in the list
     * @throws IOException
     */
    public static void deleteShow(Movie movie, int show_index) throws IOException
    {
        HashMap<Movie, ArrayList<Show>> movieShowList = FileReadWriteController.readShowTime();
        ArrayList <Show> s =movieShowList.get(movie);
        movieShowList.remove(movie, s);
        s.remove(show_index);
        movieShowList.put(movie, s);
        FileReadWriteController.writeMovieShowList(movieShowList);
    }

    /**
     * This method returns all the Cinema in the same Cineplex
     * @param cineplex The cineplex
     * @param cinemaList The list of cinema
     * @return List of all cinemas in the cineplex
     */
    public static ArrayList<Cinema> getCinemaList(String cineplex, HashMap<String, ArrayList<Cinema>>cinemaList) {
        return cinemaList.get(cineplex);
    }
}
