import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchAuthor {
	
	public static void searchAuthorMenu() throws FileNotFoundException {
				
		//  Scanner Variable
		Scanner searchAuthorScanner = BookStoreMain.keyInput;
		String userInput = "";
				
		// SQL Search Variables
		String searchVariable = ""; 
							
		System.out.println("\n*****  Search Author  *****");
		System.out.println();
		System.out.println("Enter Author Name");
		System.out.println("Search will function with part words");
		System.out.println();
		System.out.println("0.  Main Menu");
		System.out.println("Please enter selection");
				
		while (searchAuthorScanner.hasNextLine()) {
			userInput = searchAuthorScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
				}
			else {
				searchVariable = userInput;
				break;
			}
		}
				
		String sqlSearchAuthor = "SELECT * FROM authors WHERE author_id "
							+ "LIKE '%" + searchVariable + "%' OR "
							+ "author_firstname LIKE '%" + searchVariable + "%' OR "
							+ "author_surname LIKE '%" + searchVariable + "%';";
		System.out.println(DbSearchAuthors.searchAuthors(sqlSearchAuthor) + " author search.");
				
		MainInterface.mainPage();
	}
}