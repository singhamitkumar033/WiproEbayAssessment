package com.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import generic.TestBase;
import org.testng.Assert;
import org.testng.Reporter;

public class WordPressLoginPage extends TestBase {
	public WordPressLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='user_login']")
	WebElement uN_txt_bx;

	@FindBy(xpath = "//input[@id='user_pass']")
	WebElement pwd_txt_bx;

	@FindBy(xpath = "//input[@id='wp-submit']")
	WebElement submit_btn;

	@FindBy(xpath = "//div[@id='login_error']")
	WebElement error_Msg;

	public void enterUserName(String un) {
		uN_txt_bx.sendKeys(un);
		Reporter.log("Entered Username", true);
	}

	public void enterpassword(String pwd) {
		try {
			pwd_txt_bx.isDisplayed();
			pwd_txt_bx.sendKeys(pwd);
			Reporter.log("Entered password", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnSignIn() {
		submit_btn.click();
		Reporter.log("click on SignIn button", true);
	}

	public String verifyloginPageTitle() {
		return driver.getTitle().toString();
	}

	public void verifyErrorMsg(String errorms) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		try {
			String expectedText = driver.getTitle();
			Assert.assertTrue(expectedText.contains("WordPress"), "User is able to Login-Invalid Credentials");
			Reporter.log("Successfully Checked the Home Page");
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(error_Msg));
			Assert.fail(error_Msg.getText());
			Reporter.log("Error msg is as Expected");
		}
	}
}
