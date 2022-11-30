package com.epam.week13.util;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.epam.week13.service.ScreenshotTaker;

public class TestListener implements ITestListener {

	private final static String PASSED_SCREENSHOTS_PATH = ".//target/screenshots/passed/";
	private final static String FAILED_SCREENSHOTS_PATH = ".//target/screenshots/failed/";

	@Override
	public void onTestSuccess(ITestResult result) {
		ScreenshotTaker.saveScreenshot(PASSED_SCREENSHOTS_PATH);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ScreenshotTaker.saveScreenshot(FAILED_SCREENSHOTS_PATH);
	}
}
