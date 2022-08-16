package org.POM_TestCases;

import org.POM_Pages.pageLogin;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.utilities.BaseUtility;
import org.utilities.configReader;

public class LoginTestCase {
	private String bName;
	private String url;

	private WebDriver driver;

	private Logger log;

	@BeforeSuite
	public void setup() {
		configReader cr = new configReader();
		bName = cr.getTestData("browserName");
		url = cr.getTestData("url");

	}
	
	@BeforeMethod
	public void openBrowser() {
		BaseUtility bu = new BaseUtility();
		driver = bu.startUp(url, bName);

		log = Logger.getLogger("WishUpLogin");
		PropertyConfigurator.configure("log4j.properties");

		log.info("Browser Opened");
	}
	
	@Test (priority=1)
	public void varifyLoginPage() {
		log.info("Login Page Verification Start");
		pageLogin vL_Obj = new pageLogin(driver);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(vL_Obj.isWishupLogoDisplayed());
		sa.assertTrue(vL_Obj.isLoginOptOnCornerDisplayed());
		sa.assertTrue(vL_Obj.isSignupOptOnCornerDisplayed());
		sa.assertTrue(vL_Obj.isSignInWithGoogleOptDisplayed());
		sa.assertTrue(vL_Obj.isUserIdFieldDisplayed());
		sa.assertTrue(vL_Obj.isPasswordFieldDisplayed());
		sa.assertTrue(vL_Obj.isloginBtnDisplayed());
		sa.assertTrue(vL_Obj.isforgetPwdOptDisplayed());
		sa.assertTrue(vL_Obj.isclickHereToSignupOptDisplayed());
		sa.assertAll();
		log.info("Verification Done and all options are displaying properly");
		Reporter.log("Login Page Verify Successfully");
	}
	
	@Test(dataProvider="loginCredentials", priority=2)
	public void validLogin(String uName, String password) {
		pageLogin lp_Obj = new pageLogin(driver);
		log.info("Entering Email ID");
		lp_Obj.enterEmailAddress(uName);

		log.info("Entering Password");
		lp_Obj.enterPassword(password);

		log.info("Clicked on Login Button");
		lp_Obj.enterLoginBtn();
		
		log.info("Login Successful");
		Reporter.log("Login Successful");
		
	}
	@DataProvider
	public Object[][] loginCredentials() {
		Object[][] ar = new Object[4][2];
		ar[0][0] = "wishup_testuser1@gmail.com";
		ar[0][1] = "testpw1";

		ar[1][0] = "wishup_testuser3@gmail.com";
		ar[1][1] = "testpw3";

		ar[2][0] = "wishup_testuser4@gmail.com";
		ar[2][1] = "testpw4";

		ar[3][0] = "wishup_testuser2@gmail.com";
		ar[3][1] = "testpw2";
		return ar;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Browser Close");
		Reporter.log("Browser Close");
	}
	
	@AfterSuite
	public void done() {
		log.info("Exit Test");
		Reporter.log("Exit Test");
	}

}
