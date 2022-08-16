package org.POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseUtility;
public class pageLogin {

	private WebDriver driver;
	
	//	WebElements
	@FindBy(css=".ui.tiny.image")
	private WebElement wishupLogo;

	@FindBy(css=".item.active")
	private WebElement loginOption;

	@FindBy(xpath="//a[text()='Signup']")
	private WebElement signUpOption;

	@FindBy(css=".ui.wishup_button.fluid.circular.button")
	private WebElement signInWithGoogleOpt;

	@FindBy(name="email")
	private WebElement userIdField;

	@FindBy(name="password")
	private WebElement passwordField;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn;

	@FindBy(xpath="//div//a[text()='Forgot your password?']")
	private WebElement forgetPwdOpt;

	@FindBy(css=".ui.circular.basic.fluid.button")
	private WebElement clickHereToSignupOpt;


	//	Constructor
	public pageLogin (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	//	Actions
	public boolean isWishupLogoDisplayed() {
		return wishupLogo.isDisplayed();
	}

	public boolean isLoginOptOnCornerDisplayed() {
		return loginOption.isDisplayed();
	}

	public boolean isSignupOptOnCornerDisplayed() {
		return signUpOption.isDisplayed();
	}

	public boolean isSignInWithGoogleOptDisplayed() {
		return signInWithGoogleOpt.isDisplayed();
	}

	public boolean isUserIdFieldDisplayed() {
		return userIdField.isDisplayed();
	}

	public boolean isPasswordFieldDisplayed() {
		return passwordField.isDisplayed();
	}

	public boolean isloginBtnDisplayed() {
		return loginBtn.isDisplayed();
	}

	public boolean isforgetPwdOptDisplayed() {
		return forgetPwdOpt.isDisplayed();
	}

	public boolean isclickHereToSignupOptDisplayed() {
		return clickHereToSignupOpt.isDisplayed();
	}

	public void enterEmailAddress(String uName) {
		userIdField.sendKeys(uName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void enterLoginBtn() {
		loginBtn.click();
		
		BaseUtility bu = new BaseUtility();
		bu.waitForUrlContains(driver, 10, "request=true");
	
	}

}
