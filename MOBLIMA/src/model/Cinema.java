package model;

import java.io.Serializable;

/**
 * This class contains all information of the cinema
 */
public class Cinema implements Serializable {

	/**
	 * The cineplex the movie belongs to
	 */
	private String cineplex;
	private boolean is3D;
	private boolean isPlatinum;
	private String cinemaCode;


	public Cinema()
	{

	}
	/**
	 * @param cineplex		The cineplex the cinema belongs to.
	 * @param is3D			If the cinema supports 3D movies
	 * @param isPlatinum	If the cinema has platinum seats
	 * @param cinemaCode	The code of the Cinema.
	 */
	public Cinema(String cineplex, boolean is3D, boolean isPlatinum, String cinemaCode)
	{
		this.cineplex = cineplex;
		this.is3D= is3D;
		this.isPlatinum = isPlatinum;
		this.cinemaCode = cinemaCode;

	}
	
	
	//Getter and Setter methods for the attributes of the Cinema class.

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

	public String getCinemaCode() {
		return cinemaCode;
	}
	public void setCinemaCode(String cinemaCode) {
		this.cinemaCode = cinemaCode;
	}

	@Override
	public String toString() {
		return "{Cineplex: " + cineplex + ", is3D: " + is3D + ", isPlatinum: " + isPlatinum + ", Code: " + cinemaCode +"}";
	}
}
