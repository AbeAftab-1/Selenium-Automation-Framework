package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest{
	
	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException{
		String filepath = System.getProperty("user.dir")+"/testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filepath,"Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount-1][2];
		
		for(int i = 1; i<rowCount; i++) {
			data[i-1][0] = ExcelUtils.getCellData(i, 0); //Username
			data[i-1][1] = ExcelUtils.getCellData(i, 1); //Password
		}
		
		ExcelUtils.closeExcel();
		return data;
	}
	
	@DataProvider(name="LoginData2")
	public Object[][] getData(){
		return new Object[][] {
			{"user1","pass1"},
			{"user2","pass2"},
			{"user3","pass3"}
		};
	}

//	@Test(dataProvider="LoginData")
//	@Test(dataProvider="LoginData2")
	@Test
	@Parameters({"username","password"})
	public void testValidLogin(String username, String password) {
		Log.info("Starting valid login test...");
		tests = ExtentReportManager.createTest("Valid Login Test with: "+username);
		tests.info("Navigating to URL");
		LoginPage validLogin = new LoginPage(driver);
		
		Log.info("Adding credentials...");
//		validLogin.enterUserName("admin@yourstore.com");
//		validLogin.enterPassword("admin");
		validLogin.enterUserName(username);
		validLogin.enterPassword(password);
		validLogin.clickLogin();
		
		Log.info("Verifying page title...");
		System.out.println("Title for the page is: "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		Log.info("Valid login test completed...");
		tests.pass("Login Successful");
	}


//	@Test
//	public void testInvalidLogin() {
//		Log.info("Starting invalid login test...");
//		tests = ExtentReportManager.createTest("Invalid Login Test");
//		tests.info("Navigating to URL");
//		LoginPage validLogin = new LoginPage(driver);
//		
//		Log.info("Adding incorrect credentials...");
//		validLogin.enterUserName("admin1234@yourstore.com");
//		validLogin.enterPassword("admin1234");
//		validLogin.clickLogin();
//		
//		Log.info("Verifying page title...");
//		System.out.println("Title for the page is: "+driver.getTitle());
//		Assert.assertEquals(driver.getTitle(), "Just a moment...12");
//		Log.info("Valid login test completed...");
//		tests.pass("Login Successful");
//	}

}
