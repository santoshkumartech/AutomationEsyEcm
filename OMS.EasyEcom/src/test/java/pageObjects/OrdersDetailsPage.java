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
	
	@FindBy(xpath="//td[@id='Total Invoice Amount']")
	WebElement totalInvoiceAmount;
	
	@FindBy(xpath="//select[@f_type='payment_mode_id']")
	WebElement paymentDropdown;
	
	public void switchToOrderDetailsPage() {
		wu.switchToWindowContainingElement(driver, overviewText);	
	}
	
	public WebElement getPaymentDropdown() {
		return this.paymentDropdown;
	}
	
}
