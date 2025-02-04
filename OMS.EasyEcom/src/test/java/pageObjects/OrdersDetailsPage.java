package pageObjects;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//label[contains(text(),'Collectable Amount:')]/../..//div[@class='col-md-6']")
	WebElement collectableAmountText;
	
//	@FindBy(xpath="//input[@style='max-width:70px']")
//	WebElement quantityText;
	
//	@FindBy(xpath="//table[@id='orderItemsTables']/tbody/tr[1]/td[7]")
//	WebElement skuText;
	
	@FindBy(xpath="//table[@id='orderItemsTables']/tbody/tr[2]/td[7]")
	WebElement sku2Text;
	
	public void switchToOrderDetailsPage() {
		wu.switchToWindowContainingElement(driver, overviewText);	
	}
	
	public WebElement getPaymentDropdown() {
		return this.paymentDropdown;
	}
	
	public WebElement collectableAmountText() {
		return this.collectableAmountText;
	}
	
	public WebElement getTotalInvoiceAmount() {
		return this.totalInvoiceAmount;
	}
	
//	public WebElement getquantityText() {
//		return this.quantityText;
//	}
	
//	public String getSkuText() {
//		return this.skuText.getText();
//	}
	
	public String getSkuText(String sku) {
		return driver.findElement(By.xpath("//a[contains(text(),'"+sku+"')]")).getText();
	}
	
	public WebElement getQuantity(String sku) {
	//a[contains(text(),'mob000')]/../../..//input[@style='max-width:70px']
	return this.driver.findElement(By.xpath("//a[contains(text(),'"+sku+"')]/../../..//input[@style='max-width:70px']"));
	}
	
}
