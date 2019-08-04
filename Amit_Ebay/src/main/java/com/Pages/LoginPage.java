package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

	public LoginPage(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "")
	WebElement uN_txt_bx;

	@AndroidFindBy(xpath = "")
	WebElement pwd_txt_bx;

	@AndroidFindBy(xpath = "")
	WebElement submit_btn;

	@AndroidFindBy(xpath = "")
	WebElement error_Msg;

	public WebElement getuN_txt_bx() {
		return uN_txt_bx;
	}

	public WebElement getPwd_txt_bx() {
		return pwd_txt_bx;
	}

	public WebElement getSubmit_btn() {
		return submit_btn;
	}

	public WebElement getError_Msg() {
		return error_Msg;
	}

	public void enterUserName(String un) {
		getuN_txt_bx().isDisplayed();
		getuN_txt_bx().sendKeys(un);
		Reporter.log("Entered Username", true);
	}

	public void enterpassword(String pwd) {
		try {
			getuN_txt_bx().isDisplayed();
			getuN_txt_bx().sendKeys(pwd);
			Reporter.log("Entered password", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnSignIn() {
		getSubmit_btn().click();
		Reporter.log("click on SignIn button", true);
	}

}
