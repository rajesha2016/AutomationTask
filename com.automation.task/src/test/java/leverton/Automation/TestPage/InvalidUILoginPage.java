package leverton.Automation.TestPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author r.moharana
 *
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
	
	public void enterInvalidCredentials(String uName, String pWord) {
		userName.sendKeys(uName);
		passWord.sendKeys(pWord);
	}
	
	public void clickLoginButton() {
		loginBtn.click();
	}

	public String getErrorMessage() {
		
		return errorMessageText.getText().trim();
	}

}
