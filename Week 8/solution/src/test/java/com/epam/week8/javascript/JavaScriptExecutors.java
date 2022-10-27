package com.epam.week8.javascript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptExecutors {

	private static final String FIND_ELEMENT_BY_XPATH = "return document.evaluate(arguments[0], document, null, "
			+ "XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;";
	private static final String FIND_ELEMENT_BY_CSS = "return document.querySelector(arguments[0])";
	private static final String HIGHLIGHT_ELEMENT = "arguments[0].style.border='3px solid red'";
	private static final String UNHIGHLIGHT_ELEMENT = "arguments[0].style.border = \"\";";

	private WebDriver driver;
	private JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
	private WebElement lastHighlightedElement = null;

	public JavaScriptExecutors(WebDriver driver) {
		this.driver = driver;
		this.javaScriptExecutor = (JavascriptExecutor) driver;
	}

	public WebElement findElementByCss(String cssLocator) {
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssLocator)));
		return (WebElement) javaScriptExecutor.executeScript(FIND_ELEMENT_BY_CSS, cssLocator);
	}

	public WebElement findElementByXPath(String xPathLocator) {
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathLocator)));
		return (WebElement) javaScriptExecutor.executeScript(FIND_ELEMENT_BY_XPATH, xPathLocator);
	}

	public void highlightElement(WebElement elementToHighlight) {
		unhighlightLastElement();
		lastHighlightedElement = elementToHighlight;
		javaScriptExecutor.executeScript(HIGHLIGHT_ELEMENT, elementToHighlight);
	}

	private void unhighlightLastElement() {
		if (lastHighlightedElement != null) {
			try {
				javaScriptExecutor.executeScript(UNHIGHLIGHT_ELEMENT, lastHighlightedElement);
				lastHighlightedElement = null;
			} catch(StaleElementReferenceException ex) {
				lastHighlightedElement = null;
			}
		}
	}
}
