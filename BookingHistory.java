package com.models;

import java.util.ArrayList;

public class BookingHistory {
	private Customer customer;
	private ArrayList<BookingandPayment> bookingHistory;
	
	public BookingHistory(Customer customer) {
		this.customer = customer;
		bookingHistory = new ArrayList<BookingandPayment>();
	}
	public void addBookingHistory(BookingandPayment bp) {
		if (bp.getCustomer().getCustomer_id()== customer.getCustomer_id())
			bookingHistory.add(bp);
	}
	public String toString() {
		return this.customer.getName();
	}
}
