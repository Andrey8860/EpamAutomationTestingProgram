package com.epam.week11.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailRandomEmailGeneratorPage extends BasePage {
	
	private static final String PAGE_URL = "https://yopmail.com/en/email-generator";
	
	@FindBy(xpath="//button[@onclick=\"egengo();\"]")
	private WebElement checkInboxButton;
	
	public YopmailRandomEmailGeneratorPage(WebDriver driver) {
		super(driver);
	}
	
	public YopmailRandomEmailGeneratorPage openPage() {
		driver.get(PAGE_URL);
		logger.info("Opened Yopmail Email Generator Page at URL: " + PAGE_URL);
		return this;
	}
	
	public YopmailEmailInboxPage clickCheckInboxOfRandomEmailButton() {
		js.highlightElement(checkInboxButton);
		checkInboxButton.click();
		logger.info("Proceeding to the inbox of a randomly generated email");
		return new YopmailEmailInboxPage(driver);
	}
}
