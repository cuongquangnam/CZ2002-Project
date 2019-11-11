package com.models;

public class Show {
	private Movie movie;
	private String time;
	private Cinema cinema;
	
	public Show()
	{
		
	}
	
	
	public Show(Movie movie, String time, Cinema cinema) {
		super();
		this.movie = movie;
		this.time = time;
		this.cinema = cinema;
	}
	
	
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Cinema getCinema() {
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	

}
