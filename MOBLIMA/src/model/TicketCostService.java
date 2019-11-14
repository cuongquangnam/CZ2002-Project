package model;

import java.util.ArrayList;

public class TicketCostService
{
	
	public Movie getMovie() {
		return movie;
	}




	public void setMovie(Movie movie) {
		this.movie = movie;
	}




	public Show getShow() {
		return show;
	}




	public void setShow(Show show) {
		this.show = show;
	}




	public Seat getSeat() {
		return seat;
	}




	public void setSeat(Seat seat) {
		this.seat = seat;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public TicketCostService(Movie movie, Show show, Seat seat, double price) {
		super();
		this.movie = movie;
		this.show = show;
		this.seat = seat;
		this.price = price;
	}




	Movie movie;
	Show show;
	Seat seat; //Put an age attribute in seat
	double price;
	
	
	
	
	public double  calculateTicketPriceSeat(Movie movie, ArrayList<Seat> seats, Show show, Cinema cinema)
	{
		
		price =movie.getBasePrice();
		
		if(movie.isBlockBuster() == true)
			price += 5;
		for(Seat s : seats)
		{
			if(s.isSenior() == true)
				price -=5;
		}
		if(show.getTime() == //enum class of holidays)
			price += 5;
		
		if(cinema.is3D() == true)
			price += 5;
		
		if(cinema.isPlatinum() == true)
			price += 5;
		
		return price;
		
	}
}