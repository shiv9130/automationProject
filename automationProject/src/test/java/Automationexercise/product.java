package Automationexercise;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.ExtentReportManager;
import baseClassUtility.BaseClass;
import genericUtility.propertiesUtil;
import objectRepo.ProductPage;
import objectRepo.homePage;
import objectRepo.login;

@Listeners(ExtentReportManager.class)
public class product extends BaseClass {
	propertiesUtil pu = new propertiesUtil();
	
	@Test
	public void productTest() throws IOException {
		
		//create obj. of home page
		homePage hp = new homePage(driver);
		hp.getLinkSignupLogin().click();
		
		//use properties util
		String un = pu.propUtil("Username");
		String pw = pu.propUtil("Password");
		
		//create login obj.
		login lp = new login(driver);
		lp.toLogin(un, pw);
		
		//click on product page
		hp.getLinkProduct().click();
		
		//craete product page obj
		ProductPage pp = new ProductPage(driver);
		pp.getSearchProductTextField().sendKeys("tshirt");
		pp.getSubmitSearch().click();
		
		driver.findElement(By.xpath("//a[@href='/product_details/28']")).click();
		driver.findElement(By.xpath("//button[@type='button']")).click();
		
		hp.getLinkCart().click();
		
		driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
		driver.findElement(By.linkText("Place Orde")).click();

		
	}

}
