import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateAuthor {
	
	public static void updateAuthorMenu() throws FileNotFoundException, SQLException {
			
		//  Scanner Variable
		String userInput = "";
		Scanner updateAuthorScanner = BookStoreMain.keyInput;
		
		// SQL Update Author Variables
		String author_id = "";
		String updateVariable = ""; 
					
		System.out.println("\n*****  Update Author  *****");
		System.out.println();
		System.out.println("What would you like to update?");
		System.out.println();
		System.out.println("1.  Author ID");
		System.out.println("2.  First Name");
		System.out.println("3.  Surname");	
		System.out.println();
		System.out.println("0.  Main Menu");
		System.out.println("Please enter selection");
		
		while (updateAuthorScanner.hasNextLine()) {
			userInput = updateAuthorScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("1") || userInput.equals("1.")) {
				System.out.println("Enter Author ID of record to be updated");
				author_id = updateAuthorScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Author ID");
				updateVariable = updateAuthorScanner.nextLine();
				String sqlUpdateAuthorID = "UPDATE authors SET author_id = '" + updateVariable 
						+ "' WHERE author_id = '" + author_id + "';";
				System.out.println("Author ID update "
						+ DbConnection.queryDatabase(sqlUpdateAuthorID));
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				System.out.println("Enter Author ID of record to be updated");
				author_id = updateAuthorScanner.nextLine();
				System.out.println();
				System.out.println("Enter New First Name");
				updateVariable = updateAuthorScanner.nextLine();
				String sqlUpdateAuthorFirstName = "UPDATE authors SET author_firstname = '" + updateVariable 
						+ "' WHERE author_id = '" + author_id + "';";
				System.out.println("Author First Name update "
						+ DbConnection.queryDatabase(sqlUpdateAuthorFirstName));
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("3") || userInput.equals("3.")) {
				System.out.println("Enter Author ID of record to be updated");
				author_id = updateAuthorScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Surame");
				updateVariable = updateAuthorScanner.nextLine();
				String sqlUpdateAuthorSurname = "UPDATE authors SET author_surname = '" + updateVariable 
						+ "' WHERE author_id = '" + author_id + "';";
				System.out.println("Author Surname update "
						+ DbConnection.queryDatabase(sqlUpdateAuthorSurname));
				MainInterface.mainPage();
		    	}
			else {
				System.out.println("Please make a valid selection.");
			}
		}
	}
}

