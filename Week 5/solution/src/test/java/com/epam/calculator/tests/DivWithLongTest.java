package com.epam.calculator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivWithLongTest extends BaseTest {
	
	@Test(dataProvider = "divisionValues", groups = "Basic Math Operations")
	public void divWithLongTest(long dividend, long divisor, long expectedResult) {
		Assert.assertEquals(calculator.div(dividend, divisor), expectedResult, 
				"Dividend was " + dividend + ", divisor was " + divisor + ";");
	}
	
	@DataProvider(name = "divisionValues")
	public Object[][] divisionValues() {
		return new Object[][] {
			{0, 1, 0},
			{-150, 10, -15},
			{-150, -10, 15},
			{150, 10, 15},
			{150, -10, -15},
			{15875, -4533, 15875 / -4533},
			{-333, -333, -333 / -333}
		};
	}
	
}
