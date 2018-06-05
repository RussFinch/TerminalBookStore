import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class CliBooks {
	
	public static void booksPage() throws FileNotFoundException, SQLException {
		
		String userInput = "";
		Scanner booksPageScanner = BookStoreMain.keyInput;
		
		System.out.println("\n*****  Books Page *****");
		System.out.println();
		System.out.println("1. Enter Book");
		System.out.println("2. Update Book");
		System.out.println("3. Delete Book");
		System.out.println("4. Search");
		System.out.println();
		System.out.println("0. Main Menu");
		System.out.println("Please enter selection: ");

		while (booksPageScanner.hasNextLine()) {
			userInput = booksPageScanner.nextLine();
			if (userInput.equals("1") || userInput.equals("1.")) {
				CliBookEnter.enterBookMenu();
		    	}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				CliBookUpdate.updateBookMenu();
		    	}
			else if (userInput.equals("3") || userInput.equals("3.")) {
				CliBookDelete.deleteBookMenu();
		    	}
			else if (userInput.equals("4") || userInput.equals("4.")) {
				CliSearchBook.SearchBookMenu();
		    	}
			else if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
				}
			else {
				System.out.println("Invalid Selection:");
				System.out.println("Please enter a valid selection: ");
			}
		}
	}
}