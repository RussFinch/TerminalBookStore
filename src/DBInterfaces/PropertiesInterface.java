package DBInterfaces;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class manages changes to the properties file that
 * holds DB access privileges.
 * @author russellfincham
 * @version 0.1
 * @since 26-06-18
 */

public class PropertiesInterface {
	/**
	 * This method manages changes to the properties file that
	 * holds DB access privileges and url.
	 * It receives the request from CliSettingsDbAccess.dbAccessConfig.
	 * @throws FileNotFoundException if data file cannot be accessed.
	 * @param newPropertyValue String indicating the setting to be changed.
	 * @param value New value for the setting.
	 * @return String returned to calling code indicating "Configuration Updated.".
	 */
	public static String DbAccessProperties (String newPropertyValue, String value) throws FileNotFoundException {
		
		FileInputStream in = new FileInputStream("/Users/russellfincham/documents/temp/MySqlLogin.txt");
		Properties properties = new Properties();
		
		try {
			//Load properties from file into properties table
			properties.load(in);
			in.close();

			FileOutputStream out = new FileOutputStream("/Users/russellfincham/documents/temp/MySqlLogin.txt");
			
			//Set new values for system properties.
			properties.setProperty(newPropertyValue, value);
			properties.store(out, null);
			out.close();
		
		} catch (IOException e) {
			e.printStackTrace();
			}
		
		return "Configuration Updated...";
	}
}
