package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbInterface;
import Main.KeyScanner;

/**
 * This Command Line Terminal class allows the user to delete a book.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class CliBookDelete {
	/**
	 * This Command Line Terminal class allows the user to enter a book
	 * ID for deletion.  It then supplies the correct SQL query to
	 * DbInterface.queryDatabase for record deletion from the database.
	 * @throws FileNotFoundException if DbInterface.DbLogin unable to access user file.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 */
	public static void deleteBookMenu() throws FileNotFoundException, SQLException {
		
		//  Scanner Variable
		String userInput = "";
		Scanner deleteBookScanner = KeyScanner.keyInput;
		
		//SQL Delete book variables
		String book_id = "";
		
		System.out.println("\n*****  Delete Book  *****");
		System.out.println("0.  Main Menu - at any time");
		System.out.println("\n1 0f 1 - Enter Book ID");
		while (deleteBookScanner.hasNextLine()) {
			userInput = deleteBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else if (userInput.equals("")) {
				System.out.println("Book ID cannot be blank.  Please enter.");
				}
			else {
				book_id = userInput;
				break;
			}
		}
		
		String sqlDeleteBook = "DELETE FROM books WHERE id = '" + book_id + "';";
		System.out.println("Deletion of Book " 
						+ DbInterface.queryDatabase(sqlDeleteBook));
		
		CliMainPage.mainPage();
	}
}