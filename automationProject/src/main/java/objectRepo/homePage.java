package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import genericUtility.webDriverUtil;

public class homePage extends basePage {

	public homePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(linkText = "Home")
	private WebElement linkHome;
	
	@FindBy(xpath = "//a[text()=' Products']")
	private WebElement linkProduct;
	
	@FindBy(linkText = "Cart")
	private WebElement linkCart;
	
	@FindBy(xpath  = "//a[@href=\"/login\"]")
	private WebElement linkSignupLogin;

	public WebElement getLinkHome() {
		return linkHome;
	}

	public WebElement getLinkProduct() {
		return linkProduct;
	}

	public WebElement getLinkCart() {
		return linkCart;
	}

	public WebElement getLinkSignupLogin() {
		return linkSignupLogin;
	}
	
	public void ToLogOut() {
		webDriverUtil wutil = new webDriverUtil();
		wutil.moveToElement(driver, linkCart);
	}
	
}
