package com.epam.week9.tests;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.week9.model.ComputeEngineGoogleCloudCalculatorEntity;
import com.epam.week9.model.Email;
import com.epam.week9.pages.GoogleCloudHomePage;
import com.epam.week9.pages.GoogleCloudPricingCalculatorPage;
import com.epam.week9.pages.YopmailEmailInboxPage;
import com.epam.week9.pages.YopmailRandomEmailGeneratorPage;
import com.epam.week9.service.ComputeEngineGoogleCloudCreator;
import com.epam.week9.service.EmailCreator;

public class GoogleCloudCalculatorTests extends BaseTest {
	
	private final static String GOOGLE_CLOUD_CALCULATOR_WITH_EMAIL_TEST_FAIL_MESSAGE =
			"Monthly rent cost differs between email and calculator";
	private final static String GOOGLE_CLOUD_SEARCH_TEST_FAIL_MESSAGE =
			"Search results are not available";
	
	private GoogleCloudHomePage googleCloudHomePage;
	private GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage;
	private YopmailRandomEmailGeneratorPage yopmailRandomEmailGeneratorPage;
	private YopmailEmailInboxPage yopmailEmailInboxPage;
	
	@Test(groups="Google Cloud Calculator Tests")
	public void cloudPlatformPricingCalculatorWithEmailTest() {
		String searchQuery = "Google Cloud Pricing Calculator";
		Email email;
		String expectedMonthlyRent;
		List<WebElement> emailEstimationResults;
		
		ComputeEngineGoogleCloudCalculatorEntity virtualMachine = 
				ComputeEngineGoogleCloudCreator.defaultEntity();
		
		googleCloudHomePage = new GoogleCloudHomePage(driver);
		googleCloudPricingCalculatorPage = new GoogleCloudPricingCalculatorPage(driver);
		yopmailRandomEmailGeneratorPage = new YopmailRandomEmailGeneratorPage(driver);
		yopmailEmailInboxPage = new YopmailEmailInboxPage(driver);
		
		googleCloudHomePage.openPage().searchFor(searchQuery)
		.goToSpecificSearchResultWhichContainsSpecificText(searchQuery);
		googleCloudPricingCalculatorPage.switchFocusToCalculatorIFrame()
		.initializeCalculatorIFrameElements()
		.setNumberOfInstances(virtualMachine.getNumberOfInstances())
		.selectOperatingSystem(virtualMachine.getOperatingSystems())
		.selectVMClass(virtualMachine.getVMClass())
		.selectMachineTypeSeries(virtualMachine.getMachineTypeSeries())
		.selectMachineType(virtualMachine.getMachineType())
		.selectAddGPUCheckbox()
		.selectGPUType(virtualMachine.getGPUType(), virtualMachine.getNumberOfGPUs())
		.selectLocalSSD(virtualMachine.getLocalSSD())
		.selectDatacenterLocation(virtualMachine.getDatacenterLocation())
		.selectCommitedUsage(virtualMachine.getCommittedUsage())
		.clickAddToEstimateButton();
		
		expectedMonthlyRent = googleCloudPricingCalculatorPage.
				getSpecificEstimationResult("Estimated Component Cost").getText();
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		yopmailRandomEmailGeneratorPage.openPage().clickCheckInboxOfRandomEmailButton();
		email = EmailCreator.specificEmail(yopmailEmailInboxPage.getCurrentEmailAddressString());
		
		ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(0));
		
		googleCloudPricingCalculatorPage.switchFocusToCalculatorIFrame()
		.clickEmailEstimationResultsButton()
		.enterEmailIntoEmailYourEstimateForm(email.getEmailAddress())
		.clickSendEmailButtonOnEmailYourEstimateForm();
		
		driver.switchTo().window(windowHandles.get(1));
		
		emailEstimationResults = yopmailEmailInboxPage.waitForEmail()
				.switchToEmailIFrame()
				.getEstimationResultsFromEmail();
		
		Assert.assertTrue(emailEstimationResults.size() != 0 
				&& expectedMonthlyRent.contains(emailEstimationResults.get(0).getText())
				, GOOGLE_CLOUD_CALCULATOR_WITH_EMAIL_TEST_FAIL_MESSAGE);
	}
	
	@Test(groups={"Google Cloud Calculator Tests", "Smoke"})
	public void searchTest() {
		String searchQuery = "Google";
		googleCloudHomePage = new GoogleCloudHomePage(driver);
		
		WebElement searchResults = googleCloudHomePage
				.openPage()
				.searchFor(searchQuery)
				.getSearchResults();
		
		Assert.assertTrue(searchResults.isDisplayed(), GOOGLE_CLOUD_SEARCH_TEST_FAIL_MESSAGE);
	}
}
