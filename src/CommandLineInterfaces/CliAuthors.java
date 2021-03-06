package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import Main.KeyScanner;

/**
 * This Command Line Terminal class allows the user to manage authors.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class CliAuthors {
	/**
	 * This Command Line Terminal class allows the user to access
	 * sub menus for managing authors in the database.
	 * @throws FileNotFoundException if DbInterface.DbLogin unable to access user file.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 */
	public static void authorsPage() throws FileNotFoundException, SQLException {
		
		String userInput = "";
		Scanner authorsPageScanner = KeyScanner.keyInput;
		
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
				CliAuthorEnter.enterAuthorMenu();
		    	}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				CliAuthorUpdate.updateAuthorMenu();
		    	}
			else if (userInput.equals("3") || userInput.equals("3.")) {
				CliAuthorDelete.deleteAuthorMenu();
		    	}
			else if (userInput.equals("4") || userInput.equals("4.")) {
				CliSearchAuthor.searchAuthorMenu();
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