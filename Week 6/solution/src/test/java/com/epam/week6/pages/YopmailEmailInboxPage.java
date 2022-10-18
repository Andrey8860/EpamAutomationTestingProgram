package com.epam.week6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailEmailInboxPage extends BasePage {
	
	@FindBy(css="#refresh")
	private WebElement refreshEmailsButton;
	
	@FindBy(css=".bname")
	private WebElement currentEmailAddress;
	
	public YopmailEmailInboxPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickRefreshEmailsButton() {
		refreshEmailsButton.click();
	}
	
	public String getCurrentEmailAddressString() {
		return currentEmailAddress.getText();
	}
	
	public void switchToEmailIFrame() {
		driver.switchTo().frame("ifmail");
	}
	
}
