package com.epam.week9.pages;

import java.time.Duration;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.week9.util.JavaScriptExecutors;

public abstract class BasePage {
	
	protected WebDriver driver;
	protected JavaScriptExecutors js;
	protected final Logger logger = LogManager.getRootLogger();
	
	protected BasePage(WebDriver driver) {
		this.driver = driver;
		js = new JavaScriptExecutors(this.driver);
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> waitSecondsForVisibilityOfAllElements(
			long secondsToWait, List<WebElement> elementsToWaitFor) {
		logger.info("Waiting " + secondsToWait 
				+ " seconds for a list of elements: " + elementsToWaitFor);
		
		try {
			elementsToWaitFor = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait))
				.until(ExpectedConditions.visibilityOfAllElements(elementsToWaitFor));
		} catch(TimeoutException ex) {
			logger.fatal("Wait for elements failed. Elements not found");
		}
		
		return elementsToWaitFor;
	}
	
	public List<WebElement> waitSecondsForVisibilityOfAllElements(
			long secondsToWait, By locator) {
		logger.info("Waiting " + secondsToWait 
				+ " seconds for a list of elements located by  " + locator.toString());
		
		List<WebElement> elementsToWaitFor = null;
		
		try {
			elementsToWaitFor = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait))
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		} catch(TimeoutException ex) {
			logger.fatal("Wait for elements failed. Elements not found");
		}
		
		return elementsToWaitFor;
	}
	
	public WebElement waitSecondsForVisibilityOfAnElement(long secondsToWait, By locator) {
		logger.info("Waiting " + secondsToWait 
				+ " seconds for an element located by " + locator.toString());
		
		WebElement elementToWaitFor = null;
		
		try {
			elementToWaitFor = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch(TimeoutException ex) {
			logger.fatal("Wait for an element failed. Element not found");
		}
		
		return elementToWaitFor;
	}
	
	public WebElement waitSecondsForPresenceOfAnElement(long secondsToWait, By locator) {
		logger.info("Waiting " + secondsToWait 
				+ " seconds for the presence of an element located by " + locator.toString());
		
		WebElement elementToWaitFor = null;
		
		try {
			elementToWaitFor = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait))
					.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch(TimeoutException ex) {
			logger.fatal("Wait for the presence of an element failed. Element not found");
		}
		
		return elementToWaitFor;
	}
	
	public Boolean waitSecondsForInvisibilityOfAllElements(
			long secondsToWait, List<WebElement> elementsToWaitFor) {
		logger.info("Waiting " + secondsToWait 
				+ " seconds for invisibility of elements: " + elementsToWaitFor);
		
		Boolean waitingStatus = null;
		
		try {
			waitingStatus = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait))
					.until(ExpectedConditions.invisibilityOfAllElements(elementsToWaitFor));
		} catch(TimeoutException ex) {
			logger.fatal("Wait for invisibility of elements failed. Elements not found");
		}
		
		return waitingStatus;
	}
}
