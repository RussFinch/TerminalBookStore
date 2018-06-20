package DBInterfaces;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DbInterface {

	//public properties method to call whenever DBLogin details required in program
	public final static String DbLogin() throws FileNotFoundException { 
		
		String UserId = "";
		String Password = "";
		String DbUrl = "";
		
		FileInputStream in = new FileInputStream("/Users/russellfincham/documents/temp/MySqlLogin.txt");
		Properties properties = new Properties();
		
		try {
			properties.load(in);
			in.close();
			
			UserId = properties.getProperty("UserId");
			Password = properties.getProperty("Password");
			DbUrl = properties.getProperty("DbUrl");
		
		} catch (IOException e) {
			e.printStackTrace();
			}
	    
	    return (UserId + "," + Password + "," + DbUrl);
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