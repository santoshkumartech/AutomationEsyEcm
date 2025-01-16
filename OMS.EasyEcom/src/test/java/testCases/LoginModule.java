package testCases;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import pageObjects.LoginPage;
import utilities.BaseClass;

public class LoginModule extends BaseClass {

	@Test
	public void loginEasyEcom_Tc001()	{	
		
		LoginPage lp = new LoginPage(driver);
	
		lp.enterEmail(p.getProperty("email"));
		test.log(Status.INFO, "Entering Email");
		
		lp.clickContinue();
		test.log(Status.INFO, "clicking on continue");

		lp.enterPassword(p.getProperty("password"));
		test.log(Status.INFO, "Entered password");

		lp.clickLogin();
		test.log(Status.INFO, "Clicked on login");
	}
}
