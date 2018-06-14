package DBInterfaces;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSearchBooks {

	public static String searchBooks (String sqlQuery) throws FileNotFoundException {
		
		String userName = "";
		String password = "";
		String dbUrl = "";
		
		String loginString = DbInterface.DbLogin();
		
		String data[] = loginString.split(",");
        userName = data[0];
        password = data[1];
        dbUrl = data[2];
		
		try (
			Connection conn = DriverManager.getConnection(dbUrl, userName, password);
			Statement stmt = conn.createStatement();
				
			) {
			
			System.out.println("The SQL Query is: " + sqlQuery);
			System.out.println();
			
			ResultSet rset = stmt.executeQuery(sqlQuery);
			
			int rowCount = 0;
			
			System.out.println("BOOK ID:\tTITLE:\t\tDESCRIPTION:\tGENRE ID:\tPRICE:\tAUTHOR ID:"
					+ "\tPUBLISHER ID:\tPUBLISH DATE:\t\tEDITION:\t\tQUANTITY:\t");
			
			while (rset.next()) {
				String id = rset.getString("id");
				String title = rset.getString("title");
				String description = rset.getString("description");
				String genre_id = rset.getString("genre_id");
				String price = rset.getString("price");
				String author_id = rset.getString("author_id");
				String publisher_id = rset.getString("publisher_id");
				String publish_date = rset.getString("publish_date");
				String edition = rset.getString("edition");
				String qty = rset.getString("qty");

				System.out.println(id + "\t\t" + title + "\t\t" + description + "\t"
											+ genre_id + "\t" + price + "\t" + author_id
											+ "\t" + publisher_id + "\t" + publish_date
											+ "\t" + edition + "\t" + qty);
				++rowCount;
			}

			System.out.println("Total records = " + rowCount);

			} catch (SQLException ex) {
				ex.printStackTrace();
				}
		
		return "Executed";
	}
}