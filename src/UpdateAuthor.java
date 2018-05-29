import java.io.FileNotFoundException;
import java.util.Scanner;

public class UpdateAuthor {
	
	public static void updateAuthorMenu() throws FileNotFoundException {
		
		//  This needs completing
			
		//  Scanner Variable
		String userInput = "";
		Scanner updateAuthorScanner = BookStoreMain.keyInput;
			
		System.out.println("\n*****  Update Author  *****");
		System.out.println("0.  Main Menu - at any time");
		while (updateAuthorScanner.hasNextLine()) {
			userInput = updateAuthorScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else {
				System.out.println("Author ID cannot be blank.  Please enter.");
			}
		}
	}
}

