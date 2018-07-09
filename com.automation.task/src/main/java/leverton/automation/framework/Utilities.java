package leverton.automation.framework;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author r.moharana
 * This class hold all generic methods to help tests
 */
public class Utilities {
	
public static Properties config=null;
	
	// method to initialize properties file
	public static void initConfig() {

		// Initialize the Properties class
		config = new Properties();

		// read properties file
		try {
			FileInputStream readConfig = new FileInputStream(System.getProperty("user.dir")+ "\\config.properties");

			// load properties file
			config.load(readConfig);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
