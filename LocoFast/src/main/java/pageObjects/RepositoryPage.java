//This page is for Challenge 1
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import generic.WaitStatementLib;

public class RepositoryPage extends WaitStatementLib{

	
	public static WebDriver driver;
	@FindBy(css="summary.Header-link")
	private WebElement summaryHeader;
	@FindBy(xpath="//a[contains(text(),'New repository')]")
	private WebElement newRepository;
	@FindBy(xpath="//input[@name='repository[name]']")
	private WebElement inputRepoName;
	@FindBy(xpath="//button[contains(text(),'Create repository')]")
	private WebElement createRepo;
	
	
	public RepositoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//THis method create the New repository
	public void createRepository(WebDriver driver,String RepoName) throws InterruptedException
	{
		summaryHeader.click();
		newRepository.click();
		inputRepoName.sendKeys(RepoName);
		explicitWait(driver, 20, createRepo);
		createRepo.click();
		
		Reporter.log("New Repository Created successfully",true);
		
	}
	
}
