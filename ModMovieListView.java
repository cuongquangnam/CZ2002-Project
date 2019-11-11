package com.views;
import com.views.*;

import java.util.Scanner;

import com.controllers.IOController;

public class ModMovieListView extends View {

	
	public void start() {
		
	        System.out.println("Please make a selection:");
	        System.out.println("1. Create movie listing");
	        System.out.println("2. Edit movie listing");
	        System.out.println("3. Remove movie listing");
	        System.out.println("4. Return");
	        Scanner sc = new Scanner (System.in);
	        int choice  = IOController.readChoice(1, 4);
	        
	        switch (choice) {
            case 1:
            	   intent(this, new CreateMovieView());
                break;
            case 2:
            	 intent(this, new UpdateMovieView());
                break;
            case 3:
            		intent(this, new DeleteMovieView());
                break;
            case 4:
                
                break;
            default:
                System.out.println("Invalid selection.");
        }
	         
	    }
		
	}


