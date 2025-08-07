package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import PracticeFb.baseFb;
import baseClassUtility.BaseClass;
import genericUtility.webDriverUtil;

public class listenerTest implements ITestListener {

	public static WebDriver driver;
	webDriverUtil wu = new webDriverUtil();

	@Override
	public void onTestSuccess(ITestResult result) {

		ITestListener.super.onTestSuccess(result);
		Reporter.log("test case passed");
		String methodname = result.getMethod().getMethodName();

		try {
			wu.takeScreenshotOfWebPage(baseFb.sDriver, methodname);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {

		ITestListener.super.onTestFailure(result);
		String methodname = result.getMethod().getMethodName();
		Reporter.log("test case failed");
		/*
		 * TakesScreenshot ts = (TakesScreenshot) baseFb.sDriver; File src =
		 * ts.getScreenshotAs(OutputType.FILE); File tgt = new File("./\\sshot\\name" +
		 * Math.random() + ".png"); try { FileHandler.copy(src, tgt); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */

		try {
			wu.takeScreenshotOfWebPage(BaseClass.sDriver, methodname);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
