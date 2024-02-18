package org.miteshdandade.TestComponents;


import java.io.IOException;

import org.miteshdandade.resources.ExtentReporterNG;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
public class Listeners extends BaseTest implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe
    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);//unique thread id(ErrorValidationTest)->test
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        extentTest.get().log(Status.PASS, "Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        extentTest.get().fail(result.getThrowable());//

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());

        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }



        String filePath = null;
        try {

            filePath = getScreenshot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());


        //Screenshot, Attach to report


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        extent.flush();

    }

}
