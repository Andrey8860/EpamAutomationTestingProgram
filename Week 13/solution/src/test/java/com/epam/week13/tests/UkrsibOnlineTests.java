package com.epam.week13.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.week13.pages.UkrsibOnlineLoginPage;
import com.epam.week13.pages.UkrsibOnlineWelcomePage;

public class UkrsibOnlineTests extends BaseTest {
	
	private UkrsibOnlineLoginPage loginPage;
	
	@Test
	public void loginErrorMessageTest() {
		String phoneNumber = RandomStringUtils.randomNumeric(9);
		String password = RandomStringUtils.randomAlphabetic(15);
		
		new UkrsibOnlineWelcomePage(driver)
		.pressIAmAClientOptionButton();
		
		loginPage = new UkrsibOnlineLoginPage(driver)
		.enterPhoneNumber(phoneNumber)
		.enterPassword(password)
		.pressLogInButton();
		
		Assert.assertNotNull(loginPage.getLoginErrorMessage()
				, "The login error message did not appear");
	}
	
}
