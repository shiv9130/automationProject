package PracticeFb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import objectRepo.basePage;

public class FacebookRepo extends basePage{

	public FacebookRepo(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id = "email")
	private WebElement txtEmail;
	
	@find

}
