package com.utilities;

import org.testng.Reporter;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before()
	public void beforeScenario() {
		Reporter.log("Start the browser and Clear the cookies");
	}

	@Before()
	public void beforeScenarioStart() {
		Reporter.log("-----------------Start of Scenario-----------------");
	}

	@After()
	public void afterScenarioFinish() {
		Reporter.log("-----------------End of Scenario-----------------");
	}

	@After()
	public void afterScenario() {
		Reporter.log("Log out the user and close the browser");
	}

}
