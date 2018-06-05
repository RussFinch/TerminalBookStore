import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class CliSearchGenre {

	public static void searchGenreMenu() throws FileNotFoundException, SQLException {
		
		//  Scanner Variable
		Scanner searchGenreScanner = BookStoreMain.keyInput;
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