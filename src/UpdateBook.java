import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateBook {
	
	public static void updateBookMenu() throws FileNotFoundException, SQLException {
		
		//  Scanner Variable
		String userInput = "";
		Scanner updateBookScanner = BookStoreMain.keyInput;
		
		// SQL Update Author Variables
		String id = "";
		String updateVariable = ""; 
					
		System.out.println("\n*****  Update Book  *****");
		System.out.println();
		System.out.println("What would you like to update?");
		System.out.println();
		System.out.println("1.  ID");
		System.out.println("2.  Title");
		System.out.println("3.  Description");
		System.out.println("4.  Genre ID");
		System.out.println("5.  Price");
		System.out.println("6.  Author ID");
		System.out.println("7.  Publisher ID");
		System.out.println("8.  Publish Date");
		System.out.println("9.  Edition");
		System.out.println("10. Quantity");
		System.out.println();
		System.out.println("0.  Main Menu");
		System.out.println("Please enter selection");
		
		while (updateBookScanner.hasNextLine()) {
			userInput = updateBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("1") || userInput.equals("1.")) {
				System.out.println("Enter Book ID of record to be updated");
				id = updateBookScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Book ID");
				updateVariable = updateBookScanner.nextLine();
				String sqlUpdateBookID = "UPDATE books SET id = '" + updateVariable 
						+ "' WHERE id = '" + id + "';";
				System.out.println("Book ID update "
						+ DbConnection.queryDatabase(sqlUpdateBookID));
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("2") || userInput.equals("2.")) {
				System.out.println("Enter Book ID of record to be updated");
				id = updateBookScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Title");
				updateVariable = updateBookScanner.nextLine();
				String sqlUpdateBookTitle = "UPDATE books SET title = '" + updateVariable 
						+ "' WHERE id = '" + id + "';";
				System.out.println("Book Title update "
						+ DbConnection.queryDatabase(sqlUpdateBookTitle));
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("3") || userInput.equals("3.")) {
				System.out.println("Enter Book ID of record to be updated");
				id = updateBookScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Description");
				updateVariable = updateBookScanner.nextLine();
				String sqlUpdateBookDescription = "UPDATE books SET description = '" + updateVariable 
						+ "' WHERE id = '" + id + "';";
				System.out.println("Book Description update "
						+ DbConnection.queryDatabase(sqlUpdateBookDescription));
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("4") || userInput.equals("4.")) {
				System.out.println("Enter Book ID of record to be updated");
				id = updateBookScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Genre ID");
				updateVariable = updateBookScanner.nextLine();
				String sqlUpdateBookGenre = "UPDATE books SET genre_id = '" + updateVariable 
						+ "' WHERE id = '" + id + "';";
				System.out.println("Book Genre ID update "
						+ DbConnection.queryDatabase(sqlUpdateBookGenre));
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("5") || userInput.equals("5.")) {
				System.out.println("Enter Book ID of record to be updated");
				id = updateBookScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Price");
				updateVariable = updateBookScanner.nextLine();
				String sqlUpdateBookPrice = "UPDATE books SET price = '" + updateVariable 
						+ "' WHERE id = '" + id + "';";
				System.out.println("Book Price update "
						+ DbConnection.queryDatabase(sqlUpdateBookPrice));
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("6") || userInput.equals("6.")) {
				System.out.println("Enter Book ID of record to be updated");
				id = updateBookScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Author ID");
				updateVariable = updateBookScanner.nextLine();
				String sqlUpdateBookAuthorID = "UPDATE books SET author_id = '" + updateVariable 
						+ "' WHERE id = '" + id + "';";
				System.out.println("Book Author ID update "
						+ DbConnection.queryDatabase(sqlUpdateBookAuthorID));
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("7") || userInput.equals("7.")) {
				System.out.println("Enter Book ID of record to be updated");
				id = updateBookScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Publisher ID");
				updateVariable = updateBookScanner.nextLine();
				String sqlUpdateBookPublisherId = "UPDATE books SET publisher_id = '" + updateVariable 
						+ "' WHERE id = '" + id + "';";
				System.out.println("Book Publisher ID update "
						+ DbConnection.queryDatabase(sqlUpdateBookPublisherId));
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("8") || userInput.equals("8.")) {
				System.out.println("Enter Book ID of record to be updated");
				id = updateBookScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Publish Date - YYYYMMDD");
				updateVariable = updateBookScanner.nextLine();
				String sqlUpdateBookPublishDate = "UPDATE books SET publish_date = '" + updateVariable 
						+ "' WHERE id = '" + id + "';";
				System.out.println("Book Publish Date update "
						+ DbConnection.queryDatabase(sqlUpdateBookPublishDate));
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("9") || userInput.equals("9.")) {
				System.out.println("Enter Book ID of record to be updated");
				id = updateBookScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Edition");
				updateVariable = updateBookScanner.nextLine();
				String sqlUpdateBookEdition = "UPDATE books SET edition = '" + updateVariable 
						+ "' WHERE id = '" + id + "';";
				System.out.println("Book Edition update "
						+ DbConnection.queryDatabase(sqlUpdateBookEdition));
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("10") || userInput.equals("10.")) {
				System.out.println("Enter Book ID of record to be updated");
				id = updateBookScanner.nextLine();
				System.out.println();
				System.out.println("Enter New Quantity");
				updateVariable = updateBookScanner.nextLine();
				String sqlUpdateBookQty = "UPDATE books SET qty = '" + updateVariable 
						+ "' WHERE id = '" + id + "';";
				System.out.println("Book Quantity update "
						+ DbConnection.queryDatabase(sqlUpdateBookQty));
				MainInterface.mainPage();
		    	}
			else {
				System.out.println("Please make a valid selection.");
			}
		}
	}
}
