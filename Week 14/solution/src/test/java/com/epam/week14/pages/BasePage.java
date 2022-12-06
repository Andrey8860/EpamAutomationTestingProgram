package com.epam.week14.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.epam.week14.util.JavaScriptExecutors;

public abstract class BasePage {
	
	protected WebDriver driver;
	protected JavaScriptExecutors js;
	protected final Logger logger = LogManager.getRootLogger();
	
	protected BasePage(WebDriver driver) {
		this.driver = driver;
		js = new JavaScriptExecutors(this.driver);
		PageFactory.initElements(driver, this);
	}
}
