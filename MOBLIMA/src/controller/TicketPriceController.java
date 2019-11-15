package controller;

import java.io.IOException;
import java.util.ArrayList;

public class TicketPriceController {
    static ArrayList<Double> priceSettingList = getPriceSettingList();

    public static ArrayList<Double> getPriceSettingList() {
        {
            try {
                priceSettingList = FileReadWriteController.readPriceSetting();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return priceSettingList;
    }

    public static double getBlockBusterPrice() {
        priceSettingList = getPriceSettingList();
        return priceSettingList.get(0);
    }

    public static double get3DPrice() {
        priceSettingList = getPriceSettingList();
        return priceSettingList.get(1);
    }
    public static double getSeniorPrice() {
        priceSettingList = getPriceSettingList();
        return priceSettingList.get(2);
    }
    public static double getPlatinumPrice() {
        priceSettingList = getPriceSettingList();
        return priceSettingList.get(3);
    }
//    public static double getBlockBusterPrice() {
//    priceSettingList = getPriceSettingList();
//        return priceSettingList.get(0);
//    }

    public static void setBlockBusterPrice(double price) {
        priceSettingList.set(0, price);
        try {
            FileReadWriteController.writePriceSetting(priceSettingList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void set3DPrice(double price) {
        priceSettingList.set(1, price);
        try {
            FileReadWriteController.writePriceSetting(priceSettingList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setSeniorPrice(double price) {
        priceSettingList.set(2, price);
        try {
            FileReadWriteController.writePriceSetting(priceSettingList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setPlatinumPrice(double price) {
        priceSettingList.set(3, price);
        try {
            FileReadWriteController.writePriceSetting(priceSettingList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void setHolidayPrice(double price) {
//        priceSettingList.set(4, price);
//        try {
//            FileReadWriteController.writePriceSetting(priceSettingList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
