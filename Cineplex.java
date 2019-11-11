package models;

import java.util.ArrayList;


public class Cineplex {
	
    private String staffusername;
	private String staffpassword;
	private ArrayList<Cinema> cinemas;
	
	public Cineplex (String staffusername, String staffpassword, int numCinema)
	{
	this.staffusername = staffusername;
    this.staffpassword = staffpassword;
    this.cinemas = new ArrayList<Cinema>();
   }
	
	public void addCinema(boolean is3D, boolean isPlatinum) {
		cinemas.add(new Cinema(this,is3D,isPlatinum));
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
