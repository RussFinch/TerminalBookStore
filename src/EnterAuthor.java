import java.io.FileNotFoundException;
import java.util.Scanner;

public class EnterAuthor {
	
	public static void enterAuthorMenu() throws FileNotFoundException {
	
	//  Scanner Variable
	String userInput = "";
	
	//SQL Insert Author variables
	String author_id = "";
	String author_firstname = "";
	String author_surname = "";
	
	Scanner enterAuthorScanner = BookStoreMain.keyInput;
	
	//Interface output and navigation
	System.out.println("\n*****  Enter Author *****");
	System.out.println("0.  Main Menu - at any time");
	System.out.println("\n1 of 3 - Enter Author ID:");
	
	while (enterAuthorScanner.hasNextLine()) {
		userInput = enterAuthorScanner.nextLine();
		if (userInput.equals("0") || userInput.equals("0.")) {
			MainInterface.mainPage();
	    	}
		else if (userInput.equals("")) {
			System.out.println("Book ID cannot be blank.  Please enter.");
			}
		else {
			author_id = userInput;
			break;
			}
		}
	System.out.println("2 of 3 - Enter Authors First Name:");
	while (enterAuthorScanner.hasNextLine()) {
		userInput = enterAuthorScanner.nextLine();
		if (userInput.equals("0") || userInput.equals("0.")) {
			MainInterface.mainPage();
	    	}
		else if (userInput.equals("")) {
			System.out.println("Book Title cannot be blank.  Please enter.");
			}
		else {
			author_firstname = userInput;
			break;
			}
	}
	System.out.println("3 of 3 - Enter Authors Surname:");
	while (enterAuthorScanner.hasNextLine()) {
		userInput = enterAuthorScanner.nextLine();
		if (userInput.equals("0") || userInput.equals("0.")) {
			MainInterface.mainPage();
	    	}
		else {
			author_surname = userInput;
			break;
			}
	}
	//Execute SQL to insert Author
	String sqlInsertAuthor = "INSERT INTO authors VALUES "
			+ "('" + author_id + "', '"
			+ author_firstname + "', '"
			+ author_surname + "');";
	System.out.println("Author update " + DbConnection.queryDatabase(sqlInsertAuthor));
	
	MainInterface.mainPage();
	}
}

