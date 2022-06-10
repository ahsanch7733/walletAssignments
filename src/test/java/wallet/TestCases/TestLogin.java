package wallet.TestCases;

import org.testng.annotations.Test;

import wallet.Pages.FacebookPage;
import wallet.base.BaseClass;

public class TestLogin extends BaseClass {
	
	@Test
	public void testLogin() {
		setup();
		FacebookPage fbp = new FacebookPage(driver);
		
		fbp.loginFB(prop.getProperty("username"), prop.getProperty("password"));
		fbp.postMessage();
		
}
}
