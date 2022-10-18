package com.epam.week6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailRandomEmailGeneratorPage extends BasePage {
	
	private static final String pageURL = "https://yopmail.com/en/email-generator";
	
	@FindBy(xpath="//button[@onclick=\"egengo();\"]")
	private WebElement checkInboxButton;
	
	public YopmailRandomEmailGeneratorPage(WebDriver driver) {
		super(driver);
	}
	
	public void openPage() {
		driver.get(pageURL);
	}
	
	public void clickCheckInboxOfRandomEmailButton() {
		checkInboxButton.click();
	}

}
