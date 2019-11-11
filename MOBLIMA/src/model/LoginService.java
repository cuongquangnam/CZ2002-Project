package model;

public class LoginService {
	private static final String FILENAME_ADMINACCOUNT = "src/data/adminAccount.dat";

	public boolean validateUser(String username, String password)
	{
		return(username.equals("a") && password.equals("a"));
	}

}
