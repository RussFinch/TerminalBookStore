import java.io.FileNotFoundException;
import java.util.Scanner;

public class AuthorsInterface {
	
	public static void authorsPage() throws FileNotFoundException {
		
		String userInput = "";
		Scanner authorsPageScanner = BookStoreMain.keyInput;
		
		System.out.println("\n*****  Authors Page *****");
		System.out.println();
		System.out.println("1. Enter Author");
		System.out.println("2. Update Author");
		System.out.println("3. Delete Author");
		System.out.println("4. Search");
		System.out.println();
		System.out.println("0. Main Menu");
		System.out.println("Please enter selection: ");

		while (authorsPageScanner.hasNextLine()) {
			userInput = authorsPageScanner.nextLine();
			if (userInput.equals("1") || userInput.equals("1.")) {
				EnterAuthor.enterAuthorMenu();
		    	}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				UpdateAuthor.updateAuthorMenu();
		    	}
			else if (userInput.equals("3") || userInput.equals("3.")) {
				DeleteAuthor.deleteAuthorMenu();
		    	}
			else if (userInput.equals("4") || userInput.equals("4.")) {
				SearchAuthor.searchAuthorMenu();
		    	}
			else if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
				}
			else {
				System.out.println("Invalid Selection:");
				System.out.println("Please enter a valid selection: ");
			}
		}
	}
}