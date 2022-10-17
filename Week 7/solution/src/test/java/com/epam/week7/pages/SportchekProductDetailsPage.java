package com.epam.week7.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SportchekProductDetailsPage extends BasePage {
	
	private final String buyBoxSceletonLocator = ".nl-buy-box__skeleton";
	private final String cartFlyout = ".nl-cart-flyout__container";
	private final String continueToCartButtonOnCartFlyoutLocator = "#footer-btn";
	private final String baseURL = "https://qa3-www.sportchek.ca/en/pdp/product-";
	
	@FindBy(css="#variants li:first-child")
	private List<WebElement> defaultVariantOptions;
	
	@FindBy(css="#add-to-cart")
	private WebElement addToCartButton;
	
	private WebElement continueToCartButtonOnCartFlyout;
	
	public SportchekProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public void openPageFromProductIDAndInitializeElements(String productID) {
		driver.get(baseURL + productID + ".html");
		waitSecondsForInvisibilityOfAnElement(10, By.cssSelector(buyBoxSceletonLocator));
		PageFactory.initElements(driver, this);
	}
	
	public void selectDefaultVariantOptions() {
		for(WebElement variantOption : defaultVariantOptions) {
			variantOption.click();
		}
	}
	
	public void clickAddToCartButton() {
		addToCartButton.click();
		waitSecondsForVisibilityOfAnElement(10, By.cssSelector(cartFlyout));
		continueToCartButtonOnCartFlyout = driver.findElement(By
				.cssSelector(continueToCartButtonOnCartFlyoutLocator));
	}
	
	public void clickContinueToCartButtonOnCartFlyout() {
		continueToCartButtonOnCartFlyout.click();
	}
}
