package com.epam.week7.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codeborne.selenide.Selenide;

public abstract class BasePage {
	
	protected WebDriver driver;
	
	protected final String pageSpinnerLocator = ".nl-spinner__content";
	
	protected BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setLocalStorageKeyValuePair(String key, String value) {
		((WebStorage) driver).getLocalStorage().setItem(key, value);
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
	
	public void waitForPageReadyState() {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(driver ->
                "complete".equals(Selenide.executeJavaScript("return document.readyState")));
    }
}
