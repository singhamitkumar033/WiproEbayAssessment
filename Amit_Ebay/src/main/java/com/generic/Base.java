package com.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	public AppiumDriverLocalService service;
	public static AndroidDriver<MobileElement> driver;
	public static Properties prop;

	public AppiumDriverLocalService startServer() {
		service = AppiumDriverLocalService.buildDefaultService();
		return service;
	}

	/**
	 * @author Amit.Singh
	 * @description: Constructor of Base Class which is used to load the properties
	 *               file
	 * 
	 * @date : 08/09/2019
	 */
	public Base() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\Resources\\Application.properties");
			prop.load(fis);
			Reporter.log("Loaded the Properties files");
		} catch (IOException e) {
			e.getMessage();
		}
	}

	/**
	 * @author Amit.Singh
	 * @description: This method is used to Initialise the AndroidDriver with the
	 *               desired capability as PLATFORM_NAME, UDID, DeviceName,
	 *               NEW_COMMAND_TIMEOUT and version and app (to define the apk file
	 *               location)
	 * 
	 * @date : 08/09/2019
	 */
	public static void Initialise() throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\Resources\\Application.properties");
		Properties prop = new Properties();
		prop.load(fis);
		File appDir = new File("src");
		File app = new File(appDir, (String) prop.get("AppName"));
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			capabilities.setCapability(MobileCapabilityType.UDID, prop.get("deviceId"));
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.get("deviceName"));
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
			capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
			capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver<MobileElement>(url, capabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Unable to initiliase the android Driver :" + e.getMessage());
			Reporter.log("Unable to initiliase the android Driver :" + e.getMessage());
		}
	}

}
