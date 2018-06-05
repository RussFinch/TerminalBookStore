import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class CliGenre {
	
	public static void GenrePage() throws FileNotFoundException, SQLException {
		
		String userInput = "";
		Scanner GenrePageScanner = BookStoreMain.keyInput;
		
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