package com.epam.week11.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutors {

	private static final String HIGHLIGHT_ELEMENT = "arguments[0].style.border='3px solid red'";
	private static final String UNHIGHLIGHT_ELEMENT = "arguments[0].style.border = \"\";";

	private WebDriver driver;
	private JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
	private WebElement lastHighlightedElement = null;

	public JavaScriptExecutors(WebDriver driver) {
		this.driver = driver;
		this.javaScriptExecutor = (JavascriptExecutor) driver;
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
