package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbInterface;
import Main.KeyScanner;

/**
 * This Command Line Terminal class allows the user to delete a genre.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class CliGenreDelete {
	/**
	 * This Command Line Terminal class allows the user to delete a genre.
	 * It then supplies the correct SQL query to DbInterface.queryDatabase
	 * for record deletion from the database.
	 * @throws FileNotFoundException if DbInterface.DbLogin unable to access user file.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 */
	public static void deleteGenreMenu() throws FileNotFoundException, SQLException {
	
		//  Scanner Variable
		String userInput = "";
		Scanner deleteGenreScanner = KeyScanner.keyInput;
	
		//  SQL deleteAuthor variables
		String genre_id = "";
	
		System.out.println("\n*****  Delete Genre  *****");
		System.out.println("0.  Main Menu - at any time");
		System.out.println("\n1 0f 1 - Enter Genre ID");
		while (deleteGenreScanner.hasNextLine()) {
			userInput = deleteGenreScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
	    		}
			else if (userInput.equals("")) {
				System.out.println("Genre ID cannot be blank.  Please enter.");
				}
			else {
				genre_id = userInput;
				break;
				}
		}
	
		String sqlDeleteGenre = "DELETE FROM genre WHERE genre_id = '" + genre_id + "';";
		System.out.println("Deletion of genre " 
				+ DbInterface.queryDatabase(sqlDeleteGenre));
	
		CliMainPage.mainPage();
	}
}
