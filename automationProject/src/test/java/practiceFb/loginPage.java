package practiceFb;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.listenerTest;
import baseClassUtility.BaseClass;
import genericUtility.propertiesUtil;
import objectRepo.homePage;
import objectRepo.login;

@Listeners(listenerTest.class)
public class loginPage extends BaseClass{
	
	
	
	@Test
	public void loginTest(){
		homePage hp = new homePage(driver);
		hp.getLinkSignupLogin().click();
		login lp = new login(driver);
		propertiesUtil pu = new propertiesUtil();
		String email = pu.propUtil(null);
		String pass = pu.propUtil(null);
		lp.toLogin(email, pass);
		
		
		
	}

}
