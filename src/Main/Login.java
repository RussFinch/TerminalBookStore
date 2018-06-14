package Main;
import java.io.FileNotFoundException;
import java.util.Scanner;

import DBInterfaces.DbInterface;

public class Login {

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
		
		Scanner keyboard = BookStoreMain.keyInput;
	    
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
//			String DbConSetupString = DbSetupManager.dbLogin(inputUsername, inputPass);
//			System.out.println(DbConSetupString);
			state = "loggedIn";
			}
		else {
			System.out.print(inputUsername + " your username or password is incorrect.\n");
			state = "loggedOut";
			}
	return state;
	}
}