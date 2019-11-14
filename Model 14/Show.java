package model;

import java.io.Serializable;
import java.util.Date;

import static controller.IOController.formatTimeMMddHHmm;

public class Show implements Serializable {
    private String cineplex;
    private Movie movie;
    private Date dateTime;
    private Cinema cinema;
    private SeatMap seatmap;

    public Show()
    {
        seatmap = new SeatMap();
    }


    public Show(String cineplex, Movie movie, Date dateTime, Cinema cinema) {
        super();
        this.cineplex = cineplex;
        this.movie = movie;
        this.dateTime = dateTime;
        this.cinema = cinema;
        this.seatmap = new SeatMap();
    }



    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public Date getTime() {
        return dateTime;
    }
    public void setTime(Date time) {
        this.dateTime = time;
    }
    public Cinema getCinema() {
        return cinema;
    }
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
    public String getCineplex() {
        return cineplex;
    }


    public void setCineplex(String cineplex) {
        this.cineplex = cineplex;
    }
    public SeatMap getSeatMap()  {
        return seatmap;
    }

    @Override
    public String toString() {
        return cinema.getCineplex() + ": " + formatTimeMMddHHmm(dateTime);
    }




}