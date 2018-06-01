import java.io.FileNotFoundException;
import java.util.Scanner;

public class UpdateGenre {
	
	public static void updateGenreMenu() throws FileNotFoundException {
		
		//  Scanner Variable
		String userInput = "";
		Scanner updateGenreScanner = BookStoreMain.keyInput;
		
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
				MainInterface.mainPage();
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
						+ DbConnection.queryDatabase(sqlUpdateGenreID));
				MainInterface.mainPage();
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
						+ DbConnection.queryDatabase(sqlUpdateGenreName));
				MainInterface.mainPage();
				}
			else {
				System.out.println("Please make a valid selection.");
			}
		}
	}

}
