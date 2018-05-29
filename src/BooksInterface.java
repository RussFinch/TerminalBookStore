import java.io.FileNotFoundException;
import java.util.Scanner;

public class BooksInterface {
	
	public static void booksPage() throws FileNotFoundException {
		
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
				EnterBook.enterBookMenu();
		    	}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				UpdateBook.updateBookMenu();
		    	}
			else if (userInput.equals("3") || userInput.equals("3.")) {
				DeleteBook.deleteBookMenu();
		    	}
			else if (userInput.equals("4") || userInput.equals("4.")) {
				Search.searchMenu();
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