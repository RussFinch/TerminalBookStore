import java.io.FileNotFoundException;
import java.util.Scanner;

public class DeleteBook {
	
	public static void deleteBookMenu() throws FileNotFoundException {
	
		//  This needs completing
		
		//  Scanner Variable
		String userInput = "";
		Scanner deleteBookScanner = BookStoreMain.keyInput;
		
		System.out.println("\n*****  Delete Book  *****");
		System.out.println("0.  Main Menu - at any time");
		while (deleteBookScanner.hasNextLine()) {
			userInput = deleteBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else {
				System.out.println("Book ID cannot be blank.  Please enter.");
			}
		}
	}
}