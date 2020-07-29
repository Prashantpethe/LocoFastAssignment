/* This page covers from Challgene 2
 * Challenge 4
 */

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import generic.WaitStatementLib;

public class IssuesPage extends WaitStatementLib{
	
	public static WebDriver driver;
	@FindBy(xpath="//span[@data-content='Issues']")
	private WebElement issuesHeader;
	@FindBy(xpath="//span[text()='New issue']")
	private WebElement newIssue;
	@FindBy(css="input#issue_title")
	private WebElement issueTitle;
	@FindBy(css="textarea#issue_body")
	private WebElement issueBody;
	@FindBy(xpath="(//button[contains(text(),'Submit new issue')])[1]")
	private WebElement submitIssue;
	@FindBy(css="span.js-issue-title")
	private WebElement captureIssueTitle;
	@FindBy(xpath="(//a[contains(text(),'New issue')])[2]")
	private WebElement newSecondIssue;
	@FindBy(css="textarea#new_comment_field")
	private WebElement newComment;
	@FindBy(xpath="//button[contains(text(),'Comment')]")
	private WebElement addComment;
	@FindBy(xpath="(//input[@class='js-data-unfurl-hide-url-csrf'])[1]//following-sibling::div[1]/div[1]/details[1]/summary")
	private WebElement emo;
	@FindBy(xpath="(//g-emoji[@class='emoji'])[1]")
	private WebElement selectEmo;
	@FindBy(xpath="(//p/a[text()='#1'])[last()]")
	private WebElement navTOFirstLink;
	
	
	
	public IssuesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//This moethod create first issue and return header count of issue created.
	public String createFirstIssue(WebDriver driver,String titleForIssue, String bodyForIssue)
	{
		issuesHeader.click();
		newIssue.click();
		issueTitle.sendKeys(titleForIssue);
		issueBody.sendKeys(bodyForIssue);
		submitIssue.click();
		captureIssueTitle.getText();
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String iHeader="return document.getElementsByClassName(\"gh-header-number\")[0].innerText;";
		String issueHeader=(String)js.executeScript(iHeader);
		Reporter.log("First Issue Created successfully",true);
		return issueHeader;
	}
	/*This method creates second issue and mention the first issue in description, add emojis 
	and also mention first issue as new comment and navigate back to first issue*/
	public void createSecondIssue(WebDriver driver,String titleForIssue, String bodyForIssue, String firstIssueHeader) throws InterruptedException
	{
		newSecondIssue.click();
		issueTitle.sendKeys(titleForIssue);
		issueBody.sendKeys(firstIssueHeader);
		submitIssue.click();
		Reporter.log("Second Issue Created successfully",true);
		newComment.sendKeys(bodyForIssue);
		addComment.click();
		Reporter.log("Comment added to second Issue Created successfully",true);
		explicitWait(driver, 20, emo);
		emo.click();
		selectEmo.click();
		Reporter.log("Emoji added successfully",true);
		newComment.sendKeys(firstIssueHeader);
		addComment.click();
		navTOFirstLink.click();
		Reporter.log("Navigated to first issue from second issue");
	}
	
	
}
