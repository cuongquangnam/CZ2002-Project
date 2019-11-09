package models;
import java.util.Date;


public class showTime {
	private Cinema cinema;
	private Date time;
	private Movie movie;
	
	public showTime(Cinema cinema, Date time, Movie movie) {
		this.cinema = cinema;
		this.time = time;
		this.setMovie(movie);
	}

	public Date getTime() {
		return time;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
}
