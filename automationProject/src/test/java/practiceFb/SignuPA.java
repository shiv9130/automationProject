package practiceFb;

import org.testng.annotations.Test;

import baseClassUtility.BaseClass;
import genericUtility.excelUtil;
import genericUtility.javaUtility;
import objectRepo.homePage;
import objectRepo.signUp;

public class SignuPA extends BaseClass {

	@Test
	public void SignUpTest() {
		javaUtility jutil = new javaUtility();
		excelUtil eutil = new excelUtil();
		homePage hp = new homePage(driver);
		hp.getLinkSignupLogin().click();
		signUp sp = new signUp(driver);
		sp.getTxtName().sendKeys("Nita");
		sp.getTxtEmail().sendKeys("nitamitali60@gmail.com");
	}

}
