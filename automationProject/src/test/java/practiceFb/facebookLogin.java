package practiceFb;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.listenerTest;
import PracticeFb.FacebookRepo;
import PracticeFb.baseFb;
import junit.framework.Assert;

@Listeners(listenerTest.class)
public class facebookLogin extends baseFb {
	
	@Test()
	public void fblogin()  {
	
	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		FacebookRepo fr = new FacebookRepo(driver);
		
		fr.getTxtEmail().sendKeys("8871413176");
		fr.getTxtpass().sendKeys("88714");
		fr.getBtnLgn().click();
		
		
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
	}

}
