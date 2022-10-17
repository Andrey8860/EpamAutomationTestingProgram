package com.epam.week7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SportchekHeader extends BasePage {
	
	// In this case we use locators and getter methods, because Pencil Banner itself may be used not only in the order
	// of sign in and then sign out. Due to this, we can never know before runtime if we should initialize 
	// the necessary elements
	private final String signInLinkLocator = ".nl-sm-block .nl-pencil-banner__login";
	private final String signOutButtonLocator = "//div[@class='nl-pencil-banner__sign-out']/button";
	private final String hiUsernameLink = ".nl-sm-block #accountButton";
	
	@FindBy(xpath="(//span[@class='nl-store-locator--selected-store'])[2]")
	private WebElement preferredStore;
	
	public SportchekHeader(WebDriver driver) {
		super(driver);
	}
	
	public void clickSignInLink() {
		getSignInLink().click();
	}
	
	public void clickSignOutButton() {
		getSignOutButton().click();
	}
	
	public void clickHiUsernameLink() {
		getHiUsernameLink().click();
	}
	
	public WebElement getSignInLink() {
		return driver.findElement(By.cssSelector(signInLinkLocator));
	}
	
	public WebElement getSignOutButton() {
		return driver.findElement(By.xpath(signOutButtonLocator));
	}
	
	public WebElement getHiUsernameLink() {
		return driver.findElement(By.cssSelector(hiUsernameLink));
	}
	
	public WebElement getPreferredStoreInHeader() {
		return preferredStore;
	}
	
	
}
