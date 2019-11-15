package model;

import controller.FileReadWriteController;
import controller.TicketPriceController;

import java.util.ArrayList;

public class TicketCostService
{
    Movie movie;
    Show show;
    Seat seat;
    static double price;
    static double priceBlockBuster = TicketPriceController.getBlockBusterPrice();
    static double price3D = TicketPriceController.get3DPrice();
    static double priceSenior = TicketPriceController.getSeniorPrice();
    static double pricePlatinum = TicketPriceController.getPlatinumPrice();
//    static double priceHoliday = TicketPriceController.getHolidayPrice();

    public TicketCostService(Movie movie, Show show, Seat seat, double price) {
        super();
        this.movie = movie;
        this.show = show;
        this.seat = seat;
        this.price = price;
    }
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public Show getShow() {
        return show;
    }
    public void setShow(Show show) {
        this.show = show;
    }
    public Seat getSeat() {
        return seat;
    }
    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public static double  calculateTicketPriceSeat(Movie movie, ArrayList<Seat> seats, Show show, Cinema cinema)
    {

        price = movie.getBasePrice()  * seats.size();

        if(movie.isBlockBuster() == true)
            price += priceBlockBuster * seats.size();
        for(Seat s : seats)
        {
            if(s.isSenior() == true)
                price += priceSenior;
        }
//        if(show.getTime() == //enum class of holidays)
//            price += priceHoliday * seats.size();

        if(cinema.is3D() == true)
            price += price3D * seats.size();

        if(cinema.isPlatinum() == true)
            price += pricePlatinum * seats.size();

        return price;

    }
}