import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteAuthor {
	
	public static void deleteAuthorMenu() throws FileNotFoundException {
		
		//  Scanner Variable
		String userInput = "";
		Scanner deleteAuthorScanner = BookStoreMain.keyInput;
		
		//  SQL deleteAuthor variables
		String author_id = "";
		
		//MySQL Login details
		String fileScanUser = "";
		String fileScanPass = "";
		
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
		
		File inputFile = new File("/Users/russellfincham/documents/temp/MySqlLogin.txt");
		Scanner fileScanner = new Scanner(new FileInputStream(inputFile), "UTF-8");
	    
	    fileScanUser = fileScanner.nextLine();
	    fileScanPass = fileScanner.nextLine(); 
	    fileScanner.close();
		
		String DbUrlString = "jdbc:mysql://win81-desktop.home.local:3306/ebookstore?useSSL=FALSE";
		
		
		
		try (
			Connection conn = DriverManager.getConnection(DbUrlString, fileScanUser, fileScanPass);
			Statement stmt = conn.createStatement();
			) {
			
			System.out.println("\nDeleting Author from Database...");
			// Find details for author matching id provided.
			String sqlFindAuthor = "SELECT author_firstname, author_surname FROM authors"
											+ " WHERE author_id = '" + author_id + "';";
			stmt.executeUpdate(sqlFindAuthor);
			System.out.println("The author to be deleted is: " + sqlFindAuthor);
			System.out.println("Do you wish to proceed?  YES/NO");
			while (deleteAuthorScanner.hasNextLine()) {
				userInput = deleteAuthorScanner.nextLine();
				if (userInput.equals("YES") || userInput.equals("Y")) {
					String sqlDeleteAuthor = "DELETE * FROM authors WHERE author_id = '" + author_id + "';";
					stmt.executeUpdate(sqlDeleteAuthor);
					System.out.println("Author deleted...");
					break;
			    	}
				else {
					System.out.println("Delete action Cancelled.");
					break;
					}
			}
					
		} catch(SQLException ex) {
			ex.printStackTrace();
			}
		
		MainInterface.mainPage();
	}
}