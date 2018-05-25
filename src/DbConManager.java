import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConManager {
	
	public static String dbLogin(String userName, String password) {

		String DbUrlString = "jdbc:mysql://win81-desktop.home.local:3306/ebookstore?useSSL=FALSE";
		System.out.println("\nDatabase Setup Commencing...");
		try (
			Connection conn = DriverManager.getConnection(DbUrlString, userName, password);
			Statement stmt = conn.createStatement();
			) {
			
				// Create database tables if not already existing
				
				String sqlCreateTableBooks = "CREATE TABLE IF NOT EXISTS books "
						+ "(id INT, title VARCHAR(50),"
						+ " description VARCHAR(255),"
						+ " genre VARCHAR(50),"
						+ " price DECIMAL(4,2),"
						+ " author_id VARCHAR(10),"
						+ " publisher_id VARCHAR(10),"
						+ " publish_date DATE,"
						+ " edition TINYINT,"
						+ " qty INT,"
						+ " PRIMARY KEY (id));";
				int countBooksCreation = stmt.executeUpdate(sqlCreateTableBooks);
				System.out.println("\n" + (countBooksCreation + 1) + ": Books Database table verified in setup.");
				
				String sqlCreateTablePublishers = "CREATE TABLE IF NOT EXISTS publishers "
						+ "(publisher_id VARCHAR(10),"
						+ " publisher_name VARCHAR(50),"
						+ " address_1 VARCHAR(20),"
						+ " address_2 VARCHAR(20),"
						+ " address_3 VARCHAR(20),"
						+ " address_town VARCHAR(20),"
						+ " address_county VARCHAR(20),"
						+ " address_postcode VARCHAR(8),"
						+ " PRIMARY KEY (publisher_id));";
				int countPublishersCreation = stmt.executeUpdate(sqlCreateTablePublishers);
				System.out.println("\n" + (countPublishersCreation + 1) + ": Publishers Database table verified in setup.");
				
				String sqlCreateTableAuthors = "CREATE TABLE IF NOT EXISTS authors "
						+ "(author_id VARCHAR(10),"
						+ " author_firstname VARCHAR(50),"
						+ " author_surname VARCHAR(20),"
						+ " PRIMARY KEY (author_id));";
				int countAuthorsCreation = stmt.executeUpdate(sqlCreateTableAuthors);
				System.out.println("\n" + (countAuthorsCreation + 1) + ": Publishers Database table verified in setup.");
/*			
				//Insert test data
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
		return "Database Setup complete.";
	}
}
