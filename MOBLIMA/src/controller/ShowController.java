package controller;

import model.Cinema;
import model.Movie;
import model.Show;

import java.io.IOException;
import java.util.*;

public class ShowController
{

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

    public static void updateSeatMap(Movie movie, int show_index, Show newShowTime) throws IOException
    {
        HashMap<Movie, ArrayList<Show>> movieShowList = FileReadWriteController.readShowTime();
        ArrayList <Show> s =movieShowList.get(movie);
        movieShowList.remove(movie, s);
        Show show = s.get(show_index);
        s.remove(show);
        s.add(show_index, newShowTime);
        movieShowList.put(movie, s);
        FileReadWriteController.writeMovieShowList(movieShowList);
    }

    public static void deleteShow(Movie movie, int show_index) throws IOException
    {
        HashMap<Movie, ArrayList<Show>> movieShowList = FileReadWriteController.readShowTime();
        ArrayList <Show> s =movieShowList.get(movie);
        movieShowList.remove(movie, s);
        s.remove(show_index);
        movieShowList.put(movie, s);
        FileReadWriteController.writeMovieShowList(movieShowList);
    }

    public static ArrayList<Cinema> getCinemaList(String cineplex, HashMap<String, ArrayList<Cinema>>cinemaList) {
        return cinemaList.get(cineplex);
    }
}
