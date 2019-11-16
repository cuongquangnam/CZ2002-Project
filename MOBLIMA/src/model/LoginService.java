package model;

import controller.DataController;

import java.io.IOException;
import java.util.HashMap;

/**
 * This class contains information on the login service for admin
 */
public class LoginService {
	/**
	 * The path to file that stores the admin account
	 */
	private static final String FILENAME_ADMINACCOUNT = "src/data/adminAccount.dat";
	/**
	 * The admin account
	 */
	static HashMap<String, String> adminAccount;

	static {
		try {
			adminAccount = (HashMap<String, String>) DataController.readSerializedObject(FILENAME_ADMINACCOUNT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method returns the validation of account
	 * @param username The input username
	 * @param password The input password
	 * @return true if the account is admin, false otherwise
	 */
	public static boolean validateUser(String username, String password)
	{

		return(adminAccount.containsKey(username) && password.equals(adminAccount.get(username)));
	}

}
