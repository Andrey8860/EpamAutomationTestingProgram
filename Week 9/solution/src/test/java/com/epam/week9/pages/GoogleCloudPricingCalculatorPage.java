package com.epam.week9.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPricingCalculatorPage extends BasePage {
	
	private String numberOfInstancesLocator = 
			"//input[@ng-model='listingCtrl.computeServer.quantity']";
	private WebElement numberOfInstances;
	
	private String addGPUCheckboxLocator = 
			"//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']";
	private WebElement addGPUCheckbox;
	
	private String addToEstimateButtonLocator = 
			"//button[contains(@ng-click, 'addComputeServer')]";
	private WebElement addToEstimateButton;
	
	private String emailEstimationResultsButtonLocator = 
			"//button[@ng-click='cloudCartCtrl.showEmailForm();']";
	private WebElement emailEstimationResultsButton;
	
	private String emailEstimateEmailTextFieldLocator = "//input[@type='email']";
	private WebElement emailEstimateEmailTextField;
	
	private String sendEmailButtonOnEmailYourEstimateFormLocator = 
			"//button[@aria-label='Send Email']";
	private WebElement sendEmailButtonOnEmailYourEstimateForm;
	
	private String operatingSystemDropDownLocator = 
			"//md-select[@ng-model='listingCtrl.computeServer.os']";
	private WebElement operatingSystemDropDown;
	
	private String vMClassDropDownLocator = 
			"//md-select[@ng-model='listingCtrl.computeServer.class']";
	private WebElement vMClassDropDown;	
	
	private String machineTypeSeriesDropDownLocator = 
			"//md-select[@ng-model='listingCtrl.computeServer.series']";
	private WebElement machineTypeSeriesDropDown;
	
	private String machineTypeDropDownLocator = 
			"//md-select[@ng-model='listingCtrl.computeServer.instance']";
	private WebElement machineTypeDropDown;
	
	private String gGPUTypeDropDownLocator = "//md-select[@placeholder='GPU type']";
	private WebElement gGPUTypeDropDown;
	
	private String numberOfGPUDropDownLocator = "//md-select[@placeholder='Number of GPUs']";
	private WebElement numberOfGPUDropDown;
	
	private String localSSDDropDownLocator = "//md-select[@placeholder='Local SSD']";
	private WebElement localSSDDropDown;
	
	private String datacenterLocationDropDownLocator = 
			"//md-select[@ng-model='listingCtrl.computeServer.location']";
	private WebElement datacenterLocationDropDown;
	
	private String commitedUsageDropDownLocator = 
			"//md-select[@ng-model='listingCtrl.computeServer.cud']";
	private WebElement commitedUsageDropDown;
	
	private String estimationResultsLocator = "#resultBlock md-list-item";
	private String optionsOfAnActiveDropdownLocator = 
			".md-active.md-select-menu-container md-option";
	
	public GoogleCloudPricingCalculatorPage(WebDriver driver) {
		super(driver);
	}
	
	// This method switches to the IFrame of a calculator. Without it all elements would 
	// be unreachable
	public GoogleCloudPricingCalculatorPage switchFocusToCalculatorIFrame() {
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0)
				.andThen(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myFrame")));
		
		logger.info("Switched to the calculator IFrame");
		
		return this;
	}
	
	// This method initializes all the elements which are present by default once the focus 
	// switches to the calculator Iframe. It does not initialize dynamic elements which 
	// are not present at this point
	public GoogleCloudPricingCalculatorPage initializeCalculatorIFrameElements() {
		numberOfInstances = driver.findElement(By.xpath(numberOfInstancesLocator));
		addGPUCheckbox = driver.findElement(By.xpath(addGPUCheckboxLocator));
		addToEstimateButton = driver.findElement(By.xpath(addToEstimateButtonLocator));
		operatingSystemDropDown = driver.findElement(
				By.xpath(operatingSystemDropDownLocator));
		vMClassDropDown = driver.findElement(By.xpath(vMClassDropDownLocator));
		machineTypeSeriesDropDown = driver.findElement(
				By.xpath(machineTypeSeriesDropDownLocator));
		machineTypeDropDown = driver.findElement(By.xpath(machineTypeDropDownLocator));
		datacenterLocationDropDown = driver.findElement(
				By.xpath(datacenterLocationDropDownLocator));
		commitedUsageDropDown = driver.findElement(By.xpath(commitedUsageDropDownLocator));
		
		logger.info("Initialized calculator's IFrame elements");
		
		return this;
	}
	
	public GoogleCloudPricingCalculatorPage setNumberOfInstances(String numberOfInstances) {
		logger.info("Set number of instances to " + numberOfInstances);
		js.highlightElement(this.numberOfInstances);
		this.numberOfInstances.sendKeys(numberOfInstances);
		return this;
	}
	
	public List<WebElement> getOperatingSystemOptions() {
		operatingSystemDropDown.click();
		logger.info("Retrieving a list of operating systems");
		return getAllOptionsOfAnActiveDropDown();
	}
	
	public GoogleCloudPricingCalculatorPage selectOperatingSystem(String operatingSystem) {
		selectSpecificOptionFromDropdown(getOperatingSystemOptions(), operatingSystem);
		logger.info("Set operating system to " + operatingSystem);
		return this;
	}
	
	public List<WebElement> getVMClassOptions() {
		vMClassDropDown.click();
		logger.info("Retrieving a list of VM classes");
		return getAllOptionsOfAnActiveDropDown();
	}
	
	public GoogleCloudPricingCalculatorPage selectVMClass(String vMClass) {
		selectSpecificOptionFromDropdown(getVMClassOptions(), vMClass);
		logger.info("Set VM class to " + vMClass);
		return this;
	}
	
	public List<WebElement> getMachineTypeSeriesOptions() {
		machineTypeSeriesDropDown.click();
		logger.info("Retrieving a list of machine type series");
		return getAllOptionsOfAnActiveDropDown();
	}
	
	public GoogleCloudPricingCalculatorPage selectMachineTypeSeries(String machineTypeSeries) {
		selectSpecificOptionFromDropdown(getMachineTypeSeriesOptions(), machineTypeSeries);
		logger.info("Set machine type series to " + machineTypeSeries);
		return this;
	}
	
	public List<WebElement> getMachineTypeOptions() {
		machineTypeDropDown.click();
		logger.info("Retrieving a list of machine types");
		return getAllOptionsOfAnActiveDropDown();
	}
	
	public GoogleCloudPricingCalculatorPage selectMachineType(String machineType) {
		selectSpecificOptionFromDropdown(getMachineTypeOptions(), machineType);
		logger.info("Set operating system to " + machineType);
		return this;
	}
	
	// This method will check if add GPU checkbox is already selected, and if it 
	// is not - it would select it and initialize drop downs which only appear when the
	// checkbox is selected. At the same time, it will not initialize or do anything if 
	// the checkbox is either not enabled at all or is already selected
	public GoogleCloudPricingCalculatorPage selectAddGPUCheckbox() {
		
		logger.warn("Trying to select Add GPU checkbox. Current state of the checkbox is: " 
		+ "enabled - " + addGPUCheckbox.isEnabled() + ";" 
		+ "selected - " + addGPUCheckbox.isSelected());
		
		if(addGPUCheckbox.isEnabled() && !addGPUCheckbox.isSelected()) {
			js.highlightElement(addGPUCheckbox);
			addGPUCheckbox.click();
			logger.info("Checked add GPU checkbox");
			gGPUTypeDropDown = waitSecondsForVisibilityOfAnElement(5, By
					.xpath(gGPUTypeDropDownLocator));
			numberOfGPUDropDown = waitSecondsForVisibilityOfAnElement(5, By
					.xpath(numberOfGPUDropDownLocator));
		}
		return this;
	}
	
	public List<WebElement> getGPUTypeOptions() {
		gGPUTypeDropDown.click();
		logger.info("Retrieving a list of GPU types");
		return getAllOptionsOfAnActiveDropDown();
	}
	
	public List<WebElement> getNumberOfGPUSOptions() {
		numberOfGPUDropDown.click();
		logger.info("Retrieving a list of GPU numbers");
		return getAllOptionsOfAnActiveDropDown();
	}
	
	public GoogleCloudPricingCalculatorPage selectGPUType(String gPUType, String numberOfGPUS) {
		selectSpecificOptionFromDropdown(getGPUTypeOptions(), gPUType);
		logger.info("Set GPU type to " + gPUType);
		selectSpecificOptionFromDropdown(getNumberOfGPUSOptions(), numberOfGPUS);
		logger.info("Set number of GPUs to " + numberOfGPUS);
		return this;
	}
	
	// This method first of all ensures that with options already selected, 
	// Local SSD dropdown is available at all, since not every combination of
	// a virtual machine has this option
	public List<WebElement> getLocalSSDOptions() {
			localSSDDropDown = waitSecondsForVisibilityOfAnElement(
					5, By.xpath(localSSDDropDownLocator));
			localSSDDropDown.click();
			logger.info("Retrieving a list of local SSD options");
			return getAllOptionsOfAnActiveDropDown();
	}
	
	public GoogleCloudPricingCalculatorPage selectLocalSSD(String localSSD) {
		selectSpecificOptionFromDropdown(getLocalSSDOptions(), localSSD);
		logger.info("Set local SSD to " + localSSD);
		return this;
	}
	
	public List<WebElement> getDatacenterLocationOptions() {
		datacenterLocationDropDown.click();
		logger.info("Retrieving a list of datacenter locations");
		return getAllOptionsOfAnActiveDropDown();
	}
	
	public GoogleCloudPricingCalculatorPage selectDatacenterLocation(String datacenterLocation) {
		selectSpecificOptionFromDropdown(getDatacenterLocationOptions(), datacenterLocation);
		logger.info("Set datacenter location to " + datacenterLocation);
		return this;
	}
	
	public List<WebElement> getCommitedUsageOptions() {
		commitedUsageDropDown.click();
		logger.info("Retrieving a list of commited usage options");
		return getAllOptionsOfAnActiveDropDown();
	}
	
	public GoogleCloudPricingCalculatorPage selectCommitedUsage(String commitedUsage) {
		selectSpecificOptionFromDropdown(getCommitedUsageOptions(), commitedUsage);
		logger.info("Set commited usage to " + commitedUsage);
		return this;
	}
	
	public GoogleCloudPricingCalculatorPage clickAddToEstimateButton() {
		js.highlightElement(addToEstimateButton);
		addToEstimateButton.click();
		logger.info("Clicked add to estimate button");
		return this;
	}
	
	public GoogleCloudPricingCalculatorPage clickEmailEstimationResultsButton() {
		emailEstimationResultsButton = waitSecondsForVisibilityOfAnElement(
				5, By.xpath(emailEstimationResultsButtonLocator));
		js.highlightElement(emailEstimationResultsButton);
		emailEstimationResultsButton.click();
		logger.info("Clicked email estimation results button");
		return this;
	}
	
	public GoogleCloudPricingCalculatorPage enterEmailIntoEmailYourEstimateForm(String email) {
		emailEstimateEmailTextField = waitSecondsForVisibilityOfAnElement(
				5, By.xpath(emailEstimateEmailTextFieldLocator));
		js.highlightElement(emailEstimateEmailTextField);
		emailEstimateEmailTextField.sendKeys(email);
		logger.info("Entered an email to send estimation results to: " + email);
		return this;
	}
	
	public GoogleCloudPricingCalculatorPage clickSendEmailButtonOnEmailYourEstimateForm() {
		sendEmailButtonOnEmailYourEstimateForm = waitSecondsForVisibilityOfAnElement(
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
	
	private List<WebElement> getEstimationResults() {
		return waitSecondsForVisibilityOfAllElements(5, By.cssSelector(estimationResultsLocator));
	}
	
	private List<WebElement> getAllOptionsOfAnActiveDropDown() {
		return waitSecondsForVisibilityOfAllElements(5, By.cssSelector(optionsOfAnActiveDropdownLocator));
	}
	
	// This method provides the actual implementation of how a specific value 
	// in the dropdown is found and selected. It is private, since final users will have specific,
	// properly named methods, which would interact with the dropdown they actually need
	private void selectSpecificOptionFromDropdown(
			List<WebElement> dropdownOptions, String optionToSelect) {
		
		logger.warn("Trying to select the option " + optionToSelect);
		
		for (WebElement dropdownOption : dropdownOptions) {
			if (dropdownOption.getText().toLowerCase().contains(optionToSelect.toLowerCase())) {
				js.highlightElement(dropdownOption);
				dropdownOption.click();
				logger.info("Selected an option " + optionToSelect);
				waitSecondsForInvisibilityOfAllElements(5, dropdownOptions);
				break;
			}
		}
	}
}
