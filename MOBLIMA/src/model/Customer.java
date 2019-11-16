package model;

/**
 * This class contains information on the customer
 */
public class Customer {
	
	private String name;
	private String mobile;
	private String email;
	
	/**
	 * @param name		Name of the Customer.
	 * @param mobile	Mobile number of the customer.
	 * @param email		Email ID of the customer.
	 */
	public Customer (String name, String mobile, String email){
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}
	
	//Getter and Setter methods for the attributes of the Customer class.
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
	
	
