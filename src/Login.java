import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {

	public static String run() throws FileNotFoundException {
		
		File inputFile = new File("/Users/russellfincham/documents/temp/MySqlLogin.txt");
		Scanner fileScanner = new Scanner(inputFile);
	    Scanner keyboard = new Scanner(System.in);
	    
	    String scanUser = fileScanner.nextLine();
	    String scanPass = fileScanner.nextLine(); 
	    fileScanner.close();
	    
	    System.out.println("Username:");
	    String inputUser = keyboard.nextLine();   //Error here when first login fails...
	    System.out.println("Password:");
	    String inputPass = keyboard.nextLine();
	    keyboard.close();
	    
	    if (inputUser.equals(scanUser) && inputPass.equals(scanPass)) {
	        System.out.print("Hello " + inputUser + "\n");
	        String DbConSetupString = DbConManager.dbLogin(inputUser, inputPass);
	        System.out.println(DbConSetupString);
	        return "loggedIn";
	    } else {
	        System.out.print(inputUser + " your username or password is incorrect.\n");
	        return "loggedOut";
	    } 
	}
}