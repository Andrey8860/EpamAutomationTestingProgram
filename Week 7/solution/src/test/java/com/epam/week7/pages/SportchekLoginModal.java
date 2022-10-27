package com.epam.week7.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SportchekLoginModal extends BasePage {
		
	@FindBy(css=".gigya-composite-control-loginID input")
	private WebElement emailTextField;
	
	@FindBy(css=".gigya-composite-control-password input")
	private WebElement passwordTextField;
	
	@FindBy(css=".gigya-composite-control-submit input")
	private WebElement signInButton;
	
	public SportchekLoginModal(WebDriver driver) {
		super(driver);
	}
	
	public void enterLoginEmail(String email) {
		emailTextField.sendKeys(email);
	}
	
	public void enterLoginPassword(String password) {
		passwordTextField.sendKeys(password);
	}
	
	public void clickSignInButton() {
		signInButton.click();
	}
}
