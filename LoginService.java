package model;

public class LoginService {
	public boolean validateUser(Cineplex c, String username, String password)
	{
		return(username == c.getStaffusername() && password == c.getStaffpassword());
	}

}
