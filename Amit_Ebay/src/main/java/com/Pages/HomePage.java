package com.Pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author Amit.Singh Description : HomePage Java Class to include the Page
 *         Repository and method related to HomePage
 *         @date : 08/04/2019
 */
public class HomePage {

	public HomePage(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Sign in,double tap to activate\"]")
	private WebElement signInButton;
	@AndroidFindBy(xpath = "com.ebay.mobile:id/search_box")
	private WebElement searchBox;
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.ebay.mobile:id/text']")
	private List<WebElement> searchBoxResults;
	@AndroidFindBy(id = "com.ebay.mobile:id/text_slot_1")
	private WebElement saveSearchPopUp;
	@AndroidFindBy(xpath = "//andHumbergerMenuroid.widget.TextView[@resource-id=\"com.ebay.mobile:id/textview_item_title\"]")
	private List<WebElement> tvResultsNameDescription;
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.ebay.mobile:id/textview_item_price\"]")
	private List<WebElement> tvResultPrices;
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"ADD TO CART\"]")
	private WebElement addTocartBtn;

	public WebElement getSignInButton() {
		return signInButton;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public List<WebElement> getSearchBoxResults() {
		return searchBoxResults;
	}

	public WebElement getSaveSearchPopUp() {
		return saveSearchPopUp;
	}

	public List<WebElement> getTvResultsNameDescription() {
		return tvResultsNameDescription;
	}

	public List<WebElement> getTvResultPrices() {
		return tvResultPrices;
	}

	public WebElement getAddTocartBtn() {
		return addTocartBtn;
	}

	public void clickOnSignInBtn() {
		getSignInButton().isDisplayed();
		getSignInButton().click();
	}

	public void verifyHomeIsDisplayed() {
		getSearchBox().isDisplayed();
		Reporter.log("Home is Successfully Loaded");
	}

	public void enterSearchDetail(String searchDetail) {
		getSearchBox().isDisplayed();
		getSearchBox().sendKeys(searchDetail);
		Reporter.log("Entered the Search Detail");
	}

	public void selectTVFromList() {
		searchBoxResults.get(1).isDisplayed();
		searchBoxResults.get(1).click();
		Reporter.log("Clicked on 2nd Tv results Sugession", true);
	}

	public void clickOnSaVePopUp() {
		getSaveSearchPopUp().isDisplayed();
		getSaveSearchPopUp().click();
	}

	public void selectSecondTvFromSearchResults() {
		getSearchBoxResults().get(0).isDisplayed();
		getSearchBoxResults().get(0).click();
	}

	public static int TVprice;
	public static String TVdescription;

	public void getAllTheProductDetail() {
		getTvResultPrices().get(1).isDisplayed();
		TVprice = Integer.parseInt(getTvResultPrices().get(1).getText());
		TVdescription = getTvResultsNameDescription().get(1).getText();
		Reporter.log("Successfully taken The Product detail :" + "Descript : " + TVdescription + "\n and Price is :"
				+ TVprice);
	}

	public void clickOnAddToCardButton() {
		getAddTocartBtn().isDisplayed();
		getAddTocartBtn().click();
		Reporter.log("Product is added to the cart");
	}
}
