package practiceFb;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Listeners.listenerTest;
import PracticeFb.FacebookRepo;
import junit.framework.Assert;

public class facebookLogin extends listenerTest {
	
	@Test()
	public void fblogin() {
		
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		FacebookRepo fr = new FacebookRepo(driver);
		
		fr.getTxtEmail().sendKeys("8871413176");
		fr.getTxtpass().sendKeys("8871413176");
		fr.getBtnLgn().click();
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
	}

}
