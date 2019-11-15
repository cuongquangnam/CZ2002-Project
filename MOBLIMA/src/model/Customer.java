package model;

public class Customer {
	private String name;
	private String mobile;
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
	
	
	

