package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;
import view.*;
public class LoginController {
	
	static Scanner sc = new Scanner(System.in);
	static String username;
	static String password;
	static int cineplex;
	
	

	public static void  inputUsername() 
	{
		
	username = sc.next();
	}
	
	public static void inputPassword() 
	{
	
	password = sc.next();
	}
	
	public static void inputCineplex()
	{
	cineplex = sc.nextInt();
	}
	
	static LoginService service = new LoginService();
	
	public static boolean isUserValid(Cineplex c, String username, String password)
	{
		boolean validate = service.validateUser(c, username, password);
		return validate;
	}
	
	public static void main(String args[]) throws IOException
	{
		LoginView loginview = new LoginView();
		loginview.initialize();
		CineplexController.writeToFile() ;

		     
		String FILENAME_CINEPLEX = "src/DataFolder/cineplexdata.dat";
			   try {
				@SuppressWarnings("unchecked")
				ArrayList <Cineplex> cineplexList= (ArrayList<Cineplex>) DataController.readSerializedObject(FILENAME_CINEPLEX);
				System.out.println(cineplexList);
				boolean b = isUserValid(cineplexList.get(0), username, password);
				System.out.println(b);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			   
			 
	}
		
	}
	


