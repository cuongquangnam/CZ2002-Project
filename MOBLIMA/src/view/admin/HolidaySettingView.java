package view.admin;

import controller.HolidayController;
import controller.IOController;
import controller.ViewController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class HolidaySettingView extends ViewController {
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    private void displayMenu(){
        IOController.printTitle("Configure holidays");
        System.out.println("1. Add new holiday");
        System.out.println("2. Delete holiday");
        System.out.println("3. View all holidays");
        System.out.println("4. Return");

        int choice = IOController.getChoice(1, 4);
        switch (choice) {
            case 1:
                addHoliday();
                break;
            case 2:
                deleteHoliday();
                break;
            case 3:
                viewAllHolidays();
                break;
            case 4:
                return;
        }
    }

    private void viewAllHolidays() {
        IOController.printTitle("View all holidays");
        ArrayList<Date> holidayList = HolidayController.getAllHoliday();
        if(holidayList == null || holidayList.size() == 0) {
            System.out.println("There is no holiday!");
        }
        else {
            System.out.println("List of holiday:");
            int index = 1;
            for(Date date: holidayList) {
                System.out.println(index + ". " + IOController.formatTimeMMdd(date));
                index++;
            }
        }
        IOController.getString("Press ENTER to return");
    }

    private void deleteHoliday() {
        IOController.printTitle("Delete holiday");
        ArrayList<Date> holidayList = HolidayController.getAllHoliday();
        if(holidayList == null || holidayList.size() == 0) {
            System.out.println("There is no holiday!");
        }
        else {
            System.out.println("List of holiday:");
            int index = 1;
            for(Date date: holidayList) {
                System.out.println(index + ". " + IOController.formatTimeMMdd(date));
            }
            System.out.println("Select the index of holiday to delete\n" +
                    "Press 0 to return");
            int choice = IOController.getChoice(0, holidayList.size());
            if(choice == 0)
                return;
            else {
                HolidayController.deleteHoliday(choice - 1);
                System.out.println("Successfully delete holiday!");
            }
        }
        IOController.getString("Press ENTER to return");
    }

    private void addHoliday() {
        IOController.printTitle("Add new holiday");
        Date newHoliday = IOController.readTimeMMdd("Please input the date you want to set as holiday\n" +
                                                    "Format: MM-dd");
        boolean checkAdd = HolidayController.createNewHoliday(newHoliday);
        if(checkAdd)
            System.out.println("Successfully create holiday!");
        else
            System.out.println("Duplicate holiday! No new holiday!");
        IOController.getString("Press ENTER to return");
    }
}
