package com.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.models.Cinema;
import com.models.Movie;
import com.models.Show;

public class ShowController
{
	
	
	
	
	//static HashMap<String, ArrayList<Cinema>> cinemaList = FileReadWriteController.readCinemaList();
	
	





static HashMap<String, ArrayList <Cinema>> cinemaList =new HashMap<String, ArrayList <Cinema>>() ;
	
	public static void createCinemaList() throws IOException
	{
		Cinema cinemaA_1 = new Cinema("Cineplex A", true, true);
		Cinema cinemaA_2 = new Cinema("Cineplex A", true, true);
		Cinema cinemaA_3 = new Cinema("Cineplex A", true, true);
		Cinema cinemaB_1 = new Cinema("Cineplex B", true, true);
		Cinema cinemaB_2 = new Cinema("Cineplex B", true, true);
		Cinema cinemaB_3 = new Cinema("Cineplex B", true, true);
		Cinema cinemaC_1 = new Cinema("Cineplex C", true, true);
		Cinema cinemaC_2 = new Cinema("Cineplex C", true, true);
		Cinema cinemaC_3 = new Cinema("Cineplex C", true, true);
		
		ArrayList <Cinema> c1 = new ArrayList <Cinema>();
		c1.add(cinemaA_1);
		c1.add(cinemaA_2);
		c1.add(cinemaA_3);
		
		cinemaList.put("Cineplex A", c1);
		
		ArrayList <Cinema> c2 = new ArrayList <Cinema>();
		c2.add(cinemaB_1);
		c2.add(cinemaB_2);
		c2.add(cinemaB_3);
		
		cinemaList.put("Cineplex B", c2);
		
		ArrayList <Cinema> c3 = new ArrayList <Cinema>();
		c3.add(cinemaC_1);
		c3.add(cinemaC_2);
		c3.add(cinemaC_3);
		
		cinemaList.put("Cineplex C", c3);
		
		FileReadWriteController.writeCinemaList(cinemaList);
		
		
	}
	
	
	public static Cinema whichCinema (String cineplex_name, int cinema_name)
	{
		System.out.println("HI1");
		ArrayList<Cinema> c = cinemaList.get(cineplex_name);
		Cinema cin = c.get(cinema_name-1);
		System.out.println("HI2");
		return cin;
		
	}
	
	public static Movie whichMovie (String movieTitle) throws ClassNotFoundException, IOException
	{
		ArrayList <Movie> movieList = FileReadWriteController.readMovieList();
		System.out.println("HI3");
		for(Movie m: movieList)
		{
			if (m.getMovieTitle() == movieTitle)
				System.out.println("HI4");
				return m;
		}
		return null;
		
	}
	
	
	
	
	
	
	public static void createShow( String time, Cinema cinema, Movie movie, String cineplex) throws ClassNotFoundException, IOException
	{
		HashMap<Movie, ArrayList<Show>> movieShowList = FileReadWriteController.readShowTime();
		
		movieShowList.toString();
		System.out.println("HI6");
		Show show  = new Show(cineplex, movie, time, cinema);
		System.out.println(show);
		System.out.println("HI7");
		ArrayList <Show> s =movieShowList.get(movie);
		movieShowList.remove(movie);
		movieShowList.toString();
		s.add(show);
		movieShowList.put(movie, s);
		for (Movie name: movieShowList.keySet()){
            String key = name.toString();
            String value = movieShowList.get(name).toString();  
            System.out.println(key + " " + value);  
} 
		System.out.println("this is the movieShowList");
		
		
	}
	
//	public static void addShow(Movie movie, Show show)
//	{
//		System.out.println("HI");
////		Iterator hmIterator = movieShowList.entrySet().iterator(); 
////		while (hmIterator.hasNext())
////		{
////			Map.Entry mapElement = (Map.Entry)hmIterator.next();
////			if(mapElement.getKey() == movie)
////			{
////				((ArrayList<Show>) mapElement.getValue()).add(show);
////			}
////		}
//		ArrayList <Show> s = movieShowList.get(movie);
//		
//		movieShowList.remove(movie, s);
//		s.add(show);
//		movieShowList.put(movie, s);
//		System.out.println(movieShowList.toString());
//		System.out.println("HI");
//	}
//	
//	
	
	
	 public static ArrayList<Cinema> getCinemaList(String cineplex, HashMap<String, ArrayList<Cinema>>cinemaList) {
	        return cinemaList.get(cineplex);
	    }
	
	
	
	
    
	
	
}