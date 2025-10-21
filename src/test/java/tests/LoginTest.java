package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest{
	
	@Test
	public void testValidLogin() {
		Log.info("Starting valid login test...");
		tests = ExtentReportManager.createTest("Valid Login Test");
		tests.info("Navigating to URL");
		LoginPage validLogin = new LoginPage(driver);
		
		Log.info("Adding credentials...");
		validLogin.enterUserName("admin@yourstore.com");
		validLogin.enterPassword("admin");
		validLogin.clickLogin();
		
		Log.info("Verifying page title...");
		System.out.println("Title for the page is: "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		Log.info("Valid login test completed...");
		tests.pass("Login Successful");
	}


	@Test
	public void testInvalidLogin() {
		Log.info("Starting invalid login test...");
		tests = ExtentReportManager.createTest("Invalid Login Test");
		tests.info("Navigating to URL");
		LoginPage validLogin = new LoginPage(driver);
		
		Log.info("Adding incorrect credentials...");
		validLogin.enterUserName("admin1234@yourstore.com");
		validLogin.enterPassword("admin1234");
		validLogin.clickLogin();
		
		Log.info("Verifying page title...");
		System.out.println("Title for the page is: "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Just a moment...12");
		Log.info("Valid login test completed...");
		tests.pass("Login Successful");
	}

}
