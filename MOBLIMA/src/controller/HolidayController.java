package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class HolidayController {
    private static ArrayList<Date> holidayList = null;

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

    public static void deleteHoliday(int index) {
        holidayList.remove(index);
        try {
            FileReadWriteController.writeHolidayList(holidayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public static boolean checkHoliday(Date date) {
        holidayList = getAllHoliday();
        for(Date d: holidayList) {
            if(IOController.dateEquals(date, d))
                return true;
        }
        return false;
    }
}
