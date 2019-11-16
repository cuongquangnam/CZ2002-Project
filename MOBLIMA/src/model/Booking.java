package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Booking implements Serializable {

	// Set to private so that they cannot be accessed directly.
	private Date booking_dt;
	private Movie movie;
	private Show show;
	private ArrayList<Seat> seat;
	private String TID;
	private String name;
	private String mobileNumber;
	private String emailID;


	public Booking() {

	}

	/**
	 * @param booking_dt	Date of the booking made
	 * @param movie			Movie for which the booking is being made.
	 * @param show			Show for which the booking is being made.
	 * @param seat			Seats associated with the booking 
	 * @param tID			Transactions ID associated with booking
	 * @param name			Name of the user making the booking.
	 * @param mobileNumber	Mobile number of the user making the booking.
	 * @param emailID		Email ID of the user making the bookibng.
	 */
	public Booking(Date booking_dt, Movie movie, Show show, ArrayList<Seat> seat, String tID, String name,
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

	
	//To return as string, the information related to the calling object of the Booking class.
	@Override
	public String toString() {
		String str = TID + "\n" + "Name: " + name + "\n" + "Mobile: " + mobileNumber + "\n" + "Email: " + emailID + "\n"
				+ "Movie: " + movie.getMovieTitle() + "\n" + "Cineplex: " + show.getCineplex() + "\n" + "Cinema: "
				+ show.getCinema().getCinemaCode() + "\n" + "Time: " + booking_dt + "\n";
		for (int i = 0; i < seat.size(); i++) {
			str += "Seat " + (i + 1) + ": Row " + (seat.get(i).getRow() + 1) + " Col "
					+ ((seat.get(i).getCol() > 8) ? seat.get(i).getCol() : (seat.get(i).getCol() + 1)) + "\n";
		}
		return str;
	}

	/**
	 * @return	Date of the booking
	 */
	public Date getBooking_dt() {
		return booking_dt;
	}

	/**
	 * @param booking_dt	Date of booking.
	 */
	
	public void setBooking_dt(Date booking_dt) {
		this.booking_dt = booking_dt;
	}

	/**
	 * @return		The movie for which the booking is made.
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * @param movie The movie for which the booking is made.
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * @return The show for which the booking is being made
	 */
	public Show getShow() {
		return show;
	}

	/**
	 * @param show The show for which the booking is being made
	 */
	public void setShow(Show show) {
		this.show = show;
	}

	/**
	 * @return ArrayList of seat which are being booked.
	 */
	public ArrayList<Seat> getSeat() {
		return seat;
	}

	/**
	 * @param seat	ArrayList of seat which are being booked.
	 */
	public void setSeat(ArrayList<Seat> seat) {
		this.seat = seat;
	}

	/**
	 * @return The Transaction ID of the booking.
	 */
	public String getTID() {
		return TID;
	}

	/**
	 * @param tID	The Transaction ID of the booking.
	 */
	public void setTID(String tID) {
		TID = tID;
	}

	/**
	 * @return The name of the user making the booking
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name	The name of the user making the booking.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The mobile number of the user making the booking.
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber	The mobile number of the user making the booking.
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return The email ID of the user making the booking.
	 */
	public String getEmailID() {
		return emailID;
	}

	/**
	 * @param emailID	The email ID of the user making the booking.
	 */
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
}
