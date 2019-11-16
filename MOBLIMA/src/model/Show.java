package model;

import java.io.Serializable;
import java.util.Date;

import static controller.IOController.formatTimeMMddHHmm;

/**
 * This class contains information on a show of a movie
 */
public class Show implements Serializable {
    /**
     * Name of cineplex
     */
    private String cineplex;
    /**
     * The movie that the show belongs to
     */
    private Movie movie;
    /**
     * Time of the show
     */
    private Date dateTime;
    /**
     * The cinema that the show is shown
     */
    private Cinema cinema;
    /**
     * The seat mapping of the show
     */
    private SeatMap seatmap;


    /**
     * Constructor
     */
    public Show()
    {
        seatmap = new SeatMap();
    }

    /**
     * Constructor
     * @param cineplex Name of cineplex
     * @param movie The movie that the show belongs to
     * @param dateTime Time of the show
     * @param cinema The cinema that the show is shown
     */
    public Show(String cineplex, Movie movie, Date dateTime, Cinema cinema) {
        super();
        this.cineplex = cineplex;
        this.movie = movie;
        this.dateTime = dateTime;
        this.cinema = cinema;
        this.seatmap = new SeatMap();
    }


    /**
     * Get the movie
     * @return The movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Set the movie
     * @param movie The movie
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * Get the time
     * @return Time of show
     */
    public Date getTime() {
        return dateTime;
    }

    /**
     * Set the time
     * @param time Time of show
     */
    public void setTime(Date time) {
        this.dateTime = time;
    }

    /**
     * Get the cinema
     * @return Cinema of show
     */
    public Cinema getCinema() {
        return cinema;
    }

    /**
     * Set the cinema
     * @param cinema Cinema of show
     */
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    /**
     * Get the cineplex
     * @return Cineplex of show
     */
    public String getCineplex() {
        return cineplex;
    }

    /**
     * Set the cineplex
     * @param cineplex Cineplex of show
     */
    public void setCineplex(String cineplex) {
        this.cineplex = cineplex;
    }

    /**
     * Get the seat map
     * @return Seat map of show
     */
    public SeatMap getSeatMap()  {
        return seatmap;
    }

    @Override
    public String toString() {
        return cinema.getCineplex() + ", " + cinema.getCinemaCode() + " " + formatTimeMMddHHmm(dateTime);
    }




}