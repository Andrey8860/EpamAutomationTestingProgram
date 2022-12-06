package com.epam.week11.cucumber.step_definitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import com.epam.week11.driver.DriverSingleton;
import com.epam.week11.model.Email;
import com.epam.week11.pages.ComputeEngineCloudCalculatorTab;
import com.epam.week11.pages.GoogleCloudPricingCalculatorPage;
import com.epam.week11.pages.GoogleCloudSearchResultsPage;
import com.epam.week11.pages.YopmailEmailInboxPage;
import com.epam.week11.pages.YopmailRandomEmailGeneratorPage;
import com.epam.week11.service.EmailCreator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleCloudPriceCalculatorSteps {
	
	private final static String EMAIL_ESTIMATION_RESULTS_FAIL_MESSAGE =
			"Estimation results in the email are not as expected";
	private final static String CALCULATOR_TAB_ESTIMATION_RESULTS_FAIL_MESSAGE =
			"Estimation results on the calculator page are not as expected";
	
	WebDriver driver = DriverSingleton.getDriver();
	private GoogleCloudSearchResultsPage googleCloudSearchResultsPage 
		= new GoogleCloudSearchResultsPage(driver);
	private GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage;
	private ComputeEngineCloudCalculatorTab computeEngineCloudCalculatorTab;
	private YopmailRandomEmailGeneratorPage yopmailRandomEmailGeneratorPage;
	private YopmailEmailInboxPage yopmailEmailInboxPage;
	
	
	@When("I click on the search results which contains {string}")
	public void i_click_on_the_search_results_which_contains(String searchQuery) {
		googleCloudSearchResultsPage.goToSpecificSearchResultWhichContainsSpecificText(searchQuery);
	}

	@Then("the page with the {string} title opens")
	public void the_page_with_the_title_opens(String title) {
	    Assert.assertTrue(driver.getTitle().contains(title),
	    		"The name of the search results page differs from the expected");
	}

	@Given("I am on the Compute Engine Cloud Calculator tab")
	public void i_am_on_the_compute_engine_cloud_calculator_tab() {
		googleCloudPricingCalculatorPage = new GoogleCloudPricingCalculatorPage(driver);
		googleCloudPricingCalculatorPage.switchFocusToCalculatorIFrame();
		computeEngineCloudCalculatorTab = new ComputeEngineCloudCalculatorTab(driver);
	}

	@When("I fill the number of instances with {string}")
	public void i_fill_the_number_of_instances_with(String numberOfInstances) {
		computeEngineCloudCalculatorTab.setNumberOfInstances(numberOfInstances);
	}

	@When("I select the operating system as {string}")
	public void i_select_the_operating_system_as(String operatingSystem) {
		computeEngineCloudCalculatorTab.selectOperatingSystem(operatingSystem);
	}

	@When("I select the virtual machine class as {string}")
	public void i_select_the_virtual_machine_class_as(String vMClass) {
		computeEngineCloudCalculatorTab.selectVMClass(vMClass);
	}

	@When("I select the machine type series as {string}")
	public void i_select_the_machine_type_series_as(String machineSeries) {
		computeEngineCloudCalculatorTab.selectMachineTypeSeries(machineSeries);
	}

	@When("I select the machine type as {string}")
	public void i_select_the_machine_type_as(String machineType) {
		computeEngineCloudCalculatorTab.selectMachineType(machineType);
	}

	@When("I select the {string} GPUs of type {string}")
	public void i_select_the_gp_us_of_type(String gPUNumber, String gPUType) {
		computeEngineCloudCalculatorTab.selectAddGPUCheckbox().selectGPUType(gPUType, gPUNumber);
	}

	@When("I select the local SSD as {string}")
	public void i_select_the_local_ssd_as(String localSSD) {
		computeEngineCloudCalculatorTab.selectLocalSSD(localSSD);
	}

	@When("I select the datacenter location as {string}")
	public void i_select_the_datacenter_location_as(String datacenterLocation) {
		computeEngineCloudCalculatorTab.selectDatacenterLocation(datacenterLocation);
	}

	@When("I select the commited usage as {string}")
	public void i_select_the_commited_usage_as(String commitedUsage) {
	    computeEngineCloudCalculatorTab.selectCommitedUsage(commitedUsage);
	}
	
	@When("I add the combination to the estimate")
	public void i_add_the_combination_to_the_estimate() {
		computeEngineCloudCalculatorTab.clickAddToEstimateButton();
	}

	@When("I provide an email for the estimation results to be sent to")
	public void i_provide_an_email_for_the_estimation_results_to_be_sent_to() {
		driver.switchTo().newWindow(WindowType.TAB);
		
		yopmailRandomEmailGeneratorPage = new YopmailRandomEmailGeneratorPage(driver);
		yopmailRandomEmailGeneratorPage.openPage().clickCheckInboxOfRandomEmailButton();
		
		yopmailEmailInboxPage = new YopmailEmailInboxPage(driver);
		Email email = EmailCreator.createSpecificEmail(yopmailEmailInboxPage.getCurrentEmailAddressString());
		
		ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(0));
		
		googleCloudPricingCalculatorPage.switchFocusToCalculatorIFrame();
		googleCloudPricingCalculatorPage.clickEmailEstimationResultsButton()
		.enterEmailIntoEmailYourEstimateForm(email.getEmailAddress());
	}

	@When("I choose an option for the estimation results to be sent to an email")
	public void i_choose_an_option_for_the_estimation_results_to_be_sent_to_an_email() {
		googleCloudPricingCalculatorPage.clickSendEmailButtonOnEmailYourEstimateForm();
	}

	@Then("The calculated sum {string} is the same on the page and in the email")
	public void the_calculated_sum_is_the_same_on_the_page_and_in_the_email(String expectedSum) {
		List<WebElement> emailEstimationResults = yopmailEmailInboxPage.getEstimationResultsFromEmail();
		
		Assert.assertTrue(emailEstimationResults.size() != 0 &&
				emailEstimationResults.get(0).getText().contains(expectedSum), 
				EMAIL_ESTIMATION_RESULTS_FAIL_MESSAGE);
		
		ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(0));
		
		googleCloudPricingCalculatorPage
				.switchFocusToCalculatorIFrame();
		String calculatorPageEstimationResults = googleCloudPricingCalculatorPage.
				getSpecificEstimationResult("Estimated Component Cost").getText();
	
		Assert.assertTrue(calculatorPageEstimationResults.contains(expectedSum), 
				CALCULATOR_TAB_ESTIMATION_RESULTS_FAIL_MESSAGE);
	}
	
}
