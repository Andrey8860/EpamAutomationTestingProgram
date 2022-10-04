package com.epam.calculator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivWithDoubleTest extends BaseTest {
	
	@Test(dataProvider = "divisionValues", groups = "Basic Math Operations")
	public void divWithDoubleTest(double dividend, double divisor, double expectedResult) {
		Assert.assertEquals(calculator.div(dividend, divisor), expectedResult,  0.0001,
				"Dividend was " + dividend + ", divisor was " + divisor + ";");
	}
	
	@DataProvider(name = "divisionValues")
	public Object[][] divisionValues() {
		return new Object[][] {
			{0, 0, Double.NaN},
			{10, 0, Double.POSITIVE_INFINITY},
			{-10, 0, Double.NEGATIVE_INFINITY},
			{-150, 10, -150 / 10},
			{-150, -10, -150 / -10},
			{150, 10, 150 / 10},
			{150, -10, 150 / -10},
			{15.875, -453.3, 15.875 / -453.3},
			{-333, -333, -333 / -333}
		};
	}
	
}
