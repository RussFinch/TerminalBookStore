import java.io.FileNotFoundException;
import java.util.Scanner;

public class Search {
	
	public static void searchMenu() throws FileNotFoundException {
		
			//  Scanner Variable
			String userInput = "";
			Scanner searchScanner = BookStoreMain.keyInput;
						
			System.out.println("\n*****  Search  *****");
			System.out.println();
			System.out.println("What would you like to find?");
			System.out.println();
			System.out.println("1.  Book");
			System.out.println("2.  Author");
			System.out.println("3.  Publisher");
			System.out.println();
			System.out.println("0.  Main Menu");
			System.out.println("Please enter selection");
			
			while (searchScanner.hasNextLine()) {
				userInput = searchScanner.nextLine();
				if (userInput.equals("1") || userInput.equals("1.")) {
					SearchBook.SearchBookMenu();
			    	}
				else if (userInput.equals("2") || userInput.equals("2.")) {
					SearchAuthor.searchAuthorMenu();
			    	}
				else if (userInput.equals("3") || userInput.equals("3.")) {
					SearchPublisher.searchPublisherMenu();
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