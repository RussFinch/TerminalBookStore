package DBInterfaces;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class DbInterface {

	//public scanner method to call whenever DBLogin details required in program
	public final static String DbLogin() throws FileNotFoundException { 
	
		String fileScanUser = "";
		String fileScanPass = "";
		String fileScanDbUrl = "";
		String loginFile = "/Users/russellfincham/documents/temp/MySqlLogin.txt";
		
		Scanner fileScanner = new Scanner(new FileInputStream(loginFile), "UTF-8");
		
	    fileScanUser = fileScanner.nextLine();
	    fileScanPass = fileScanner.nextLine();
	    fileScanDbUrl = fileScanner.nextLine(); 
	    fileScanner.close();
	    
	    return (fileScanUser + "," + fileScanPass + "," + fileScanDbUrl);
	}
	
	//public method used as query interface to the database
	public static String queryDatabase(String sqlQuery) throws FileNotFoundException {

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
			
			stmt.executeUpdate(sqlQuery);			

			} catch (SQLException ex) {
				ex.printStackTrace();
				}
		
		return "Executed.";
	}
}