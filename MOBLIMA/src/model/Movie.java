package model;


import java.io.Serializable;
import java.util.*;
public class Movie implements Serializable {
	private String movieTitle;
	private int showingStatus;
	private String sypnosis;
	private String director;
	private ArrayList <String> cast;
	private double basePrice;
	private boolean isBlockBuster;
	
	public Movie() { }
	
	public double getBasePrice() {
		return this.basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	//Getter and Setter Methods
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public int getShowingStatus() {
		return showingStatus;
	}
	public void setShowingStatus(int showingStatus) {
		this.showingStatus = showingStatus;
	}
	public String getSypnosis() {
		return sypnosis;
	}
	public void setSypnosis(String sypnosis) {
		this.sypnosis = sypnosis;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public ArrayList<String> getCast() {
		return cast;
	}
	public void setCast(ArrayList<String> cast) {
		this.cast = cast;
	}
	public boolean isBlockBuster() {
		return isBlockBuster;
	}
	public void setBlockBuster(boolean isBlockBuster) {
		this.isBlockBuster = isBlockBuster;
	}
	public String getStringShowingStatus() {
		if (showingStatus == 1)
			return "Coming Soon";
		else if (showingStatus == 2)
			return "Preview";
		else if (showingStatus == 3)
			return "Now Showing";
		else if (showingStatus == 4)
			return "End of Showing";
		return null;
	}

	
	
	
	//equals and hash code
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cast == null) ? 0 : cast.hashCode());
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((movieTitle == null) ? 0 : movieTitle.hashCode());
		
		result = prime * result + ((sypnosis == null) ? 0 : sypnosis.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (cast == null) {
			if (other.cast != null)
				return false;
		} else if (!cast.equals(other.cast))
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (movieTitle == null) {
			if (other.movieTitle != null)
				return false;
		} else if (!movieTitle.equals(other.movieTitle))
			return false;
		
		if (sypnosis == null) {
			if (other.sypnosis != null)
				return false;
		} else if (!sypnosis.equals(other.sypnosis))
			return false;
		return true;
	}
	
	//to string
	@Override
	public String toString() {
		return "Title: " + movieTitle + "\nShowing Status: " + this.getStringShowingStatus() + "\nDirector: " + director +
				"\nSypnosis: " + sypnosis +"\nCast: " + cast + "\nBlockbuster: " + isBlockBuster + "\n";
	}
	
	
	
}


