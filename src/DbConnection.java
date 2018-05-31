import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class DbConnection {

	public static String queryDatabase(String sqlQuery) throws FileNotFoundException {

		String fileScanUser = "";
		String fileScanPass = "";
		String DbUrlString = "jdbc:mysql://win81-desktop.home.local:3306/ebookstore?useSSL=FALSE";
		
		File inputFile = new File("/Users/russellfincham/documents/temp/MySqlLogin.txt");
		Scanner fileScanner = new Scanner(new FileInputStream(inputFile), "UTF-8");
		
	    fileScanUser = fileScanner.nextLine();
	    fileScanPass = fileScanner.nextLine(); 
	    fileScanner.close();
		
		try (
			Connection conn = DriverManager.getConnection(DbUrlString, fileScanUser, fileScanPass);
			Statement stmt = conn.createStatement();
			) {
			
			stmt.executeUpdate(sqlQuery);			

			} catch (SQLException ex) {
				ex.printStackTrace();
				}
		
		return "Executed.";
	}
}