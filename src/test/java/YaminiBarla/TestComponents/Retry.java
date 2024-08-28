package YaminiBarla.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import YaminiBarla.resourses.ExtentTestManager;



public class Retry implements IRetryAnalyzer{

	int count=0;
	int Maxtry=2;
	@Override
	public boolean retry(ITestResult result) {
		
		
		if(count<Maxtry) {
			
			count++;
			 ExtentTestManager.getTest().log(Status.INFO, "Retrying test " + result.getName() + " with status "
	                    + getResultStatusName(result.getStatus()) + " for the " + count + " time.");
			return true;
		}
		return false;
	}
	
	 public String getResultStatusName(int status) {
	        String resultName = null;
	        if (status == 1)
	            resultName = "SUCCESS";
	        if (status == 2)
	            resultName = "FAILURE";
	        if (status == 3)
	            resultName = "SKIP";
	        return resultName;
	 }

}
