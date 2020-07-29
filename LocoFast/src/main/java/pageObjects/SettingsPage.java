//THis page is for challenge 5
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SettingsPage {
	
	public static WebElement driver;
	
	@FindBy(xpath="//span[@data-content='Settings']")
	private WebElement settingsLink;
	@FindBy(xpath="//summary[contains(text(),'Delete this repository')]")
	private WebElement deleteRepoBtn;
	@FindBy(xpath="(//input[@name='verify'])[last()]")
	private WebElement confirmMsg;
	@FindBy(xpath="(//button[contains(text(),'understand the consequences')])[last()]")
	private WebElement btnClick;
	
	
	
	public SettingsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//This method delete the repository
	public void deleteRepo(WebDriver driver) throws InterruptedException
	{
		settingsLink.click();
		deleteRepoBtn.click();
		WebElement beforeDeleteRepoName=driver.findElement(By.xpath("//strong[contains(text(),'cannot')]/following-sibling::strong"));
		String s=beforeDeleteRepoName.getText();
		confirmMsg.click();
		confirmMsg.sendKeys(s);
		btnClick.click();
		Reporter.log("New Repository Deleted successfully",true);
	}


}
