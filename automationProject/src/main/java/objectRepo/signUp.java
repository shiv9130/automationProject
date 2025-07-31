package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class signUp extends basePage {

	public signUp(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id = "name")
	private WebElement txtName;
	
	@FindBy(id = "email")
	private WebElement txtEmail;
	
	@FindBy(xpath = "//button[text()='Signup']")
	private WebElement btnSignUp;
	
	@FindBy(id = "id_gender1")
	private WebElement rbtnM;
	
	@FindBy(id = "id_gender2")
	private WebElement rbtnF;
	
	@FindBy(id = "password")
	private WebElement txtPassword;
	
	@FindBy(id = "days")
	private WebElement ddays;
	
	@FindBy(id = "months")
	private WebElement dmonths;
	
	@FindBy(id = "years")
	private WebElement dyears;
	
	@FindBy(id = "newsletter")
	private WebElement chknewsletter;
	
	@FindBy(id = "optin")
	private WebElement chkoptin;
	
	@FindBy(id = "first_name")
	private WebElement txtfirst_name;
	
	@FindBy(id = "last_name")
	private WebElement txtlast_name;
	
	@FindBy(id = "company")
	private WebElement txtcompany;
	
	@FindBy(id = "address1")
	private WebElement txtaddress1;
	
	@FindBy(id = "address2")
	private WebElement txtaddress2;
	
	@FindBy(id = "country")
	private WebElement dcountry;
	
	@FindBy(id = "state")
	private WebElement txtstate;
	
	@FindBy(id = "city")
	private WebElement txtcity;
	
	@FindBy(id = "zipcode")
	private WebElement txtzipcode;
	
	@FindBy(id = "mobile_number")
	private WebElement txtmobile_number;
	
	@FindBy(xpath = "//button[text()='Create Account']")
	private WebElement btnCreateAct;
	
	//method for select country
	public void country(String Country) {
		new Select(dcountry).selectByContainsVisibleText(Country);
	}

    // Method to select DOB
    public void selectDateOfBirth(String day, String month, String year) {
	
    new Select(ddays).selectByVisibleText(day);//new object create for days, months, year
    new Select(dmonths).selectByVisibleText(month);
    new Select(dyears).selectByVisibleText(year);
   }
    
    public void name(String name) {
    txtName.sendKeys(name);
    }
    
    public void email(String email) {
        txtEmail.sendKeys(email);
    }
    public void signClick() {
    btnSignUp.click();
    }
    
    
}