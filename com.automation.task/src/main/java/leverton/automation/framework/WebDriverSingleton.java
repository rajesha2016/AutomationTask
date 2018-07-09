package leverton.automation.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author r.moharana
 * Singleton Design Pattern of Java
 * This class allows to creates only single WebDriver session and return the driver session to calling class
 */
public class WebDriverSingleton {
	
	// instance of singleton class
		private static WebDriverSingleton instanceofWebdriver=null;
		
		// instance of WebDriver
		private WebDriver driver;
		
		// Constructor
		private WebDriverSingleton() {
			
			//Please change the path here for Mac machine to ' System.getProperty("user.dir")+"//chromedriver.exe" ' replace '\\' with '//'
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		// TO create instance of class
		public static WebDriverSingleton getInstanceofWebdriver() {
			if(instanceofWebdriver == null) {
				instanceofWebdriver = new WebDriverSingleton();
			}
			
			return instanceofWebdriver;
		}

		// To get driver
		public WebDriver getDriver() {
			
			return driver;
		}

}
