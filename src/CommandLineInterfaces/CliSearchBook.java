package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbSearchBooks;
import Main.KeyScanner;

/**
 * This Command Line Terminal class allows the user to search for a book.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class CliSearchBook {
	/**
	 * This Command Line Terminal class allows the user to search for a book.
	 * It then supplies the correct SQL query to DbSearchBooks.searchBooks for
	 * retrieval of matching records.
	 * @throws FileNotFoundException if DbInterface.DbLogin unable to access user file.
	 * @throws SQLException if DbSearchBooks.searchBooks unable to successfully
	 * query database
	 */
	public static void SearchBookMenu() throws FileNotFoundException, SQLException {
			
		//  Scanner Variable
		Scanner searchPublisherScanner = KeyScanner.keyInput;
		String userInput = "";
		
		// SQL Search Variables
		String searchVariable = ""; 
					
		System.out.println("\n*****  Search Book  *****");
		System.out.println();
		System.out.println("Enter Book search word");
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
			
		String sqlSearchBook = "SELECT * FROM books WHERE id LIKE '%" + searchVariable + "%' "
											+ "OR title LIKE '%" + searchVariable + "%' "
											+ "OR genre_id LIKE '%" + searchVariable + "%';"; 
		System.out.println(DbSearchBooks.searchBooks(sqlSearchBook) + " book search.");
			
		CliMainPage.mainPage();
	}
}		
