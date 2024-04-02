package coreUtilities.testlisteners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import coreUtilities.utils.ExtentReportManager;
import static coreUtilities.testutils.TestUtils.businessTestFile;
import static coreUtilities.testutils.TestUtils.currentTest;
import static coreUtilities.testutils.TestUtils.yakshaAssert;

import java.io.IOException;



public class TestListener implements ITestListener
{

	//Extent Report Declarations
    private static ExtentReports extent = ExtentReportManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
 
    public synchronized void onStart(ITestContext context) {
        System.out.println("Extent Reports Version 3 Test Suite started!");
    }
 
    public synchronized void onFinish(ITestContext context) {
        System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
        extent.flush();
    }
 
    public synchronized void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started!"));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(extentTest);
    }
 
    public synchronized void onTestSuccess(ITestResult result) {
       System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
        try {
            yakshaAssert(result.getMethod().getMethodName(), true, businessTestFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    public synchronized void onTestFailure(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " failed!"));
        System.out.println(result.getThrowable().toString());
        try {
            yakshaAssert(result.getMethod().getMethodName(), false, businessTestFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        test.get().fail(result.getThrowable());
    }
 
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        try {
            yakshaAssert(result.getMethod().getMethodName(), false, businessTestFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        test.get().skip(result.getThrowable());
    }
 
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }	

}