package com.StepDefinition;

import java.io.IOException;

import com.Pages.HumbergerMenu;
import com.generic.Base;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition extends Base {
	HumbergerMenu hum = new HumbergerMenu(driver);;

	@Given("^user launches the brouwser$")
	public void userLaunchesTheBrouwser() throws IOException, InterruptedException  {
		Base.Initialise();
	}

	@When("^User clicks on humberger Menu ICon$")
	public void userClicksOnHumbergerMenuICon() throws InterruptedException  {	
		hum.clickOnHumbergerMenu();
	}

	@When("^User moves to setting submenu$")
	public void userMovesToSettingSubmenu(){
		hum.clickOnSettingSubMenu();
	}

	@When("^User select the country as 'Australia'$")
	public void userSelectTheCountryAsAustralia()  {
		hum.verifyCountryName();
		hum.clickOnCountySelectionLink();
		hum.clickOnSliderBotton();
		hum.clickOnCountySelectionLink();
		hum.enterSerchDetailforCountrySelection("Austra");
		hum.selectTheCountry();
	}

	@When("^User navigates back to Home Page$")
	public void userNavigatesBackToHomePage()  {
		hum.getNavigateBack().click();
		hum.getNavigateBack().click();
	}

}
