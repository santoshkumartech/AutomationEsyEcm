package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.WebdriverUtility;

public class BasePage {
	
	WebDriver driver;
	WebdriverUtility wu = new WebdriverUtility();
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
}
