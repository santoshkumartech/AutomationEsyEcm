package testCases;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OrdersDetailsPage;
import pageObjects.RetailOrdersPage;
import utilities.BaseClass;

public class OrdersModule extends BaseClass {

	String orderType="Retail Order";
	String paymentMode ="Online";
	String sku = "mob000";
	String price = "16000";
	
	@Test(priority=1)
	public void createRetailOrder_Tc001(){
		
		LoginPage lp = new LoginPage(driver);
		
		lp.login(p.getProperty("email"), p.getProperty("password"));
		test.log(Status.INFO, "login successfull");
		
		HomePage hp = new HomePage(driver);
		
		hp.naviagetToCreateOrderPage();
		test.log(Status.INFO, "navigated to create orders page");
		
		hp.selectOrderType(orderType);
		test.log(Status.INFO, "selected "+ orderType );

		
		RetailOrdersPage rop = new RetailOrdersPage(driver);
		
		rop.scrollToNameTextField();
		test.log(Status.INFO, "scrolled till name text field is visible");
		
		rop.enterConatctPersonDetails("tester", "demo@test.com", "8856985466");
		test.log(Status.INFO, "Entered contact person details");
		
		rop.enterShippingAddress("Chruch Street","Bengaluru", "560085");
		test.log(Status.INFO, "Entered shipping address details and copied same to billing adress");

		rop.selectPaymentMode(paymentMode);
		test.log(Status.INFO, "selected the" + paymentMode + "of payment");
		
		rop.searchAndValidateProduct(sku);
		test.log(Status.INFO, "selected the" + sku + "of payment");

		rop.enterPriceProduct(price);
		test.log(Status.INFO, "entered" + price + "for the product"+ sku);
		
		rop.clickCreateButton();
		test.log(Status.INFO, "clicked on create order button");
		
		rop.verifyOrderCreated();
		test.log(Status.INFO, "Order created successfully");

		rop.clickOkButton();
		test.log(Status.INFO, "clicked ok button in success popup");


	}
	
	@Test(priority=2)
	public void VerifycreateRetailOrder_Tc002() {
		
		OrdersDetailsPage odp = new OrdersDetailsPage(driver);
		
		odp.switchToOrderDetailsPage();
		test.log(Status.INFO, "Switched to orders details tab");

	}
}
