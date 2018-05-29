import java.io.FileNotFoundException;
import java.util.Scanner;

public class UpdateBook {
	
	public static void updateBookMenu() throws FileNotFoundException {
		
		//  This needs completing
			
		//  Scanner Variable
		String userInput = "";
		Scanner updateBookScanner = BookStoreMain.keyInput;
			
		System.out.println("\n*****  Update Book  *****");
		System.out.println("0.  Main Menu - at any time");
		while (updateBookScanner.hasNextLine()) {
			userInput = updateBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else {
				System.out.println("Book ID cannot be blank.  Please enter.");
			}
		}
	}
}