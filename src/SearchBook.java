import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchBook {

	public static void SearchBookMenu() throws FileNotFoundException {
			
		//  Scanner Variable
		Scanner searchPublisherScanner = BookStoreMain.keyInput;
		String userInput = "";
		
		// SQL Search Variables
		String searchVariable = ""; 
					
		System.out.println("\n*****  Search Book  *****");
		System.out.println();
		System.out.println("Enter Book search word");
		System.out.println("Search will function with part words");
		System.out.println();
		System.out.println("0.  Main Menu");
		System.out.println("Please enter selection");
			
		while (searchPublisherScanner.hasNextLine()) {
			userInput = searchPublisherScanner.nextLine();
			if (searchVariable.equals("0") || searchVariable.equals("0.")) {
				MainInterface.mainPage();
				}
			else {
				searchVariable = userInput;
				break;
			}
		}
			
		String sqlSearchBook = "SELECT * FROM books WHERE id LIKE '%" + searchVariable + "%' "
											+ "OR title LIKE '%" + searchVariable + "%' "
											+ "OR genre_id LIKE '%" + searchVariable + "%';"; 
		System.out.println(DbSearchBooks.searchBooks(sqlSearchBook) + " book search.");
			
		MainInterface.mainPage();
	}
}		
