//package controller;
//
//import model.Booking;
//import model.BookingHistory;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class BookingController {
//    public static ArrayList<Booking> getBookingHistory(String name, String mobile) throws IOException, ClassNotFoundException {
//        ArrayList<Booking> allBookingHistory = BookingHistory.readBookingHistory();
//        ArrayList<Booking> bookingHistory = new ArrayList<Booking>();
//        for(int i = 0; i < allBookingHistory.size(); i++) {
//            if(allBookingHistory.get(i).getCustomer().getName().equals(name) &&
//                    allBookingHistory.get(i).getCustomer().getMobile().equals(mobile))
//                bookingHistory.add(allBookingHistory.get(i));
//        }
//        return bookingHistory;
//    }
//}
