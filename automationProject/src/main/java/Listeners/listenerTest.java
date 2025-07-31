package Listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import baseClassUtility.BaseClass;

public class listenerTest implements ITestListener{
	
	static WebDriver driver;

	@Override
	public void onTestSuccess(ITestResult result) {
		
		ITestListener.super.onTestSuccess(result);
		String methodname = result.getMethod().getMethodName();
		Reporter.log("test case passed");
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File tgt = new File("./automationProject\\sshot"+methodname+Math.random()+".png");
		try {
			FileHandler.copy(src, tgt);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		ITestListener.super.onTestFailure(result);
		String methodname = result.getMethod().getMethodName();
		Reporter.log("test case passed");
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File tgt = new File("./automationProject\\sshot"+methodname+Math.random()+".png");
		try {
			FileHandler.copy(src, tgt);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

}
