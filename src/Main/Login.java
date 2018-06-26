package Main;

import java.io.FileNotFoundException;
import java.util.Scanner;

import DBInterfaces.DbInterface;

/**
 * This class manages the user login process.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class Login {
	/**
	 * This method matches user input credentials against those specified
	 * in the file accessed by DbInterface.DbLogin.
	 * @throws FileNotFoundException if DbInterface.DbLogin missing login file.
	 * @return state User Login state of loggedOut or loggedIn.
	 */

	public static String run() throws FileNotFoundException {
		
		String userName = "";
		String password = "";
		String state = "loggedOut";
		String inputUsername = "";
		String inputPass = "";

		String loginString = DbInterface.DbLogin();
		
		String data[] = loginString.split(",");
        userName = data[0];
        password = data[1];
		
		Scanner keyboard = KeyScanner.keyInput;
	    
	    System.out.println("Please enter user credentials:");
	    System.out.println("Username:");
	    
	    while (keyboard.hasNextLine()) {
			inputUsername = keyboard.nextLine();
			System.out.println("Password:");
			inputPass = keyboard.nextLine();
			break;
	    	}
		if (inputUsername.equals(userName) && inputPass.equals(password)) {
			System.out.print("\nHello " + inputUsername + "\n");
			state = "loggedIn";
			}
		else {
			System.out.println(inputUsername + " your username or password is incorrect.\n");
			state = "loggedOut";
			}
	return state;
	}
}