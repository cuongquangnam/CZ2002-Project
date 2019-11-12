package com.views;

import com.controllers.IOController;
import com.controllers.MovieListingController;

public class DeleteMovieView extends View {

	@Override
	public void start() {
		String movieTitle = IOController.readString("Enter the title of the movie to delete");
		MovieListingController.deleteMovie(movieTitle);

}
}
