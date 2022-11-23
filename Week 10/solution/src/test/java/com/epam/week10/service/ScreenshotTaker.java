package com.epam.week10.service;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.epam.week10.driver.DriverSingleton;

public final class ScreenshotTaker {

	private final static Logger LOGGER = LogManager.getRootLogger();

	public static void saveScreenshot(String screenshotPath) {
		File screenshot = ((TakesScreenshot) DriverSingleton.getDriver())
				.getScreenshotAs(OutputType.FILE);

		try {
				FileUtils.copyFile(screenshot, new File(screenshotPath 
						+ TimeService.getCurrentTimeAsString() + ".png"));
				LOGGER.info("Took a screenshot. Screenshot is available in " 
						+ screenshotPath);
		} catch (IOException e) {
			LOGGER.error("Failed to save screenshot: " + e.getLocalizedMessage());
		}
	}

}
