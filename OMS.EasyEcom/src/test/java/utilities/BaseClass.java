 package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public WebDriver driver;
	public Properties p;
	static ExtentReports report;
	public ExtentTest test;
	
	
	@BeforeSuite
	public void setupReport(ITestContext context)
	{
		String suiteName = context.getSuite().getName();
		 
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./reports/"+getLocalDateTime()+".html");
		sparkReporter.config().setReportName("Suite: " + suiteName);
		report = new ExtentReports();
		report.attachReporter(sparkReporter);
	
	}
	
	@BeforeTest
	public void setupTest(XmlTest test)
	{
		String testName = test.getName();
		report.setSystemInfo("Test", testName);
	}
	
	@BeforeClass
	public void setup() throws IOException
	{	
		
		FileReader file = new FileReader("src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		driver.get(p.getProperty("appURL"));
	}
	
	@BeforeMethod
	public void configureTestReport(Method method)
	{
		test = report.createTest(method.getName());
	}
	
	
	@AfterMethod
    public void teardownTest(ITestResult result) {
		
        if (result.getStatus() == ITestResult.SUCCESS) {
        	test.log(Status.PASS,"Test passed successfully.");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL,"Test failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
        	 test.log(Status.SKIP,"Test skipped: " + result.getThrowable());
        }
    }
	
	@AfterClass
	public void tearDown()
	{
//		driver.quit();
	}
	
	
	@AfterSuite
	public void flushReport() 
	{
		report.flush();
	}
	
	
	private static String getLocalDateTime() {
		LocalDateTime DateTime = LocalDateTime.now();
		return DateTime.getHour()+"Hr-"+DateTime.getMinute()+"Min-"+DateTime.getSecond()+"Sec "+DateTime.getDayOfMonth()+"-"+DateTime.getMonthValue()+"-"+DateTime.getYear(); 
		
	}
	
}
