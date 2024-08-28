package YaminiBarla.resourses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	
	 private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	    private static ExtentReports extent = ExtentReporterNg.getReportObject();
	 
	    public static synchronized ExtentTest getTest() {
	        return extentTest.get();
	    }
	 
	    public static synchronized void endTest() {
	        extent.flush();
	    }
	 
	    public static synchronized ExtentTest startTest(String testName, String desc) {
	        ExtentTest test = extent.createTest(testName, desc);
	        extentTest.set(test);
	        return getTest();
	    }

}
