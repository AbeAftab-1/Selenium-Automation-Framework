package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void testValidLogin() {
		
		LoginPage validLogin = new LoginPage(driver);
		
		validLogin.enterUserName("admin@yourstore.com");
		validLogin.enterPassword("admin");
		validLogin.clickLogin();
		
		System.out.println("Title for the page is: "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
	}

}
