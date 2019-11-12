package com.views;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.controllers.DataManager;
import com.controllers.*;
import com.models.Movie;
public class DisplayMovieView extends DataManager {
	static String FILENAME_MOVIE = "/Users/ritwikkanodia/eclipse-workspace/M1/src/DataFolder/Movie.dat";
	static ArrayList <Movie> movieListing = new ArrayList <Movie>();
	
	
    public static void readMovieListing() throws IOException, ClassNotFoundException {
        if (readSerializedObject(FILENAME_MOVIE) == null) movieListing = new ArrayList<>();
        else {
            movieListing = FileReadWriteController.readMovieList();
            // sort listing by movie status
           
        }
        System.out.println(movieListing);
    }
}
    

	
	
	//Read from file and display


