//Maybe implement change in price for seat section

package com.models;
import com.models.Customer; 

public class TicketCostService {
	private double totalCost;
	
	//function to calculate total cost of 1 movie ticket
	public double totalCostTicket(Customer customer, Cinema cinema, Movie movie)
	{
		totalCost = movie.getBasePrice();
		if(customer.isStudent() == true)
			totalCost += -10;
		
		if(cinema.is3D() == true)
			totalCost += 5;
		
		if(cinema.isPlatinum() == true)
			totalCost += 5;
		
		return totalCost;
			
	}
	

}
