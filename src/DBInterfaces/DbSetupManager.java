package DBInterfaces;

import java.io.FileNotFoundException;

/**
 * This class creates the database schema on system first use.
 * It 
 * @author russellfincham
 * @version 0.1
 * @since 26-06-18
 */

public class DbSetupManager {
	/**
	 * This method creates the database Schema when the system is
	 * first used. It is called from System settings once database
	 * connection parameters have been configured.
	 * Tables will be created in the system if they do not already exist.
	 * If they do the table will be skipped.
	 * @throws FileNotFoundException if data file cannot be accessed by 
	 * DbInterface.DbLogin.
	 * @return String returned to calling code indicating setup has completed.
	 */
	public static String dbSetup() throws FileNotFoundException {
		
		System.out.println("\nDatabase Setup Commencing...");
			
		// SQL to create/verify Books database table		
		String sqlCreateTableBooks = "CREATE TABLE IF NOT EXISTS books "
										+ "(id INT,"
										+ " title VARCHAR(50),"
										+ " description VARCHAR(255),"
										+ " genre_id VARCHAR(50),"
										+ " price DECIMAL(4,2),"
										+ " author_id VARCHAR(10),"
										+ " publisher_id VARCHAR(10),"
										+ " publish_date DATE,"
										+ " edition TINYINT,"
										+ " qty INT,"
										+ " PRIMARY KEY (id));";
		System.out.println("Books table verification " 
										+ DbInterface.queryDatabase(sqlCreateTableBooks));
		
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
										+ DbInterface.queryDatabase(sqlCreateTablePublishers));
		
		//SQL to create/verify Authors database table
		String sqlCreateTableAuthors = "CREATE TABLE IF NOT EXISTS authors "
										+ "(author_id VARCHAR(10),"
										+ " author_firstname VARCHAR(50),"
										+ " author_surname VARCHAR(20),"
										+ " PRIMARY KEY (author_id));";
		System.out.println("Authors table verification " 
										+ DbInterface.queryDatabase(sqlCreateTableAuthors));
		
		//SQL to create/verify genre database table
		String sqlCreateTableGenre = "CREATE TABLE IF NOT EXISTS genre "
										+ "(genre_id VARCHAR(3),"
										+ " genre_name VARCHAR(50),"
										+ " PRIMARY KEY (genre_id));";
		System.out.println("Genre table verification " 
										+ DbInterface.queryDatabase(sqlCreateTableGenre));
		
		//SQL to create/verify Users database table
				String sqlCreateTableUsers = "CREATE TABLE IF NOT EXISTS users "
												+ "(user_id VARCHAR(255),"
												+ " user_password VARCHAR(50) NOT NULL,"
												+ " PRIMARY KEY (user_id));";
				System.out.println("Users table verification " 
												+ DbInterface.queryDatabase(sqlCreateTableUsers));
				
		//SQL to create/verify Settings database table
		String sqlCreateTableSettings = "CREATE TABLE IF NOT EXISTS settings "
										+ "(setting_name VARCHAR(255),"
										+ " value VARCHAR(255),"
										+ " PRIMARY KEY (setting_name));";
		System.out.println("Settings table verification " 
										+ DbInterface.queryDatabase(sqlCreateTableSettings));

		return "\nDatabase Setup/verification complete.";
	}
}
