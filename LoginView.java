package com.views;
import com.controllers.*;

public class LoginView extends View {
	
	public void start()
	{

	        System.out.println("Please login to access staff system.");

	        String username = IOController.readString("Please enter your username: ");
	        String password = IOController.readString("Please enter your password: ");
	        
	        boolean validate = true; //Initially
	        
	        if(validate == true)
	        {
	        	intent(this, new StaffHomePageView());
	        }

	        
	}

}
