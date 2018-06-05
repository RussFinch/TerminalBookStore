import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSearchGenre {
	
	public static String searchGenre (String sqlQuery) throws FileNotFoundException {
		
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
			
			System.out.println("GENRE ID:\tGENRE NAME:");
			
			while (rset.next()) {
				String genre_id = rset.getString("genre_id");
				String genre_name = rset.getString("genre_name");

				System.out.println(genre_id + "\t\t" + genre_name);
				++rowCount;
			}

			System.out.println("Total records = " + rowCount);

			} catch (SQLException ex) {
				ex.printStackTrace();
				}
		
		return "Executed";
	}
}