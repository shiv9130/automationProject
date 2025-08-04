package PracticeFb;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import genericUtility.propertiesUtil;

public class baseFb {
	
	
	protected WebDriver driver;
    public static WebDriver sDriver;
    
    @BeforeMethod
    public void setup() throws IOException {
    	propertiesUtil pu = new propertiesUtil();
    	String BROWSER = pu.propUtil("Browser");
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
    }
 }


