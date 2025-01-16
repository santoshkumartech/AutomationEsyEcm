package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@type='email']")
	WebElement emailTF;
	
	@FindBy(xpath="//button[@id='continueLogin']")
	WebElement continueButton;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordTF;
	
	@FindBy(xpath="//button[@id='continueLogin']")
	WebElement loginButton;
	
	public void enterEmail(String email) {
		emailTF.sendKeys(email);
	}
	
	public void clickContinue() {
		continueButton.click();
	}
	
	public void enterPassword(String password) {
		passwordTF.sendKeys(password);	
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void login(String email,String password ) {
		emailTF.sendKeys(email);
		continueButton.click();
		passwordTF.sendKeys(password);
		loginButton.click();
		
	}
}
