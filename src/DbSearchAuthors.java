import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSearchAuthors {
	
	public static String searchAuthors (String sqlQuery) throws FileNotFoundException {
		
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
			
			System.out.println("AUTHOR ID:\tAUTHOR NAME:\tAUTHOR SURNAME:");
			
			while (rset.next()) {
				String author_id = rset.getString("author_id");
				String author_firstname = rset.getString("author_firstname");
				String author_surname = rset.getString("author_surname");

				System.out.println(author_id + "\t\t" + author_firstname + "\t\t" + author_surname);
				++rowCount;
			}

			System.out.println("Total records = " + rowCount);

			} catch (SQLException ex) {
				ex.printStackTrace();
				}
		
		return "Executed";
	}
}