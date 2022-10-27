package com.epam.week8.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SportchekFooter extends BasePage {
	
	private WebElement storeLocatorLink;
	private final String storeLocatorLinkLocator = "a[data-link-value='Store Locator']";
	
	public SportchekFooter(WebDriver driver) {
		super(driver);
		storeLocatorLink = js.findElementByCss(storeLocatorLinkLocator);
	}
	
	public void clickStoreLocatorLink() {
		clickWithHighlight(storeLocatorLink);
	}
}
