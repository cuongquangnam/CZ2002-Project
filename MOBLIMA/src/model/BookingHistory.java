package model;

import java.io.IOException;
import java.util.ArrayList;
import controller.DataController;

public class BookingHistory {
	private static final String FILENAME_BOOKINGHISTORY = "src/data/bookingHistory.dat";
	private static ArrayList<Booking> bookingHistory;
	
	public BookingHistory() throws IOException, ClassNotFoundException {
		bookingHistory = readBookingHistory();
	}
	public void addBookingHistory(Booking bp) {
		bookingHistory.add(bp);
	}

	public static ArrayList<Booking> readBookingHistory() throws IOException, ClassNotFoundException {
		ArrayList<Booking> allBookingHistory = (ArrayList<Booking>) DataController.readSerializedObject(FILENAME_BOOKINGHISTORY);
		return allBookingHistory;
	}

	public static void writeBookingHistory(ArrayList<Booking> bookingHistory) {

	}
}
