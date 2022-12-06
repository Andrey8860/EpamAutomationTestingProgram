package com.epam.week14.util;

import java.time.Duration;
import java.util.List;
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
	
	public static List<WebElement> waitSecondsForVisibilityOfAllElements(WebDriver driver,
			long secondsToWait, List<WebElement> elementsToWaitFor) {
		LOGGER.info("Waiting " + secondsToWait 
				+ " seconds for a list of elements: " + elementsToWaitFor);
		
		try {
			elementsToWaitFor = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait))
				.until(ExpectedConditions.visibilityOfAllElements(elementsToWaitFor));
		} catch(TimeoutException ex) {
			LOGGER.fatal("Wait for elements failed. Elements not found");
		}
		
		return elementsToWaitFor;
	}
	
	public static List<WebElement> waitSecondsForVisibilityOfAllElements(WebDriver driver,
			long secondsToWait, By locator) {
		LOGGER.info("Waiting " + secondsToWait 
				+ " seconds for a list of elements located by  " + locator.toString());
		
		List<WebElement> elementsToWaitFor = null;
		
		try {
			elementsToWaitFor = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait))
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		} catch(TimeoutException ex) {
			LOGGER.fatal("Wait for elements failed. Elements not found");
		}
		
		return elementsToWaitFor;
	}
	
	public static WebElement waitSecondsForVisibilityOfAnElement(WebDriver driver, 
			long secondsToWait, By locator) {
		LOGGER.info("Waiting " + secondsToWait 
				+ " seconds for an element located by " + locator.toString());
		
		WebElement elementToWaitFor = null;
		
		try {
			elementToWaitFor = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch(TimeoutException ex) {
			LOGGER.fatal("Wait for an element failed. Element not found");
		}
		
		return elementToWaitFor;
	}
	
	public static WebElement waitSecondsForPresenceOfAnElement(WebDriver driver,
			long secondsToWait, By locator) {
		LOGGER.info("Waiting " + secondsToWait 
				+ " seconds for the presence of an element located by " + locator.toString());
		
		WebElement elementToWaitFor = null;
		
		try {
			elementToWaitFor = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait))
					.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch(TimeoutException ex) {
			LOGGER.fatal("Wait for the presence of an element failed. Element not found");
		}
		
		return elementToWaitFor;
	}
	
	public static Boolean waitSecondsForInvisibilityOfAllElements(WebDriver driver,
			long secondsToWait, List<WebElement> elementsToWaitFor) {
		LOGGER.info("Waiting " + secondsToWait 
				+ " seconds for invisibility of elements: " + elementsToWaitFor);
		
		Boolean waitingStatus = null;
		
		try {
			waitingStatus = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait))
					.until(ExpectedConditions.invisibilityOfAllElements(elementsToWaitFor));
		} catch(TimeoutException ex) {
			LOGGER.fatal("Wait for invisibility of elements failed. Elements not found");
		}
		
		return waitingStatus;
	}
}
