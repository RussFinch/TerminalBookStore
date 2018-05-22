
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;


public class BookStoreMain {

	public static void main(String args[]) throws FileNotFoundException {
		
		String DbUrlString = "jdbc:mysql://win81-desktop.home.local:3306/ebookstore?useSSL=FALSE";
		String userName = "";
		String password = "";
		
		Scanner userLogin = new Scanner(System.in);
		System.out.println("Username:  ");
	    userName = userLogin.next();
	    System.out.println("Password:  ");
	    password = userLogin.next();
	    userLogin.close();

		try (
				Connection conn = DriverManager.getConnection(DbUrlString, userName, password);
				Statement stmt = conn.createStatement();
			) {
				
				// Create books table if not already existing
				String sqlCreateTableBooks = "create table if not exists books "
						+ "(ID int, Title varchar(50), Author varchar(50), QTY int, primary key (ID))";
				System.out.println("The SQL Query is: " + sqlCreateTableBooks);
				int countCreation = stmt.executeUpdate(sqlCreateTableBooks);
				System.out.println(countCreation + ": Table created");
				
/*				//Insert test data
				String sqlInsertBooksData = "insert into books values "
						+ "(3001, 'A Tale of Two Cities', 'Charles Dickens', 30), "
						+ "(3002, 'Harry Potter and the Philosophers Stone', 'J.K. Rowling', 40), "
						+ "(3003, 'The Lion the Witch and the Wardrobe', 'C.S. Lewis', 25), "
						+ "(3004, 'The Lord of theRings', 'J.R.R Tolkien', 37), "
						+ "(3005, 'Alice in Wonderland', 'Lewis Carroll', 12)";
					System.out.println("The SQL query is: " + sqlInsertBooksData);
					int countInserted = stmt.executeUpdate(sqlInsertBooksData);
					System.out.println(countInserted + " records inserted.\n");
*/				
				
			} catch (SQLException ex) {
				ex.printStackTrace();
				}
			
			}
	}



