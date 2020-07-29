package generic;
import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseLib {
	public WebDriver driver;
	public WaitStatementLib wLib;
	public SoftAssert sAssert;
	public static Properties prop;
	Logger log;

	@BeforeMethod
	public void preCondition() throws MalformedURLException {

		prop= new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\data.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		driver= new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

		Reporter.log("Navigating to the url", true);
		wLib = new WaitStatementLib();
		wLib.implicitWaitForSeconds(driver, 20);
		Reporter.log("Implicit Wait implemented", true);
		sAssert = new SoftAssert();

	}

	@AfterMethod
	public void postCondition()  {

		driver.quit();
		Reporter.log("browsers closed", true);

	}

}