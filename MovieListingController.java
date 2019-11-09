package controller;
import model.*;
import view.*;
import java.util.*;
public class MovieListingController {
static	ArrayList <Movie> movieList = new ArrayList <Movie>(); 
	static Scanner sc = new Scanner(System.in);
	
	static String movieTitle;
	int showingStatus;
	String sypnosis;
	String director;
	ArrayList <String> cast = new ArrayList <String>();
	double basePrice;
	boolean is3D;
	boolean isBlockBuster;
	
	
	public void addMovie(Movie m)
	{
		movieList.add(m);
	}
	
	public void updateMovie(Movie old, Movie newm)
	{
		movieList.remove(old);
		movieList.add(newm);
	}
	
	public void deleteMovie(Movie m)
	{
		movieList.remove(m);
	}
	
	public static int inputChoice()
	{
		
		AdminView adminview = new AdminView();
		int choice = adminview.modifyMovieListingMenu();
		return choice;
		
	}
	
	
	
	
	
	public void inputMovieTitle()
	{
		
		movieTitle = sc.next();
	
	}
	

	public  void inputShowingStatus()
	{
		
	 showingStatus = sc.nextInt();
		
	}
	

	public  void inputSypnosis()
	{
		
		sypnosis = sc.next();
		
	}
	

	public  void inputDirector()
	{
		
		director = sc.next();
		
	}

	public  void inputCast()
	{
		
		
		
		String each_cast;
		do
        {
        each_cast = sc.next();
        cast.add(each_cast);
        } while(!each_cast.equals("0"));
		
	}
	
	public  void inputBasePrice()
	{
		
		 basePrice = sc.nextInt();
		
	}
	
	public  void inputIs3D()
	{
		 is3D = sc.nextBoolean();
		
	}
	
	public  void inputIsBlockBuster()
	{
		
		isBlockBuster = sc.nextBoolean();
		
	}
	
	public Movie createNewMovie()
	{
		Movie m = new Movie(movieTitle, showingStatus, sypnosis, director, cast, basePrice, is3D, isBlockBuster);
	
//		m.setBasePrice();
//		m.setShowingStatus();
//		m.setBlockBuster();
//		m.setCast();
//		m.setDirector();
//		m.setSypnosis();
//		m.setIs3D();
		return m;
	}
	
	public static void main(String args[])
	{
		MovieListingController movielistingcontroller = new MovieListingController();
		
		MovieListView movielistview = new MovieListView();
		movielistview.initialize();
//		int choice = movielistingcontroller.inputChoice();
		
			
			Movie m = movielistingcontroller.createNewMovie();
			movieList.add(m);
			System.out.println(m);
			

	
		for(Movie m1: movieList)
		System.out.println(m1);
	}
	
	
	
	
	
	
	
	
	
	
	//If choice ==1; addMovie()
	//If choice ==2; updateMovie()
	//If choice ==1; deleteMovie()
	

}
   