package pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public Properties p;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[contains(text(),'Masters ')]")
	WebElement masters;
	
	@FindBy(xpath="//span[contains(text(),' Product Master ')]")
	WebElement productMaster;
	
	@FindBy(xpath="//i[@class='fa fa-plus-circle']")
	WebElement plus_Icon;
	
	@FindBy(xpath="//i[@class='fa fa-shopping-basket']")
	WebElement createRetailOrder;
	
	@FindBy(xpath="//select[@id='selectOrder']")
	WebElement selectOrderType_DropDown;
	
	public void naviagetToRetailOrderPage() {
		plus_Icon.click();
		createRetailOrder.click();
	}
	
}
