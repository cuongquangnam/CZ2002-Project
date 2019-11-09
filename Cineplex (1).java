package model;

public class Cineplex {
	
    private String staffusername;
	private String staffpassword;
	
	
	public Cineplex (String staffusername, String staffpassword)
	{
	this.staffusername = staffusername;
    this.staffpassword = staffpassword;
   }

	public String getStaffusername() {
		return staffusername;
	}

	public void setStaffusername(String staffusername) {
		this.staffusername = staffusername;
	}

	public String getStaffpassword() {
		return staffpassword;
	}

	public void setStaffpassword(String staffpassword) {
		this.staffpassword = staffpassword;
	}
}