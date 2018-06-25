package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbInterface;
import Main.KeyScanner;

/**
 * This Command Line Terminal class allows the user to enter a new genre.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class CliGenreEnter {
	/**
	 * This Command Line Terminal class allows the user to enter a new genre.
	 * It then supplies the correct SQL query to DbInterface.queryDatabase
	 * for record addition to the database.
	 * @throws FileNotFoundException if DbInterface.DbLogin unable to access user file.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 */
	public static void enterGenreMenu() throws FileNotFoundException, SQLException {
		
	//  Scanner Variable
	String userInput = "";
	
	//SQL Insert Author variables
	String genre_id = "";
	String genre_name = "";
	
	Scanner enterGenreScanner = KeyScanner.keyInput;
	
	//Interface output and navigation
	System.out.println("\n*****  Enter Genre *****");
	System.out.println("0.  Main Menu - at any time");
	System.out.println("\n1 of 2 - Enter Genre ID:");
	
	while (enterGenreScanner.hasNextLine()) {
		userInput = enterGenreScanner.nextLine();
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
	System.out.println("2 of 2 - Enter Genre Name:");
	while (enterGenreScanner.hasNextLine()) {
		userInput = enterGenreScanner.nextLine();
		if (userInput.equals("0") || userInput.equals("0.")) {
			CliMainPage.mainPage();
	    	}
		else if (userInput.equals("")) {
			System.out.println("Genre name cannot be blank.  Please enter.");
			}
		else {
			genre_name = userInput;
			break;
			}
	}
	//Execute SQL to insert Author
	String sqlInsertAuthor = "INSERT INTO genre VALUES "
			+ "('" + genre_id + "', '"
			+ genre_name + "');";
	System.out.println("Genre update " + DbInterface.queryDatabase(sqlInsertAuthor));
	
	CliMainPage.mainPage();
	}
}
