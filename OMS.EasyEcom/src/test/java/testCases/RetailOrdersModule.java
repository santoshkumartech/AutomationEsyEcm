package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OrdersDetailsPage;
import pageObjects.RetailOrdersPage;
import utilities.BaseClass;

public class RetailOrdersModule extends BaseClass {

	String orderType="Retail Order";
	String paymentMode ="Online";
	String sku = "mob000";
	String price = "16000";
	String collectableAmount ="15000";
	String discount = "500";
	String shippingCharge = "40";
	
	@Test(priority=1)
	public void B2C_001(){
		
		LoginPage lp = new LoginPage(driver);
		lp.login(p.getProperty("email"), p.getProperty("password"));
		test.log(Status.INFO, "login successfull");
		
		HomePage hp = new HomePage(driver);
		hp.naviagetToCreateOrderPage();
		test.log(Status.INFO, "navigated to create orders page");
		
		try {
				hp.selectOrderType(orderType);
				test.log(Status.INFO, "selected "+ orderType );
			} 
		catch (Exception e)
			{
				System.out.println("Create Retail order is selected by default");
			}
		
		RetailOrdersPage rop = new RetailOrdersPage(driver);
		rop.scrollToNameTextField();
		test.log(Status.INFO, "scrolled till name text field is visible");
		
		rop.enterConatctPersonDetails("tester", "demo@test.com", "8856985466");
		test.log(Status.INFO, "Entered contact person details");
		
		rop.enterShippingAddress("Chruch Street","Bengaluru", "560085");
		test.log(Status.INFO, "Entered shipping address details and copied same to billing adress");
		
//		String referenceNumber = driver.findElement(By.xpath("//input[@placeholder='Enter Reference No.']")).getDomAttribute("value");
//		System.out.println(referenceNumber);

		rop.selectPaymentMode(paymentMode);
		test.log(Status.INFO, "selected the " + paymentMode + " of payment");
		
		rop.searchAndValidateProduct(sku);
		test.log(Status.INFO, "selected the " + sku + " Product");

		rop.enterPriceProduct(price);
		test.log(Status.INFO, "entered price " + price + " for the product "+ sku);
		
		rop.clickCreateButton();
		test.log(Status.INFO, "clicked on create order button");
		
		rop.verifyOrderCreated();
		test.log(Status.INFO, "Order created successfully");

		rop.clickOkButton();
		test.log(Status.INFO, "clicked ok button in success popup");
		
		OrdersDetailsPage odp = new OrdersDetailsPage(driver);
		odp.switchToOrderDetailsPage();
		test.log(Status.INFO, "Switched to orders details tab");
		
		boolean paymentIsSelected = wu.verifyOptionIsSelected(odp.getPaymentDropdown(), paymentMode);
		System.out.println("Is the "+paymentMode+" payment mode selected: " + paymentIsSelected);
		Assert.assertTrue(paymentIsSelected, " The payment mode is not selected as expected.");
		test.log(Status.INFO, "verified that "+paymentMode+ " is displayed in the payment dropdown of the orders details page");

	}
	
	@Test(priority=2)
	public void B2C_002() {

			HomePage hp = new HomePage(driver);
			hp.naviagetToCreateOrderPage();
			test.log(Status.INFO, "navigated to create orders page");
			
			try {
					hp.selectOrderType(orderType);
					test.log(Status.INFO, "selected "+ orderType );
				} catch (Exception e)
				{
					System.out.println("Create Retail order is selected by default");
				}
			
			RetailOrdersPage rop = new RetailOrdersPage(driver);
			rop.scrollToNameTextField();
			test.log(Status.INFO, "scrolled till name text field is visible");
			
			rop.enterConatctPersonDetails("tester", "demo@test.com", "8856985466");
			test.log(Status.INFO, "Entered contact person details");
			
			rop.enterShippingAddress("Chruch Street","Bengaluru", "560085");
			test.log(Status.INFO, "Entered shipping address details and copied same to billing adress");
			
			rop.selectPaymentMode("COD");;
			test.log(Status.INFO, "selected the COD of payment");
			
			rop.searchAndValidateProduct(sku);
			test.log(Status.INFO, "selected the " + sku + " product");

			rop.enterPriceProduct(price);
			test.log(Status.INFO, "entered price " + price + " for the product "+ sku);
			
			rop.enterCollectableAmount(collectableAmount);
			test.log(Status.INFO, "entered collectable amount of " + collectableAmount + " for the product "+ sku);

			rop.clickCreateButton();
			test.log(Status.INFO, "clicked on create order button");
			
			rop.verifyOrderCreated();
			test.log(Status.INFO, "Order created successfully");

			rop.clickOkButton();
			test.log(Status.INFO, "clicked ok button in success popup");
			
			OrdersDetailsPage odp = new OrdersDetailsPage(driver);
			odp.switchToOrderDetailsPage();
			test.log(Status.INFO, "Switched to orders details tab");
			
			boolean paymentIsSelected = wu.verifyOptionIsSelected(odp.getPaymentDropdown(), "COD");
			System.out.println("Is the COD payment mode selected: " + paymentIsSelected);
			Assert.assertTrue(paymentIsSelected, " The payment mode is not selected as expected.");
			test.log(Status.INFO, "verified that collectable amount textfield is displayed in Add Items to Order section of Retail Orders Page and Cod is displayed in the payment dropdown of the orders details page");
			
			String collectableAmountInOdersDetailPage = odp.collectableAmountText().getText();
			
			if (collectableAmount.equals(collectableAmountInOdersDetailPage)) {
			    test.log(Status.INFO, "collectable amount on both pages matches");
			} else {
			    test.log(Status.INFO, "Text on pages do not match. Page 1: " + collectableAmount + ", Page 2: " + collectableAmountInOdersDetailPage);
			}	
		}
	
	@Test(priority=3)
	public void B2C_003() {
		
		HomePage hp = new HomePage(driver);
		hp.naviagetToCreateOrderPage();
		test.log(Status.INFO, "navigated to create orders page");
		
		try {
				hp.selectOrderType(orderType);
				test.log(Status.INFO, "selected "+ orderType );
			} 
		catch (Exception e)
			{
				System.out.println("Create Retail order is selected by default");
			}
		
		RetailOrdersPage rop = new RetailOrdersPage(driver);
		rop.scrollToNameTextField();
		test.log(Status.INFO, "scrolled till name text field is visible");
		
		rop.enterConatctPersonDetails("tester", "demo@test.com", "8856985466");
		test.log(Status.INFO, "Entered contact person details");
		
		rop.enterShippingAddress("Chruch Street","Bengaluru", "560085");
		test.log(Status.INFO, "Entered shipping address details and copied same to billing adress");

		rop.selectPaymentMode(paymentMode);
		test.log(Status.INFO, "selected the " + paymentMode + " of payment");
		
		rop.searchAndValidateProduct(sku);
		test.log(Status.INFO, "selected the " + sku + " Product");

		rop.enterPriceProduct(price);
		test.log(Status.INFO, "entered price " + price + " for the product "+ sku);
		
		rop.enterDiscount(discount);
		test.log(Status.INFO, "entered discount " + discount + " for the product "+ sku);
		
		
		
		double expectedTotal = ju.calculateTotalAfterDiscount(price, discount);
		String actualTotalText = rop.getTotalText().getText();
		
		// Remove commas from the actual total text if present
		actualTotalText = actualTotalText.replaceAll(",", "");
		double actualTotal = Double.parseDouble(actualTotalText);
		if (expectedTotal == actualTotal) {
			test.log(Status.INFO,"Expected total "+expectedTotal+" and Actual total "+actualTotal+" Test Passed! The total values match.");
            System.out.println("Test Passed! The total values match.");
        } else {
			test.log(Status.INFO,"Expected total "+expectedTotal+" and Actual total "+actualTotal+" Test Failed! The total values does not match.");
            System.out.println("Test Failed! The expected total was " + expectedTotal + " but the actual total was " + actualTotal);
        }
		
		rop.clickCreateButton();
		test.log(Status.INFO, "clicked on create order button");
		
		rop.verifyOrderCreated();
		test.log(Status.INFO, "Order created successfully");

		rop.clickOkButton();
		test.log(Status.INFO, "clicked ok button in success popup");
		
		OrdersDetailsPage odp = new OrdersDetailsPage(driver);
		odp.switchToOrderDetailsPage();
		test.log(Status.INFO, "Switched to orders details tab");
		
		boolean paymentIsSelected = wu.verifyOptionIsSelected(odp.getPaymentDropdown(), paymentMode);
		System.out.println("Is the "+paymentMode+" payment mode selected: " + paymentIsSelected);
		Assert.assertTrue(paymentIsSelected, " The payment mode is not selected as expected.");
		test.log(Status.INFO, "verified that "+paymentMode+ " is displayed in the payment dropdown of the orders details page");
	}
	
	
	@Test(priority=4) 
	public void B2C_004() {
		
		HomePage hp = new HomePage(driver);
		hp.naviagetToCreateOrderPage();
		test.log(Status.INFO, "navigated to create orders page");
		
		try {
				hp.selectOrderType(orderType);
				test.log(Status.INFO, "selected "+ orderType );
			} 
		catch (Exception e)
			{
				System.out.println("Create Retail order is selected by default");
			}
		
		RetailOrdersPage rop = new RetailOrdersPage(driver);
		rop.scrollToNameTextField();
		test.log(Status.INFO, "scrolled till name text field is visible");
		
		rop.enterConatctPersonDetails("tester", "demo@test.com", "8856985466");
		test.log(Status.INFO, "Entered contact person details");
		
		rop.enterShippingAddress("Chruch Street","Bengaluru", "560085");
		test.log(Status.INFO, "Entered shipping address details and copied same to billing adress");

		rop.selectPaymentMode(paymentMode);
		test.log(Status.INFO, "selected the " + paymentMode + " of payment");
		
		rop.searchAndValidateProduct(sku);
		test.log(Status.INFO, "selected the " + sku + " Product");

		rop.enterPriceProduct(price);
		test.log(Status.INFO, "entered price " + price + " for the product "+ sku);
		
		rop.enterShippingCharges(shippingCharge);
		test.log(Status.INFO, "entered shipping charge of " + shippingCharge + " for the product "+ sku);
		
		double expectedTotal = ju.calculateTotalAfterShippingCharges(price, shippingCharge);
		
		rop.clickCreateButton();
		test.log(Status.INFO, "clicked on create order button");
		
		rop.verifyOrderCreated();
		test.log(Status.INFO, "Order created successfully");

		rop.clickOkButton();
		test.log(Status.INFO, "clicked ok button in success popup");
		
		OrdersDetailsPage odp = new OrdersDetailsPage(driver);
		odp.switchToOrderDetailsPage();
		test.log(Status.INFO, "Switched to orders details tab");
		
		String actualTotalText = odp.getTotalInvoiceAmount().getText();
		// Remove the currency symbol (₹) and any spaces from the actual total text
		actualTotalText = actualTotalText.replaceAll("[^0-9.]", "");
		double actualTotal = Double.parseDouble(actualTotalText);
		if (expectedTotal == actualTotal) {
			test.log(Status.INFO,"Expected total "+expectedTotal+" and Actual total "+actualTotal+" Test Passed! The total values match.");
            System.out.println("Test Passed! The total values match.");
        } else {
			test.log(Status.INFO,"Expected total "+expectedTotal+" and Actual total "+actualTotal+" Test Failed! The total values does not match.");
            System.out.println("Test Failed! The expected total was " + expectedTotal + " but the actual total was " + actualTotal);
        }
		
	}
}
