package stepDefinition;

import org.testng.Assert;
import org.testng.Reporter;
import com.PageObject.WordPressLoginPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import generic.TestBase;

public class LoginStepDefinition extends TestBase{
	WordPressLoginPage wpdl;
	
	@Given("^navigate to wordpress page$")
	public void navigate() {
		TestBase.initialise();
		wpdl = new WordPressLoginPage();
		String title = wpdl.verifyloginPageTitle();
		Assert.assertEquals(title, "WordPress.org Login");
	}

	@When("^user logged in using username as \"(.*)\" and password as \"(.*)\"$")
	public void login(String username, String password) throws InterruptedException {
		Thread.sleep(2000);
		wpdl.enterUserName(username);
		Thread.sleep(2000);
		wpdl.enterpassword(password);
		wpdl.clickOnSignIn();
		Reporter.log("driver title " + driver.getTitle());
	}

	@Then("^home page should be displayed$")
	public void verifySuccessful() {
		wpdl.verifyErrorMsg("The password you entered for the username sumitsingh21 is incorrect. Lost your password?");
	}

	@When("^User Closed the Browser Always$")
	public void closeTheBrowser() {
		// driver.close();
		Reporter.log("Browser is closed Successfully");
	}

	@After
	public void cleanUp() {
		driver.close();
	}
}