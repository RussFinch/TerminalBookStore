import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EnterAuthor {
	
	public static void enterAuthorMenu() throws FileNotFoundException {
	
	//  Scanner Variable
	String userInput = "";
	
	//SQL Insert Author variables
	String author_id = "";
	String author_firstname = "";
	String author_surname = "";
	
	//MySQL Login details
	String fileScanUser = "";
	String fileScanPass = "";
	
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
		String sqlInsertAuthor = "INSERT INTO authors VALUES "
				+ "('" + author_id + "', '"
				+ author_firstname + "', '"
				+ author_surname + "');";
		System.out.println("The SQL query is: " + sqlInsertAuthor);
		int countAuthorInsertion = stmt.executeUpdate(sqlInsertAuthor);
		System.out.println((countAuthorInsertion) + " Author called '" + author_firstname + " "
											+ author_surname + "' inserted into database.");
				
	} catch(SQLException ex) {
		ex.printStackTrace();
		}
	
	MainInterface.mainPage();
	}
}

