package com.epam.week13.util;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class DriverWaits {
	
	private final static Logger LOGGER = LogManager.getRootLogger();
	
	public static WebElement waitSecondsForVisibilityOfAnElement(WebDriver driver, 
			long secondsToWait, By locator) {
		LOGGER.info(String.format("Waiting %s seconds for an element located by %s"
				, secondsToWait, locator.toString()));
		
		WebElement elementToWaitFor = null;
		
		try {
			elementToWaitFor = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch(TimeoutException ex) {
			LOGGER.fatal("Wait for an element failed. Element not found");
		}
		
		return elementToWaitFor;
	}
}
