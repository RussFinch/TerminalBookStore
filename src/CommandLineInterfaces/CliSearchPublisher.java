package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbSearchPublishers;
import Main.KeyScanner;

/**
 * This Command Line Terminal class allows the user to search for a publisher.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class CliSearchPublisher {
	/**
	 * This Command Line Terminal class allows the user to search for a publisher.
	 * It then supplies the correct SQL query to DbSearchPublishers.searchPublishers
	 * for matching records in the database.
	 * @throws FileNotFoundException if DbInterface.DbLogin unable to access user file.
	 * @throws SQLException if DbSearchPublishers.searchPublishers unable to successfully
	 * query database
	 */
	public static void searchPublisherMenu() throws FileNotFoundException, SQLException {
		
		//  Scanner Variable
		Scanner searchPublisherScanner = KeyScanner.keyInput;
		String userInput = "";
		
		// SQL Search Variables
		String searchVariable = ""; 
					
		System.out.println("\n*****  Search Publisher  *****");
		System.out.println();
		System.out.println("Enter Publisher Name");
		System.out.println("Search will function with part words");
		System.out.println();
		System.out.println("0.  Main Menu");
		System.out.println("Please enter selection");
		
		while (searchPublisherScanner.hasNextLine()) {
			userInput = searchPublisherScanner.nextLine();
			if (searchVariable.equals("0") || searchVariable.equals("0.")) {
				CliMainPage.mainPage();
				}
			else {
				searchVariable = userInput;
				break;
			}
		}
		
		String sqlSearchPublisher = "SELECT * FROM publishers WHERE publisher_id "
									+ "LIKE '%" + searchVariable + "%' OR "
									+ "publisher_name LIKE '%" + searchVariable + "%';";
		System.out.println(DbSearchPublishers.searchPublishers(sqlSearchPublisher) + " publisher search.");
		
		CliMainPage.mainPage();
	}
}