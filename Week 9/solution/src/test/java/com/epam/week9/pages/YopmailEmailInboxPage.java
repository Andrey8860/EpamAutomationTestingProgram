package com.epam.week9.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailEmailInboxPage extends BasePage {
	
	private final String numberOfEmailsLocator = "//div[text()='1 mail']";
	private final String estimationResultsEmailLocator = "//tr/td[2]/h3";
	
	@FindBy(css="#refresh")
	private WebElement refreshEmailsButton;
	
	@FindBy(css=".bname")
	private WebElement currentEmailAddress;
	
	public YopmailEmailInboxPage(WebDriver driver) {
		super(driver);
	}
	
	public YopmailEmailInboxPage clickRefreshEmailsButton() {
		js.highlightElement(refreshEmailsButton);
		refreshEmailsButton.click();
		logger.info("Clicking on Refresh Emails button");
		return this;
	}
	
	public String getCurrentEmailAddressString() {
		logger.info("Retrieving current email address");
		return currentEmailAddress.getText();
	}
	
	public YopmailEmailInboxPage switchToEmailIFrame() {
		driver.switchTo().frame("ifmail");
		
		logger.info("Switched to the email IFrame");
		
		return this;
	}
	
	public YopmailEmailInboxPage waitForEmail() {
		js.highlightElement(refreshEmailsButton);
		
		do {
			clickRefreshEmailsButton();
		} while(driver.findElements(By.xpath(numberOfEmailsLocator)).size() == 0);
		logger.info("Email Received");
		
		return this;
	}
	
	public List<WebElement> getEstimationResultsFromEmail() {
		logger.info("Retrieving estimation results from an email");
		return driver.findElements(By.xpath(estimationResultsEmailLocator));
	}
	
}
