package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import Main.KeyScanner;

/**
 * This Command Line Terminal class allows the user to manage genre.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class CliGenre {
	/**
	 * This Command Line Terminal class allows the user to access
	 * sub menus for managing books in the database.
	 * @throws FileNotFoundException if DbInterface.DbLogin unable to access user file.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 */
	public static void GenrePage() throws FileNotFoundException, SQLException {
		
		String userInput = "";
		Scanner GenrePageScanner = KeyScanner.keyInput;
		
		System.out.println("\n*****  Genre Page *****");
		System.out.println();
		System.out.println("1. Enter Genre");
		System.out.println("2. Update Genre");
		System.out.println("3. Delete Genre");
		System.out.println("4. Search");
		System.out.println();
		System.out.println("0. Main Menu");
		System.out.println("Please enter selection: ");

		while (GenrePageScanner.hasNextLine()) {
			userInput = GenrePageScanner.nextLine();
			if (userInput.equals("1") || userInput.equals("1.")) {
				CliGenreEnter.enterGenreMenu();
		    	}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				CliGenreUpdate.updateGenreMenu();
		    	}
			else if (userInput.equals("3") || userInput.equals("3.")) {
				CliGenreDelete.deleteGenreMenu();
		    	}
			else if (userInput.equals("4") || userInput.equals("4.")) {
				CliSearchGenre.searchGenreMenu();
		    	}
			else if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
				}
			else {
				System.out.println("Invalid Selection:");
				System.out.println("Please enter a valid selection: ");
			}
		}
	}
}