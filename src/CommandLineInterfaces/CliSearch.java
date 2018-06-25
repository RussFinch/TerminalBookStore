package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import Main.KeyScanner;

public class CliSearch {
	
	public static void searchMenu() throws FileNotFoundException, SQLException {
		
			//  Scanner Variable
			String userInput = "";
			Scanner searchScanner = KeyScanner.keyInput;
						
			System.out.println("\n*****  Search  *****");
			System.out.println();
			System.out.println("What would you like to find?");
			System.out.println();
			System.out.println("1.  Book");
			System.out.println("2.  Author");
			System.out.println("3.  Publisher");
			System.out.println("4.  Genre");
			System.out.println();
			System.out.println("0.  Main Menu");
			System.out.println("Please enter selection");
			
			while (searchScanner.hasNextLine()) {
				userInput = searchScanner.nextLine();
				if (userInput.equals("1") || userInput.equals("1.")) {
					CliSearchBook.SearchBookMenu();
			    	}
				else if (userInput.equals("2") || userInput.equals("2.")) {
					CliSearchAuthor.searchAuthorMenu();
			    	}
				else if (userInput.equals("3") || userInput.equals("3.")) {
					CliSearchPublisher.searchPublisherMenu();
			    	}
				else if (userInput.equals("4") || userInput.equals("4.")) {
					CliSearchGenre.searchGenreMenu();
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