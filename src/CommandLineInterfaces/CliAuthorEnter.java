package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbInterface;
import Main.KeyScanner;

/**
 * This Command Line Terminal class allows the user to enter a new author.
 * @author russellfincham
 * @version 0.1
 * @since 25-06-18
 */

public class CliAuthorEnter {
	/**
	 * This Command Line Terminal class allows the user to enter a new author. 
	 * It then supplies the correct SQL query to DbInterface.queryDatabase for 
	 * record addition to the database.
	 * @throws FileNotFoundException if DbInterface.DbLogin unable to access user file.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 */
	public static void enterAuthorMenu() throws FileNotFoundException, SQLException {
	
	//  Scanner Variable
	String userInput = "";
	
	//SQL Insert Author variables
	String author_id = "";
	String author_firstname = "";
	String author_surname = "";
	
	Scanner enterAuthorScanner = KeyScanner.keyInput;
	
	//Interface output and navigation
	System.out.println("\n*****  Enter Author *****");
	System.out.println("0.  Main Menu - at any time");
	System.out.println("\n1 of 3 - Enter Author ID:");
	
	while (enterAuthorScanner.hasNextLine()) {
		userInput = enterAuthorScanner.nextLine();
		if (userInput.equals("0") || userInput.equals("0.")) {
			CliMainPage.mainPage();
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
			CliMainPage.mainPage();
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
			CliMainPage.mainPage();
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
	System.out.println("Author update " + DbInterface.queryDatabase(sqlInsertAuthor));
	
	CliMainPage.mainPage();
	}
}

