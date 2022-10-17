package com.epam.week7.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SportchekCartPage extends BasePage {
	
	private final String cartItemLocator = ".nl-shopping-cart__item";
	private final String quantitySelectorInputLocator = ".nl-qty-selector__text-input";
	private final String cartItemPricesLocator = ".nl-price--total";
	private final String subtotalFromOrderSummaryLocator = ".nl-order-summary__subtotal .nl-order-summary__price";
	
	@FindBy(css=cartItemLocator)
	private List<WebElement> cartItems;
	
	public SportchekCartPage(WebDriver driver) {
		super(driver);
		waitSecondsForVisibilityOfAnElement(10, By.cssSelector(cartItemLocator));
		PageFactory.initElements(driver, this);
	}
	
	public void increaseQuantityOfCartItem(String newQuantity, int cartItemIndex) {
		WebElement cartIteamQuantitySelector = cartItems.get(cartItemIndex).findElement(By
				.cssSelector(quantitySelectorInputLocator));
		
		cartIteamQuantitySelector.sendKeys(Keys.BACK_SPACE + newQuantity);
		
		waitForThePageSpinnerToBeInvisible();
	}
	
	public String getTotalPriceOfCartItem(int cartItemIndex) {
		return cartItems.get(cartItemIndex).findElement(By
				.cssSelector(cartItemPricesLocator)).getText();
	}
	
	public String getSubtotalFromOrderSummary() {
		return driver.findElement(By.cssSelector(subtotalFromOrderSummaryLocator)).getText();
	}
}
