package com.epam.week7.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.week7.pages.SportchekHomePage;
import com.epam.week7.pages.SportchekLoginModal;
import com.epam.week7.pages.SportchekProductDetailsPage;
import com.epam.week7.pages.SportchekStoreDetailsPage;
import com.epam.week7.pages.SportchekStoreLocatorPage;
import com.epam.week7.pages.SportchekCartPage;
import com.epam.week7.pages.SportchekFooter;
import com.epam.week7.pages.SportchekHeader;

public class SportchekTests extends BaseTest {
	
	private final static String SIGN_OUT_TEST_FAIL_MESSAGE = "Sign out was unsuccessful";
	private final static String PREFERRED_STORE_CHANGE_FROM_STORE_LOCATOR_TEST_FAIL_MESSAGE =
			"Change of preferred store through store locator was unsuccessful";
	private final static String SUBTOTAL_PRICE_IN_CART_FAIL_MESSAGE = 
			"Subtotal is different than the actual price of the cart item";
	
	@Test
	public void sportchekSignOutTest() {
		String loginEmail = "testreg.12.4.2022_1@mailinator.com";
		String loginPassword = "Testtest&1";
		
		SportchekHomePage sportchekHomePage = new SportchekHomePage(driver);
		sportchekHomePage.openPage();
		sportchekHomePage.setLocalStorageKeyValuePair("preferred-store-id", "371");
		
		SportchekHeader sportchekHeader = new SportchekHeader(driver);
		sportchekHeader.clickSignInLink();
		
		SportchekLoginModal sportchekLoginModal = new SportchekLoginModal(driver);
		sportchekLoginModal.enterLoginEmail(loginEmail);
		sportchekLoginModal.enterLoginPassword(loginPassword);
		sportchekLoginModal.clickSignInButton();
		sportchekLoginModal.waitForThePageSpinnerToBeInvisible();
		
		sportchekHeader.clickHiUsernameLink();
		sportchekHeader.clickSignOutButton();
		
		Assert.assertTrue(sportchekHeader.getSignInLink().isDisplayed(), SIGN_OUT_TEST_FAIL_MESSAGE);
	}
	
	@Test
	public void sportchekPreferredStoreChangeFromStoreLocatorTest() {
		String storeSearchQuery = "Gander Sport Chek";
		
		SportchekHomePage sportchekHomePage = new SportchekHomePage(driver);
		sportchekHomePage.openPage();
		sportchekHomePage.setLocalStorageKeyValuePair("preferred-store-id", "371");
		
		SportchekFooter sportchekFooter = new SportchekFooter(driver);
		sportchekFooter.clickStoreLocatorLink();
		
		SportchekStoreLocatorPage storeLocatorPage = new SportchekStoreLocatorPage(driver);
		storeLocatorPage.searchForStoreWithFirstOptionSelected(storeSearchQuery);
		storeLocatorPage.setPreferredStoreAtIndex(0);
		storeLocatorPage.clickOnStoreDetailsLinkAtIndex(0);
		
		SportchekStoreDetailsPage storeDetailsPage = new SportchekStoreDetailsPage(driver);
		SportchekHeader sportchekHeader = new SportchekHeader(driver);
		
		System.out.println(storeDetailsPage.getStoreTitleInDetailedAddressSection().getText());
		System.out.println(sportchekHeader.getPreferredStoreInHeader().getText());
		
		Assert.assertTrue(storeDetailsPage.getStoreTitleInDetailedAddressSection().getText()
				.equalsIgnoreCase(sportchekHeader.getPreferredStoreInHeader().getText()),
				PREFERRED_STORE_CHANGE_FROM_STORE_LOCATOR_TEST_FAIL_MESSAGE);
	}
	
	@Test
	public void subtotalPriceInCartTest() {
		String productID = "13078481f";
		
		SportchekProductDetailsPage productDetailsPage = new SportchekProductDetailsPage(driver);
		productDetailsPage.openPageFromProductIDAndInitializeElements(productID);
		productDetailsPage.selectDefaultVariantOptions();
		productDetailsPage.clickAddToCartButton();
		productDetailsPage.clickContinueToCartButtonOnCartFlyout();
		
		SportchekCartPage cartPage = new SportchekCartPage(driver);
		cartPage.increaseQuantityOfCartItem("5", 0);

		Assert.assertTrue(cartPage.getTotalPriceOfCartItem(0)
				.equalsIgnoreCase(cartPage.getSubtotalFromOrderSummary()), 
				SUBTOTAL_PRICE_IN_CART_FAIL_MESSAGE);
	}
}
