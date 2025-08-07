package Listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseClassUtility.BaseClass;
import genericUtility.javaUtility;

public class Listener_ExtentReport implements ISuiteListener, ITestListener {
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("Report Configuration", true);
		javaUtility jutil = new javaUtility();
		String currentTime = jutil.getSystemDateAndTimeForScreenshot();
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/Report_" + currentTime + ".html");
		spark.config().setDocumentTitle("Automation Practice");
		spark.config().setReportName("Automation Practice Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows10");
		report.setSystemInfo("Browser", "Chrome");
	}

	@Override
	public void onTestStart(ITestResult result) {
 //every @Test annotated method
		String methodName = result.getMethod().getMethodName();
      //Reporter.log("======"+methodName+"===Started=========", true);
		test = report.createTest(methodName);
		test.log(Status.INFO, "======" + methodName + "===Started=========");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log("======" + methodName + "===SUCCESS=========", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		javaUtility jutil = new javaUtility();
		String dateTime = jutil.getSystemDateAndTimeForScreenshot();
		TakesScreenshot tks = (TakesScreenshot) BaseClass.sDriver;
		File temp = tks.getScreenshotAs(OutputType.FILE);
		test.addScreenCaptureFromBase64String(methodName + "_" + dateTime);
		File perm = new File("./errorshots/myntra.png");

		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, "======" + methodName + "===FAILED=========");
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("Report Back up", true);
		report.flush();
	}
}
