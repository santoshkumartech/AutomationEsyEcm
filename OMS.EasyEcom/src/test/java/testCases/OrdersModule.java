package testCases;


import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testBase.BaseClass;

public class OrdersModule extends BaseClass {

	@Test
	public void Order_Tc001()	{		
		
		test.log(Status.INFO, "Order 1 Email");
		
		test.log(Status.INFO, "Order 1 on continue");
		}
	
	@Test
	public void Order_Tc002()	{		
		
		test.log(Status.INFO, "Order 2 Email");
		
		test.log(Status.INFO, "Order 2 on continue");
		
		Assert.fail();
		
		}
	
}
