package model;

import controller.FileReadWriteController;
import controller.HolidayController;
import controller.IOController;
import controller.TicketPriceController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class TicketCostService
{
    private static double price;
    private static double priceBlockBuster = TicketPriceController.getBlockBusterPrice();
    private static double price3D = TicketPriceController.get3DPrice();
    private static double priceSenior = TicketPriceController.getSeniorPrice();
    private static double pricePlatinum = TicketPriceController.getPlatinumPrice();
    private static double priceWeekend = TicketPriceController.getWeekendPrice();
    private static double priceHoliday = TicketPriceController.getHolidayPrice();
    private static ArrayList<Date> holidayList;

    public static double calculateTicketPriceSeat(ArrayList<Seat> seats, Show show, Cinema cinema)
    {
        {
            try {
                holidayList = FileReadWriteController.readHolidayList();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        price = show.getMovie().getBasePrice()  * seats.size();

        if(show.getMovie().isBlockBuster() == true)
            price += priceBlockBuster * seats.size();
        for(Seat s : seats)
        {
            if(s.isSenior() == true)
                price += priceSenior;
        }
        if(show.getTime().getDay() == 6 || show.getTime().getDay() == 7)
            price += priceWeekend * seats.size();

        if(holidayList.size() != 0) {
            if(HolidayController.checkHoliday(show.getTime()))
                price += priceHoliday * seats.size();
        }
        if(cinema.is3D() == true)
            price += price3D * seats.size();

        if(cinema.isPlatinum() == true)
            price += pricePlatinum * seats.size();

        return price;

    }
}