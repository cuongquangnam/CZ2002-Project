package model;

/**
 * This class contains information on the customer
 */
public class Customer {
	/**
	 * Name of customer
	 */
	private String name;
	/**
	 * Mobile phone of customer
	 */
	private String mobile;
	/**
	 * Email of
	 */
	private String email;
	
	public Customer (String name, String mobile, String email){
		this.name = name;
		this.mobile = mobile;
		this.email = email;
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
}
	
	
	

