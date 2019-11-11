package com.models;

import java.util.ArrayList;

public class Cinema {
	private static final int row = 9;
	private static final int col = 16;
	private Cineplex cineplex;
	private boolean is3D;
	private boolean isPlatinum;
	private Seat[][] seats;
	private ArrayList<MovieShowing> showing;
	
	public Cinema(Cineplex cineplex, boolean is3D, boolean isPlatinum) {
		this.cineplex = cineplex;
		this.is3D = is3D;
		this.isPlatinum = isPlatinum;
		this.seats = new Seat[row][col];
		this.showing = new ArrayList<MovieShowing>();
	}
	public Cineplex getCineplex() {
		return cineplex;
	}
	public void setCineplex(Cineplex cineplex) {
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
	public void addMovieShowing(MovieShowing movieshowing) {
		this.showing.add(movieshowing);
	}
	public ArrayList<MovieShowing> getMovieShowing(){
		return this.showing;
	}
}
