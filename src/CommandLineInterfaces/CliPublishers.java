package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import Main.KeyScanner;

/**
 * This Command Line Terminal class allows the user to manage publishers.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class CliPublishers {
	/**
	 * This Command Line Terminal class allows the user to access
	 * sub menus for managing publishers in the database.
	 * @throws FileNotFoundException if DbInterface.DbLogin unable to access user file.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 */
	public static void PublishersPage() throws FileNotFoundException, SQLException {
		
		String userInput = "";
		Scanner PublishersPageScanner = KeyScanner.keyInput;
		
		System.out.println("\n*****  Publishers Page *****");
		System.out.println();
		System.out.println("1. Enter Publisher");
		System.out.println("2. Update Publisher");
		System.out.println("3. Delete Publisher");
		System.out.println("4. Search");
		System.out.println();
		System.out.println("0. Main Menu");
		System.out.println("Please enter selection: ");

		while (PublishersPageScanner.hasNextLine()) {
			userInput = PublishersPageScanner.nextLine();
			if (userInput.equals("1") || userInput.equals("1.")) {
				CliPublisherEnter.enterPublisherMenu();
		    	}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				CliPublisherUpdate.updatePublisherMenu();
		    	}
			else if (userInput.equals("3") || userInput.equals("3.")) {
				CliPublisherDelete.deletePublisherMenu();
		    	}
			else if (userInput.equals("4") || userInput.equals("4.")) {
				CliSearchPublisher.searchPublisherMenu();
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