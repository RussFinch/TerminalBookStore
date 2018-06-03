import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletePublisher {
	
	public static void deletePublisherMenu() throws FileNotFoundException, SQLException {
		
		//  Scanner Variable
		String userInput = "";
		Scanner deletePublisherScanner = BookStoreMain.keyInput;
		
		//SQL Delete Publisher variables
		String publisher_id = "";
		
		System.out.println("\n*****  Delete Publisher  *****");
		System.out.println("0.  Main Menu - at any time");
		System.out.println("\n1 0f 1 - Enter Publisher ID");
		while (deletePublisherScanner.hasNextLine()) {
			userInput = deletePublisherScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("")) {
				System.out.println("Publisher ID cannot be blank.  Please enter.");
				}
			else {
				publisher_id = userInput;
				break;
			}
		}
		
		String sqlDeleteBook = "DELETE FROM publishers WHERE publisher_id = '" + publisher_id + "';";
		System.out.println("Deletion of Publisher " 
						+ DbConnection.queryDatabase(sqlDeleteBook));
		
		MainInterface.mainPage();
	}
}
