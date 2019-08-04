package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author Amit.Singh Description: Not Able to inspect the cart Page to get
 *         Locator, Because of the error produces while getting screenshot of
 *         page using uiautomatorviewer and also used Appium but didn't get the
 *         Cart Page Detail
 *         @date : 08/04/2019
 */
public class CartPage {
	public CartPage(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "")
	private WebElement cartPageHeader;
	@AndroidFindBy(xpath = "")
	private WebElement productsPrice;
	@AndroidFindBy(xpath = "")
	private WebElement ProdcutsDescription;

	/**
	 * @author Amit.Singh Description: Created Getter of all the WebElements to get
	 *         the Element using getter for dataRestriction purpose
	 *         @date : 08/04/2019
	 */
	public WebElement getCartPageHeader() {
		return cartPageHeader;
	}

	public WebElement getProductsPrice() {
		return productsPrice;
	}

	public WebElement getProdcutsDescription() {
		return ProdcutsDescription;
	}

	public void verifyCartPageIsDisplaying() {
		getCartPageHeader().isDisplayed();
		Reporter.log("Cart Page is Displayed");
	}

	/**
	 * @author Amit.Singh Description: Have Used Assert to check the TV detail
	 */
	public void verifyTheproductDetail() {
		int TVPriceonOnCart = Integer.parseInt(getProductsPrice().getText());
		String tvDescOnCart = getProdcutsDescription().getText();
		Assert.assertEquals(TVPriceonOnCart, HomePage.TVprice);
		Assert.assertEquals(tvDescOnCart, HomePage.TVdescription);
		Reporter.log("TV Name, Price and desription are verified on Cart Page");
	}

}
