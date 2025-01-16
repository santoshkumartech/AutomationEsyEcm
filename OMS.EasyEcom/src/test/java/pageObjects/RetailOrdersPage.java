package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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
	
//	@FindBy(xpath="//h5[text()='Shipping Address']/..//div[text()='Select Country']")
//	WebElement countryDropdownShipping;
	
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
	
	public void scrollToNameTextField() {
        wu.scrollToElement(driver, nameTF, 3);
    }
	
	public void enterConatctPersonDetails(String name, String email, String contactNo) {
		
		nameTF.sendKeys(name);
		emailTF.sendKeys(email);
		contactNoTF.sendKeys(contactNo);
		saveContactPerson.click();
	}
		
	public void enterShippingAddress(String street, String city,  String postalCode) {
		streetTF.sendKeys(street);
		cityTF.sendKeys(city);
		countryText.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		wu.waitUntilElementClickable(driver, 10, countryDropdownShipping);
		countryDropdownShipping.click();
		wu.waitUntilElementClickable(driver, 10, indiaOption);
		indiaOption.click();
		wu.waitUntilElementClickable(driver, 10, stateDropdownShipping);
		stateDropdownShipping.click();
		wu.waitUntilElementClickable(driver, 10, karnatakaOption);
		karnatakaOption.click();
		
		postalCodeTF.sendKeys(postalCode);
		copyShippingAddressToBillingAddressCheckbox.click();
		saveShippingAddress.click();
		saveBillingAddress.click();
	}
	
}
