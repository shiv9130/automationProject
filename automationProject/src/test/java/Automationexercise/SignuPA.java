package Automationexercise;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClassUtility.BaseClass;
import genericUtility.excelUtil;
import genericUtility.javaUtility;
import genericUtility.webDriverUtil;
import objectRepo.homePage;
import objectRepo.signUp;

public class SignuPA extends BaseClass {

	@Test
	public void SignUpTest() {
		javaUtility jutil = new javaUtility();
		excelUtil eutil = new excelUtil();
		homePage hp = new homePage(driver);
		//wutil.waitForPageToLoad(driver);
		hp.getLinkSignupLogin().click();
		signUp sp = new signUp(driver);
		sp.getTxtName().sendKeys("Nita");
		sp.getTxtEmail().sendKeys("nitamitali60@gmail.com");
		sp.getBtnSignUp().click();
		sp.getRbtnF().click();
		sp.getTxtPassword().sendKeys("Nita@239");
		sp.selectDateOfBirth("1", "June", "2000");
		sp.country("India");
		sp.getChknewsletter().sendKeys("");
		sp.getChkoptin().sendKeys("");
		sp.getTxtfirst_name().sendKeys("Nita");
		sp.getTxtlast_name().sendKeys("Mitali");;
		sp.getTxtcompany().sendKeys("tesca");
		sp.getTxtaddress1().sendKeys("Rose Villa near kathe road");
		sp.getTxtaddress2().sendKeys("Thane west");
		sp.getDcountry().sendKeys("India");
		sp.getTxtstate().sendKeys("Maharashtra");
		sp.getTxtcity().sendKeys("Thane");
		sp.getTxtzipcode().sendKeys("421005");
		sp.getTxtmobile_number().sendKeys("9190905667");
		sp.getBtnCreateAct().click();
		
	 
	}

}
