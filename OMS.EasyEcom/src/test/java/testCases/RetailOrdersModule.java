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
	String sku2 ="mob111";
	String price = "16000";
	String collectableAmount ="15000";
	String discount = "500";
	String shippingCharge = "40";
	String qty ="2";
	String discount2 ="1000";
	
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

		rop.selectPaymentMode(paymentMode);
		test.log(Status.INFO, "selected the " + paymentMode + " of payment");
		
		rop.searchAndValidateProduct(sku);
		test.log(Status.INFO, "selected the " + sku + " Product");

		rop.enterPriceProduct(sku, price);
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
		wu.switchToLastOpenedWindowAndCloseOthers(driver);
		
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

			rop.enterPriceProduct(sku, price);
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
			wu.switchToLastOpenedWindowAndCloseOthers(driver);
			
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

		rop.enterPriceProduct(sku, price);
		test.log(Status.INFO, "entered price " + price + " for the product "+ sku);
		
		rop.enterDiscount(sku,discount);
		test.log(Status.INFO, "entered discount " + discount + " for the product "+ sku);
		
		double expectedTotal = ju.calculateTotalAfterDiscount(price, discount);
		String actualTotalText = rop.getTotalText().getText();
		
		// Remove commas from the actual total text if present
		actualTotalText = actualTotalText.replaceAll(",", "");
		double actualTotal = Double.parseDouble(actualTotalText);
		if (expectedTotal == actualTotal) {
			test.log(Status.INFO,"Expected total "+expectedTotal+" and Actual total "+actualTotal+" Test Passed! The total values match.");
        } else {
			test.log(Status.INFO,"Expected total "+expectedTotal+" and Actual total "+actualTotal+" Test Failed! The total values does not match.");
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
		
		wu.switchToLastOpenedWindowAndCloseOthers(driver);
		
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

		rop.enterPriceProduct(sku, price);
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
		wu.switchToLastOpenedWindowAndCloseOthers(driver);
		
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
	
	@Test(priority=5)
	public void B2C_005() {
		
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
		
		rop.enterQty(sku,qty);
		test.log(Status.INFO, "Entered " + qty + " in QTY textfield for the product "+ sku);

		rop.enterPriceProduct(sku, price);
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
		wu.switchToLastOpenedWindowAndCloseOthers(driver);
		
		double expectedTotal = ju.calculateTotalAfterMultiplyingQuantity(price, qty);
		String actualTotalText = odp.getTotalInvoiceAmount().getText();
		actualTotalText = actualTotalText.replaceAll("[^0-9.]", "");
		double actualTotal = Double.parseDouble(actualTotalText);
		if (expectedTotal == actualTotal) {
			test.log(Status.INFO,"Expected total "+expectedTotal+" and Actual total "+actualTotal+" Test Passed! The total values match.");
        } else {
			test.log(Status.INFO,"Expected total "+expectedTotal+" and Actual total "+actualTotal+" Test Failed! The total values does not match.");
        }
		
		String quantityInOrdersDetailsPage = odp.getQuantity(sku).getDomAttribute("value");
		if (qty.equals(quantityInOrdersDetailsPage)) {
			test.log(Status.INFO,"The total quantity values match.");
        } else {
			test.log(Status.INFO,"The total quantity values do not match.");
        }
	}
	
	@Test(priority=6)
	public void B2C_006() {
	
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
		
		rop.clickRemoveIcon();
		test.log(Status.INFO, "Removed the " + sku + " Product");
		
		rop.searchAndValidateProduct(sku2);
		test.log(Status.INFO, "selected the " + sku2 + " Product");
		
		rop.enterPriceProduct(sku2, price);
		test.log(Status.INFO, "entered price " + price + " for the product "+ sku2);
		
		rop.clickCreateButton();
		test.log(Status.INFO, "clicked on create order button");
		
		rop.verifyOrderCreated();
		test.log(Status.INFO, "Order created successfully");

		rop.clickOkButton();
		test.log(Status.INFO, "clicked ok button in success popup");
		
		OrdersDetailsPage odp = new OrdersDetailsPage(driver);
		odp.switchToOrderDetailsPage();
		test.log(Status.INFO, "Switched to orders details tab");
		wu.switchToLastOpenedWindowAndCloseOthers(driver);
		
		String actualTotalText = odp.getTotalInvoiceAmount().getText();
		actualTotalText = actualTotalText.replaceAll("[^0-9.]", "");
		double actualTotal = Double.parseDouble(actualTotalText);
		double convertedPrice = ju.stringToDouble(price);
		if (convertedPrice == actualTotal) {
			test.log(Status.INFO,"Expected total "+convertedPrice+" and Actual total "+actualTotal+" Test Passed! The total values match.");
        } else {
			test.log(Status.INFO,"Expected total "+convertedPrice+" and Actual total "+actualTotal+" Test Failed! The total values does not match.");
        }
	}
	
	@Test(priority=7)
	public void B2C_007() {
		
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
		
		rop.enterPriceProduct(sku, price);
		test.log(Status.INFO, "entered price " + price + " for the product "+ sku);
		
		rop.searchAndValidateProduct(sku2);
		test.log(Status.INFO, "selected the " + sku2 + " Product");
		
		rop.enterPriceProduct(sku2, price);
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
		wu.switchToLastOpenedWindowAndCloseOthers(driver);
		String skuText = odp.getSkuText(sku);
		if(skuText.equals(sku)) {
			test.log(Status.INFO, "Sku entered in retail orders page and Sku displayed in orders detail page are same");
		}
		else
			test.log(Status.INFO, "Sku entered in retail orders page and Sku displayed in orders detail page are not same");	
		
		String sku2Text = odp.getSkuText(sku2);
		if(sku2Text.equals(sku2)) {
			test.log(Status.INFO, "Sku entered in retail orders page and Sku displayed in orders detail page are same");
		}
		else
			test.log(Status.INFO, "Sku entered in retail orders page and Sku displayed in orders detail page are not same");	
	}
	
	@Test(priority=8)
	public void B2C_008() {
		
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
		
		rop.enterPriceProduct(sku, price);
		test.log(Status.INFO, "entered price " + price + " for the product "+ sku);
		
		rop.enterQty(sku,qty);
		test.log(Status.INFO, "Entered " + qty + " in QTY textfield for the product "+ sku);
		
		rop.searchAndValidateProduct(sku2);
		test.log(Status.INFO, "selected the " + sku2 + " Product");
		
		rop.enterPriceProduct(sku2, price);
		test.log(Status.INFO, "entered price " + price + " for the product "+ sku2);
		
		rop.enterQty(sku2,qty);
		test.log(Status.INFO, "Entered " + qty + " in QTY textfield for the product "+ sku2);
		
		rop.clickCreateButton();
		test.log(Status.INFO, "clicked on create order button");
		
		rop.verifyOrderCreated();
		test.log(Status.INFO, "Order created successfully");

		rop.clickOkButton();
		test.log(Status.INFO, "clicked ok button in success popup");
		
		OrdersDetailsPage odp = new OrdersDetailsPage(driver);
		odp.switchToOrderDetailsPage();
		test.log(Status.INFO, "Switched to orders details tab");
		wu.switchToLastOpenedWindowAndCloseOthers(driver);
		
		String skuTextInOrdersDetailsPage = odp.getSkuText(sku);
		Assert.assertEquals(sku, skuTextInOrdersDetailsPage);
		
		String sku2TextInOrdersDetailsPage = odp.getSkuText(sku2);
		Assert.assertEquals(sku2, sku2TextInOrdersDetailsPage);
		
		String Sku1QuantityInOrdersDetailsPage = odp.getQuantity(sku).getDomAttribute("value");
		if (qty.equals(Sku1QuantityInOrdersDetailsPage)) {
			test.log(Status.INFO,"The total quantity values match.");
        } else {
			test.log(Status.FAIL,"The total quantity values do not match.");
        }
		
		String Sku2QuantityInOrdersDetailsPage = odp.getQuantity(sku2).getDomAttribute("value");
		if (qty.equals(Sku2QuantityInOrdersDetailsPage)) {
			test.log(Status.INFO,"The total quantity values match.");
        } else {
			test.log(Status.FAIL,"The total quantity values do not match.");
        }
	}
	
	@Test(priority=9)
	public void B2C_009() {
		
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
		
		rop.enterPriceProduct(sku, price);
		test.log(Status.INFO, "entered price " + price + " for the product "+ sku);
		
		rop.enterQty(sku,qty);
		test.log(Status.INFO, "Entered " + qty + " in QTY textfield for the product "+ sku);
		
		rop.enterDiscount(sku, discount);
		test.log(Status.INFO, "entered discount " + discount + " for the product "+ sku);
		
		rop.searchAndValidateProduct(sku2);
		test.log(Status.INFO, "selected the " + sku2 + " Product");
		
		rop.enterPriceProduct(sku2, price);
		test.log(Status.INFO, "entered price " + price + " for the product "+ sku2);
		
		rop.enterQty(sku2,qty);
		test.log(Status.INFO, "Entered " + qty + " in QTY textfield for the product "+ sku2);
		
		rop.enterDiscount(sku2, discount2);
		test.log(Status.INFO, "entered discount " + discount2 + " for the product "+ sku2);
		
		rop.clickCreateButton();
		test.log(Status.INFO, "clicked on create order button");
		
		rop.verifyOrderCreated();
		test.log(Status.INFO, "Order created successfully");

		rop.clickOkButton();
		test.log(Status.INFO, "clicked ok button in success popup");
		
		OrdersDetailsPage odp = new OrdersDetailsPage(driver);
		odp.switchToOrderDetailsPage();
		test.log(Status.INFO, "Switched to orders details tab");
		wu.switchToLastOpenedWindowAndCloseOthers(driver);
		
		String actualTotalTextInOrderDetailPage = odp.getTotalInvoiceAmount().getText();
		actualTotalTextInOrderDetailPage = actualTotalTextInOrderDetailPage.replaceAll("[^0-9.]", "");
		double actualTotalInOrderDetailPage = Double.parseDouble(actualTotalTextInOrderDetailPage);
		
		double expectedTotalOfSku1 = ju.totalAfterDiscountAndQuantities(price,qty, discount);
		double expectedTotalOfSku2 = ju.totalAfterDiscountAndQuantities(price,qty, discount2);
		double expectedTotal = ju.add(expectedTotalOfSku1, expectedTotalOfSku2);
		
		if (expectedTotal == actualTotalInOrderDetailPage) {
			test.log(Status.INFO,"Expected total "+expectedTotal+" and Actual total "+actualTotalInOrderDetailPage+" Test Passed! The total values match.");
        } else {
			test.log(Status.INFO,"Expected total "+expectedTotal+" and Actual total "+actualTotalInOrderDetailPage+" Test Failed! The total values does not match.");
        }
	}
	
	@Test(priority=10)
	public void B2C_010() {
		
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
		
		rop.enterPriceProduct(sku, price);
		test.log(Status.INFO, "entered price " + price + " for the product "+ sku);
		
		rop.enterQty(sku,qty);
		test.log(Status.INFO, "Entered " + qty + " in QTY textfield for the product "+ sku);
		
		rop.enterDiscount(sku, discount);
		test.log(Status.INFO, "entered discount " + discount + " for the product "+ sku);
		
		rop.searchAndValidateProduct(sku2);
		test.log(Status.INFO, "selected the " + sku2 + " Product");
		
		rop.enterPriceProduct(sku2, price);
		test.log(Status.INFO, "entered price " + price + " for the product "+ sku2);
		
		rop.enterQty(sku2,qty);
		test.log(Status.INFO, "Entered " + qty + " in QTY textfield for the product "+ sku2);
		
		rop.enterDiscount(sku2, discount2);
		test.log(Status.INFO, "entered discount " + discount2 + " for the product "+ sku2);
		
		rop.enterShippingCharges(shippingCharge);
		test.log(Status.INFO, "entered shipping charge of " + shippingCharge + " for the product "+ sku);
		
		rop.clickCreateButton();
		test.log(Status.INFO, "clicked on create order button");
		
		rop.verifyOrderCreated();
		test.log(Status.INFO, "Order created successfully");

		rop.clickOkButton();
		test.log(Status.INFO, "clicked ok button in success popup");
		
		OrdersDetailsPage odp = new OrdersDetailsPage(driver);
		odp.switchToOrderDetailsPage();
		test.log(Status.INFO, "Switched to orders details tab");
		wu.switchToLastOpenedWindowAndCloseOthers(driver);
		
		String actualTotalTextInOrderDetailPage = odp.getTotalInvoiceAmount().getText();
		actualTotalTextInOrderDetailPage = actualTotalTextInOrderDetailPage.replaceAll("[^0-9.]", "");
		double actualTotalInOrderDetailPage = Double.parseDouble(actualTotalTextInOrderDetailPage);
		double shippingChargesConvereted = ju.stringToDouble(shippingCharge);
		
		double expectedTotalOfSku1 = ju.totalAfterDiscountAndQuantities(price,qty, discount);
		double expectedTotalOfSku2 = ju.totalAfterDiscountAndQuantities(price,qty, discount2);
		double expectedTotal = ju.add(expectedTotalOfSku1, expectedTotalOfSku2,shippingChargesConvereted);
		
		if (expectedTotal == actualTotalInOrderDetailPage) {
			test.log(Status.INFO,"Expected total "+expectedTotal+" and Actual total "+actualTotalInOrderDetailPage+" Test Passed! The total values match.");
        } else {
			test.log(Status.INFO,"Expected total "+expectedTotal+" and Actual total "+actualTotalInOrderDetailPage+" Test Failed! The total values does not match.");
        }
	}
}
