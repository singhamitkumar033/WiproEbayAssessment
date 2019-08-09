package com.commonUtility;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.generic.Base;

public class CustomListener implements ITestListener {

	/**
	 * @author Amit.Singh
	 * @description: This method is called on the failure of any Test and it will
	 *               take screenshot of that Test with method name and will save in
	 *               project folder
	 * @param ItestResuit is used to get the describe the
	 * @date : 08/09/2019
	 */
	public void onTestFailure(ITestResult result) {
		File scrFile = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(scrFile, new File(System.getProperty("user.dir") + "\\" + result.getName() + ".png"));
			Reporter.log("take screen shot");
		} catch (IOException e) {
			e.printStackTrace();
			Reporter.log("Fail to take screen shot");
		}
	}

	/**
	 * @author Amit.Singh
	 * @description: This method is called on the start of any Test and it will
	 * @param ItestResuit is used to get the describe the
	 * @date : 08/09/2019
	 */
	public void onTestStart(ITestResult result) {

	}

	/**
	 * @author Amit.Singh
	 * @description: This method is called on the Success of any Test and it will
	 *               take screenshot of that Test with method name and will save in
	 *               project folder
	 * @param ItestResuit is used to get the describe the result of a test
	 * @date : 08/09/2019
	 */
	public void onTestSuccess(ITestResult result) {
		File scrFile = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(scrFile, new File(System.getProperty("user.dir") + "\\" + result.getName() + ".png"));
			Reporter.log("take screen shot");
		} catch (IOException e) {
			e.printStackTrace();
			Reporter.log("Fail to take screen shot");
		}
	}

	/**
	 * @author Amit.Singh
	 * @description: This method is called on the skipping of any Test and it will
	 *               Print the Skipped Test case name in Report
	 * @param ItestResuit is used to get the describe the result of a test
	 * @date : 08/09/2019
	 */
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName() + " is Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	/**
	 * @author Amit.Singh
	 * @description: This method is Invoked after the test class is instantiated and
	 *               before any configuration method is called
	 * @param ITestContext class defines a test context which contains all the
	 *                     information for a given test run
	 * @date : 08/09/2019
	 */
	public void onStart(ITestContext context) {
		Reporter.log(context.getName() + " is Started");
	}

	/**
	 * @author Amit.Singh
	 * @description: This method is called on the finish of any Test and it will
	 *               take screenshot of that Test with method name and will save in
	 *               project folder
	 * @param ITestContext class defines a test context which contains all the
	 *                     information for a given test run
	 * @date : 08/09/2019
	 */
	public void onFinish(ITestContext context) {
		File scrFile = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(scrFile, new File(System.getProperty("user.dir") + "\\" + context.getName() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
			Reporter.log("Fail to take screen shot");
		}
	}

}
