package Automationexercise;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.listenerTestFB;
import baseClassUtility.BaseClass;
import genericUtility.propertiesUtil;
import objectRepo.homePage;
import objectRepo.login;

//@Listeners(listenerTest.class)
public class loginPage extends BaseClass{
	
	
	
	@Test
	public void loginTest() throws IOException{
		homePage hp = new homePage(driver);
		hp.getLinkSignupLogin().click();
		login lp = new login(driver);
		propertiesUtil pu = new propertiesUtil();
	    String un = pu.propUtil("Username");
	    String pw = pu.propUtil("Password");
	    System.out.println(un);
	    System.out.println(pw);
	    lp.toLogin(un, pw);
		
		
		
	}

	
}
