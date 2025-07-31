package practiceFb;

import org.testng.annotations.Test;

import Listeners.listenerTest;
import PracticeFb.FacebookRepo;

public class facebookLogin extends listenerTest {
	
	@Test()
	public void fblogin() {
		
		FacebookRepo fr = new FacebookRepo(driver);
	}

}
