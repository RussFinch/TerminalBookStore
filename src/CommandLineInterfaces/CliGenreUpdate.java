package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbInterface;
import Main.KeyScanner;

/**
 * This Command Line Terminal class allows the user to update a genre.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class CliGenreUpdate {
	/**
	 * This Command Line Terminal class allows the user to update a genre.
	 * It then supplies the correct SQL query to DbInterface.queryDatabase
	 * for record update in the database.
	 * @throws FileNotFoundException if DbInterface.DbLogin unable to access user file.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 */
	public static void updateGenreMenu() throws FileNotFoundException, SQLException {
		
		//  Scanner Variable
		String userInput = "";
		Scanner updateGenreScanner = KeyScanner.keyInput;
		
		// SQL Update Author Variables
		String genre_id = "";
		String updateVariable = ""; 
					
		System.out.println("\n*****  Update Genre  *****");
		System.out.println();
		System.out.println("What would you like to update?");
		System.out.println();
		System.out.println("1.  Genre ID");
		System.out.println("2.  Genre Name");
		System.out.println();
		System.out.println("0.  Main Menu");
		System.out.println("Please enter selection");
		
		while (updateGenreScanner.hasNextLine()) {
			userInput = updateGenreScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else if (userInput.equals("1") || userInput.equals("1.")) {
				System.out.println("Enter Genre ID of record to be updated");
				genre_id = updateGenreScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Genre ID");
				updateVariable = updateGenreScanner.nextLine();
				String sqlUpdateGenreID = "UPDATE genre SET genre_id = '" + updateVariable 
						+ "' WHERE genre_id = '" + genre_id + "';";
				System.out.println("Genre ID update "
						+ DbInterface.queryDatabase(sqlUpdateGenreID));
				CliMainPage.mainPage();
		    	}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				System.out.println("Enter Genre ID of record to be updated");
				genre_id = updateGenreScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Genre Name");
				updateVariable = updateGenreScanner.nextLine();
				String sqlUpdateGenreName = "UPDATE genre SET genre_name = '" + updateVariable 
						+ "' WHERE genre_id = '" + genre_id + "';";
				System.out.println("Author First Name update "
						+ DbInterface.queryDatabase(sqlUpdateGenreName));
				CliMainPage.mainPage();
				}
			else {
				System.out.println("Please make a valid selection.");
			}
		}
	}

}
