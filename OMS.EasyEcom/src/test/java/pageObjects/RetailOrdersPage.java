package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RetailOrdersPage extends BasePage  {
	
	public RetailOrdersPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='Enter Name']")
	WebElement nameTF;
	
	@FindBy(xpath="//input[@placeholder='Enter Email']")
	WebElement emailTF;
	
	@FindBy(xpath="//input[@placeholder='Enter Contact Number']")
	WebElement contactNoTF;
	
	@FindBy(xpath="//h5[text()='Contact Person']/..//b[text()='Save']")
	WebElement saveContactPerson;
	
	@FindBy(xpath="//input[@placeholder='Enter Shipping Street']")
	WebElement streetTF;
	
	@FindBy(xpath="//input[@placeholder='Enter Shipping City']")
	WebElement cityTF;
	
	@FindBy(xpath="//h5[text()='Shipping Address']/..//label[text()='Country ']")
	WebElement countryText;
	
	@FindBy(xpath="//h5[text()='Shipping Address']/..//div[text()='Select Country']/../following-sibling::span")
	WebElement countryDropdownShipping;
	
	@FindBy(xpath="//span[text()='India']")
	WebElement indiaOption;
	
	@FindBy(xpath="//h5[text()='Shipping Address']/..//div[text()='Select States']/../following-sibling::span")
	WebElement stateDropdownShipping;
	
	@FindBy(xpath="//span[text()='Karnataka']")
	WebElement karnatakaOption;
	
	@FindBy(xpath="//input[@placeholder='Enter Shipping Postal Code']")
	WebElement postalCodeTF;
	
	@FindBy(xpath="//label[text()='Copy Shipping Address to Billing Address']")
	WebElement copyShippingAddressToBillingAddressCheckbox;
	
	@FindBy(xpath="//h5[text()='Shipping Address']/..//b[text()='Save']")
	WebElement saveShippingAddress;
	
	@FindBy(xpath="//h5[text()='Billing Address']/..//b[text()='Save']")
	WebElement saveBillingAddress;
	
	@FindBy(xpath="//h5[text()='Payment Mode ']")
	WebElement paymentModeText;
	
	@FindBy(xpath="//select[@class='full-width form-control ng-untouched ng-pristine ng-valid']")
	WebElement paymentModeDropdown;
	
	@FindBy(xpath="//input[@placeholder='Search Product...']")
	WebElement searchProductTF;
	
//	@FindBy(xpath="//tbody//td[3]//input[@type='number']")
//	WebElement qtyTF;
	
//	@FindBy(xpath="//tbody//td[5]//input[@type='number']")
//	WebElement priceTF;
	
//	@FindBy(xpath="//tbody//td[6]//input[@type='number']")
//	WebElement discountTF;
	
	@FindBy(xpath="//i[@class='fa fa-times-circle delete-item text-danger']")
	WebElement removeIcon;
	
	@FindBy(xpath="//textarea[@class='additional-notes form-control ng-valid ng-touched ng-dirty']")
	WebElement additionalNotesTF;
	
	//b[text()='Total: ']/../..//div[@class='col-md-4 col-6']
	@FindBy(xpath="(//td[@class='text-center'])[1]")
	WebElement totalText;
	
	@FindBy(xpath="//div[text()='Shipping Charge: ']/..//input[@type='number']")
	WebElement shippingChargeTF;
			
	@FindBy(xpath="//button[@class='btn btn-success']")
	WebElement createOrderButton;
	
	@FindBy(xpath="//h2[text()='Success!']")
	WebElement successText;
	
	@FindBy(xpath="//div[contains(text(),'Order No:')]")
	WebElement orderIdText;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement okButton;
	
	@FindBy(xpath="//div[text()='Collectable Amount: ']/..//input[@type='number']")
	WebElement collectableAmountTF;
	
	public void scrollToNameTextField() {
        wu.scrollToElement(driver, nameTF);
    }
	
	public void enterConatctPersonDetails(String name, String email, String contactNo) {
		
		this.nameTF.sendKeys(name);
		this.emailTF.sendKeys(email);
		this.contactNoTF.sendKeys(contactNo);
		this.saveContactPerson.click();
	}
		
	public void enterShippingAddress(String street, String city,  String postalCode) {
		this.streetTF.sendKeys(street);
		this.cityTF.sendKeys(city);
		this.countryText.click();
		
		wu.waitUntilElementClickable(driver, 10, countryDropdownShipping);
		this.countryDropdownShipping.click();
		wu.waitUntilElementClickable(driver, 10, indiaOption);
		this.indiaOption.click();
		wu.waitUntilElementClickable(driver, 10, stateDropdownShipping);
		this.stateDropdownShipping.click();
		wu.waitUntilElementClickable(driver, 10, karnatakaOption);
		this.karnatakaOption.click();
		
		this.postalCodeTF.sendKeys(postalCode);
		this.copyShippingAddressToBillingAddressCheckbox.click();
		this.saveShippingAddress.click();
		this.saveBillingAddress.click();
	}
	
	public void selectPaymentMode(String paymentMode) {
		wu.scrollToElement(driver, paymentModeText);
		wu.selectByVisibileText(paymentModeDropdown, paymentMode);
	}
	
	public void searchAndValidateProduct(String SKU) {
		wu.scrollToElement(driver, searchProductTF);
		this.searchProductTF.sendKeys(SKU);
		String SKUText = driver.findElement(By.xpath("//div[contains(text(), '"+SKU+"')]")).getText();
		Assert.assertTrue(SKUText.contains(SKU),"Search product is not matching");
	}
	
	public void enterPriceProduct(String sku,String price) {
		wu.scrollToElement(driver, this.createOrderButton);
		WebElement priceTF = driver.findElement(By.xpath("//div[contains(text(), '"+sku+"')]/../../td[5]//input[@type='number']"));
		wu.waitUntilElementVisible(driver, 2, priceTF);
		priceTF.clear();
		priceTF.sendKeys(price);
	}
	
	public void enterQty(String sku,String qty) {
		WebElement qtyTF = driver.findElement(By.xpath("//div[contains(text(), '"+sku+"')]/../../td[3]//input[@type='number']"));
		wu.waitUntilElementVisible(driver, 2, qtyTF);
		qtyTF.clear();
		qtyTF.sendKeys(qty);
	}
	
	public void enterDiscount(String sku,String discount) {
		WebElement discountTF = driver.findElement(By.xpath("//div[contains(text(), '"+sku+"')]/../../td[6]//input[@type='number']"));
		wu.waitUntilElementVisible(driver, 2, discountTF);
		discountTF.clear();
		discountTF.sendKeys(discount);
	}
	
	public void clickCreateButton() {
		
		wu.scrollToElement(driver, this.createOrderButton);
		this.createOrderButton.click();
	}
	
	public void verifyOrderCreated() {
		wu.waitUntilElementVisible(driver, 5, this.successText);
		wu.isDisplayed(this.successText);
	}
	
	public void clickOkButton() {
		this.okButton.click();
	}
	
	public void enterCollectableAmount(String collectableAmount) {
		wu.waitUntilElementVisible(driver, 5, this.collectableAmountTF);
		this.collectableAmountTF.sendKeys(collectableAmount);
	}
	
	public WebElement getTotalText() {
		return this.totalText;
	}
	
	public void enterShippingCharges(String shippingCharges) {
		this.shippingChargeTF.clear();
		this.shippingChargeTF.sendKeys(shippingCharges);
	}
	
	public void clickRemoveIcon() {
		this.removeIcon.click();
		}
	public void enterAdditionalNotes(String notes) {
		wu.waitUntilElementClickable(driver, 0, additionalNotesTF);
		this.additionalNotesTF.sendKeys(notes);
	}
	
}
