import java.io.FileNotFoundException;
import java.util.Scanner;

public class Search {
	
	public static void searchMenu() throws FileNotFoundException {
		
		//  Scanner Variable
		String userInput = "";
		
		//MySQL Login details
//		String fileScanUser = "";
//		String fileScanPass = "";
		
		Scanner enterSearchScanner = BookStoreMain.keyInput;
		
		//Interface output and navigation
		System.out.println("\n*****  Search Menu *****");
		System.out.println("0.  Main Menu - at any time");
		while (enterSearchScanner.hasNextLine()) {    			//Validate ID number is int
			userInput = enterSearchScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
			   	}
			else {
				System.out.println("Search cannot be blank.  Please enter.");
			}
		}
	}
}
