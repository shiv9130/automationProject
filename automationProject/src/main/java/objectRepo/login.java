package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login extends basePage {

	public login(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(name = "email")
	private WebElement txtlEmail;
	
	@FindBy(name = "password")
	private WebElement txtlpass;
	
	@FindBy(xpath = "//button[text()=\"Login\"]")
	private WebElement btnlLogin;

	public WebElement getTxtlEmail() {
		return txtlEmail;
	}

	public WebElement getTxtlpass() {
		return txtlpass;
	}

	public WebElement getBtnlLogin() {
		return btnlLogin;
	}

	public void toLogin(String Uname, String pswd) {
		txtlEmail.sendKeys(Uname);
		txtlpass.sendKeys(pswd);
		btnlLogin.click();
	}
	
	

}
