package stepDefinition;

import org.testng.Reporter;
import com.PageObject.HomePage;
import cucumber.api.java.en.Given;
import generic.TestBase;

public class HomePageSteps extends TestBase{

	HomePage home=new HomePage();
	
	@Given("^User enter the searchtext in wordPress SearchBox$")
	public void enterSearchText() {
		home.enterSearchDetail();
		home.clickOnSearch();
		Reporter.log("got The Search Search");
	}
	

}
