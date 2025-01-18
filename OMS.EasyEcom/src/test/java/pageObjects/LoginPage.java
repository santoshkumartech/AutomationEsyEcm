package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@type='email']")
	WebElement emailTF;

	@FindBy(xpath = "//button[@id='continueLogin']")
	WebElement continueButton;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordTF;

	@FindBy(xpath = "//button[@id='continueLogin']")
	WebElement loginButton;

	public void enterEmail(String email) {
		this.emailTF.sendKeys(email);
	}

	public void clickContinue() {
		this.continueButton.click();
	}

	public void enterPassword(String password) {
		this.passwordTF.sendKeys(password);
	}

	public void clickLogin() {
		this.loginButton.click();
	}

	public void login(String email, String password) {
		this.emailTF.sendKeys(email);
		this.continueButton.click();
		this.passwordTF.sendKeys(password);
		this.loginButton.click();

	}
}
