package model;

public class Customer {
	
	private int customer_id;
	private int age;
	private String name;
	private String mobile;
	private String email;
	private boolean isStudent;
	private BookingHistory bookingHistory;
	
	public Customer (int customer_id, int age, String name, String mobile, String email, boolean isStudent) {
		this.customer_id = customer_id;
		this.age = age;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.isStudent = isStudent;
		this.bookingHistory = new BookingHistory(this);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isStudent() {
		return isStudent;
	}
	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public BookingHistory getBookingHistory() {
		return bookingHistory;
	}
}
	
	
	

