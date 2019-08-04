package com.StepDefinition;

import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.generic.Base;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageDefinition extends Base {

	HomePage homePage = new HomePage(driver);
	LoginPage login = new LoginPage(driver);

	@When("^User clicks on Sign-In Button$")
	public void userClicksOnSignInButton() {
		homePage.clickOnSignInBtn();
	}

	@When("^User logged in using username, password and click signIn Button$")
	public void userLoggedInUsingUsernamePasswordAndClickSignInButton() {
		login.enterUserName(prop.getProperty("userName"));
		login.enterpassword(prop.getProperty("password"));
		login.clickOnSignIn();
	}

	@Then("^User should see that home page is displayed$")
	public void userShouldSeeThatHomePageIsDisplayed() {
		homePage.verifyHomeIsDisplayed();
	}

	@When("^User serches for '\"(.*)\"'$")
	public void userSerchesForInchTV(String tvDetail) {
		homePage.enterSearchDetail(tvDetail);
	}

	@When("^User click on one of the TV's displayes except first and Last$")
	public void userClickOnOneOfTheTVDisplayesExceptFirstAndLast() {
		homePage.selectSecondTvFromSearchResults();
	}

	@When("^User Add the Product to cart$")
	public void userAddTheProductToCart() {
		homePage.clickOnAddToCardButton();
	}

}
