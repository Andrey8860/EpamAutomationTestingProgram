package com.epam.week10.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.week10.util.DriverWaits;

public class GoogleCloudPricingCalculatorPage extends BasePage {
	
	private String emailEstimationResultsButtonLocator = 
			"//button[@ng-click='cloudCartCtrl.showEmailForm();']";
	private WebElement emailEstimationResultsButton;
	
	private String emailEstimateEmailTextFieldLocator = "//input[@type='email']";
	private WebElement emailEstimateEmailTextField;
	
	private String sendEmailButtonOnEmailYourEstimateFormLocator = 
			"//button[@aria-label='Send Email']";
	private WebElement sendEmailButtonOnEmailYourEstimateForm;
	
	private String estimationResultsLocator = "#resultBlock md-list-item";
	private String optionsOfAnActiveDropdownLocator = 
			".md-active.md-select-menu-container md-option";
	
	public GoogleCloudPricingCalculatorPage(WebDriver driver) {
		super(driver);
	}
	
	// This method switches to the IFrame of a calculator. Without it all elements would 
	// be unreachable
	public void switchFocusToCalculatorIFrame() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0)
				.andThen(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myFrame")));
		
		logger.info("Switched to the calculator IFrame");
	}
	
	public GoogleCloudPricingCalculatorPage clickEmailEstimationResultsButton() {
		emailEstimationResultsButton = DriverWaits.waitSecondsForVisibilityOfAnElement(driver,
				5, By.xpath(emailEstimationResultsButtonLocator));
		js.highlightElement(emailEstimationResultsButton);
		emailEstimationResultsButton.click();
		logger.info("Clicked email estimation results button");
		return this;
	}
	
	public GoogleCloudPricingCalculatorPage enterEmailIntoEmailYourEstimateForm(String email) {
		emailEstimateEmailTextField = DriverWaits.waitSecondsForVisibilityOfAnElement(driver,
				5, By.xpath(emailEstimateEmailTextFieldLocator));
		js.highlightElement(emailEstimateEmailTextField);
		emailEstimateEmailTextField.sendKeys(email);
		logger.info("Entered an email to send estimation results to: " + email);
		return this;
	}
	
	public GoogleCloudPricingCalculatorPage clickSendEmailButtonOnEmailYourEstimateForm() {
		sendEmailButtonOnEmailYourEstimateForm = DriverWaits.waitSecondsForVisibilityOfAnElement(driver,
				5, By.xpath(sendEmailButtonOnEmailYourEstimateFormLocator));
		js.highlightElement(sendEmailButtonOnEmailYourEstimateForm);
		sendEmailButtonOnEmailYourEstimateForm.click();
		logger.info("Clicked send email button");
		return this;
	}
	
	public WebElement getSpecificEstimationResult(String nameOfTheOption) {
		for(WebElement esimationResult : getEstimationResults()) {
			if(esimationResult.getText().toLowerCase().trim().contains(
					nameOfTheOption.toLowerCase().trim())) {
				logger.info("Retrieving a specific estimation result: " + nameOfTheOption);
				return esimationResult;
			}
		}
		logger.error("Estimation result " + nameOfTheOption + " not found. Returning null");
		return null;
	}
	
	protected List<WebElement> getEstimationResults() {
		return DriverWaits.waitSecondsForVisibilityOfAllElements(driver, 5, By.cssSelector(estimationResultsLocator));
	}
	
	protected List<WebElement> getAllOptionsOfAnActiveDropDown() {
		return DriverWaits.waitSecondsForVisibilityOfAllElements(driver, 5, By.cssSelector(optionsOfAnActiveDropdownLocator));
	}
	
	// This method provides the actual implementation of how a specific value 
	// in the dropdown is found and selected. It is private, since final users will have specific,
	// properly named methods, which would interact with the dropdown they actually need
	protected void selectSpecificOptionFromDropdown(
			List<WebElement> dropdownOptions, String optionToSelect) {
		
		logger.warn("Trying to select the option " + optionToSelect);
		
		for (WebElement dropdownOption : dropdownOptions) {
			if (dropdownOption.getText().toLowerCase().contains(optionToSelect.toLowerCase())) {
				js.highlightElement(dropdownOption);
				dropdownOption.click();
				logger.info("Selected an option " + optionToSelect);
				DriverWaits.waitSecondsForInvisibilityOfAllElements(driver, 5, dropdownOptions);
				break;
			}
		}
	}
}
