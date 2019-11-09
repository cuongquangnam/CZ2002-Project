package controller;
import java.util.Scanner;
import model.*;
import view.*;
public class LoginController {
	
	public static void  getUsername() 
	{
		Scanner sc = new Scanner(System.in);
		String username = sc.next();
	}
	
	public static void getPassword() 
	{
		Scanner sc = new Scanner(System.in);
		String password = sc.next();
	}
	
	LoginService service = new LoginService();
	
	public boolean isUserValid(Cineplex c, String username, String password)
	{
		boolean validate = service.validateUser(c, username, password);
		return validate;
	}
	

}
