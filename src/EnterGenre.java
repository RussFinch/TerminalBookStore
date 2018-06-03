import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class EnterGenre {
	
	public static void enterGenreMenu() throws FileNotFoundException, SQLException {
		
	//  Scanner Variable
	String userInput = "";
	
	//SQL Insert Author variables
	String genre_id = "";
	String genre_name = "";
	
	Scanner enterGenreScanner = BookStoreMain.keyInput;
	
	//Interface output and navigation
	System.out.println("\n*****  Enter Genre *****");
	System.out.println("0.  Main Menu - at any time");
	System.out.println("\n1 of 2 - Enter Genre ID:");
	
	while (enterGenreScanner.hasNextLine()) {
		userInput = enterGenreScanner.nextLine();
		if (userInput.equals("0") || userInput.equals("0.")) {
			MainInterface.mainPage();
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
			MainInterface.mainPage();
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
	System.out.println("Genre update " + DbConnection.queryDatabase(sqlInsertAuthor));
	
	MainInterface.mainPage();
	}
}
