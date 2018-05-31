import java.io.FileNotFoundException;

public class DbSetupManager {
	
	public static String dbLogin(String userName, String password) throws FileNotFoundException {

		System.out.println("\nDatabase Setup Commencing...");
			
		// SQL to create/verify Books database table		
		String sqlCreateTableBooks = "CREATE TABLE IF NOT EXISTS books "
										+ "(id INT,"
										+ " title VARCHAR(50),"
										+ " description VARCHAR(255),"
										+ " genre VARCHAR(50),"
										+ " price DECIMAL(4,2),"
										+ " author_id VARCHAR(10),"
										+ " publisher_id VARCHAR(10),"
										+ " publish_date DATE,"
										+ " edition TINYINT,"
										+ " qty INT,"
										+ " PRIMARY KEY (id));";
		System.out.println("Books table verification " 
										+ DbConnection.queryDatabase(sqlCreateTableBooks));
		
		//SQL to create/verify Publishers database table
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
		System.out.println("Publishers table verification " 
										+ DbConnection.queryDatabase(sqlCreateTablePublishers));
		
		//SQL to create/verify Authors database table
		String sqlCreateTableAuthors = "CREATE TABLE IF NOT EXISTS authors "
										+ "(author_id VARCHAR(10),"
										+ " author_firstname VARCHAR(50),"
										+ " author_surname VARCHAR(20),"
										+ " PRIMARY KEY (author_id));";
		System.out.println("Authors table verification " 
										+ DbConnection.queryDatabase(sqlCreateTableAuthors));
					
		//Insert test data  -  Needs updating for latest tables
/*		String sqlInsertTestData = "insert into books values "
							+ "(3001, 'A Tale of Two Cities', 'Charles Dickens', 30), "
							+ "(3002, 'Harry Potter and the Philosophers Stone', 'J.K. Rowling', 40), "
							+ "(3003, 'The Lion the Witch and the Wardrobe', 'C.S. Lewis', 25), "
							+ "(3004, 'The Lord of theRings', 'J.R.R Tolkien', 37), "
							+ "(3005, 'Alice in Wonderland', 'Lewis Carroll', 12)";
		System.out.println("Test Data setup " + DbConnection.queryDatabase(sqlInsertTestData));
*/		
		return "\nDatabase Setup complete.";
	}
}
