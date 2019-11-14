package controller;
import model.*;

import java.io.IOException;
import java.util.*;

import static controller.FileReadWriteController.readMovieList;

public class MovieListingController extends DataController{
	private static ArrayList <Movie> movieList;

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

		try {
			movieList = readMovieList();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		movieList.remove(m);
		m.setMovieTitle(nmovieTitle);
		movieList.add(m);

		try {
			FileReadWriteController.writeMovieList(movieList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void updateShowingStatus(String omovieTitle, int nshowingStatus)
	{
		Movie m = search(movieList, omovieTitle);

		try {
			movieList = readMovieList();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		movieList.remove(m);
		m.setShowingStatus(nshowingStatus);
		movieList.add(m);

		try {
			FileReadWriteController.writeMovieList(movieList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void updateSypnosis(String omovieTitle, String nsypnosis)
	{
		Movie m = search(movieList, omovieTitle);

		try {
			movieList = readMovieList();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		movieList.remove(m);
		m.setSypnosis(nsypnosis);
		movieList.add(m);

		try {
			FileReadWriteController.writeMovieList(movieList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void updateDirector(String omovieTitle, String ndirector)
	{
		Movie m = search(movieList, omovieTitle);

		try {
			movieList = readMovieList();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		movieList.remove(m);
		m.setDirector(ndirector);
		movieList.add(m);

		try {
			FileReadWriteController.writeMovieList(movieList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void updateCast(String omovieTitle, ArrayList <String> ncast)
	{
		Movie m = search(movieList, omovieTitle);

		try {
			movieList = readMovieList();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		movieList.remove(m);
		m.setCast(ncast);
		movieList.add(m);

		try {
			FileReadWriteController.writeMovieList(movieList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void updateIsBlockbuster(String omovieTitle, boolean nisBlockbuster)
	{
		Movie m = search(movieList, omovieTitle);

		try {
			movieList = readMovieList();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		movieList.remove(m);
		m.setBlockBuster(nisBlockbuster);
		movieList.add(m);

		try {
			FileReadWriteController.writeMovieList(movieList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void deleteMovie(String movieTitle)
	{
		try {
			movieList = readMovieList();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Movie m = search(movieList, movieTitle);
		m.setShowingStatus(4);

		try {
			FileReadWriteController.writeMovieList(movieList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void createNewMovie(String movieTitle, int showingStatus, String sypnosis, String director, ArrayList<String> cast, double basePrice, boolean isBlockBuster) throws IOException, ClassNotFoundException {
		Movie m = new Movie();
		m.setMovieTitle(movieTitle);
		m.setShowingStatus(showingStatus);
		m.setSypnosis(sypnosis);
		m.setDirector(director);
		m.setCast(cast);
		m.setBasePrice(basePrice);
		m.setBlockBuster(isBlockBuster);
		movieList = readMovieList();
		movieList.add(m);
		FileReadWriteController.writeMovieList(movieList);
	}
	public static ArrayList<Movie> getMovieByTitle(String title) throws IOException, ClassNotFoundException {
		movieList = readMovieList();
		ArrayList<Movie> searchResult = new ArrayList<>();
		for (Movie movie: movieList) {
			if (!title.equals("") && movie.getMovieTitle().toUpperCase().contains(title.toUpperCase()))
				searchResult.add(movie);
		}
		return searchResult;
	}

	//Return all movie object in the file
	public static ArrayList<Movie> getAllMovie() throws IOException, ClassNotFoundException {
		movieList = readMovieList();
		return movieList;
	}

	public static ArrayList<Movie> getTop5MovieListing(String orderBy) throws IOException, ClassNotFoundException {
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
//			Collections.sort(top5, (o1, o2) -> Integer.compare(o2.getSales(), o1.getSales()));
		}

		while (top5.size() > 5) {
			top5.remove(5);
		}

		return top5;
	}

	//If choice ==1; addMovie()
	//If choice ==2; updateMovie()
	//If choice ==3; deleteMovie()
	

}
