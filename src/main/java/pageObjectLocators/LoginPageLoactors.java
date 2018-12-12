package pageObjectLocators;

import org.openqa.selenium.By;

public class LoginPageLoactors {

	public static By email = By.id("user_email");
	public static By password = By.id("user_password");
	public static By login = By.xpath("//input[@value='Log In']");
	public static By forGotPassword = By.xpath("//a[text()='Forgot Password?']");
	public static By createAccount = By.xpath("//a[text()='Create an Account");
    public static By logoutImage = By.xpath("//img[contains(@src,'https://s.gravatar.com')]");
    public static By logout = By.xpath("//a[contains(@href,'sign_out')]");
}
