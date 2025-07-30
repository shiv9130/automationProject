package baseClassUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import genericUtility.propertiesUtil;
import genericUtility.webDriverUtil;
import objectRepo.homePage;
import objectRepo.login;

public class BaseClass {
	
	public static WebDriver sDriver= null;
	public webDriverUtil wutil = new webDriverUtil();
	public propertiesUtil putil = new propertiesUtil();
	public WebDriver driver = null;
	
	@BeforeSuite(groups = {"SmokeTestCase","RegressionTestCase"})
	public void configBs() {
		Reporter.log("Before Suite Database Connectivity", true);
	}

	@BeforeTest(groups = {"SmokeTestCase","RegressionTestCase"})
	public void configBt() {
		Reporter.log("pre-conditions", true);
	}

	@BeforeClass(groups = {"SmokeTestCase","RegressionTestCase"})
	public void configBc() throws IOException {
		String BROWSER = putil.propUtil("Browser");
		String URL = putil.propUtil("Url");
		// cross Browser Testing
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sDriver= driver;
		// Login
		driver.manage().window().maximize();
		wutil.waitForPageToLoad(driver);
		driver.get(URL);
	}

	@BeforeMethod(groups = {"SmokeTestCase","RegressionTestCase"})
	public void configBm() throws IOException {
		String UNAME = putil.propUtil("Username");
		String PWD = putil.propUtil("Password");
		login lp = new login(driver);
		lp.toLogin(UNAME, PWD);
		Reporter.log("login successful", true);
	}

	@AfterMethod(groups = {"SmokeTestCase","RegressionTestCase"})
	public void configAM() throws InterruptedException {
		// logout
		homePage hp = new homePage(driver);
		hp.ToLogOut();
		Thread.sleep(3000);
		driver.quit();
	}

	@AfterTest(groups = {"SmokeTestCase","RegressionTestCase"})
	public void configAt() {

		Reporter.log("Post Conditions", true);
	}

	@AfterSuite(groups = {"SmokeTestCase","RegressionTestCase"})
	public void configAs() {
		Reporter.log("Database connectivity closed", true);
	}
	
	@AfterClass(groups = {"SmokeTestCase","RegressionTestCase"})
	public void configAC() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		Reporter.log("Successfully browser closed", true);
	}


}
