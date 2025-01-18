package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
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
	WebElement createOrder;
	
	@FindBy(xpath="//select[@id='selectOrder']")
	WebElement selectOrderType_DropDown;
	
	public void naviagetToCreateOrderPage() {
		this.plus_Icon.click();
		this.createOrder.click();
	}
	
	public void selectOrderType(String orderType) {
		wu.selectByVisibileText(this.selectOrderType_DropDown, orderType);
	}
	
	
}
