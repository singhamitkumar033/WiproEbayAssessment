package com.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

import generic.TestBase;

public class HomePage extends TestBase {
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='global-search']")
	WebElement wo_global_search;
	@FindBy(xpath = "//li[@id='download']/a")
	WebElement wo_get_WordPress;

	public void enterSearchDetail() {
		wo_global_search.isDisplayed();
		wo_global_search.sendKeys("word data");
		Reporter.log("Enter Search Detail", 8);
	}

	public void clickOnSearch() {
		wo_get_WordPress.click();
		if(ExpectedConditions.alertIsPresent() != null);
	}
}
