package testCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class loginModule extends BaseClass{
	
	@Test
	public void loginEasyEcom_Tc001()	{	
		
		LoginPage lp = new LoginPage(driver);
	
		lp.enterEmail(p.getProperty("email"));
		test.log(Status.INFO, "entering Email");
		
		lp.clickContinue();
		test.log(Status.INFO, "clicking on continue");

		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
	}
}
