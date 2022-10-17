package com.epam.week6.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	
	protected WebDriver driver;
	
	protected BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> waitSecondsForVisibilityOfAllElements(long secondsToWait, List<WebElement> list) {
		return new WebDriverWait(driver, Duration.ofSeconds(secondsToWait))
				.until(ExpectedConditions.visibilityOfAllElements(list));
	}
	
	public WebElement waitSecondsForVisibilityOfAnElement(long secondsToWait, By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(secondsToWait))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
}
