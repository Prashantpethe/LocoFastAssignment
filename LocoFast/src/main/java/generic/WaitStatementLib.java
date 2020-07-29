package generic;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib {
	
	public WebDriverWait wait;
	public FluentWait<WebDriver> fw; 
	
	public void implicitWaitForSeconds(WebDriver driver, int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	public void implicitWaitForMinutes(WebDriver driver, int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.MINUTES);
	}
	public void explicitWait(WebDriver driver, int time, WebElement element){
		wait=new WebDriverWait(driver, time);
		//wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void fluentWaitForSeconds(WebDriver driver, int totalTime, int pollingTime, WebElement element){
		fw=new FluentWait<WebDriver>(driver);
		fw.withTimeout(totalTime, TimeUnit.SECONDS);
		fw.pollingEvery(pollingTime, TimeUnit.SECONDS);
		fw.ignoring(NoSuchElementException.class);
		fw.until(ExpectedConditions.visibilityOf(element));
	}
}
