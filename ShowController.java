package com.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import com.models.*;

public class ShowController {
	

	private static HashMap<Movie, ArrayList<Show>> movieShowtime;

	
	public void createShow(Movie movie, String time, Cinema cinema)
	{
		Show show = new Show();
		show.setCinema(cinema);
		show.setMovie(movie);
		show.setTime(time);
	}
	
	public static void addShow(Show show)
	{
		
		movieShowtime.put(Mvie m, show); 
		System.out.println(showList);
	}
	
	public void updateShow(Show oshow, Show nshow)
	{
		showList.remove(oshow);
		showList.add(nshow);
	}
	
	public void deleteShow(Show show)
	{
		showList.remove(show);
	}
	
	public static void addmovieShow(Show show)
	{
		
		movieShowtime.put(show.getMovie(), showList); 
		System.out.println(showList);
	}
	
	

				
	
	

}
