package com.epam.week11.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.week11.util.DriverWaits;

public class ComputeEngineCloudCalculatorTab extends GoogleCloudPricingCalculatorPage {
	
	@FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
	private WebElement numberOfInstances;
	
	@FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
	private WebElement addGPUCheckbox;
	
	@FindBy(xpath = "//button[contains(@ng-click, 'addComputeServer')]")
	private WebElement addToEstimateButton;
	
	@FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
	private WebElement operatingSystemDropDown;
	
	@FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
	private WebElement vMClassDropDown;	
	
	@FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.series']")
	private WebElement machineTypeSeriesDropDown;
	
	@FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
	private WebElement machineTypeDropDown;
	
	private String gGPUTypeDropDownLocator = "//md-select[@placeholder='GPU type']";
	private WebElement gGPUTypeDropDown;
	
	private String numberOfGPUDropDownLocator = "//md-select[@placeholder='Number of GPUs']";
	private WebElement numberOfGPUDropDown;
	
	@FindBy(xpath = "//md-select[@placeholder='Local SSD']")
	private WebElement localSSDDropDown;
	
	@FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
	private WebElement datacenterLocationDropDown;
	
	@FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
	private WebElement commitedUsageDropDown;
	
	public ComputeEngineCloudCalculatorTab(WebDriver driver) {
		super(driver);
	}
	
	public ComputeEngineCloudCalculatorTab setNumberOfInstances(String numberOfInstances) {
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
	
	public ComputeEngineCloudCalculatorTab selectOperatingSystem(String operatingSystem) {
		selectSpecificOptionFromDropdown(getOperatingSystemOptions(), operatingSystem);
		logger.info("Set operating system to " + operatingSystem);
		return this;
	}
	
	public List<WebElement> getVMClassOptions() {
		vMClassDropDown.click();
		logger.info("Retrieving a list of VM classes");
		return getAllOptionsOfAnActiveDropDown();
	}
	
	public ComputeEngineCloudCalculatorTab selectVMClass(String vMClass) {
		selectSpecificOptionFromDropdown(getVMClassOptions(), vMClass);
		logger.info("Set VM class to " + vMClass);
		return this;
	}
	
	public List<WebElement> getMachineTypeSeriesOptions() {
		machineTypeSeriesDropDown.click();
		logger.info("Retrieving a list of machine type series");
		return getAllOptionsOfAnActiveDropDown();
	}
	
	public ComputeEngineCloudCalculatorTab selectMachineTypeSeries(String machineTypeSeries) {
		selectSpecificOptionFromDropdown(getMachineTypeSeriesOptions(), machineTypeSeries);
		logger.info("Set machine type series to " + machineTypeSeries);
		return this;
	}
	
	public List<WebElement> getMachineTypeOptions() {
		machineTypeDropDown.click();
		logger.info("Retrieving a list of machine types");
		return getAllOptionsOfAnActiveDropDown();
	}
	
	public ComputeEngineCloudCalculatorTab selectMachineType(String machineType) {
		selectSpecificOptionFromDropdown(getMachineTypeOptions(), machineType);
		logger.info("Set operating system to " + machineType);
		return this;
	}
	
	// This method will check if add GPU checkbox is already selected, and if it 
	// is not - it would select it and initialize drop downs which only appear when the
	// checkbox is selected. At the same time, it will not initialize or do anything if 
	// the checkbox is either not enabled at all or is already selected
	public ComputeEngineCloudCalculatorTab selectAddGPUCheckbox() {
		
		logger.warn("Trying to select Add GPU checkbox. Current state of the checkbox is: " 
		+ "enabled - " + addGPUCheckbox.isEnabled() + ";" 
		+ "selected - " + addGPUCheckbox.isSelected());
		
		if(addGPUCheckbox.isEnabled() && !addGPUCheckbox.isSelected()) {
			js.highlightElement(addGPUCheckbox);
			addGPUCheckbox.click();
			logger.info("Checked add GPU checkbox");
			gGPUTypeDropDown = DriverWaits.waitSecondsForVisibilityOfAnElement(driver, 5, By
					.xpath(gGPUTypeDropDownLocator));
			numberOfGPUDropDown = DriverWaits.waitSecondsForVisibilityOfAnElement(driver, 5, By
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
	
	public ComputeEngineCloudCalculatorTab selectGPUType(String gPUType, String numberOfGPUS) {
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
			localSSDDropDown.click();
			logger.info("Retrieving a list of local SSD options");
			return getAllOptionsOfAnActiveDropDown();
	}
	
	public ComputeEngineCloudCalculatorTab selectLocalSSD(String localSSD) {
		selectSpecificOptionFromDropdown(getLocalSSDOptions(), localSSD);
		logger.info("Set local SSD to " + localSSD);
		return this;
	}
	
	public List<WebElement> getDatacenterLocationOptions() {
		datacenterLocationDropDown.click();
		logger.info("Retrieving a list of datacenter locations");
		return getAllOptionsOfAnActiveDropDown();
	}
	
	public ComputeEngineCloudCalculatorTab selectDatacenterLocation(String datacenterLocation) {
		selectSpecificOptionFromDropdown(getDatacenterLocationOptions(), datacenterLocation);
		logger.info("Set datacenter location to " + datacenterLocation);
		return this;
	}
	
	public List<WebElement> getCommitedUsageOptions() {
		commitedUsageDropDown.click();
		logger.info("Retrieving a list of commited usage options");
		return getAllOptionsOfAnActiveDropDown();
	}
	
	public ComputeEngineCloudCalculatorTab clickAddToEstimateButton() {
		js.highlightElement(addToEstimateButton);
		addToEstimateButton.click();
		logger.info("Clicked add to estimate button");
		return this;
	}
	
	public ComputeEngineCloudCalculatorTab selectCommitedUsage(String commitedUsage) {
		selectSpecificOptionFromDropdown(getCommitedUsageOptions(), commitedUsage);
		logger.info("Set commited usage to " + commitedUsage);
		return this;
	}
	
}
