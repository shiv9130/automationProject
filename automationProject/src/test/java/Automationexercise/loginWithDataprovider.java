package Automationexercise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClassUtility.BaseClass;
import objectRepo.login;

public class loginWithDataprovider extends BaseClass {
	
	@DataProvider
	public Object[][] getLoginDetails() {
		Object[][] objL = new Object[2][2];
		objL[0][0]="yuvi950@gmail.com";
		objL[0][1]="yuvi@123";
		objL[1][0]="nitamitali60@gmail.com";
		objL[1][1]="Nita@239";
		objL[2][0]="shiv950@gmail.com";
		objL[2][1]="yuvi950";
		return objL;
		
	}
	@Test(dataProvider = "getLoginDetails")
	public void loginDetails(String un, String pw) {
		login lp = new login(driver);
		lp.toLogin(un, pw);
		
	}
}

  