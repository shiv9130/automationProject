package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cartPage extends basePage {

	public cartPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//li[text()='Shopping Cart']")
	private WebElement textMsgShop;
	
	@FindBy(partialLinkText = "Proceed To Checkout")
	private WebElement btnCheck;
	
	@FindBy(xpath = "//a[@class='cart_quantity_delete']")
	private WebElement btnDel;

	public WebElement getTextMsgShop() {
		return textMsgShop;
	}

	public WebElement getBtnCheck() {
		return btnCheck;
	}

	public WebElement getBtnDel() {
		return btnDel;
	}
	
	

}
