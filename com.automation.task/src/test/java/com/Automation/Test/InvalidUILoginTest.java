package com.Automation.Test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Automation.TestPage.InvalidUILoginPage;
import com.automation.framework.TestDataProviderClass;
import com.automation.framework.TestInitialization;


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
				
				//pass user name and password
				login_page.enterInvalidCredentials(_wrongUserName, _wrongPassword);
				login_page.clickLoginButton();
				
				//validate the error message user get after entering incorrect username and password
				Assert.assertEquals(login_page.getErrorMessage(), _errorMessageToBeValidated,"Expected text is not matching with actual");
				
				System.out.println("*** Automated UI Test passed for user name "+_wrongUserName+" & password "+_wrongPassword+" ***" );
				
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
}
