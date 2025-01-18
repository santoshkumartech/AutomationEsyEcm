package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrdersDetailsPage extends BasePage {

	public OrdersDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='Overview']")
	WebElement overviewText;
	
	@FindBy(xpath="//div[contains(text(),'ORD/')]")
	WebElement orderNumberText;
	
	
	public void switchToOrderDetailsPage() {
		wu.switchToWindowContainingElement(driver, overviewText);
	}
}
