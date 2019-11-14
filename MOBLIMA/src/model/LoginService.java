package model;

import controller.DataController;

import java.io.IOException;
import java.util.HashMap;

public class LoginService {
	private static final String FILENAME_ADMINACCOUNT = "src/data/adminAccount.dat";
	static HashMap<String, String> adminAccount;

	static {
		try {
			adminAccount = (HashMap<String, String>) DataController.readSerializedObject(FILENAME_ADMINACCOUNT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean validateUser(String username, String password)
	{

		return(adminAccount.containsKey(username) && password.equals(adminAccount.get(username)));
	}

}
