package Automationexercise;

import org.testng.annotations.Test;

import baseClassUtility.BaseClass;
import objectRepo.homePage;



public class homePageTest extends BaseClass {
	
	@Test
	public void Home() {
	homePage hp = new homePage(sDriver);
	hp.getLinkSignupLogin();
    
	}

}
