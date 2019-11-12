package com.views;
import java.io.IOException;
import java.util.Scanner;

import com.controllers.*;
import com.views.View;


public class MainView extends View {
    public void start()
    {
    	
        
            Scanner sc = new Scanner(System.in);
            
            System.out.println("MOvie Booking and LIsting Management Application (MOBLIMA)");
            System.out.println("Welcome, please make a selection:");
            System.out.println("1. Moviegoer Menu");
            System.out.println("2. Staff Menu");
            System.out.println("3. Exit application");

            int choice = IOController.readChoice(1,3);

            switch (choice) {
                case 1:
                	intent(this, new MovieGoerView());
                    break;
                case 2:
                	intent(this, new LoginView());
                    break;
                case 3:
                    System.out.println("Bye, hope to see you again!");
                   
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }
   public static void main(String[] args) throws IOException
    {
	   ShowController.createCinemaList();
  	MainView mainview = new MainView();
    	mainview.start();
    	}

	
	
}