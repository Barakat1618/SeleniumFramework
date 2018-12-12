package com.accenture.ESC;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import pageObjectLocators.LoginPageLoactors;
import pageObjectMethods.HomePageMethods;
import pageObjectMethods.LoginPageMethods;
import resources.BaseClass;

public class HomePageTest extends BaseClass{

	public static WebDriver driver;
	HomePageMethods hpm = null;
	LoginPageMethods lpm = null;
	
	@BeforeTest
	public void initializeAndEnterUrl() throws IOException {
		this.driver = initializeDriver();
		driver.get(BaseClass.property.getProperty("URL"));
		hpm = new HomePageMethods(driver);
		lpm = new LoginPageMethods(driver);
		
	}
	
	
	@Test(dataProvider= "loginCredentials")
	public void loginScenario(String userName, String password, String typeOfCredentials) throws IOException, InterruptedException {
		driver.get(BaseClass.property.getProperty("URL"));
		hpm.clickOnLoginButton().click();
		System.out.println("Trying with " + typeOfCredentials);
		lpm.emailId().sendKeys(userName);
		lpm.password().sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(LoginPageLoactors.login));
		lpm.login().click();
		
		/*
		if(driver.getCurrentUrl().equals("https://sso.teachable.com/secure/9521/users/sign_in?flow_school_id=9521")) {
			driver.navigate().back();
			driver.navigate().back();
			Thread.sleep(2000);
		}
		*/
		assertEquals("https://qaclickacademy.usefedora.com/gdpr/agree_updated_privacy_policy", driver.getCurrentUrl(),"Wrong Credentials");
		lpm.logoutImage().click();
		lpm.logout().click();
	}
	
	

	@Test
	public void homeButtonScenario() throws IOException {
		driver.get(BaseClass.property.getProperty("URL"));
		hpm.clickOnHomeButton().click();
		driver.navigate().back();
		
	}
	
	
	@Test
	public void coursesButtonScenario() throws IOException {
		hpm.clickOnCoursesButton().click();
		driver.navigate().back();
		
	}
	
	@DataProvider
	public String[][] loginCredentials() {
		String credentials[][]  = new String[2][3];
		credentials[0][0]="barakatshk93@gmail.com";
		credentials[0][1]="bigboss";
		credentials[0][2]="Wrong Credentials";
		
		credentials[1][0]="alizzz.ali18@gmail.com";
		credentials[1][1]="barakatali";
		credentials[1][2]="Correct credentials";
		return credentials;
	}
	
	/*
	@DataProvider
	public Object[][] getData() {
		Object[][] credentials = new Object[1][2];
		credentials[0][0]="barakatshk93@gmail.com";
		credentials[0][1]="bigboss";
		credentials[0][2]="Wrong Credentials";
		credentials[1][0]="alizzz.ali18@gmail.com";
		credentials[1][1]="barakatali";
		credentials[1][2]="Correct credentials";
		return credentials;
	}
	*/
	
	
	
	@Test 
	public void headerVerification() throws IOException {
		String headerValue = hpm.headerVerification().getText();
		Assert.assertEquals("FEATURED COURSES", headerValue,"Header does not match");
		System.out.println("Passed Test Case");
		
	}
	
	@Test
	public void contactTabValidation() throws IOException {
		System.out.println(driver.getTitle());
		Assert.assertEquals(true, hpm.contactButtonValidation().isDisplayed(),"Contact button is absent");
		System.out.println("Contact button is present");
		Assert.assertEquals(true, hpm.contactButtonValidation().isEnabled(),"Contact button is disabled");
		System.out.println("Contact button is enabled");
		Assert.assertEquals("CONTACT",hpm.contactButtonValidation().getText(),"Incorrect text");
		System.out.println("Present text " + hpm.contactButtonValidation().getText());
		
	}
	
	
	@AfterTest
	public void quitTheBrowser() {
		HomePageTest.driver.close();
		//driver = null;
	}
	
	
}
