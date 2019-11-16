package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class contains all information on the booking
 */
public class Booking implements Serializable {

	/**
	 * Time of the booking
	 */
	private Date booking_dt;
	/**
	 * The booked movie
	 */
	private Movie movie;
	/**
	 * The booked show
	 */
	private Show show;
	/**
	 * The list of booked seats
	 */
	private ArrayList <Seat> seat;
	/**
	 * The transaction ID
	 */
	private String TID;
	/**
	 * Name of the booker
	 */
	private String name;
	/**
	 * Mobile number of the booker
	 */
	private String mobileNumber;
	/**
	 * Email of booker
	 */
	private String emailID;

	/**
	 * Constructor
	 */
	public Booking()
	{

	}

	public Booking(Date booking_dt, Movie movie, Show show, ArrayList <Seat> seat, String tID, String name,
				   String mobileNumber, String emailID) {
		super();
		this.booking_dt = booking_dt;
		this.movie = movie;
		this.show = show;
		this.seat = seat;
		this.TID = tID;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailID = emailID;
	}


	@Override
	public String toString() {
		String str = TID + "\n" +
				"Name: " + name + "\n" +
				"Mobile: " + mobileNumber + "\n" +
				"Email: " + emailID + "\n" +
				"Movie: " + movie.getMovieTitle() + "\n" +
				"Cineplex: " + show.getCineplex() + "\n" +
				"Cinema: " + show.getCinema().getCinemaCode() + "\n" +
				"Time: " + booking_dt + "\n";
		for(int i = 0; i < seat.size(); i++) {
			str += "Seat " + (i + 1) + ": Row " + (seat.get(i).getRow() + 1) + " Col " + ((seat.get(i).getCol() > 8) ? seat.get(i).getCol() : (seat.get(i).getCol() + 1)) + "\n";
		}
		return str;
	}

	/**
	 * This method gets the time of booking
	 * @return The time of booking
	 */
	public Date getBooking_dt() {
		return booking_dt;
	}

	/**
	 * This method sets the time of booking
	 * @param booking_dt The time of booking
	 */
	public void setBooking_dt(Date booking_dt) {
		this.booking_dt = booking_dt;
	}

	/**
	 * This method gets the booked movie
	 * @return The booked movie
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * This method sets the booked movie
	 * @param movie The booked movie
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * This method gets the booked show
	 * @return The booked show
	 */
	public Show getShow() {
		return show;
	}

	/**
	 * The method sets the booked show
	 * @param show The booked show
	 */
	public void setShow(Show show) {
		this.show = show;
	}

	/**
	 * The method gets the list of booked seats
	 * @return The list of booked seats
	 */
	public ArrayList <Seat> getSeat() {
		return seat;
	}

	/**
	 * The method sets the list of booked seats
	 * @param seat The list of booked seats
	 */
	public void setSeat(ArrayList <Seat> seat) {
		this.seat = seat;
	}

	/**
	 * The method gets the transaction ID
	 * @return Transaction ID
	 */
	public String getTID() {
		return TID;
	}

	/**
	 * The method sets the transaction ID
	 * @param tID Transaction ID
	 */
	public void setTID(String tID) {
		TID = tID;
	}

	/**
	 * The method gets the name of the booker
	 * @return The name of the booker
	 */
	public String getName() {
		return name;
	}

	/**
	 * The method sets the name of the booker
	 * @param name The name of the booker
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The method gets the mobile number of the booker
	 * @return The mobile number of the booker
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * The method sets the mobile number of the booker
	 * @param mobileNumber Mobile number
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * This method gets email of the booker
	 * @return The email of booker
	 */
	public String getEmailID() {
		return emailID;
	}

	/**
	 * This method sets email of booker
	 * @param emailID Email of booker
	 */
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
}