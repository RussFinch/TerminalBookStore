package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbSearchGenre;
import Main.KeyScanner;

/**
 * This Command Line Terminal class allows the user to search for a genre.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class CliSearchGenre {
	/**
	 * This Command Line Terminal class allows the user to search for a genre
	 * It then supplies the correct SQL query to DbSearchGenre.searchGenre
	 * for matching records in the database.
	 * @throws FileNotFoundException if DbInterface.DbLogin unable to access user file.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 */
	public static void searchGenreMenu() throws FileNotFoundException, SQLException {
		
		//  Scanner Variable
		Scanner searchGenreScanner = KeyScanner.keyInput;
		String userInput = "";
				
		// SQL Search Variables
		String searchVariable = ""; 
							
		System.out.println("\n*****  Search Genre  *****");
		System.out.println();
		System.out.println("Enter Genre Name");
		System.out.println("Search will function with part words");
		System.out.println();
		System.out.println("0.  Main Menu");
		System.out.println("Please enter selection");
				
		while (searchGenreScanner.hasNextLine()) {
			userInput = searchGenreScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
				}
			else {
				searchVariable = userInput;
				break;
			}
		}
				
		String sqlSearchGenre = "SELECT * FROM genre WHERE genre_id "
							+ "LIKE '%" + searchVariable + "%' OR "
							+ "genre_name LIKE '%" + searchVariable + "%';";
		System.out.println(DbSearchGenre.searchGenre(sqlSearchGenre) + " genre search.");
				
		CliMainPage.mainPage();
	}
}