package com.epam.week8.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SportchekStoreLocatorPage extends BasePage {
	
	private WebElement storeSearchInputField;
	private final String storeSearchInputFieldLocator = "#nl-store-locator-search-box";
	private final String searchResultsLocator = ".nl-store-selector-flyout__stores-list__item";
	
	@FindBy(css="a[dap-wac-value='View Store Details']")
	private List<WebElement> storeDetailsLinksOfSearchResults;
	
	@FindBy(css=".nl-store-selector-flyout__stores-list__item__set-preferred-store button")
	private List<WebElement> setAsPreferredStoreButtonsOfSearchResults;
	
	@FindBy(css=searchResultsLocator)
	private List<WebElement> searchResultsItems;
	
	
	public SportchekStoreLocatorPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		storeSearchInputField = js.findElementByCss(storeSearchInputFieldLocator);
	}
	
	public void searchForStoreWithFirstOptionSelected(String searchQuery) {
		js.highlightElement(storeSearchInputField);
		
		new Actions(driver)
		.click(storeSearchInputField)
		.sendKeys(searchQuery)
		.pause(Duration.ofSeconds(2))
		.sendKeys(Keys.DOWN)
		.sendKeys(Keys.ENTER)
		.sendKeys(Keys.ENTER)
		.build().perform();
		
		waitForPageReadyState();
		
		PageFactory.initElements(driver, this);
	}
	
	public void setPreferredStoreAtIndex(int index) {
		clickWithHighlight(setAsPreferredStoreButtonsOfSearchResults.get(index));
	}
	
	public void clickOnStoreDetailsLinkAtIndex(int index) {
		clickWithHighlight(storeDetailsLinksOfSearchResults.get(index));
	}
}
