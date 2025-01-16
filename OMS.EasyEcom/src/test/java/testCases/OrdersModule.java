package testCases;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RetailOrdersPage;
import utilities.BaseClass;

public class OrdersModule extends BaseClass {

	@Test
	public void createRetailOrder_Tc001(){
		
		LoginPage lp = new LoginPage(driver);
		lp.login(p.getProperty("email"), p.getProperty("password"));
		test.log(Status.INFO, "login successfull");
		
		HomePage hp = new HomePage(driver);
		hp.naviagetToRetailOrderPage();
		test.log(Status.INFO, "navigated to retail orders page");
		
		RetailOrdersPage rop = new RetailOrdersPage(driver);
		
		rop.scrollToNameTextField();
		test.log(Status.INFO, "scrolled till name text field is visible");
		
		rop.enterConatctPersonDetails("tester", "demo@test.com", "8856985466");
		test.log(Status.INFO, "Entered contact person details");
		
		rop.enterShippingAddress("Chruch Street","Bengaluru", "560085");
		test.log(Status.INFO, "Entered shipping address details and copied same to billing adress");

		
	}
}
