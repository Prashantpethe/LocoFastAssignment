//This page is to sign in into Github account
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	@FindBy(xpath="//a[@href='/login']")
	private WebElement signIn;
	
	@FindBy(css="input#login_field")
	private WebElement userName;
	
	@FindBy(css="input#password")
	private WebElement password;
	
	@FindBy(css="input[name='commit']")
	private WebElement signInBtn;
	
	public  LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//This method clicks on SignIn link
	public  void clickOnSignIn()
	{
		signIn.click();
	}
	//This method sign in user information
	public void fillSignInForm(String uName, String pass)
	{
		userName.sendKeys(uName);
		password.sendKeys(pass);
		signInBtn.click();
		
	}
	
	
	
}
