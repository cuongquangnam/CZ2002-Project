package model;

import java.io.IOException;

public class Customer {

	private int age;
	private String name;
	private String mobile;
	private String email;
	private boolean isStudent;
	private boolean isSenior;

	private BookingHistory bookingHistory;
	
	public Customer (int customer_id, int age, String name, String mobile, String email, boolean isStudent, boolean isSenior) throws IOException, ClassNotFoundException {
		this.age = age;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.isStudent = isStudent;
		this.isSenior = isSenior;
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
	public boolean isSeniorCitizen() {
		return isSenior;
	}
	public void setSenior(boolean isSenior) {
		this.isSenior = isSenior;
	}
	public BookingHistory getBookingHistory() {
		return bookingHistory;
	}
}
	
	
	

