package com.test.plugins.arrow;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

/**
 * Test result Listener.
 * 
 * @author kevinkong
 * 
 */
public class TestResultListener extends TestListenerAdapter {

	private static Logger logger = Logger.getLogger(TestResultListener.class);

	protected ITestContext testContext = null;
	String  browser = null;
	
	@Override
	public void onStart(ITestContext testContext) { // 这里也是新加的，用于对context进行统一
		this.testContext = testContext;
		browser = String.valueOf(testContext.getCurrentXmlTest().getParameter("browserName"));
		super.onStart(testContext);
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		logger.info(tr.getName() + " Failure");
		WebDriver webDriver = (WebDriver) testContext.getAttribute("SELENIUM_DRIVER"); // 这里就是取driver
		saveScreenShot(tr, webDriver);
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
		logger.info(tr.getName() + " Skipped");
		WebDriver webDriver = (WebDriver) testContext.getAttribute("SELENIUM_DRIVER");
		saveScreenShot(tr, webDriver);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		logger.info(tr.getName() + " Success");
	}

	@Override
	public void onTestStart(ITestResult tr) {
		super.onTestStart(tr);
		logger.info(tr.getName() + " Start");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);

		// List of test results which we will delete later
		ArrayList<ITestResult> testsToBeRemoved = new ArrayList<ITestResult>();
		// collect all id's from passed test
		Set<Integer> passedTestIds = new HashSet<Integer>();
		for (ITestResult passedTest : testContext.getPassedTests().getAllResults()) {
			logger.info("PassedTests = " + passedTest.getName());
			passedTestIds.add(getId(passedTest));
		}

		// Eliminate the repeat methods
		Set<Integer> skipTestIds = new HashSet<Integer>();
		for (ITestResult skipTest : testContext.getSkippedTests().getAllResults()) {
			logger.info("skipTest = " + skipTest.getName());
			// id = class + method + dataprovider
			int skipTestId = getId(skipTest);

			if (skipTestIds.contains(skipTestId) || passedTestIds.contains(skipTestId)) {
				testsToBeRemoved.add(skipTest);
			} else {
				skipTestIds.add(skipTestId);
			}
		}
		
		// Eliminate the repeat failed methods
		Set<Integer> failedTestIds = new HashSet<Integer>();
		for (ITestResult failedTest : testContext.getFailedTests().getAllResults()) {
			logger.info("failedTest = " + failedTest.getName());
			// id = class + method + dataprovider
			int failedTestId = getId(failedTest);

			// if we saw this test as a failed test before we mark as to be
			// deleted
			// or delete this failed test if there is at least one passed
			// version
			if (failedTestIds.contains(failedTestId) || passedTestIds.contains(failedTestId) ||
					skipTestIds.contains(failedTestId)) {
				testsToBeRemoved.add(failedTest);
			} else {
				failedTestIds.add(failedTestId);
			}
		}
		
		// finally delete all tests that are marked
		for (Iterator<ITestResult> iterator = testContext.getFailedTests().getAllResults().iterator(); iterator.hasNext();) {
			ITestResult testResult = iterator.next();
			if (testsToBeRemoved.contains(testResult)) {
				logger.info("Remove repeat Fail Test: " + testResult.getName());
				iterator.remove();
			}
		}

	}

	private int getId(ITestResult result) {
		int id = result.getTestClass().getName().hashCode();
		id = id + result.getMethod().getMethodName().hashCode();
		id = id + (result.getParameters() != null ? Arrays.hashCode(result.getParameters()) : 0);
		return id;
	}
	
    private void saveScreenShot(ITestResult tr,WebDriver driver) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String mDateTime = formatter.format(new Date());
        String fileName = mDateTime + "_" + tr.getName();
        String filePath = "";
        try {
            //这里可以调用不同框架的截图功能
        	String outputPath = "result/target/";
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            filePath = "screenshot/" + fileName + ".jpg";
            File destFile = new File(outputPath+filePath);
            FileUtils.copyFile(screenshot, destFile);
            logger.info("["+fileName + "] tackScreentshot Success，save as：" + "[ " + filePath + " ]");
        } catch (Exception e) {
                filePath ="["+ fileName + " ]tackScreentshot Failure:" + e.getMessage();
                logger.error(filePath);
        }

        if (!"".equals(filePath)) {
             Reporter.setCurrentTestResult(tr);
             Reporter.log(filePath);
             //把截图写入到Html报告中方便查看
             Reporter.log("<img src=\"./" + filePath + "\"/>");
        }
 }

}
