package com.Automation.TestPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author r.moharana
 * Page Object Model- This is Login page class for UI test
 * WebElements locators and Methods that support UI Test
 */
public class InvalidUILoginPage {
	
	@FindBy(xpath="//input[@id='username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='password-field']")
	WebElement passWord;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement loginBtn;
	
	@FindBy(xpath="//p[@class='subtitle']")
	WebElement errorMessageText;
	
	
	// This method set user name and password to the respective fields
	public void enterInvalidCredentials(String uName, String pWord) {
		userName.sendKeys(uName);
		passWord.sendKeys(pWord);
	}
	
	//This method click the login button
	public void clickLoginButton() {
		loginBtn.click();
	}

	//This method capture the login error text to validate
	public String getErrorMessage() {
		
		return errorMessageText.getText().trim();
	}

}
