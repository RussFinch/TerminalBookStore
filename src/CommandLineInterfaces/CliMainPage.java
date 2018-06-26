package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import Main.KeyScanner;

/**
 * This Command Line Terminal class is the systems Main terminal page.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class CliMainPage {
	/**
	 * This Command Line Terminal class is the system main page.
	 * It allows users to drop into sub menus for managing
	 * books, searching, system settings and quitting
	 * @throws FileNotFoundException if DbInterface.DbLogin unable to access user file.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 */
	public static void mainPage() throws FileNotFoundException, SQLException {
		
		String userInput = "";
		Scanner mainPageScanner = KeyScanner.keyInput;
		
		System.out.println("\n*****  Main Page *****");
		System.out.println();
		System.out.println("1. Books");
		System.out.println("2. Authors");
		System.out.println("3. Publishers");
		System.out.println("4. Genre");
		System.out.println("5. Search");
		System.out.println();
		System.out.println("6. Settings");
		System.out.println();
		System.out.println("0. Quit\n");
		System.out.println("Please enter selection: ");

		while (mainPageScanner.hasNextLine()) {
			userInput = mainPageScanner.nextLine();
			if (userInput.equals("1") || userInput.equals("1.")) {
				CliBooks.booksPage();
		    	}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				CliAuthors.authorsPage();
		    	}
			else if (userInput.equals("3") || userInput.equals("3.")) {
				CliPublishers.PublishersPage();
		    	}
			else if (userInput.equals("4") || userInput.equals("4.")) {
				CliGenre.GenrePage();
		    	}
			else if (userInput.equals("5") || userInput.equals("5.")) {
				CliSearch.searchMenu();
		    	}
			else if (userInput.equals("6") || userInput.equals("6.")) {
				CliSettings.setupPage();
		    	}
			else if (userInput.equals("0") || userInput.equals("0.")) {
				System.out.println("System Quit...");
				System.exit(0);
				}
			else {
				System.out.println("Invalid Selection:");
				System.out.println("Please enter a valid selection: ");
			}
		}
	}
}
