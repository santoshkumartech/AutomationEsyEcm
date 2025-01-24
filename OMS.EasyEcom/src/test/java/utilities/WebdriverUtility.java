package utilities;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility  {
	
	public void selectByVisibileText( WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public boolean verifyOptionIsSelected( WebElement element, String visibleText)
	{
		Select sel = new Select(element);
		List<WebElement> allOptions = sel.getAllSelectedOptions();
		
		for(WebElement option:allOptions) {
			if(option.getText().equals(visibleText))
			{
				return true;
			}
		}
		return false;
	}
	
	public void waitUntilElementClickable(WebDriver driver, int  timeout, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
            return false;
        }
    }
	
	 public void scrollToElement(WebDriver driver, WebElement element) {
	        try {

	        	Actions actions = new Actions(driver);
	            actions.moveToElement(element).perform();
	         
	        	} 
	        		catch (Exception e) {
	        			System.out.println("Error while scrolling up to element: " + e.getMessage());
	        		}
	 	}
	 
	 public void waitUntilElementVisible(WebDriver driver, int  timeout, WebElement element) {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
	 
	 
	 public void switchToWindowContainingElement(WebDriver driver, WebElement elementTovalidate) {
		    Set<String> allWindowHandles = driver.getWindowHandles();

		    for (String windowHandle : allWindowHandles) {
		        driver.switchTo().window(windowHandle);

		        try {
		            if (elementTovalidate.isDisplayed()) {
		                System.out.println("Switched to the window containing the element.");
		                break; // Exit the method once the correct window is found
		            }
		        } 
		        catch (Exception e) {
		        }
		    }
		}

}
	 

