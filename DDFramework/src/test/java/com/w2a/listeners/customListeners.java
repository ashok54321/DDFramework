package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.Testutil;

public class customListeners extends TestBase implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			Testutil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+" Failed with exception : "+arg0.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(Testutil.screenshotName));
		
		Reporter.log("Click to see screenshot");
		Reporter.log("<a target=\"_blank\" href="+Testutil.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+Testutil.screenshotName+"> <img src="+Testutil.screenshotName+" height=200 width=200></img></a>");
	
		rep.endTest(test);
		rep.flush();
	}
	
	public void onTestSkipped(ITestResult arg0) {
		
		test.log(LogStatus.SKIP, arg0.getName().toUpperCase()+" skipped the test as the run mode NO");
		
		rep.endTest(test);
		rep.flush();
	}

	public void onTestStart(ITestResult arg0) {
		
		test = rep.startTest(arg0.getName().toUpperCase());
		
		//Runmode - Y
		
		System.out.println(Testutil.isTestRunnable(arg0.getName(), excel));
		
		
	}

	public void onTestSuccess(ITestResult arg0) {
		
		test.log(LogStatus.PASS, arg0.getName().toUpperCase()+" PASS");
		rep.endTest(test);
		rep.flush();
		
	}

}
