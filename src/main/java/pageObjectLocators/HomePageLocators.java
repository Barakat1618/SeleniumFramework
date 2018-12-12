package pageObjectLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageLocators {
	
	public static By loginButton = By.xpath("//span[text()='Login']");
	public static By homeButton = By.xpath("//a[contains(text(),'Home')]");
	public static By coursesButton = By.xpath("//a[text()='Courses']");
	public static By interviewButton = By.xpath("//a[text()='Interview Guide']");
	public static By mailId = By.xpath("//a[contains(@href,'info@qaclickacademy.com')]");
	public static By phoneNumber = By.xpath("//span[contains(text(),'(+1) 323-744-6780')]");
	public static By header = By.xpath("//h2[text()='Featured Courses']");
	public static By contactButton = By.xpath("//a[contains(text(),'Contact')]");
	
	
	
	
}
