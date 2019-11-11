package model;

public class BookingandPayment {
	
	private Customer customer;
	private String TID;
	private Seat seat;
	private String code;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getTID() {
		return TID;
	}
	public void setTID(String tID) {
		TID = tID;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	
}
