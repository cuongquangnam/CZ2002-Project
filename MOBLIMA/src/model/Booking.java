package model;

import java.util.ArrayList;
import java.util.Date;

public class Booking {

	private Date booking_dt;
	private Movie movie;
	private Show show;
	private ArrayList <Seat> seat;
	private String TID;
	private String name;
	private String mobileNumber;
	private String emailID;
	private boolean isSenior;


	public Booking()
	{

	}

	public Booking(Date booking_dt, Movie movie, Show show, ArrayList <Seat> seat, String tID, String name,
				   String mobileNumber, String emailID, boolean isSenior) {
		super();
		this.booking_dt = booking_dt;
		this.movie = movie;
		this.show = show;
		this.seat = seat;
		this.TID = tID;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailID = emailID;
		this.isSenior = isSenior;
	}


	@Override
	public String toString() {
		return "BookingAndPayment [booking_dt=" + booking_dt + ", movie=" + movie + ", show=" + show + ", seat=" + seat
				+ ", TID=" + TID + ", name=" + name + ", mobileNumber=" + mobileNumber + ", emailID=" + emailID +
				", isSenior=" + isSenior + "]";
	}
	public Date getBooking_dt() {
		return booking_dt;
	}
	public void setBooking_dt(Date booking_dt) {
		this.booking_dt = booking_dt;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public ArrayList <Seat> getSeat() {
		return seat;
	}
	public void setSeat(ArrayList <Seat> seat) {
		this.seat = seat;
	}
	public String getTID() {
		return TID;
	}
	public void setTID(String tID) {
		TID = tID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public boolean isSenior() {
		return isSenior;
	}
	public void setSenior(boolean senior) {
		isSenior = senior;
	}
}