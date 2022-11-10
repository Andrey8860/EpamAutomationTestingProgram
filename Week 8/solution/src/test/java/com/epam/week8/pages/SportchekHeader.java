package com.epam.week8.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import lombok.Getter;

public class SportchekHeader extends BasePage {
	
	private final String signInLinkLocator = ".nl-sm-block .nl-pencil-banner__login";
	private final String signOutButtonLocator = "//div[@class='nl-pencil-banner__sign-out']/button";
	private final String hiUsernameLinkLocator = ".nl-sm-block #accountButton";
	private final String preferredStoreLocator = ".nl-primary-navigation .nl-store-locator--selected-store";
	
	@Getter private WebElement preferredStoreInHeader;
	
	public SportchekHeader(WebDriver driver) {
		super(driver);
		preferredStoreInHeader = js.findElementByCss(preferredStoreLocator);
	}
	
	public void clickSignInLink() {
		clickWithHighlight(getSignInLink());
	}
	
	public void clickSignOutButton() {
		clickWithHighlight(getSignOutButton());
	}
	
	public void clickHiUsernameLink() {
		clickWithHighlight(getHiUsernameLink());
	}
	
	public WebElement getSignInLink() {
		return js.findElementByCss(signInLinkLocator);
	}
	
	public WebElement getSignOutButton() {
		return js.findElementByXPath(signOutButtonLocator);
	}
	
	public WebElement getHiUsernameLink() {
		return js.findElementByCss(hiUsernameLinkLocator);
	}
}
