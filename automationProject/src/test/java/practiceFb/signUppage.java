package practiceFb;

import org.testng.annotations.Test;

import baseClassUtility.BaseClass;
import objectRepo.signUp;

public class signUppage extends BaseClass{
	
	@Test
	public void signUpTest() {
		signUp sp = new signUp(sDriver);
		sp.getTxtName().sendKeys("shivam");		
		sp.getTxtEmail().sendKeys("yuvi950@gmail.com");
		sp.getBtnSignUp();
		
	}
	
	 
	

}
