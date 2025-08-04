package PracticeFb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import objectRepo.basePage;

public class FacebookRepo extends basePage{
	WebDriver driver;
	public FacebookRepo(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(id = "email")
	private WebElement txtEmail;
	
	@FindBy(id = "pass")
	private WebElement txtpass;
	
	@FindBy(name = "login")
	private WebElement btnLgn;

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtpass() {
		return txtpass;
	}

	public WebElement getBtnLgn() {
		return btnLgn;
	}
	
	/*public void inputEmail(String Email) {
		txtEmail.sendKeys(Email);
	}
	public void inputPass(String pass) {
		txtpass.sendKeys(pass);
	}
	public void clickLogin() {
		btnLgn.click();
	}*/
}
