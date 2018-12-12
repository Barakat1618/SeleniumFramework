package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.BaseClass;

public class Listener implements ITestListener {

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
		
		File src = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(
					"C:\\Users\\ADMIN\\ClinicalTrials\\CompletedScreenshots\\" + result.getInstanceName() + "-" + result.getName() + "ScreenShot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public void onTestFailure(ITestResult result) {
	 * 
	 * File src = ((TakesScreenshot)
	 * BaseClass.driver).getScreenshotAs(OutputType.FILE); StringBuilder sb = new
	 * StringBuilder("C:\\Users\\ADMIN\\ClinicalTrials\\FailedScreenshot\\"); String
	 * title= BaseClass.driver.getTitle(); System.out.println(title); String
	 * splitString[] = title.split(" "); sb.append(splitString[0]);
	 * sb.append(".png"); String path = sb.toString();
	 * 
	 * try { FileUtils.copyFile(src, new File(path)); } catch (IOException e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 */

	public void onTestFailure(ITestResult result) {
		File src = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File(
					"C:\\Users\\ADMIN\\ClinicalTrials\\FailedScreenshot\\" + result.getInstanceName() + "-" + result.getName() + "ScreenShot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	

	public void onTestSkipped(ITestResult result) {
		
		File src = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(
					"C:\\Users\\ADMIN\\ClinicalTrials\\SkippedScreenshots\\" + result.getInstanceName() + "-" + result.getName() + "ScreenShot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		
	}

}
