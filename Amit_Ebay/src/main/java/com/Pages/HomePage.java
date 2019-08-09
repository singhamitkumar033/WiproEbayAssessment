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
 * @date : 08/04/2019
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

	/**
	 * @author Amit.Singh
	 * @Description : This method is used to check display of SignIn Button and then
	 *              click on SignIn Button
	 * @date : 08/09/2019
	 */
	public void clickOnSignInBtn() {
		getSignInButton().isDisplayed();
		getSignInButton().click();
	}

	/**
	 * @author Amit.Singh
	 * @Description : This method is used to verify presence of Home Page
	 * @date : 08/09/2019
	 */
	public void verifyHomeIsDisplayed() {
		getSearchBox().isDisplayed();
		Reporter.log("Home is Successfully Loaded");
	}

	/**
	 * @author Amit.Singh
	 * @Description : This method is for entering the search detail in the search
	 *              Box
	 * @date : 08/09/2019
	 */
	public void enterSearchDetail(String searchDetail) {
		getSearchBox().isDisplayed();
		getSearchBox().sendKeys(searchDetail);
		Reporter.log("Entered the Search Detail");
	}

	/**
	 * @author Amit.Singh
	 * @Description : This method is used to select the TV list details from the
	 *              suggestion displayed
	 * @date : 08/09/2019
	 */
	public void selectTVFromList() {
		searchBoxResults.get(1).isDisplayed();
		searchBoxResults.get(1).click();
		Reporter.log("Clicked on 2nd Tv results Sugession", true);
	}

	/**
	 * @author Amit.Singh
	 * @Description : This method is for verifying the pop-up presence and then
	 *              click on the same
	 * @date : 08/09/2019
	 */
	public void clickOnSaVePopUp() {
		getSaveSearchPopUp().isDisplayed();
		getSaveSearchPopUp().click();
	}

	/**
	 * @author Amit.Singh
	 * @Description : This method is for selecting the second Tv from the results
	 *              displayed click on the same
	 * @date : 08/09/2019
	 */
	public void selectSecondTvFromSearchResults() {
		getSearchBoxResults().get(1).isDisplayed();
		getSearchBoxResults().get(1).click();
	}

	public static int TVprice;
	public static String TVdescription;

	/**
	 * @author Amit.Singh
	 * @Description : This method is for storing the TC price an description in
	 *              static variable so we can use these to verify it on the cart
	 *              page
	 * @date : 08/09/2019
	 */
	public void getAllTheProductDetail() {
		getTvResultPrices().get(1).isDisplayed();
		TVprice = Integer.parseInt(getTvResultPrices().get(1).getText());
		TVdescription = getTvResultsNameDescription().get(1).getText();
		Reporter.log("Successfully taken The Product detail :" + "Descript : " + TVdescription + "\n and Price is :"
				+ TVprice);
	}

	/**
	 * @author Amit.Singh
	 * @Description : This method is for verifying presence of the Cart Button and
	 *              then adding the product to cart page
	 * @date : 08/09/2019
	 */
	public void clickOnAddToCardButton() {
		getAddTocartBtn().isDisplayed();
		getAddTocartBtn().click();
		Reporter.log("Product is added to the cart");
	}
}
