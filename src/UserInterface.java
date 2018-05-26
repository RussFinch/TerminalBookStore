import java.util.Scanner;

public class UserInterface {
	
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
				enterBookMenu();
		    	}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				updateBookMenu();
		    	}
			else if (userInput.equals("3") || userInput.equals("3.")) {
				deleteBookMenu();
		    	}
			else if (userInput.equals("4") || userInput.equals("4.")) {
				searchBookMenu();
		    	}
			else if (userInput.equals("0") || userInput.equals("0.")) {
				searchBookMenu();
				}
			else {
				System.out.println("Invalid Selection:");
				System.out.println("Please enter a valid selection: ");
				}
			}
		}
	
	public static void enterBookMenu() {
		System.out.println("This is the enter book menu");
	}
	
	public static void updateBookMenu() {
		System.out.println("This is the update book menu");
	}
	
	public static void deleteBookMenu() {
		System.out.println("This is the delete book menu");
	}
	
	public static void searchBookMenu() {
		System.out.println("This is the search book menu");
	}
}
