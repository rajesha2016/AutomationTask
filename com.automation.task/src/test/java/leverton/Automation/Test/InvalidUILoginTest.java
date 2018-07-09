package leverton.Automation.Test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import leverton.Automation.TestPage.InvalidUILoginPage;
import leverton.automation.framework.TestDataProviderClass;
import leverton.automation.framework.TestInitialization;


/**
 * @author r.moharana
 * Page Object Model- UI test class to validate Login failed scenario
 * It takes test data from TestDataProviderClass.java class
 * Access all InvalidUILoginPage.java class methods
 */
public class InvalidUILoginTest extends TestInitialization{
	
	@Test(dataProvider="InvalidUILoginTestData",dataProviderClass=TestDataProviderClass.class)
	public void testDataProvider(String _wrongUserName, String _wrongPassword,String _errorMessageToBeValidated) {
		
		
		try {
				
				//this initElements method will create all WebElements
				InvalidUILoginPage login_page=PageFactory.initElements(driver, InvalidUILoginPage.class);
				
				//pass username and password
				login_page.enterInvalidCredentials(_wrongUserName, _wrongPassword);
				login_page.clickLoginButton();
				
				//validate the error message user get after entering incorrect username and password
				Assert.assertEquals(login_page.getErrorMessage(), _errorMessageToBeValidated,"Error message text validated successfully");
				
				System.out.println("*** Automated UI Test Completed for user name "+_wrongUserName+" & password "+_wrongPassword+" ***" );
				
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
}
