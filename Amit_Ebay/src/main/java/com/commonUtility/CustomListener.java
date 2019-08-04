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

	public void onTestStart(ITestResult result) {

	}

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

	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName() + " is Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		Reporter.log(context.getName() + " is Started");
	}

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
