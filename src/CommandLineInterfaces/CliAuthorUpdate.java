package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbInterface;
import Main.KeyScanner;

/**
 * This Command Line Terminal class allows the user to update an author.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class CliAuthorUpdate {
	/**
	 * This Command Line Terminal class allows the user to update an author
	 * that already exists in the system.  It then supplies the correct SQL query to
	 * DbInterface.queryDatabase for record update in the database.
	 * @throws FileNotFoundException if DbInterface.DbLogin unable to access user file.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 */
	public static void updateAuthorMenu() throws FileNotFoundException, SQLException {
			
		//  Scanner Variable
		String userInput = "";
		Scanner updateAuthorScanner = KeyScanner.keyInput;
		
		// SQL Update Author Variables
		String author_id = "";
		String updateVariable = ""; 
					
		System.out.println("\n*****  Update Author  *****");
		System.out.println();
		System.out.println("What would you like to update?");
		System.out.println();
		System.out.println("1.  Author ID");
		System.out.println("2.  First Name");
		System.out.println("3.  Surname");	
		System.out.println();
		System.out.println("0.  Main Menu");
		System.out.println("Please enter selection");
		
		while (updateAuthorScanner.hasNextLine()) {
			userInput = updateAuthorScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else if (userInput.equals("1") || userInput.equals("1.")) {
				System.out.println("Enter Author ID of record to be updated");
				author_id = updateAuthorScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Author ID");
				updateVariable = updateAuthorScanner.nextLine();
				String sqlUpdateAuthorID = "UPDATE authors SET author_id = '" + updateVariable 
						+ "' WHERE author_id = '" + author_id + "';";
				System.out.println("Author ID update "
						+ DbInterface.queryDatabase(sqlUpdateAuthorID));
				CliMainPage.mainPage();
		    	}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				System.out.println("Enter Author ID of record to be updated");
				author_id = updateAuthorScanner.nextLine();
				System.out.println();
				System.out.println("Enter New First Name");
				updateVariable = updateAuthorScanner.nextLine();
				String sqlUpdateAuthorFirstName = "UPDATE authors SET author_firstname = '" + updateVariable 
						+ "' WHERE author_id = '" + author_id + "';";
				System.out.println("Author First Name update "
						+ DbInterface.queryDatabase(sqlUpdateAuthorFirstName));
				CliMainPage.mainPage();
		    	}
			else if (userInput.equals("3") || userInput.equals("3.")) {
				System.out.println("Enter Author ID of record to be updated");
				author_id = updateAuthorScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Surame");
				updateVariable = updateAuthorScanner.nextLine();
				String sqlUpdateAuthorSurname = "UPDATE authors SET author_surname = '" + updateVariable 
						+ "' WHERE author_id = '" + author_id + "';";
				System.out.println("Author Surname update "
						+ DbInterface.queryDatabase(sqlUpdateAuthorSurname));
				CliMainPage.mainPage();
		    	}
			else {
				System.out.println("Please make a valid selection.");
			}
		}
	}
}

