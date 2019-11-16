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
	/**
	 * Whether the cinema is 3D or not
	 */
	private boolean is3D;
	/**
	 * Whether the cinema is platinum or not
	 */
	private boolean isPlatinum;
	/**
	 * The code of cinema
	 */
	private String cinemaCode;


	/**
	 * Constructor
	 */
	public Cinema()
	{

	}
	public Cinema(String cineplex, boolean is3D, boolean isPlatinum, String cinemaCode)
	{
		this.cineplex = cineplex;
		this.is3D= is3D;
		this.isPlatinum = isPlatinum;
		this.cinemaCode = cinemaCode;

	}

	/**
	 * This method gets cineplex of cinema
	 * @return Cineplex of cinema
	 */
	public String getCineplex() {
		return cineplex;
	}

	/**
	 * This method sets cineplex of cinema
	 * @param cineplex Cineplex of cinema
	 */
	public void setCineplex(String cineplex) {
		this.cineplex = cineplex;
	}

	/**
	 * This method gets whether the cinema is 3D or not
	 * @return true if cinema is 3D, false otherwise
	 */
	public boolean is3D() {
		return is3D;
	}

	/**
	 * This method sets whether the cinema is 3D or not
	 * @param is3d true if cinema is 3D, false otherwise
	 */
	public void setIs3D(boolean is3d) {
		is3D = is3d;
	}

	/**
	 * This method gets whether cinema is Platinum or not
	 * @return true if cinema is Platinum, false otherwise
	 */
	public boolean isPlatinum() {
		return isPlatinum;
	}

	/**
	 * This method sets whether cinema is Platinum or not
	 * @param isPlatinum true if cinema is Platinum, false otherwise
	 */
	public void setPlatinum(boolean isPlatinum) {
		this.isPlatinum = isPlatinum;
	}

	/**
	 * This method gets the cinema code
	 * @return The cinema code
	 */
	public String getCinemaCode() {
		return cinemaCode;
	}

	/**
	 * This method sets the cinema code
	 * @param cinemaCode The cinema code
	 */
	public void setCinemaCode(String cinemaCode) {
		this.cinemaCode = cinemaCode;
	}

	@Override
	public String toString() {
		return "{Cineplex: " + cineplex + ", is3D: " + is3D + ", isPlatinum: " + isPlatinum + ", Code: " + cinemaCode +"}";
	}
}
