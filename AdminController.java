public class AdminController{
    private static final String staffUsername = 'admin';
    private String staffPassword = 'pass';

    public void createMovieListing() {
        Movie movie;
        String title, director, synopsis;
        MovieStatus movieStatus;
        int sales;
        AgeRestriction ageRestriction;
        ArrayList<String> cast;

        //Set title
        //Set showing status
        //Set type of movie (Blockbuster, normal, etc.)
        //Set synopsis
        //Set director
        //Set casts
        //Set past reviews
        //Set base price
        //Set age restriction

        //Create new movie
        //Add new movie into list
    }

    public void updateMovieListing() {
        Movie movieToUpdate, newMovieInfo;
        String title, director, synopsis;
        MovieStatus movieStatus;
        AgeRestriction ageRestriction;
        ArrayList<String> cast;

        //Get movie that need to be updated

        //Clone
        newMovieInfo = (Movie) movieToUpdate.clone();

        //Choice
        "Choose the field that need to be changed:\n" +
                "1. Title\n" +
                "2. Showing Status\n" +
                "3. Type of movie\n" +
                "4. Synopsis\n" +
                "5. Director\n" +
                "6. Cast\n" +
                "7. Age Restriction"
        //Set title
        //Set showing status
        //Set type of movie (Blockbuster, normal, etc.)
        //Set synopsis
        //Set director
        //Set casts
        //Set age restriction

        //Create new movie
        //Add new movie into list
    }

    public void removeMovieListing() {
        Movie movieToRemove;

        //Get movie to remove

        //Remove movie showing

        //Change showing status to ENDOFSHOWING
        movieToRemove.setShowingStatus(Movie.ShowingStatus.ENDOFSHOWING);
    }

    public void createMovieShowing() {
        Movie movie;
        Cinema cinema;
        Cineplex cineplex;
        Date showTime = null;

        //Get movie

        //Get cineplex

        //Get cinema

        //Input showtime

        //Add new movie showing
    }

    public void updateMovieShowing() {
        Movie movie;
        Cinema cinema;
        Cineplex cineplex;
        Date showTime = null;

        //Get movie

        //Get cineplex

        //Get cinema

        //Input showtime

        //Add new movie showing
    }

    public void removeMovieShowing() {
        MovieShowing movieShowingToRemove;

        //Remove movie showing
    }
}