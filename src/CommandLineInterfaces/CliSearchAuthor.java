package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbSearchAuthors;
import Main.KeyScanner;

/**
 * This Command Line Terminal class allows the user to search for an author.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class CliSearchAuthor {
	/**
	 * This Command Line Terminal class allows the user to search for an
	 * author. It then supplies the correct SQL query to DbSearchAuthors.searchAuthors
	 * to find matching records.
	 * @throws FileNotFoundException if DbInterface.DbLogin unable to access user file.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 */
	public static void searchAuthorMenu() throws FileNotFoundException, SQLException {
				
		//  Scanner Variable
		Scanner searchAuthorScanner = KeyScanner.keyInput;
		String userInput = "";
				
		// SQL Search Variables
		String searchVariable = ""; 
							
		System.out.println("\n*****  Search Author  *****");
		System.out.println();
		System.out.println("Enter Author Name");
		System.out.println("Search will function with part words");
		System.out.println();
		System.out.println("0.  Main Menu");
		System.out.println("Please enter selection");
				
		while (searchAuthorScanner.hasNextLine()) {
			userInput = searchAuthorScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
				}
			else {
				searchVariable = userInput;
				break;
			}
		}
				
		String sqlSearchAuthor = "SELECT * FROM authors WHERE author_id "
							+ "LIKE '%" + searchVariable + "%' OR "
							+ "author_firstname LIKE '%" + searchVariable + "%' OR "
							+ "author_surname LIKE '%" + searchVariable + "%';";
		System.out.println(DbSearchAuthors.searchAuthors(sqlSearchAuthor) + " author search.");
				
		CliMainPage.mainPage();
	}
}