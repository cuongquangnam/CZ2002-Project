package controller;
import model.*;

import java.io.IOException;
import java.util.*;
public class MovieListingController extends DataController{
	private static final String FILENAME_MOVIE = "src/data/movieListing.dat";
	private static ArrayList <Movie> movieList;

	public static void addMovie(Movie m)
	{
		movieList.add(m);
	}

	public static void updateMovie(Movie old, Movie newm)
	{
		movieList.remove(old);
		movieList.add(newm);
	}

	public static void deleteMovie(Movie m)
	{
		movieList.remove(m);
	}

	//Save all movies object into movieList
	private static void readMovieList() throws IOException, ClassNotFoundException {
		if (readSerializedObject(FILENAME_MOVIE) == null) movieList = new ArrayList<>();
		else {
			movieList = (ArrayList<Movie>) readSerializedObject(FILENAME_MOVIE);
		}
	}
	
	public static void createNewMovie(String movieTitle, int showingStatus, String sypnosis, String director, ArrayList<String> cast, double basePrice, boolean isBlockBuster) throws IOException, ClassNotFoundException {
		Movie m = new Movie();
		m.setMovieTitle(movieTitle);
		m.setShowingStatus(showingStatus);
		m.setSypnosis(sypnosis);
		m.setDirector(director);
		m.setCast(cast);
		m.setBasePrice(basePrice);
		m.setBlockBuster(isBlockBuster);
		readMovieList();
		addMovie(m);
		writeSerializedObject(FILENAME_MOVIE, movieList);
	}

	//Return all movie object in the file
	public static ArrayList<Movie> listAllMovie() throws IOException, ClassNotFoundException {
		readMovieList();
		return movieList;
	}

	//If choice ==1; addMovie()
	//If choice ==2; updateMovie()
	//If choice ==3; deleteMovie()
	

}
