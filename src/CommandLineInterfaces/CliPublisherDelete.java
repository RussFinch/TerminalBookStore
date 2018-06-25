package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbInterface;
import Main.KeyScanner;

/**
 * This Command Line Terminal class allows the user to delete a publisher.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class CliPublisherDelete {
	/**
	 * This Command Line Terminal class allows the user to delete a publisher
	 * It then supplies the correct SQL query to DbInterface.queryDatabase for
	 * record deletion from the database.
	 * @throws FileNotFoundException if DbInterface.DbLogin unable to access user file.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 */
	public static void deletePublisherMenu() throws FileNotFoundException, SQLException {
		
		//  Scanner Variable
		String userInput = "";
		Scanner deletePublisherScanner = KeyScanner.keyInput;
		
		//SQL Delete Publisher variables
		String publisher_id = "";
		
		System.out.println("\n*****  Delete Publisher  *****");
		System.out.println("0.  Main Menu - at any time");
		System.out.println("\n1 0f 1 - Enter Publisher ID");
		while (deletePublisherScanner.hasNextLine()) {
			userInput = deletePublisherScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else if (userInput.equals("")) {
				System.out.println("Publisher ID cannot be blank.  Please enter.");
				}
			else {
				publisher_id = userInput;
				break;
			}
		}
		
		String sqlDeleteBook = "DELETE FROM publishers WHERE publisher_id = '" + publisher_id + "';";
		System.out.println("Deletion of Publisher " 
						+ DbInterface.queryDatabase(sqlDeleteBook));
		
		CliMainPage.mainPage();
	}
}
