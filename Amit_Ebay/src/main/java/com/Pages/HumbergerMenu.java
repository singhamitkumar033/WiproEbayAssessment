package com.Pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.commonUtility.AppiumUtility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HumbergerMenu {

	public HumbergerMenu(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id=\"com.ebay.mobile:id/home\"]")
	private WebElement humbergerMenyBtn;
	@AndroidFindBy(id = "com.ebay.mobile:id/menuitem_settings")
	private WebElement settingtab;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Country/region']")
	private WebElement countrySelectTag;
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/summary\"]")
	private List<WebElement> countryName;
	@AndroidFindBy(id = "com.ebay.mobile:id/switchWidget")
	private WebElement autoDetectSlider;
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/title']")
	private WebElement countrySelectionOption;
	@AndroidFindBy(id = "com.ebay.mobile:id/filter")
	private WebElement countrySearchBox;
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text=\"Australia\"]")
	private WebElement selectAustralia;
	@AndroidFindBy(accessibility = "Navigate up")
	private WebElement navigateBack;

	public WebElement getHumbergerMenyBtn() {
		return humbergerMenyBtn;
	}

	public WebElement getSettingtab() {
		return settingtab;
	}

	public WebElement getCountrySelectTag() {
		return countrySelectTag;
	}

	public List<WebElement> getCountryName() {
		return countryName;
	}

	public WebElement getAutoDetectSlider() {
		return autoDetectSlider;
	}

	public WebElement getCountrySearchBox() {
		return countrySearchBox;
	}

	public WebElement getSelectAustralia() {
		return selectAustralia;
	}

	public WebElement getNavigateBack() {
		return navigateBack;
	}

	public WebElement getCountrySelectionOption() {
		return countrySelectionOption;
	}

	public void clickOnHumbergerMenu() throws InterruptedException {
		Thread.sleep(10000);
		getHumbergerMenyBtn().isDisplayed();
		getHumbergerMenyBtn().click();
		Reporter.log("Clicked on Menu ICon");
	}

	public void scrollUptoSettingView() {
		AppiumUtility.scrollToText("setting");
		getSettingtab().click();
	}

	public void clickOnSettingSubMenu() {
		getSettingtab().click();
		Reporter.log("Successfully Clicked on Setting submenu icon");
	}

	public void verifyCountryName() {
		String defaultcountry = getCountryName().get(1).getText().toString();
		Reporter.log("default selected country is : " + defaultcountry);
	}

	public void clickOnSliderBotton() {
		getAutoDetectSlider().isDisplayed();
		getAutoDetectSlider().click();
	}

	public void clickOnCountySelectionLink() {
		getCountrySelectTag().isDisplayed();
		getCountrySelectTag().click();
	}

	public void clickOnContrySelection() {
		getCountrySelectionOption().isDisplayed();
		getCountrySelectionOption().click();
	}

	public void enterSerchDetailforCountrySelection(String country) {
		getCountrySearchBox().isDisplayed();
		getCountrySearchBox().sendKeys(country);
	}

	public void selectTheCountry() {
		getSelectAustralia().isDisplayed();
		getSelectAustralia().click();
		Reporter.log("Desired Country is selected Successfully");
	}
}
