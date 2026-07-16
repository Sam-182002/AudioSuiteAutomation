package com.audiosuite.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.audiosuite.base.BaseClass;

public class ListenerUtlity extends BaseClass implements ITestListener{
	public static com.aventstack.extentreports.ExtentTest test;

	  @Override
	    public void onTestStart(ITestResult result) {

	        test = ereport.createTest(result.getMethod().getMethodName());
	        test.log(Status.INFO, "Test Started");
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.log(Status.PASS, "Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {

	        test.log(Status.FAIL, "Test Failed");
	        test.log(Status.FAIL, result.getThrowable());

	        if (driver != null) {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File src = ts.getScreenshotAs(OutputType.FILE);
	    		File dest = new File("./screenshots/" + result.getName() + jutil.getSysystemTime() + ".png");
	    		try {
					FileHandler.copy(src, dest);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            String base64 = ts.getScreenshotAs(OutputType.BASE64);
	            test.addScreenCaptureFromBase64String(base64, result.getName());
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.log(Status.SKIP, "Test Skipped");
	    }
}
