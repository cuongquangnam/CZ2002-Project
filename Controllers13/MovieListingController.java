package com.controllers;
import com.models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;




public class MovieListingController {
	static	ArrayList <Movie> movieList = new ArrayList <Movie>(); 
	static	HashMap<Movie, ArrayList <Show>> movieShowList = new HashMap<Movie, ArrayList <Show>>(); 
	static Scanner sc = new Scanner(System.in);
	
	
	public static Movie search(ArrayList<Movie> movieList, String movieTitle)
	{
		for(Movie m : movieList)
		{
			if(m.getMovieTitle().equalsIgnoreCase(movieTitle))
				return m;
		}
		return  null;
	}
	

	public static void addMovie(Movie m) throws IOException
	{
		
		movieList.add(m);
		movieShowList.put(m, new ArrayList<Show>());
		FileReadWriteController.writeMovieList(movieList);
		FileReadWriteController.writeMovieShowList(movieShowList);
		
		System.out.println(movieList);
		
	}
	
	public static void updateMovieTitle(String omovieTitle,String nmovieTitle)
	{
		Movie m = search(movieList, omovieTitle);
		
		movieList.remove(m);
		m.setMovieTitle(nmovieTitle);
		movieList.add(m);
		System.out.println(movieList);
	}
	
	public static void updateShowingStatus(String omovieTitle, int nshowingStatus)
	{
		Movie m = search(movieList, omovieTitle);
		
		movieList.remove(m);
		m.setShowingStatus(nshowingStatus);
		movieList.add(m);
		System.out.println(movieList);
	}
	
	public static void updateSypnosis(String omovieTitle, String nsypnosis)
	{
		Movie m = search(movieList, omovieTitle);
		
		movieList.remove(m);
		m.setSypnosis(nsypnosis);
		movieList.add(m);
		System.out.println(movieList);
	}
	
	
	public static void updateDirector(String omovieTitle, String ndirector)
	{
		Movie m = search(movieList, omovieTitle);
		
		movieList.remove(m);
		m.setDirector(ndirector);
		movieList.add(m);
		System.out.println(movieList);
	}
	
	
	public static void updateCast(String omovieTitle, ArrayList <String> ncast)
	{
		Movie m = search(movieList, omovieTitle);
		
		movieList.remove(m);
		m.setCast(ncast);
		movieList.add(m);
		System.out.println(movieList);
	}
	
	public static void updateIsBlockbuster(String omovieTitle, boolean nisBlockbuster)
	{
		Movie m = search(movieList, omovieTitle);
		
		movieList.remove(m);
		m.setBlockBuster(nisBlockbuster);
		movieList.add(m);
		System.out.println(movieList);
	}
	
	public static void deleteMovie(String movieTitle)
	{
		Movie m = search(movieList, movieTitle);
		movieList.remove(m);
		System.out.println(movieList);
		
	}
	
	public static void createMovie(String movieTitle, int showingStatus, String sypnosis, String director, ArrayList <String> cast, double basePrice) throws IOException  
	{
		Movie m = new Movie();
		m.setMovieTitle(movieTitle);
		m.setBasePrice(basePrice);
		m.setCast(cast);
		m.setDirector(director);
		m.setShowingStatus(showingStatus);
		m.setSypnosis(sypnosis);
	
		addMovie(m);
	}
	
	
	
	
	


}

