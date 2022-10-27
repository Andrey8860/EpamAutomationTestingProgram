package com.epam.week7.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SportchekFooter extends BasePage {
	
	@FindBy(css="a[data-link-value='Store Locator']")
	private WebElement storeLocatorLink;
	
	public SportchekFooter(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickStoreLocatorLink() {
		storeLocatorLink.click();
	}
}
