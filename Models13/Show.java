package com.models;

import java.io.Serializable;

public class Show implements Serializable {
	private String cineplex;
	private Movie movie;
	private String time;
	private Cinema cinema;
	
	public Show()
	{
		
	}
	
	
	public Show(String cineplex, Movie movie, String time, Cinema cinema) {
		super();
		this.cineplex = cineplex;
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
	public String getCineplex() {
		return cineplex;
	}


	public void setCineplex(String cineplex) {
		cineplex = cineplex;
	}
	
	@Override
	public String toString() {
		return "Show [Cineplex=" + cineplex + ", movie=" + movie + ", time=" + time + ", cinema=" + cinema + "]";
	}


	

}
