package controller;

import model.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MovieListingController{
	private static ArrayList <Movie> movieList;

	static {
		try {
			movieList = FileReadWriteController.readMovieList();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Movie search(ArrayList<Movie> movieList, String movieTitle)
	{
		for(Movie m : movieList)
		{
			if(m.getMovieTitle().equalsIgnoreCase(movieTitle))
				return m;
		}
		return  null;
	}



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
	public static ArrayList<Movie> getMovieByTitle(String title){
		ArrayList<Movie> searchResult = new ArrayList<>();
		for (Movie movie: movieList) {
			if (!title.equals("") && movie.getMovieTitle().toUpperCase().contains(title.toUpperCase()))
				searchResult.add(movie);
		}
		return searchResult;
	}
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

	//Return all movie object in the file
	public static ArrayList<Movie> getAllMovie(){
		try {
			movieList = FileReadWriteController.readMovieList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Collections.sort(movieList, Comparator.comparingInt(Movie::getShowingStatus));
		return movieList;
	}

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
