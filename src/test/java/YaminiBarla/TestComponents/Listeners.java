package YaminiBarla.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import YaminiBarla.resourses.ExtentReporterNg;
import YaminiBarla.resourses.ExtentTestManager;

public class Listeners extends invokeBrowser implements ITestListener {

//	ExtentReports extent = ExtentReporterNg.getReportObject();
//	ExtentTest test;
//	ThreadLocal<ExtentTest>  extentTest = new ThreadLocal<ExtentTest>();
//	@Override
//	public void onTestStart(ITestResult result) {
//		
//		test = extent.createTest(result.getMethod().getMethodName());
//		extentTest.set(test);
//	}
//
//	@Override
//	public void onTestSuccess(ITestResult result) {
//		
//		extentTest.get().log(Status.PASS, "Test Passed Successfully");
//		
//	}
//
//	@Override
//	public void onTestFailure(ITestResult result) {
//		
//		extentTest.get().fail(result.getThrowable());
//		
//		try {
//			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		
//		//SS, attach SS
//		String FilePath = null;
//		try {
//			FilePath = TakeScreenshot(result.getMethod().getMethodName(),driver);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		extentTest.get().addScreenCaptureFromPath(FilePath, result.getMethod().getMethodName());
//		
//	}	
//		
//
//	@Override
//	public void onTestSkipped(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onStart(ITestContext context) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onFinish(ITestContext context) {
//		extent.flush();
//		
//	}
	
	@Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
    }
 
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
    }
 
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());
    }
 
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }
 
    @Override
    public void onFinish(ITestContext context) {
        ExtentTestManager.endTest();
    }

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

}
