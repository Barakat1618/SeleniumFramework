package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	public static Properties property = new Properties();
	public static WebDriverWait wait;

	public static WebDriver initializeDriver() throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\ADMIN\\ClinicalTrials\\src\\main\\java\\resources\\Data.propertise");

		property.load(fis);

		String browser = property.getProperty("Browser");

		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "d:\\Desktop\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "d:\\Desktop\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		return driver;
	}

	
	public void takeScreenShot() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\ADMIN\\ClinicalTrials\\FailedScreenshot\\Screenshot.png"));
	}

	
}
