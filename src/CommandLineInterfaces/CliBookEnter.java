package CommandLineInterfaces;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import DBInterfaces.DbInterface;
import Main.KeyScanner;

public class CliBookEnter {
	
	public static void enterBookMenu() throws FileNotFoundException, SQLException {

		//  Scanner Variable
		String userInput = "";
		
		//SQL Insert book variables
		String id = "";
		String title = "";
		String description = "";
		String genre_id = "";
		String price = "";
		String author_id = "";
		String publisher_id = "";
		String publish_date = "";
		String edition = "";
		String qty = "";
		
		Scanner enterBookScanner = KeyScanner.keyInput;
		
		//Interface output and navigation
		System.out.println("\n*****  Enter Book *****");
		System.out.println("0.  Main Menu - at any time");
		System.out.println("\n1 of 10 - Enter book ID:");
		while (enterBookScanner.hasNextLine()) {
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else if (userInput.equals("")) {
				System.out.println("Book ID cannot be blank.  Please enter.");
				}
			else {
				id = userInput;
				break;
				}
		}
		System.out.println("2 of 10 - Enter book Title:");
		while (enterBookScanner.hasNextLine()) {
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else if (userInput.equals("")) {
				System.out.println("Book Title cannot be blank.  Please enter.");
				}
			else {
				title = userInput;
				break;
				}
		}
		System.out.println("3 of 10 - Enter Description:");
		while (enterBookScanner.hasNextLine()) {
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else {
				description = userInput;
				break;
				}
		}
		System.out.println("4 of 10 - Enter Genre ID:");
		while (enterBookScanner.hasNextLine()) {
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else {
				genre_id = userInput;
				break;
				}
		}
		System.out.println("5 of 10 - Enter price:");
		while (enterBookScanner.hasNextLine()) {
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else if (userInput.equals("")) {
				System.out.println("Book price cannot be blank.  Please enter a value.");
				}
			else {
				price = userInput;
				break;
				}
		}
		System.out.println("6 of 10 - Enter Author ID:");
		while (enterBookScanner.hasNextLine()) {
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else {
				author_id = userInput;
				break;
				}
		}
		System.out.println("7 of 10 - Enter Publisher ID:");
		while (enterBookScanner.hasNextLine()) {
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else {
				publisher_id = userInput;
				break;
				}
		}
		System.out.println("8 of 10 - Enter date published  YYYY/MM/DD:");
		while (enterBookScanner.hasNextLine()) {
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else {
				publish_date = userInput;
				break;
				}
		}
		System.out.println("9 of 10 - Enter Edition Number:");
		while (enterBookScanner.hasNextLine()) {
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else {
				edition = userInput;
				break;
				}
		}
		System.out.println("10 of 10 - Enter Quantity:");
		while (enterBookScanner.hasNextLine()) {
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				CliMainPage.mainPage();
		    	}
			else {
				qty = userInput;
				break;
				}
		}
				
		// SQL string to insert book information into database
		String sqlInsertBook = "INSERT INTO books VALUES "
							+ "('" + id + "', '"
							+ title + "', '"
							+ description + "', '"
							+ genre_id + "', "
							+ price + ", '"
							+ author_id + "', '"
							+ publisher_id + "', "
							+ publish_date + ", "
							+ edition + ", "
							+ qty + ");";
		System.out.println("Book entry "
				+ DbInterface.queryDatabase(sqlInsertBook));
					
		CliMainPage.mainPage();
	}
}
