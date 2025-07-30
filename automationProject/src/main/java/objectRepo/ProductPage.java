package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends basePage {
		
	public ProductPage(WebDriver driver) {
		super(driver);	
	}

	@FindBy(id = "search_product")
	private WebElement searchProductTextField;
	
	@FindBy(id = "submit_search")
	private WebElement submitSearch;
	
	@FindBy(xpath = "//a[@href=\"#Women\"]")
	private WebElement women;
	
	@FindBy(xpath = "//a[@href=\"#Men\"]")
	private WebElement men;
	
	@FindBy(xpath = "//a[@href=\"#Kids\"]")
	private WebElement kids;

	@FindBy(linkText = "Add to cart")
	private WebElement addToCart;
	
	@FindBy(linkText = "View Product")
	private WebElement viewProduct;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchProductTextField() {
		return searchProductTextField;
	}

	public WebElement getSubmitSearch() {
		return submitSearch;
	}

	public WebElement getWomen() {
		return women;
	}

	public WebElement getMen() {
		return men;
	}

	public WebElement getKids() {
		return kids;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getViewProduct() {
		return viewProduct;
	}
	
}
