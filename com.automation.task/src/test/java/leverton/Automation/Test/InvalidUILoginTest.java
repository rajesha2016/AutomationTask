package leverton.Automation.Test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import leverton.Automation.TestPage.InvalidUILoginPage;
import leverton.automation.framework.TestDataProviderClass;
import leverton.automation.framework.TestInitialization;


/**
 * @author r.moharana
 *
 */
public class InvalidUILoginTest extends TestInitialization{
	
	@Test(dataProvider="InvalidUILoginTestData",dataProviderClass=TestDataProviderClass.class)
	public void testDataProvider(String _wrongUserName, String _wrongPassword,String _errorMessageToBeValidated) {
		
		
		try {
						
				InvalidUILoginPage login_page=PageFactory.initElements(driver, InvalidUILoginPage.class);
				
				login_page.enterInvalidCredentials(_wrongUserName, _wrongPassword);
				login_page.clickLoginButton();
				
				Assert.assertEquals(login_page.getErrorMessage(), _errorMessageToBeValidated,"Error message text validated successfully");
				
				System.out.println("*** Automated UI Test Completed for user name "+_wrongUserName+" & password "+_wrongPassword+" ***" );
				
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
}
