import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {

	public static String run() throws FileNotFoundException {
		
		String state = "loggedOut";
		String fileScanUser = "";
		String fileScanPass = "";
		String inputUsername = "";
		String inputPass = "";

		
		File inputFile = new File("/Users/russellfincham/documents/temp/MySqlLogin.txt");
		Scanner fileScanner = new Scanner(new FileInputStream(inputFile), "UTF-8");
	    Scanner keyboard = new Scanner(System.in);
	    
	    fileScanUser = fileScanner.nextLine();
	    fileScanPass = fileScanner.nextLine(); 
	    fileScanner.close();
	    
	    System.out.println("Please enter user credentials:");
	    System.out.println("Username:");
	    
	    while (keyboard.hasNextLine()) {
			inputUsername = keyboard.nextLine();
			System.out.println("Password:");
			inputPass = keyboard.nextLine();
			break;
	    	}
		if (inputUsername.equals(fileScanUser) && inputPass.equals(fileScanPass)) {
			System.out.print("\nHello " + inputUsername);
			String DbConSetupString = DbConManager.dbLogin(inputUsername, inputPass);
			System.out.println(DbConSetupString);
			state = "loggedIn";
			keyboard.close();
			}
		else {
			System.out.print(inputUsername + " your username or password is incorrect.\n");
			state = "loggedOut";
			}
	return state;
	}
}
	

