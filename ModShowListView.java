package com.views;

import java.util.Scanner;

import com.controllers.IOController;

public class ModShowListView extends View{
	public void start()
	{
		System.out.println("Please make a selection:");
        System.out.println("1. Create a show");
        System.out.println("2. Edit a show");
        System.out.println("3. Remove a show");
        System.out.println("4. Return");
        Scanner sc = new Scanner (System.in);
        int choice  = IOController.readChoice(1, 4);
        
        switch (choice) {
        case 1:
        	   intent(this, new CreateShowView());
            break;
        case 2:
            
            break;
        case 3:
            
            break;
        case 4:
            
            break;
        default:
            System.out.println("Invalid selection.");
	}

}
}
