package com.epam.week13.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.epam.week13.driver.DriverManager;

public final class ScreenshotTaker {

	private final static Logger LOGGER = LogManager.getRootLogger();

	public static void saveScreenshot(String screenshotPath) {
		
		// due to how recent versions of Appium work, we need to take a screenshot in the Base64 format
		byte[] screenshot = Base64.decodeBase64(((TakesScreenshot) DriverManager.getDriver())
				.getScreenshotAs(OutputType.BASE64));
		
		try (OutputStream stream = new FileOutputStream(screenshotPath 
				+ TimeService.getCurrentTimeAsString() + ".png")) {
		    stream.write(screenshot);
		    
		    LOGGER.info("Screenshot taken and is available in " + screenshotPath);
		} catch (IOException ex) {
			LOGGER.error("Screenshot not taken. An exception occurred: " + ex.getMessage());
		}
	}

}
