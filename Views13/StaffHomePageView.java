package com.views;
import com.controllers.*;
public class StaffHomePageView extends View {
	
	

public void start() {
   
	
        System.out.println("Staff");
        System.out.println("Welcome, please make a selection:");
        System.out.println("1. Modify movie listing");
        System.out.println("2. Configure System Settings");
        System.out.println("3. Modify cinema showtime and movies to be shown");
        System.out.println("4. Logout");

        int choice = IOController.readChoice(1, 4);

        switch (choice) {
            case 1:
                intent(this, new ModMovieListView());
                break;
            case 2:
                
                break;
            case 3:
                intent(this, new ModShowListView());
                break;
            case 4:
                
                break;
            default:
                System.out.println("Invalid selection.");
        }
}
}