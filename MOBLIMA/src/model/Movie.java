package model;


import controller.IOController;

import java.io.Serializable;
import java.util.*;

/**
 * This class contains all information on a movie
 */
public class Movie implements Serializable {
	/**
	 * Title of movie
	 */
	private String movieTitle;
	/**
	 * Showing status of movie
	 */
	private int showingStatus;
	/**
	 * Synopsis of movie
	 */
	private String sypnosis;
	/**
	 * Director of movie
	 */
	private String director;
	/**
	 * The cast of movie
	 */
	private ArrayList <String> cast;
	/**
	 * Base price of the movie
	 */
	private double basePrice;
	/**
	 * Whether movie is Blockbuster or not
	 */
	private boolean isBlockBuster;
	/**
	 * Sales of movie
	 */
	private int sales;

	/**
	 * Constructor
	 */
	public Movie() {
		this.sales = 0;
	}

	/**
	 * This method gets base price of movie
	 * @return Base price of movie
	 */
	public double getBasePrice() {
		return this.basePrice;
	}

	/**
	 * This method sets the base price of movie
	 * @param basePrice Base price of movie
	 */
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * This method gets the movie title
	 * @return Movie title
	 */
	public String getMovieTitle() {
		return movieTitle;
	}

	/**
	 * This method sets the movie title
	 * @param movieTitle Movie title
	 */
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	/**
	 * This method gets the showing status
	 * @return Showing status
	 */
	public int getShowingStatus() {
		return showingStatus;
	}

	/**
	 * This method sets the showing status
	 * @param showingStatus Showing status
	 */
	public void setShowingStatus(int showingStatus) {
		this.showingStatus = showingStatus;
	}

	/**
	 * This method gets the synopsis of movie
	 * @return Synopsis of movie
	 */
	public String getSypnosis() {
		return sypnosis;
	}

	/**
	 * This method sets the synopsis of movie
	 * @param sypnosis Synopsis of movie
	 */
	public void setSypnosis(String sypnosis) {
		this.sypnosis = sypnosis;
	}

	/**
	 * This method gets the director of movie
	 * @return Director of movie
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * This method sets the director of movie
	 * @param director Director of movie
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * This method gets the cast of movie
	 * @return The cast
	 */
	public ArrayList<String> getCast() {
		return cast;
	}

	/**
	 * This method sets the cast of movie
	 * @param cast Cast of movie
	 */
	public void setCast(ArrayList<String> cast) {
		this.cast = cast;
	}

	/**
	 * This method returns whether a movie is blockbuster or not
	 * @return true if movie is blockbuster, false otherwise
	 */
	public boolean isBlockBuster() {
		return isBlockBuster;
	}

	/**
	 * This method sets whether a movie is blockbuster or not
	 * @param isBlockBuster true if movie is blockbuster, false otherwise
	 */
	public void setBlockBuster(boolean isBlockBuster) {
		this.isBlockBuster = isBlockBuster;
	}

	/**
	 * This method gets the sales of movie
	 * @return Sales of movie
	 */
	public int getSales() {
		return sales;
	}

	/**
	 * This method sets the sales of movie
	 * @param sales Sales of movie
	 */
	public void setSales(int sales) {
		this.sales = sales;
	}

	/**
	 * This method returns the string defined Showing status
	 * @return Showing status string
	 */
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
				"\nSynopsis: " + IOController.breakLines(sypnosis, 59,  10) +"\nCast: " + cast + "\nBlockbuster: " + isBlockBuster + "\n";
	}
	
	
	
}


