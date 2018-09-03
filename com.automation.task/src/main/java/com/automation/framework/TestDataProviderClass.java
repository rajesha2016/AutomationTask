package com.automation.framework;

import org.testng.annotations.DataProvider;

/**
 * @author r.moharana
 * This class provides parameterization to Automated tests
 */
public class TestDataProviderClass {
	
	
	/**
	 * this method to provide test data for Automated UI test
	 * @return two dimensional Object array.
	 * Rows- Number of times test has to repeated.
	 * Columns - Number of parameters in test data. 
	 */
	@DataProvider(name="InvalidUILoginTestData")
    public static Object[][] getTestDataforInvalidLogin(){
		
        return new Object[][] {
        	
            { "wrongusername1", "password1","Sorry, we were not able to find a user with that username and password."},
            { "wrongusername2", "password2","Sorry, we were not able to find a user with that username and password."},
            { "wrongusername3", "password3","Sorry, we were not able to find a user with that username and password."}
            
        };  
	}
	
	
	
	/**
	 * this method to provide test data for Automated API test
	 * @return two dimensional Object array.
	 * Rows- Number of times test has to repeated.
	 * Columns - Number of parameters in test data.
	 */
	@DataProvider(name="CountryVerificationTestData")
    public static Object[][] getTestDataforAPI(){
		
        return new Object[][] {
        	
            { "Germany"},
            { "India"},
            { "Australia"},
            { "France" },
            { "Italy" }
            
        };  
	}
    
}
