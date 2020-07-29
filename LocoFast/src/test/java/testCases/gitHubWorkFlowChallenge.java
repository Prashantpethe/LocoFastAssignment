package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.BaseLib;
import pageObjects.IssuesPage;
import pageObjects.LoginPage;
import pageObjects.RepositoryPage;
import pageObjects.SettingsPage;

public class gitHubWorkFlowChallenge extends BaseLib {

	@Test
	public void gitHubChallenge() throws InterruptedException
	{
		LoginPage lp= new LoginPage(driver);
		lp.clickOnSignIn();
		lp.fillSignInForm(prop.getProperty("username"), prop.getProperty("password"));
		RepositoryPage repoPageObject = new RepositoryPage(driver);
		repoPageObject.createRepository(driver,prop.getProperty("RepositoryName"));
		IssuesPage issuePageObject = new IssuesPage(driver);
		String firstIssueHeader=issuePageObject.createFirstIssue(driver,prop.getProperty("titleForIssue"), prop.getProperty("bodyForIssue"));
		issuePageObject.createSecondIssue(driver,prop.getProperty("titleForIssue"), prop.getProperty("bodyForIssue"), firstIssueHeader);
		SettingsPage settingPageObject = new SettingsPage(driver);
		settingPageObject.deleteRepo(driver);
	
	}
	
	
}
