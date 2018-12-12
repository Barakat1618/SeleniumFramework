package pageObjectMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjectLocators.HomePageLocators;

public class HomePageMethods {

	public WebDriver driver;
	
	public HomePageMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement clickOnLoginButton() {
		return driver.findElement(HomePageLocators.loginButton);
	}
	
	public WebElement clickOnHomeButton() {
		return driver.findElement(HomePageLocators.homeButton);
	}
	
	public WebElement clickOnCoursesButton() {
		return driver.findElement(HomePageLocators.coursesButton);
	}
	
	
	public WebElement clickOnMailId() {
		return driver.findElement(HomePageLocators.mailId);
	}
	
	
	public WebElement headerVerification() {
		return driver.findElement(HomePageLocators.header);
	}
	
	
	public WebElement contactButtonValidation() {
		return driver.findElement(HomePageLocators.contactButton);
	}
	
}
