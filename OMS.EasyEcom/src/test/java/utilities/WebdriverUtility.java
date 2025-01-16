package utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility  {
	
	public void selectByVisibileText(WebDriver driver, WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void waitUntilElementClickable(WebDriver driver, int  timeout, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	 public void scrollToElement(WebDriver driver, WebElement element, int scrollDelay) {
	        try {

	        	Actions actions = new Actions(driver);
	            actions.moveToElement(element).perform();
	            Thread.sleep(scrollDelay * 1000);  
	        	} 
	        		catch (InterruptedException e) {
	        			System.out.println("Error while scrolling up to element: " + e.getMessage());
	        		}
	 	}
}
