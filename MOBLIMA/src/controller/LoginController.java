package controller;
import java.util.Scanner;

import static model.LoginService.validateUser;

public class LoginController {
    static Scanner sc = new Scanner(System.in);
	public static String inputUsername()
	{
		String username = sc.next();
		return username;
	}
	
	public static String inputPassword()
	{
		String password = sc.next();
		return password;
	}

	public static boolean isUserValid(String username, String password) {
		boolean validate = validateUser(username, password);
		return validate;
	}
	

}
