package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class handles the holiday
 */
public class HolidayController {
    /**
     * List of holiday
     */
    private static ArrayList<Date> holidayList = null;

    /**
     * This method returns all the holidays in the list
     * @return A list of Date
     */
    public static ArrayList<Date> getAllHoliday(){
        {
            try {
                holidayList = FileReadWriteController.readHolidayList();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return holidayList;
    }

    /**
     * This method deletes the selected holiday
     * @param index The index of selected holiday
     */
    public static void deleteHoliday(int index) {
        holidayList.remove(index);
        try {
            FileReadWriteController.writeHolidayList(holidayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method creates new holiday
     * @param date The date to be made into holiday
     * @return true if holiday can be created, false if there is already a holiday with same date
     */
    public static boolean createNewHoliday(Date date) {
        boolean check = false;
        holidayList = getAllHoliday();
        if(!holidayList.contains(date)) {
            holidayList.add(date);
            check = true;
        }
        try {
            FileReadWriteController.writeHolidayList(holidayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return check;
    }

    /**
     * This method checks whether a date is a holiday or not
     * @param date The date to be checked
     * @return true if the date is a holiday, false otherwise
     */
    public static boolean checkHoliday(Date date) {
        holidayList = getAllHoliday();
        for(Date d: holidayList) {
            if(IOController.dateEquals(date, d))
                return true;
        }
        return false;
    }
}
