package model;

import controller.TicketPriceController;

import java.util.ArrayList;

public class TicketCostService
{
    static double price;
    static double priceBlockBuster = TicketPriceController.getBlockBusterPrice();
    static double price3D = TicketPriceController.get3DPrice();
    static double priceSenior = TicketPriceController.getSeniorPrice();
    static double pricePlatinum = TicketPriceController.getPlatinumPrice();
//    static double priceHoliday = TicketPriceController.getHolidayPrice();

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
