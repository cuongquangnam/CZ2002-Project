package model;

import controller.FileReadWriteController;
import controller.HolidayController;
import controller.TicketPriceController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class contains information on the ticket cost service for calculation of ticket price
 */
public class TicketCostService
{
    /**
     * The base price of a transaction
     */
    private static double price;
    /**
     * The Blockbuster price modifier
     */
    private static double priceBlockBuster = TicketPriceController.getBlockBusterPrice();
    /**
     * The 3D price modifier
     */
    private static double price3D = TicketPriceController.get3DPrice();
    /**
     * The Senior Citizen price modifier
     */
    private static double priceSenior = TicketPriceController.getSeniorPrice();
    /**
     * The Platinum cinema price modifier
     */
    private static double pricePlatinum = TicketPriceController.getPlatinumPrice();
    /**
     * The Weekend price modifier
     */
    private static double priceWeekend = TicketPriceController.getWeekendPrice();
    /**
     * The Holiday price modifier
     */
    private static double priceHoliday = TicketPriceController.getHolidayPrice();
    /**
     * The list of holiday
     */
    private static ArrayList<Date> holidayList;


    /**
     * This method calculates the base ticket price of a transaction
     * @param seats List of all booked seats
     * @param show Selected showtime
     * @param cinema Selected cinema
     * @return The base price
     */
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
        if(show.getTime().getDay() == 6 || show.getTime().getDay() == 0)
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