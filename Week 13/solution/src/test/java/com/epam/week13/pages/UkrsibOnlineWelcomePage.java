package com.epam.week13.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.epam.week13.util.DriverWaits;
import io.appium.java_client.AppiumDriver;

public class UkrsibOnlineWelcomePage extends BasePage {
	
	private String iAmAClientOptionButtonLocator = "com.ukrsibbank.client.android:id/loginCardView";
	private WebElement iAmAClientOptionButton;
	
	public UkrsibOnlineWelcomePage(AppiumDriver driver) {
		super(driver);
		iAmAClientOptionButton = DriverWaits.waitSecondsForVisibilityOfAnElement(
				driver, 10, By.id(iAmAClientOptionButtonLocator));
	}
	
	public UkrsibOnlineWelcomePage pressIAmAClientOptionButton() {
		iAmAClientOptionButton.click();
		
		logger.info("Pressed the login button");
		
		return this;
	}
}
