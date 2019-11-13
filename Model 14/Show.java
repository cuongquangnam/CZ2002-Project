package com.models;

import java.io.Serializable;
import java.util.Date;

public class Show implements Serializable {
	private String cineplex;
	private Movie movie;
	private Date dateTime;
	private Cinema cinema;
	
	public Show()
	{
		
	}
	
	
	public Show(String cineplex, Movie movie, Date dateTime, Cinema cinema) {
		super();
		this.cineplex = cineplex;
		this.movie = movie;
		this.dateTime = dateTime;
		this.cinema = cinema;
	}
	
	
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Date getTime() {
		return dateTime;
	}
	public void setTime(Date time) {
		this.dateTime = time;
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
		return "Show [Cineplex=" + cineplex + ", movie=" + movie + ", time=" + dateTime + ", cinema=" + cinema + "]";
	}


	

}
