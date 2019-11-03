package entity

import java.text.SimpleDateFormat;
import java.util.Date;


public class MovieShowing{
    private Movie movie;
    private Cinema cinema;
    private Cineplex cineplex;
    private Date showTime;

    public MovieShowing(Movie movie, Cinema cinema, Cineplex cineplex, Date date) {
        this.movie = movie;
        this.cinema = cinema;
        this.cineplex = cineplex;
        this.showTime = date;
    }

    public Movie getMovie() {
        return movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public Cineplex getCineplex() {
        return cineplex;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public String toString() {
        SimpleDateFormat time = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        return "Movie title: " + movie.getTitle() +
                "\nType: " + movie.getType() +
                "\nCinema code: " + cinema.toString() +
                "\nPlatinum cinema: " + cinema.getisPlatinum() +
                "\n3D: " + cinema.getis3D() +
                "\nShow time: " + time.format(showTime);
    }


}