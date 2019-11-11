package controller;
import java.util.Scanner;
import model.*;

public class LoginController {
	public static String getUsername()
	{
		Scanner sc = new Scanner(System.in);
		String username = sc.next();
		return username;
	}
	
	public static String getPassword()
	{
		Scanner sc = new Scanner(System.in);
		String password = sc.next();
		return password;
	}

	public static boolean isUserValid(String username, String password)
	{
		LoginService service = new LoginService();
		boolean validate = service.validateUser(username, password);
		return validate;
	}
	

}
