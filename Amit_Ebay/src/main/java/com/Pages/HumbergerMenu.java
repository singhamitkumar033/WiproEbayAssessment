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

	/**
	 * @author Amit.Singh
	 * @Description : This method is for clicking on humberger menu
	 * @date : 08/09/2019
	 */
	public void clickOnHumbergerMenu() throws InterruptedException {
		Thread.sleep(10000);
		getHumbergerMenyBtn().isDisplayed();
		getHumbergerMenyBtn().click();
		Reporter.log("Clicked on Menu ICon");
	}

	/**
	 * @author Amit.Singh
	 * @Description : This method is for scrolling upto Setting submenu is in view
	 *              and then clicking on setting
	 * @date : 08/09/2019
	 */
	public void scrollUptoSettingView() {
		AppiumUtility.scrollToText("setting");
		getSettingtab().click();
	}

	/**
	 * @author Amit.Singh
	 * @Description : This method is used for clicking on setting submenu
	 * @date : 08/09/2019
	 */
	public void clickOnSettingSubMenu() {
		getSettingtab().click();
		Reporter.log("Successfully Clicked on Setting submenu icon");
	}

	/**
	 * @author Amit.Singh
	 * @Description : This method is used for verifying the country name
	 * @date : 08/09/2019
	 */
	public void verifyCountryName() {
		String defaultcountry = getCountryName().get(1).getText().toString();
		Reporter.log("default selected country is : " + defaultcountry);
	}

	/**
	 * @author Amit.Singh
	 * @Description : This method is used for clicking on slider button
	 * @date : 08/09/2019
	 */
	public void clickOnSliderBotton() {
		getAutoDetectSlider().isDisplayed();
		getAutoDetectSlider().click();
	}

	/**
	 * @author Amit.Singh
	 * @Description : This method is used for clicking country selection link
	 * @date : 08/09/2019
	 */
	public void clickOnCountySelectionLink() {
		getCountrySelectTag().isDisplayed();
		getCountrySelectTag().click();
	}

	/**
	 * @author Amit.Singh
	 * @Description : This method is fused for clicking on select option for country
	 * @date : 08/09/2019
	 */
	public void clickOnContrySelection() {
		getCountrySelectionOption().isDisplayed();
		getCountrySelectionOption().click();
	}

	/**
	 * @author Amit.Singh
	 * @Description : This method is for entering Country name in searchBox
	 * @date : 08/09/2019
	 */
	public void enterSerchDetailforCountrySelection(String country) {
		getCountrySearchBox().isDisplayed();
		getCountrySearchBox().sendKeys(country);
	}

	/**
	 * @author Amit.Singh
	 * @Description : This method is used for selecting the desired country
	 * @date : 08/09/2019
	 */
	public void selectTheCountry() {
		getSelectAustralia().isDisplayed();
		getSelectAustralia().click();
		Reporter.log("Desired Country is selected Successfully");
	}
}
