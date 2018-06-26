package DBInterfaces;

import java.io.*;
import java.sql.*;

/**
 * This class manages data upload requests to the database.
 * It 
 * @author russellfincham
 * @version 0.1
 * @since 26-06-18
 */

public class DbDataUploadManager {
	/**
	 * This method manages the upload of Genre.
	 * The method manages upload into the genre table in the database.
	 * The database is logged into before a query run to determine file location
	 * from settings table.  Data is then read line by line, split into separate
	 * attributes and inserted into the genre table using a defined query.
	 * @throws FileNotFoundException if data file cannot be accessed.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 * @return String returned to calling code indicating "Genre upload complete"
	 */
	public static String genreDataUpload() throws FileNotFoundException, SQLException {
		
		//DB Login variables returned from DbInterface.DbLogin
		String userName = "";
		String password = "";
		String dbUrl = "";
		
		//Genre table columns
	    String genre_id = "";
	    String genre_name = "";
	    
	    //Locate upload file from settings table in database.
	    String sqlQuery = "SELECT * FROM settings WHERE setting_name='genreUpload'";
	    String uploadFile = DbInterface.querySettings(sqlQuery);
	    
	    PreparedStatement ps = null;
	    
	    String loginString = DbInterface.DbLogin();
		String loginArray[] = loginString.split(",");
        userName = loginArray[0];
        password = loginArray[1];
        dbUrl = loginArray[2];

	    try {
	    	//Data collection from file setup using location from database.
	        BufferedReader reader = new BufferedReader(new FileReader(uploadFile));

	        Connection conn = DriverManager.getConnection(dbUrl, userName, password);

	        //Extract data line by line, split and insert into database.
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            String data[] = line.split(",");
	            genre_id = data[0];
	            genre_name = data[1];
	            System.out.println(genre_id + "\t" + genre_name);
	            String sqlGenreUpload =
	                    "INSERT INTO genre (genre_id, genre_name) values "
	                    + "('" + genre_id + "', '" + genre_name + "');";
	            ps = conn.prepareStatement(sqlGenreUpload);
	            ps.executeUpdate();
	        }

	        reader.close();
	        conn.close();
	        ps.close();

	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    return "Genre upload complete";
	}
	
	/**
	 * This method manages the upload of Authors.
	 * The method manages upload into the authors table in the database.
	 * The database is logged into before a query run to determine file location
	 * from settings table.  Data is then read line by line, split into separate
	 * attributes and inserted into the authors table using a defined query.
	 * @throws FileNotFoundException if data file cannot be accessed.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 * @return String returned to calling code indicating "Authors upload complete"
	 */
	public static String authorsDataUpload() throws FileNotFoundException, SQLException {
		
		//DB Login variables returned from DbInterface.DbLogin
		String userName = "";
		String password = "";
		String dbUrl = "";
		
		//Author table columns
	    String author_id = "";
	    String author_firstname = "";
	    String author_surname = "";
	    
	    //Locate upload file from settings table in database.
	    String sqlQuery = "SELECT * FROM settings WHERE setting_name='authorsUpload'";
	    String uploadFile = DbInterface.querySettings(sqlQuery);
	    
	    PreparedStatement ps = null;
	    
	    String loginString = DbInterface.DbLogin();
		String loginArray[] = loginString.split(",");
        userName = loginArray[0];
        password = loginArray[1];
        dbUrl = loginArray[2];

	    try {
	    	//Data collection from file setup using location from database.
	        BufferedReader reader = new BufferedReader(new FileReader(uploadFile));

	        Connection conn = DriverManager.getConnection(dbUrl, userName, password);

	        //Extract data line by line, split and insert into database.
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            String data[] = line.split(",");
	            author_id = data[0];
	            author_firstname = data[1];
	            author_surname = data[2];
	            System.out.println(author_id + "\t" + author_firstname + "\t" + author_surname);
	            String sqlAuthorUpload =
	                    "INSERT INTO authors (author_id, author_firstname, author_surname) values "
	                    + "('" + author_id + "', '" + author_firstname + "', '" + author_surname + "');";
	            ps = conn.prepareStatement(sqlAuthorUpload);
	            ps.executeUpdate();
	        }

	        reader.close();
	        conn.close();
	        ps.close();

	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    return "Authors upload complete";
		
	}
	
	/**
	 * This method manages the upload of Books.
	 * The method manages upload into the books table in the database.
	 * The database is logged into before a query run to determine file location
	 * from settings table.  Data is then read line by line, split into separate
	 * attributes and inserted into the books table using a defined query.
	 * @throws FileNotFoundException if data file cannot be accessed.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 * @return String returned to calling code indicating "Books upload complete"
	 */
	public static String booksDataUpload() throws FileNotFoundException, SQLException {
		
		//DB Login variables returned from DbInterface.DbLogin
		String userName = "";
		String password = "";
		String dbUrl = "";
		
		//Books table columns
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
	    
	    //Locate upload file from settings table in database.
	    String sqlQuery = "SELECT * FROM settings WHERE setting_name='booksUpload'";
	    String uploadFile = DbInterface.querySettings(sqlQuery);
	    
	    PreparedStatement ps = null;
	    
	    String loginString = DbInterface.DbLogin();
		String loginArray[] = loginString.split(",");
        userName = loginArray[0];
        password = loginArray[1];
        dbUrl = loginArray[2];

	    try {
	    	//Data collection from file setup using location from database.
	        BufferedReader reader = new BufferedReader(new FileReader(uploadFile));

	        Connection conn = DriverManager.getConnection(dbUrl, userName, password);

	        //Extract data line by line, split and insert into database.
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            String data[] = line.split(",");
	            id = data[0];
	            title = data[1];
	            description = data[2];
	            genre_id = data[3];
	            price = data[4];
	            author_id = data[5];
	            publisher_id = data[6];
	            publish_date = data[7];
	            edition = data[8];
	            qty = data[9];
	            System.out.println(id + "\t" + title + "\t" + description + "\t" + genre_id 
	            		+ "\t" + price + "\t" + author_id + "\t" + publisher_id + "\t"
	            		+ publish_date + "\t" + edition + "\t" + qty);
	            String sqlBookUpload =
	                    "INSERT INTO books (id, title, description, genre_id, price, author_id,"
	                    + "publisher_id, publish_date, edition, qty) values "
	                    + "('" + id + "', '" + title + "', '" + description + "', '"
	                    + genre_id + "', '" + price + "', '" + author_id + "', '"
	                    + publisher_id + "', '" + publish_date + "', '"
	                    + edition + "', '" + qty + "');";
	            ps = conn.prepareStatement(sqlBookUpload);
	            ps.executeUpdate();
	        }

	        reader.close();
	        conn.close();
	        ps.close();

	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    return "Books upload complete";
		
	}
	
	/**
	 * This method manages the upload of Publishers.
	 * The method manages upload into the Publishers table in the database.
	 * The database is logged into before a query run to determine file location
	 * from settings table.  Data is then read line by line, split into separate
	 * attributes and inserted into the Publishers table using a defined query.
	 * @throws FileNotFoundException if data file cannot be accessed.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 * @return String returned to calling code indicating "Publishers upload complete"
	 */
	public static String publishersDataUpload() throws FileNotFoundException, SQLException {
		
		//DB Login variables returned from DbInterface.DbLogin
		String userName = "";
		String password = "";
		String dbUrl = "";
		
		//Genre table columns
	    String publisher_id = "";
	    String publisher_name = "";
	    String address_1 = "";
	    String address_2 = "";
	    String address_3 = "";
	    String address_town = "";
	    String address_county = "";
	    String address_postcode = "";
	    
	    //Locate upload file from settings table in database.
	    String sqlQuery = "SELECT * FROM settings WHERE setting_name='publishersUpload'";
	    String uploadFile = DbInterface.querySettings(sqlQuery);
	    
	    PreparedStatement ps = null;
	    
	    String loginString = DbInterface.DbLogin();
		String loginArray[] = loginString.split(",");
        userName = loginArray[0];
        password = loginArray[1];
        dbUrl = loginArray[2];

	    try {
	    	//Data collection from file setup using location from database.
	        BufferedReader reader = new BufferedReader(new FileReader(uploadFile));

	        Connection conn = DriverManager.getConnection(dbUrl, userName, password);

	        //Extract data line by line, split and insert into database.
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            String data[] = line.split(",");
	            publisher_id = data[0];
	            publisher_name = data[1];
	            address_1 = data[2];
	            address_2 = data[3];
	            address_3 = data[4];
	            address_town = data[5];
	            address_county = data[6];
	            address_postcode = data[7];       
	            System.out.println(publisher_id + "\t" + publisher_name + "\t" + address_1 + "\t" + address_2 
	            		+ "\t" + address_3 + "\t" + address_town + "\t" + address_county + "\t"
	            		+ address_postcode);
	            String sqlPublisherUpload =
	                    "INSERT INTO publishers (publisher_id, publisher_name, address_1, address_2, address_3, address_town,"
	                    + "address_county, address_postcode) values "
	                    + "('" + publisher_id + "', '" + publisher_name + "', '" + address_1 + "', '"
	                    + address_2 + "', '" + address_3 + "', '" + address_town + "', '"
	                    + address_county + "', '" + address_postcode + "');";
	            ps = conn.prepareStatement(sqlPublisherUpload);
	            ps.executeUpdate();
	        }

	        reader.close();
	        conn.close();
	        ps.close();

	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    return "Publishers upload complete";	
	}
	
	/**
	 * This method manages the upload of User details.
	 * The method manages upload into the users table in the database.
	 * The database is logged into before a query run to determine file location
	 * from settings table.  Data is then read line by line, split into separate
	 * attributes and inserted into the users table using a defined query.
	 * @throws FileNotFoundException if data file cannot be accessed.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 * @return String returned to calling code indicating "Users upload complete"
	 */
	public static String userDataUpload() throws FileNotFoundException, SQLException {
		
		//DB Login variables returned from DbInterface.DbLogin
		String userName = "";
		String password = "";
		String dbUrl = "";
		
		//Users table columns
	    String user_id = "";
	    String user_password = "";
	    
	    //Locate upload file from settings table in database.
	    String sqlQuery = "SELECT * FROM settings WHERE setting_name='usersUpload'";
	    String uploadFile = DbInterface.querySettings(sqlQuery);
	    
	    PreparedStatement ps = null;
	    
	    String loginString = DbInterface.DbLogin();
		String loginArray[] = loginString.split(",");
        userName = loginArray[0];
        password = loginArray[1];
        dbUrl = loginArray[2];

	    try {
	    	//Data collection from file setup using location from database.
	        BufferedReader reader = new BufferedReader(new FileReader(uploadFile));

	        Connection conn = DriverManager.getConnection(dbUrl, userName, password);

	        //Extract data line by line, split and insert into database.
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            String data[] = line.split(",");
	            user_id = data[0];
	            user_password = data[1];

	            System.out.println(user_id + "\t *Password*");
	            String sqlUsersUpload =
	                    "INSERT INTO users (user_id, user_password) values "
	                    + "('" + user_id + "', '" + user_password + "');";
	            ps = conn.prepareStatement(sqlUsersUpload);
	            ps.executeUpdate();
	        }

	        reader.close();
	        conn.close();
	        ps.close();

	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    return "Users upload complete";
	}
	
	/**
	 * This method manages the upload of System Settings.
	 * The method manages upload into the settings table in the database.
	 * The database is logged into before a query run to determine file location
	 * from settings table.  Data is then read line by line, split into separate
	 * attributes and inserted into the settings table using a defined query.
	 * @throws FileNotFoundException if data file cannot be accessed.
	 * @throws SQLException if DbInterface.QueryDatabase unable to successfully
	 * query database
	 * @return String returned to calling code indicating "Settings upload complete"
	 */
	public static String settingsDataUpload() throws FileNotFoundException, SQLException {
		
		//DB Login variables returned from DbInterface.DbLogin
		String userName = "";
		String password = "";
		String dbUrl = "";
		
		//Settings table columns
	    String setting_name = "";
	    String value = "";
	    
	    //Locate upload file from settings table in database.
	    String sqlQuery = "SELECT * FROM settings WHERE setting_name='settingsUpload'";
	    String uploadFile = DbInterface.querySettings(sqlQuery);
	    
	    PreparedStatement ps = null;
	    
	    String loginString = DbInterface.DbLogin();
		String loginArray[] = loginString.split(",");
        userName = loginArray[0];
        password = loginArray[1];
        dbUrl = loginArray[2];

	    try {
	    	//Data collection from file setup using location from database.
	        BufferedReader reader = new BufferedReader(new FileReader(uploadFile));

	        Connection conn = DriverManager.getConnection(dbUrl, userName, password);

	        //Extract data line by line, split and insert into database.
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            String data[] = line.split(",");
	            setting_name = data[0];
	            value = data[1];

	            System.out.println(setting_name + "\t" + value);
	            String sqlSettingsUpload =
	                    "INSERT INTO settings (setting_name, value) values "
	                    + "('" + setting_name + "', '" + value + "');";
	            ps = conn.prepareStatement(sqlSettingsUpload);
	            ps.executeUpdate();
	        }

	        reader.close();
	        conn.close();
	        ps.close();

	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    return "Settings upload complete";
	}
}
