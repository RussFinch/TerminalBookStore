package Main;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import CommandLineInterfaces.CliMainPage;

/**
 * This main class executes the user login process.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class BookStoreMain {
	/**
	 * This method manages login retries to login.run method.
	 *  Only if loggedIn returned will Terminal menu launch. 
	 *  Exits system if login attempts exceeded.
	 * @param args unused
	 * @throws FileNotFoundException if DbInterface.DbLogin missing login file.
	 * @throws SQLException if program unable to successfully query database
	 */
	public static void main(String args[]) throws FileNotFoundException, SQLException {

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
		//System exit when Login attempts exceeded.
		System.out.println("Login attempts exceeded.  Program closed.");
		System.exit(0);
	}
}