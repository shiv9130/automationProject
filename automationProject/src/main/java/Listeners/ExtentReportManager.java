package Listeners;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import NinzaCrmBase.baseClass;
import genericUtility.javaUtility;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkrReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;
	javaUtility ju = new javaUtility();
	String reportName;
	
	
	@Override
	public void onStart(ITestContext context) {
		String cd = ju.currentdate();
		
		reportName = "Test-Report-"+cd+".html";//name
		sparkrReporter = new ExtentSparkReporter("./\\Extentreports"+cd+"reportName");//location
		sparkrReporter.config().setDocumentTitle("AutomationReport");
		sparkrReporter.config().setReportName("AutomationExercise");
		sparkrReporter.config().setTheme(Theme.DARK);
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkrReporter);
		extentReports.setSystemInfo("username", System.getProperty("user.name"));
		
		String brow = context.getCurrentXmlTest().getParameter("browser");
		extentReports.setSystemInfo("Browser",brow );
		
		String os = context.getCurrentXmlTest().getParameter("os");
		extentReports.setSystemInfo("operating system", os);
		
		List<String> group = context.getCurrentXmlTest().getIncludedGroups();
		if(!group.isEmpty());
		extentReports.setSystemInfo("groups", group.toString());
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
	extentTest=extentReports.createTest(result.getTestClass().getName());
	extentTest.assignCategory(result.getMethod().getGroups());
	extentTest.log(Status.PASS, result.getName()+"sucessfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String cd = ju.currentdate();
			extentTest=extentReports.createTest(result.getTestClass().getName());
			extentTest.assignCategory(result.getMethod().getGroups());
			extentTest.log(Status.FAIL, result.getName()+"execution failed");
			extentTest.log(Status.INFO, result.getThrowable().getMessage());//also print error message
			TakesScreenshot ts= (TakesScreenshot) baseClass.sdriver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File tgt = new File("./\\errorShots"+result.getName()+ "_"  +cd +".png");
			try {
				FileHandler.copy(src, tgt);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest = extentReports.createTest(result.getTestClass().getName());//display get the class name
		extentTest.assignCategory(result.getMethod().getGroups());//display group in report
		
		extentTest.log(Status.FAIL, result.getName()+"skipped");
		extentTest.log(Status.INFO, result.getThrowable().getMessage());//also print error message
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReports.flush();
		
	}
	
	

		
	
 

	
	

}
