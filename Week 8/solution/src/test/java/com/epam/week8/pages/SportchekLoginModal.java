package com.epam.week8.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SportchekLoginModal extends BasePage {
	
	private WebElement emailTextField;
	private final String emailTextFieldLocator = ".gigya-composite-control-loginID input";
	private WebElement passwordTextField;
	private final String passwordTextFieldLocator = ".gigya-composite-control-password input";
	private WebElement signInButton;
	private final String signInButtonLocator = ".gigya-composite-control-submit input";
	
	public SportchekLoginModal(WebDriver driver) {
		super(driver);
		emailTextField = js.findElementByCss(emailTextFieldLocator);
		passwordTextField = js.findElementByCss(passwordTextFieldLocator);
		signInButton = js.findElementByCss(signInButtonLocator);
	}
	
	public void logIn(String email, String password) {
		new Actions(driver)
		.sendKeys(emailTextField, email)
		.sendKeys(passwordTextField, password)
		.click(signInButton)
		.build()
		.perform();
	}
}
