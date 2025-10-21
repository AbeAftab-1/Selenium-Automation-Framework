package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest{
	
	@Test
	public void testValidLogin() {
		Log.info("Starting valid login test...");
		LoginPage validLogin = new LoginPage(driver);
		
		Log.info("Adding credentials...");
		validLogin.enterUserName("admin@yourstore.com");
		validLogin.enterPassword("admin");
		validLogin.clickLogin();
		
		Log.info("Verifying page title...");
		System.out.println("Title for the page is: "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		Log.info("Valid login test completed...");
	}

}
