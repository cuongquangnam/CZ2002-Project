package controller;

import model.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class handles the movie listing
 */
public class MovieListingController{
	/**
	 * List of movies
	 */
	private static ArrayList <Movie> movieList;

	static {
		try {
			movieList = FileReadWriteController.readMovieList();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method searchs for a movie in the list using the title
	 * @param movieList The list of movies
	 * @param movieTitle The title of movie that need to be searched for
	 * @return The requested movie
	 */
	public static Movie search(ArrayList<Movie> movieList, String movieTitle)
	{
		for(Movie m : movieList)
		{
			if(m.getMovieTitle().equalsIgnoreCase(movieTitle))
				return m;
		}
		return  null;
	}


	/**
	 * This method updates the movie title of movie
	 * @param omovieTitle	Old title of movie
	 * @param nmovieTitle	New title of movie
	 */
	public static void updateMovieTitle(String omovieTitle,String nmovieTitle)
	{
		Movie m = search(movieList, omovieTitle);

		int index = movieList.indexOf(m);
		movieList.remove(m);
		m.setMovieTitle(nmovieTitle);
		movieList.add(m);
		movieList.add(index, m);

		try {
			FileReadWriteController.writeMovieList(movieList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method updates the showing status of movie
	 * @param omovieTitle Title of movie
	 * @param nshowingStatus New showing status
	 */
	public static void updateShowingStatus(String omovieTitle, int nshowingStatus)
	{
		Movie m = search(movieList, omovieTitle);

		int index = movieList.indexOf(m);
		movieList.remove(m);
		m.setShowingStatus(nshowingStatus);
		movieList.add(index, m);

		try {
			FileReadWriteController.writeMovieList(movieList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method updates the synopsis of movie
	 * @param omovieTitle Title of movie
	 * @param nsypnosis New synopsis of movie
	 */
	public static void updateSypnosis(String omovieTitle, String nsypnosis)
	{
		Movie m = search(movieList, omovieTitle);

		int index = movieList.indexOf(m);
		movieList.remove(m);
		m.setSypnosis(nsypnosis);
		movieList.add(index, m);

		try {
			FileReadWriteController.writeMovieList(movieList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * This method updates the director of movie
	 * @param omovieTitle Title of movie
	 * @param ndirector New director of movie
	 */
	public static void updateDirector(String omovieTitle, String ndirector)
	{
		Movie m = search(movieList, omovieTitle);

		int index = movieList.indexOf(m);
		movieList.remove(m);
		m.setDirector(ndirector);
		movieList.add(index, m);

		try {
			FileReadWriteController.writeMovieList(movieList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method updates the cast of the movie
	 * @param omovieTitle Title of movie
	 * @param ncast New cast of movie
	 */
	public static void updateCast(String omovieTitle, ArrayList <String> ncast)
	{
		Movie m = search(movieList, omovieTitle);

		int index = movieList.indexOf(m);
		movieList.remove(m);
		m.setCast(ncast);
		movieList.add(index, m);

		try {
			FileReadWriteController.writeMovieList(movieList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method updates whether movie is blockbuster or not
	 * @param omovieTitle Title of movie
	 * @param nisBlockbuster New setting whether movie is blockbuster or not
	 */
	public static void updateIsBlockbuster(String omovieTitle, boolean nisBlockbuster)
	{
		Movie m = search(movieList, omovieTitle);

		int index = movieList.indexOf(m);
		movieList.remove(m);
		m.setBlockBuster(nisBlockbuster);
		movieList.add(index, m);

		try {
			FileReadWriteController.writeMovieList(movieList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method updates the base price of movie
	 * @param omovieTitle Title of movie
	 * @param nBasePrice New base price of movie
	 */
	public static void updateBasePrice(String omovieTitle, double nBasePrice)
	{
		Movie m = search(movieList, omovieTitle);

		int index = movieList.indexOf(m);
		movieList.remove(m);
		m.setBasePrice(nBasePrice);
		movieList.add(index, m);

		try {
			FileReadWriteController.writeMovieList(movieList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method deletes movie from the list and write back to file
	 * @param movieTitle The title of selected movie
	 */
	public static void deleteMovie(String movieTitle)
	{

		Movie m = search(movieList, movieTitle);

		movieList.remove(m);
		m.setShowingStatus(4);
		movieList.add(m);

		try {
			FileReadWriteController.writeMovieList(movieList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method creates new movie
	 * @param movieTitle Movie Title
	 * @param showingStatus Showing Status of movie
	 * @param sypnosis Synopsis of movie
	 * @param director Director of movie
	 * @param cast The cast of the movie
	 * @param basePrice Base price of the movie
	 * @param isBlockBuster Whether the movie is blockbuster or not
	 * @throws IOException
	 */
	public static void createNewMovie(String movieTitle, int showingStatus, String sypnosis, String director, ArrayList<String> cast, double basePrice, boolean isBlockBuster) throws IOException{
		Movie m = new Movie();
		m.setMovieTitle(movieTitle);
		m.setShowingStatus(showingStatus);
		m.setSypnosis(sypnosis);
		m.setDirector(director);
		m.setCast(cast);
		m.setBasePrice(basePrice);
		m.setBlockBuster(isBlockBuster);
		movieList.add(m);
		FileReadWriteController.writeMovieList(movieList);
	}

	/**
	 * This method finds the movie by a string in title
	 * @param title The string in title
	 * @return The list of movies that have the string in their title
	 */
	public static ArrayList<Movie> getMovieByTitle(String title){
		ArrayList<Movie> searchResult = new ArrayList<>();
		for (Movie movie: movieList) {
			if (!title.equals("") && movie.getMovieTitle().toUpperCase().contains(title.toUpperCase()))
				searchResult.add(movie);
		}
		return searchResult;
	}

	/**
	 * This method updates the sales of a movie with each ticket sold
	 * @param movie The movie to be updated
	 * @param ticket The number of tickets sold
	 */
	public static void updateSales(Movie movie, int ticket) {
		Movie m = search(movieList, movie.getMovieTitle());

		int index = movieList.indexOf(m);
		movieList.remove(m);
		int sales = m.getSales() + ticket;
		m.setSales(sales);
		movieList.add(index, m);

		try {
			FileReadWriteController.writeMovieList(movieList);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method returns all movie object in the file
	 * @return The list of movie in file
	 */
	public static ArrayList<Movie> getAllMovie(){
		try {
			movieList = FileReadWriteController.readMovieList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Collections.sort(movieList, Comparator.comparingInt(Movie::getShowingStatus));
		return movieList;
	}

	/**
	 * This method returns the list of movie ordered by overall rating or sales in decreasing order
	 * @param orderBy The way to ordered the movies
	 * @return The list of ordered movies
	 */
	public static ArrayList<Movie> getTop5MovieListing(String orderBy){
		ArrayList<Movie> top5 = new ArrayList<>();
		ArrayList<Movie> movieListing = getAllMovie();
		for (Movie movie : movieListing) {
			if (movie.getShowingStatus() != 4)
				top5.add(movie);
		}

		if (orderBy.equals("Rating")) {  // order by overall ratings
			Collections.sort(top5, (o1, o2) -> Double.compare(ReviewController.getMovieRating(o2), ReviewController.getMovieRating(o1)));
		}
		else if(orderBy.equals("Sales")){  // order by ticket sales
			Collections.sort(top5, (o1, o2) -> Integer.compare(o2.getSales(), o1.getSales()));
		}

		while (top5.size() > 5) {
			top5.remove(5);
		}

		return top5;
	}
}
