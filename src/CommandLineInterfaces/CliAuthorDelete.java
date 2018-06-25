package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbInterface;
import Main.KeyScanner;

/**
 * This Command Line Terminal class allows the user to delete an author.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class CliAuthorDelete {
	/**
	 * This Command Line Terminal class allows the user to enter an author
	 * ID for deletion.  It then supplies the correct SQL query to
	 * DbInterface.queryDatabase for record deletion from the database.
	 * @throws FileNotFoundException if DbInterface.DbLogin unable to access user file.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 */
	public static void deleteAuthorMenu() throws FileNotFoundException, SQLException {
		
		//  Scanner Variable
		String userInput = "";
		Scanner deleteAuthorScanner = KeyScanner.keyInput;
		
		//  SQL deleteAuthor variables
		String author_id = "";
		
		System.out.println("\n*****  Delete Author  *****");
		System.out.println("0.  Main Menu - at any time");
		System.out.println("\n1 0f 1 - Enter Author ID");
		while (deleteAuthorScanner.hasNextLine()) {
			userInput = deleteAuthorScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else if (userInput.equals("")) {
				System.out.println("Author ID cannot be blank.  Please enter.");
				}
			else {
				author_id = userInput;
				break;
				}
		}
		
		String sqlDeleteAuthor = "DELETE FROM authors WHERE author_id = '" + author_id + "';";
		System.out.println("Deletion of Author " 
				+ DbInterface.queryDatabase(sqlDeleteAuthor));
		
		CliMainPage.mainPage();
	}
}