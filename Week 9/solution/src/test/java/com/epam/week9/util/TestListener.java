package com.epam.week9.util;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.epam.week9.driver.Driver;

public class TestListener implements ITestListener {
	
	// Here it might not be a perfect solution, but I spent a lot of time trying to avoid saving screenshots into a working Jenkins
	// directory, but with no success. If a better Jenkins configuration can be advised - please do
	
	private final static String PASSED_SCREENSHOTS_PATH = ".//.slave/workspace/Week9/screenshots/passed/";
	private final static String FAILED_SCREENSHOTS_PATH = ".//.slave/workspace/Week9/screenshots/failed/";
	
	private Logger logger = LogManager.getRootLogger();

	@Override
	public void onTestSuccess(ITestResult result) {
		saveScreenshot(true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		saveScreenshot(false);
	}
	
	private void saveScreenshot(boolean isPassed) {
		File screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
		
		try {
			if(isPassed) {
				FileUtils.copyFile(screenshot, new File(PASSED_SCREENSHOTS_PATH + 
						getCurrentTimeAsString() + ".png"));
				logger.info("Took a screenshot of a passed test. Screenshot is available in "
						+ PASSED_SCREENSHOTS_PATH);
			} else {
				FileUtils.copyFile(screenshot, new File(FAILED_SCREENSHOTS_PATH + 
						getCurrentTimeAsString() + ".png"));
				logger.info("Took a screenshot of a failed test. Screenshot is available in "
						+ FAILED_SCREENSHOTS_PATH);
			}
		} catch(IOException e) {
			logger.error("Failed to save screenshot: " + e.getLocalizedMessage());
		}
	}
	
	private String getCurrentTimeAsString() {
		return ZonedDateTime.now().format(DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss"));
	}
}
