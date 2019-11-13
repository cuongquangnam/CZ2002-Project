package controller;

import model.Cinema;
import model.Movie;
import model.Show;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



public class ShowController
{
    static  ArrayList<Show> movieShowList = new ArrayList <Show>();
    public static void initialise() throws ClassNotFoundException, IOException
    {
        movieShowList = FileReadWriteController.readShowTime();
    }
    //static HashMap<String, ArrayList<Cinema>> cinemaList = FileReadWriteController.readCinemaList();







    static HashMap<String, ArrayList <Cinema>> cinemaList =new HashMap<String, ArrayList <Cinema>>() ;

    public static void createCinemaList() throws IOException
    {
        Cinema cinemaA_1 = new Cinema("Cineplex A", true, true, "A01");
        Cinema cinemaA_2 = new Cinema("Cineplex A", true, true, "A02");
        Cinema cinemaA_3 = new Cinema("Cineplex A", true, true);
        Cinema cinemaB_1 = new Cinema("Cineplex B", true, true);
        Cinema cinemaB_2 = new Cinema("Cineplex B", true, true);
        Cinema cinemaB_3 = new Cinema("Cineplex B", true, true);
        Cinema cinemaC_1 = new Cinema("Cineplex C", true, true);
        Cinema cinemaC_2 = new Cinema("Cineplex C", true, true);
        Cinema cinemaC_3 = new Cinema("Cineplex C", true, true);

        ArrayList <Cinema> c1 = new ArrayList <Cinema>();
        c1.add(cinemaA_1);
        c1.add(cinemaA_2);
        c1.add(cinemaA_3);

        cinemaList.put("Cineplex A", c1);

        ArrayList <Cinema> c2 = new ArrayList <Cinema>();
        c2.add(cinemaB_1);
        c2.add(cinemaB_2);
        c2.add(cinemaB_3);

        cinemaList.put("Cineplex B", c2);

        ArrayList <Cinema> c3 = new ArrayList <Cinema>();
        c3.add(cinemaC_1);
        c3.add(cinemaC_2);
        c3.add(cinemaC_3);

        cinemaList.put("Cineplex C", c3);

        FileReadWriteController.writeCinemaList(cinemaList);


    }


    public static Cinema whichCinema (String cineplex_name, int cinema_name)
    {
        System.out.println("HI");
        ArrayList<Cinema> c = cinemaList.get(cineplex_name);
        Cinema cin = c.get(cinema_name-1);
        System.out.println("HI");
        return cin;

    }





    public static void createShow(String time, Cinema cinema, Movie movie, String cineplex)
    {
        System.out.println("HI");
        Show show  = new Show(cineplex, movie, time, cinema);
        System.out.println(show);
        System.out.println("HI");
        movieShowList.add(show);
        for(Show s: movieShowList)
            System.out.println(s);
//		addShow(movie, show);

    }

//	public static void addShow(Movie movie, Show show)
//	{
//		System.out.println("HI");
////		Iterator hmIterator = movieShowList.entrySet().iterator();
////		while (hmIterator.hasNext())
////		{
////			Map.Entry mapElement = (Map.Entry)hmIterator.next();
////			if(mapElement.getKey() == movie)
////			{
////				((ArrayList<Show>) mapElement.getValue()).add(show);
////			}
////		}
//		ArrayList <Show> s = movieShowList.get(movie);
//
//		movieShowList.remove(movie, s);
//		s.add(show);
//		movieShowList.put(movie, s);
//		System.out.println(movieShowList.toString());
//		System.out.println("HI");
//	}
//
//


    public static ArrayList<Cinema> getCinemaList(String cineplex, HashMap<String, ArrayList<Cinema>>cinemaList) {
        return cinemaList.get(cineplex);
    }







}