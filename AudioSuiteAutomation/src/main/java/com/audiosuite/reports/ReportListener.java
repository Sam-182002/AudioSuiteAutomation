package com.audiosuite.reports;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.audiosuite.base.BaseClass;
import com.audiosuite.utils.JavaUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

public class ReportListener implements ITestListener {

    private JavaUtility jutil = new JavaUtility();

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new ExtentTest node for every @Test method
        BaseClass.test = BaseClass.ereport.createTest(result.getMethod().getMethodName());
        BaseClass.test.log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        BaseClass.test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        BaseClass.test.log(Status.FAIL, result.getThrowable());

        if (BaseClass.driver != null) {

            TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;

            File src = ts.getScreenshotAs(OutputType.FILE);

			String screenshotPath = "./screenshots/" + result.getName() + "_" + jutil.getSysystemTime() + ".png";

            File dest = new File(screenshotPath);

            try {
                FileHandler.copy(src, dest);

                // Attach screenshot as thumbnail/link in report
                BaseClass.test.fail("Screenshot on failure")
                        .addScreenCaptureFromPath(dest.getAbsolutePath());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BaseClass.test.log(Status.FAIL, "Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        BaseClass.test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush writes the HTML report to disk
        ExtentReports extent = ExtentManager.getInstance();
        extent.flush();
    }
}
