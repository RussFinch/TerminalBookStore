package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbInterface;
import Main.KeyScanner;

public class CliGenreUpdate {
	
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