import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteAuthor {
	
	public static void deleteAuthorMenu() throws FileNotFoundException, SQLException {
		
		//  Scanner Variable
		String userInput = "";
		Scanner deleteAuthorScanner = BookStoreMain.keyInput;
		
		//  SQL deleteAuthor variables
		String author_id = "";
		
		System.out.println("\n*****  Delete Author  *****");
		System.out.println("0.  Main Menu - at any time");
		System.out.println("\n1 0f 1 - Enter Author ID");
		while (deleteAuthorScanner.hasNextLine()) {
			userInput = deleteAuthorScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("")) {
				System.out.println("Author ID cannot be blank.  Please enter.");
				}
			else {
				author_id = userInput;
				break;
				}
		}
		
		String sqlDeleteAuthor = "DELETE FROM authors WHERE author_id = '" + author_id + "';";
		System.out.println("Deletion of Author " 
				+ DbConnection.queryDatabase(sqlDeleteAuthor));
		
		MainInterface.mainPage();
	}
}