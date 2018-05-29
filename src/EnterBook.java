
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EnterBook {
	
	public static void enterBookMenu() throws FileNotFoundException {

		//  Scanner Variable
		String userInput = "";
		
		//SQL Insert book variables
		String id = "";
		String title = "";
		String description = "";
		String genre = "";
		String price = "";  //need a way of validating currency input.
		String author_id = "";
		String publisher_id = "";
		String publish_date = "";
		String edition = "";
		String qty = "";
		
		//MySQL Login details
		String fileScanUser = "";
		String fileScanPass = "";
		
		
		Scanner enterBookScanner = BookStoreMain.keyInput;
		
		//Interface output and navigation
		System.out.println("\n*****  Enter Book *****");
		System.out.println("0.  Main Menu - at any time");
		System.out.println("\n1 of 10 - Enter book ID:");
		while (enterBookScanner.hasNextLine()) {    			//Validate ID number is int
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
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
				MainInterface.mainPage();
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
				MainInterface.mainPage();
		    	}
			else {
				description = userInput;
				break;
				}
		}
		
		System.out.println("4 of 10 - Enter Genre:");  //Genre should be its own table
		while (enterBookScanner.hasNextLine()) {
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else {
				genre = userInput;
				break;
				}
		}

		System.out.println("5 of 10 - Enter price:");  // Needs currency format validation
		while (enterBookScanner.hasNextLine()) {
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else if (userInput.equals("")) {
				System.out.println("Book price cannot be blank.  Please enter a value.");
				}
			else {
				price = userInput;
				break;
				}
		}
		
		System.out.println("6 of 10 - Enter Author ID:");  //Needs existing Author validation
		while (enterBookScanner.hasNextLine()) {
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else {
				author_id = userInput;
				break;
				}
		}
		
		System.out.println("7 of 10 - Enter Publisher ID:");  //Needs existing Publisher validation
		while (enterBookScanner.hasNextLine()) {
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else {
				publisher_id = userInput;
				break;
				}
		}
		
		System.out.println("8 of 10 - Enter date published  DD/MM/YYYY:");  //  Needs date format validation
		while (enterBookScanner.hasNextLine()) {
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else {
				publish_date = userInput;
				break;
				}
		}
		
		System.out.println("9 of 10 - Enter Edition Number:");  // make sure int is used
		while (enterBookScanner.hasNextLine()) {
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else {
				edition = userInput;
				break;
				}
		}
		
		System.out.println("10 of 10 - Enter Quantity:");  //make sure int is used.
		while (enterBookScanner.hasNextLine()) {
			userInput = enterBookScanner.nextLine();
			if (userInput.equals("0") || userInput.equals("0.")) {
				MainInterface.mainPage();
		    	}
			else {
				qty = userInput;
				break;
				}
		}
		
		File inputFile = new File("/Users/russellfincham/documents/temp/MySqlLogin.txt");
		Scanner fileScanner = new Scanner(new FileInputStream(inputFile), "UTF-8");
	    
	    fileScanUser = fileScanner.nextLine();
	    fileScanPass = fileScanner.nextLine(); 
	    fileScanner.close();
		
		String DbUrlString = "jdbc:mysql://win81-desktop.home.local:3306/ebookstore?useSSL=FALSE";
		System.out.println("\nInserting Book into Database...");
		
		try (
			Connection conn = DriverManager.getConnection(DbUrlString, fileScanUser, fileScanPass);
			Statement stmt = conn.createStatement();
			) {
				
			// SQL string to insert book information into database
			String sqlInsertBook = "INSERT INTO books VALUES "
					+ "('" + id + "', '"
					+ title + "', '"
					+ description + "', '"
					+ genre + "', "
					+ price + ", '"
					+ author_id + "', '"
					+ publisher_id + "', "
					+ publish_date + ", "
					+ edition + ", "
					+ qty + ");";
			System.out.println("The SQL query is: " + sqlInsertBook);
			int countBookInsertion = stmt.executeUpdate(sqlInsertBook);
			System.out.println((countBookInsertion) + " book called '" + title + "' inserted into database.");
					
		} catch(SQLException ex) {
			ex.printStackTrace();
			}
		
		MainInterface.mainPage();
	}
}
