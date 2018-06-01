import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchGenre {

	public static void searchGenreMenu() throws FileNotFoundException {
		
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
				MainInterface.mainPage();
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
				
		MainInterface.mainPage();
	}
}