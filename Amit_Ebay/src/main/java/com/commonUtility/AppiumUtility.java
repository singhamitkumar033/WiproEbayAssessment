package com.commonUtility;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.generic.Base;

import io.appium.java_client.android.AndroidElement;

public class AppiumUtility extends Base {

	/**
	 * @author Amit.Singh
	 * @description: Static Utility method for java-script click with Element
	 *               parameter
	 * @date : 08/01/2019
	 */
	public static void javaScriptClick(AndroidElement element) throws IOException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		Reporter.log("Javascript click is succesfully performed");
	}

	/**
	 * @author Amit.Singh
	 * @description: Static Utility method scrolling to target element with text
	 *               Parameter
	 * @date : 08/01/2019
	 */
	public static void scrollToText(String text) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
	}

	/**
	 * @author Amit.Singh
	 * @description: Static Utility method to check the visibility of element using
	 *               Explicit wait condition and 20 sec. time is defined
	 * @date : 08/0/2019
	 */
	public static void explicitWaitVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
