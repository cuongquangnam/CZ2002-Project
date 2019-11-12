package com.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.models.Cinema;
//import com.models.Cineplex;
import com.models.Movie;
import com.models.Show;

public class FileReadWriteController {
	
	
	static String FILENAME_CINEMA = "/Users/ritwikkanodia/eclipse-workspace/M1/src/DataFolder/Cinema.dat";
	static String FILENAME_MOVIE = "/Users/ritwikkanodia/eclipse-workspace/M1/src/DataFolder/Cinema.dat";
	static String FILENAME_SHOWTIME = "/Users/ritwikkanodia/eclipse-workspace/M1/src/DataFolder/movieShowTime.dat";
	
	
	
	
	static ArrayList <Movie> movieList = new ArrayList <Movie>();
    static HashMap<String, ArrayList<Cinema>> cinemaList = new HashMap<String, ArrayList<Cinema>>();
    static  ArrayList<Show> movieShowtime = new  ArrayList<Show>();
	
	
    
    
    
    
    //Read MOVIELIST
    @SuppressWarnings("unchecked")
	public static ArrayList <Movie> readMovieList() throws IOException, ClassNotFoundException {
        if (DataManager.readSerializedObject(FILENAME_MOVIE) == null) movieList = new ArrayList<>();
        else {
            movieList = (ArrayList<Movie>)DataManager.readSerializedObject(FILENAME_MOVIE);
            // sort listing by movie status
            //Collections.sort(movieListing, Comparator.comparing(o -> o.getMovieStatus().toString()));
        }
        return movieList;
    }
    
    
    
	
	//Read CINEMALIST
	@SuppressWarnings("unchecked")
	public static HashMap<String, ArrayList<Cinema>> readCinemaList() throws IOException, ClassNotFoundException {
        if (DataManager.readSerializedObject(FILENAME_CINEMA) == null) cinemaList = new HashMap<>();
        else {
            cinemaList = (HashMap<String, ArrayList<Cinema>>)DataManager.readSerializedObject(FILENAME_CINEMA);
            // sort listing by movie status
            //Collections.sort(movieListing, Comparator.comparing(o -> o.getMovieStatus().toString()));
            
        }
        return cinemaList;
    }
	
	
	
	
	//Read SHOWLIST
	@SuppressWarnings("unchecked")
	public static ArrayList<Show> readShowTime() throws IOException, ClassNotFoundException {
        if (DataManager.readSerializedObject(FILENAME_SHOWTIME) == null) movieShowtime = new ArrayList<>();
        else {
        	movieShowtime = (ArrayList<Show>)DataManager.readSerializedObject(FILENAME_SHOWTIME);
            // sort listing by movie status
            //Collections.sort(movieListing, Comparator.comparing(o -> o.getMovieStatus().toString()));
        }
        return movieShowtime;
    }
	
	public static void writeMovieList(ArrayList <Movie> movieList) throws IOException
	{
		DataManager.writeSerializedObject(FILENAME_MOVIE, movieList);
	}
	
	public static void writeCinemaList(HashMap<String, ArrayList<Cinema>> cinemaList) throws IOException
	{
		DataManager.writeSerializedObject(FILENAME_CINEMA, cinemaList);
	}
	
	public static void writeMovieShowList(HashMap<Movie, ArrayList<Show>> movieShowTime) throws IOException
	{
		DataManager.writeSerializedObject(FILENAME_SHOWTIME, movieShowTime);
	}
	
	

	
	

}
