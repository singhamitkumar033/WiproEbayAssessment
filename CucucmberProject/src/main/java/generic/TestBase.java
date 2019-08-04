package generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\Resources\\config.properties");
			prop.load(fis);
			Reporter.log("Loaded the Properties files");
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public static void initialise() {
		String browser = prop.getProperty("browserName");
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\driverExecutables\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\driverExecutables\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\driverExecutables\\IEdriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
