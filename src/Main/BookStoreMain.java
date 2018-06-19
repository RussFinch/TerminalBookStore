package Main;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import CommandLineInterfaces.CliMainPage;

public class BookStoreMain {

	public static void main(String args[]) throws FileNotFoundException, SQLException {
		
		//begin program with user login
		String userState = "loggedOut";
		int loginTries = 0;
		
		for (loginTries=0; loginTries<=2; loginTries++) {
			if (userState.equals("loggedOut")) {
				userState = Login.run();
				}
			else if (userState.equals("loggedIn")) {
				System.out.println("\nYou've logged in...");
				CliMainPage.mainPage();
				break;
				}
		}
		
		System.out.println("Login attempts exceeded.  Program closed.");
		System.exit(0);
	}
	//public scanner to call whenever terminal input required anywhere in program
	public final static Scanner keyInput = new Scanner(System.in);
}