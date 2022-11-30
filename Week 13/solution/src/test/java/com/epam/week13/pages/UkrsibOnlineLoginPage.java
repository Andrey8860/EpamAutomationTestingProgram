package com.epam.week13.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.epam.week13.util.DriverWaits;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class UkrsibOnlineLoginPage extends BasePage {
	
	@AndroidFindBy(id = "com.ukrsibbank.client.android:id/phoneInput")
	private WebElement phoneNumberTextField;
	
	@AndroidFindBy(id = "com.ukrsibbank.client.android:id/passwordValue")
	private WebElement passwordTextField;
	
	@AndroidFindBy(id = "com.ukrsibbank.client.android:id/loginAction")
	private WebElement logInButton;
	
	private String loginErrorMessageLocator = "com.ukrsibbank.client.android:id/operationGlobalErrorContainer";
	private WebElement loginErrorMessage;
	
	public UkrsibOnlineLoginPage(AppiumDriver driver) {
		super(driver);
	}
	
	public UkrsibOnlineLoginPage enterPhoneNumber(String phoneNumber) {
		phoneNumberTextField.click();
		phoneNumberTextField.sendKeys(phoneNumber);
		
		logger.info("Entered a phone number " + phoneNumber);
		
		return this;
	}
	
	public UkrsibOnlineLoginPage enterPassword(String password) {
		passwordTextField.sendKeys(password);
		
		logger.info("Entered a password " + password);
		
		return this;
	}
	
	public UkrsibOnlineLoginPage pressLogInButton() {
		logInButton.click();
		
		logger.info("Pressed the login button");
		
		return this;
	}
	
	public WebElement getLoginErrorMessage() {
		if(loginErrorMessage == null) {
			loginErrorMessage = DriverWaits.waitSecondsForVisibilityOfAnElement(
					driver, 5, By.id(loginErrorMessageLocator));
		}
		return loginErrorMessage;
	}
}
