package pageObjectMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjectLocators.LoginPageLoactors;
import resources.BaseClass;

public class LoginPageMethods {

	public WebDriver driver;

	public LoginPageMethods(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement emailId() {
		return driver.findElement(LoginPageLoactors.email);
	}

	public WebElement password() {
		return driver.findElement(LoginPageLoactors.password);
	}
	
	public WebElement login() {
		return driver.findElement(LoginPageLoactors.login);
	}
	
	public WebElement logoutImage() {
		return driver.findElement(LoginPageLoactors.logoutImage);
	}
	
	public WebElement logout() {
		return driver.findElement(LoginPageLoactors.logout);
	}
	
}
