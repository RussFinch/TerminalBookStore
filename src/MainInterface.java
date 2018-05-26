import java.util.Scanner;

public class MainInterface {
	
	public static void mainPage() {
		
		String userInput = "";
		Scanner mainPageScanner = BookStoreMain.keyInput;
		
		System.out.println("\n*****  Main Page *****");
		System.out.println();
		System.out.println("1. Enter book");
		System.out.println("2. Update book");
		System.out.println("3. Delete book");
		System.out.println("4. Search books");
		System.out.println("0. Exit\n");
		System.out.println("Please enter selection: ");

		while (mainPageScanner.hasNextLine()) {
			userInput = mainPageScanner.nextLine();
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
				SearchBook.searchBookMenu();
		    	}
			else if (userInput.equals("0") || userInput.equals("0.")) {
				System.exit(0);  // look at this again later
				}
			else {
				System.out.println("Invalid Selection:");
				System.out.println("Please enter a valid selection: ");
			}
		}
	}
}
