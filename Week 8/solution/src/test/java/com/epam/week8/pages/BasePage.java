package com.epam.week8.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.html5.RemoteWebStorage;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.week8.javascript.JavaScriptExecutors;

public abstract class BasePage {
	
	protected WebDriver driver;
	protected JavaScriptExecutors js;
	protected final String pageSpinnerLocator = ".nl-spinner__content";
	
	protected BasePage(WebDriver driver) {
		this.driver = driver;
		js = new JavaScriptExecutors(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickWithHighlight(WebElement element) {
		js.highlightElement(element);
		element.click();
	}
	
	public void sendKeysWithHighlight(WebElement element, CharSequence... keys) {
		js.highlightElement(element);
		element.sendKeys(keys);
	}
	
	public void setLocalStorageKeyValuePair(String key, String value) {
		if(driver instanceof RemoteWebDriver) {
			RemoteWebStorage webStorage = 
					 new RemoteWebStorage(new RemoteExecuteMethod((RemoteWebDriver) driver));
			 webStorage.getLocalStorage().setItem(key, value);
		} else {
			((WebStorage) driver).getLocalStorage().setItem(key, value);
		}
	}
	
	public boolean waitSecondsForInvisibilityOfAnElement(long secondsToWait, By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(secondsToWait))
				.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public WebElement waitSecondsForVisibilityOfAnElement(long secondsToWait, By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(secondsToWait))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public List<WebElement> waitSecondsForVisibilityOfAllElements(long secondsToWait, By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(secondsToWait))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public void waitForThePageSpinnerToBeInvisible() {
		waitSecondsForInvisibilityOfAnElement(10, By.cssSelector(".nl-spinner__content"));
	}
}
