package com.models;

import java.io.Serializable;

public class Cinema implements Serializable {
	
	private String cineplex;
	private boolean is3D;
	private boolean isPlatinum;
	
	
	public Cinema()
	{
		
	}
	public Cinema(String cineplex, boolean b, boolean c)
	{
		
	
	
	
        this.cineplex = cineplex;
        this.is3D= b;
        this.isPlatinum = c;
        
    }
	
	public String getCineplex() {
		return cineplex;
	}
	public void setCineplex(String cineplex) {
		this.cineplex = cineplex;
	}
	public boolean is3D() {
		return is3D;
	}
	public void setIs3D(boolean is3d) {
		is3D = is3d;
	}
	public boolean isPlatinum() {
		return isPlatinum;
	}
	public void setPlatinum(boolean isPlatinum) {
		this.isPlatinum = isPlatinum;
	}
	
	
	

	

}
