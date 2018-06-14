package DBInterfaces;
import java.io.*;
import java.sql.*;

public class DbDataUploadManager {

	public static String genreDataUpload() throws FileNotFoundException, SQLException {
		
		//DB Login variables returned from DbInterface.DbLogin
		String userName = "";
		String password = "";
		String dbUrl = "";
		
		//Genre table columns
	    String genre_id = "";
	    String genre_name = "";
	    
	    PreparedStatement ps = null;
	    
	    String loginString = DbInterface.DbLogin();
		String loginArray[] = loginString.split(",");
        userName = loginArray[0];
        password = loginArray[1];
        dbUrl = loginArray[2];

	    try {
	        BufferedReader reader = new BufferedReader(new FileReader("/Users/russellfincham/documents/temp/GenreInput.txt"));

	        Connection conn = DriverManager.getConnection(dbUrl, userName, password);

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
	
	public static String authorsDataUpload() throws FileNotFoundException, SQLException {
		
		//DB Login variables returned from DbInterface.DbLogin
		String userName = "";
		String password = "";
		String dbUrl = "";
		
		//Genre table columns
	    String author_id = "";
	    String author_firstname = "";
	    String author_surname = "";
	    
	    PreparedStatement ps = null;
	    
	    String loginString = DbInterface.DbLogin();
		String loginArray[] = loginString.split(",");
        userName = loginArray[0];
        password = loginArray[1];
        dbUrl = loginArray[2];

	    try {
	        BufferedReader reader = new BufferedReader(new FileReader("/Users/russellfincham/documents/temp/AuthorInput.txt"));

	        Connection conn = DriverManager.getConnection(dbUrl, userName, password);

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
	
	public static String booksDataUpload() throws FileNotFoundException, SQLException {
		
		//DB Login variables returned from DbInterface.DbLogin
		String userName = "";
		String password = "";
		String dbUrl = "";
		
		//Genre table columns
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
	    
	    PreparedStatement ps = null;
	    
	    String loginString = DbInterface.DbLogin();
		String loginArray[] = loginString.split(",");
        userName = loginArray[0];
        password = loginArray[1];
        dbUrl = loginArray[2];

	    try {
	        BufferedReader reader = new BufferedReader(new FileReader("/Users/russellfincham/documents/temp/BookInput.txt"));

	        Connection conn = DriverManager.getConnection(dbUrl, userName, password);

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
	    
	    PreparedStatement ps = null;
	    
	    String loginString = DbInterface.DbLogin();
		String loginArray[] = loginString.split(",");
        userName = loginArray[0];
        password = loginArray[1];
        dbUrl = loginArray[2];

	    try {
	        BufferedReader reader = new BufferedReader(new FileReader("/Users/russellfincham/documents/temp/PublisherInput.txt"));

	        Connection conn = DriverManager.getConnection(dbUrl, userName, password);

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
}
