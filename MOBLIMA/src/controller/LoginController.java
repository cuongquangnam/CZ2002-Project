package controller;
import java.util.Scanner;

import static model.LoginService.validateUser;

/**
 * This class handles the login of admin module
 */
public class LoginController {
    static Scanner sc = new Scanner(System.in);

	/**
	 * This method takes username as input and returns it
	 * @return The username
	 */
	public static String inputUsername()
	{
		String username = sc.next();
		return username;
	}

	/**
	 * This method takes password as input and returns it
	 * @return The password
	 */
	public static String inputPassword()
	{
		String password = sc.next();
		return password;
	}

	/**
	 * This methods check whether the user can access admin module or not
	 * @param username The input username
	 * @param password The input password
	 * @return true if username and password provided are correct, false otherwise
	 */
	public static boolean isUserValid(String username, String password) {
		boolean validate = validateUser(username, password);
		return validate;
	}
	

}
