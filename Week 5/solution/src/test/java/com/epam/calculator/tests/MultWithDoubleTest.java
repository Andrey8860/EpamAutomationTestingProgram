package com.epam.calculator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultWithDoubleTest extends BaseTest {
	
	@Test(dataProvider = "multiplicationValues", groups = "Basic Math Operations")
	public void multWithDoubleTest(double multiplicand, double multiplier, double expectedResult) {
		Assert.assertEquals(calculator.mult(multiplicand, multiplier), expectedResult,  0.0001,
				"Multiplicand was " + multiplicand + ", multiplier was " + multiplier + ";");
	}
	
	@DataProvider(name = "multiplicationValues")
	public Object[][] multiplicationValues() {
		return new Object[][] {
			{0, 0, 0 * 0},
			{20, 0, 20 * 0},
			{0, 30, 0 * 30},
			{5, 5, 5 * 5},
			{19234.7457, 763.99, Math.floor(19234.7457 * 763.99)},
			{-77823.33, -5657.44, Math.floor(-77823.33 * -5657.44)},
			{19234.7457, -763.99, Math.floor(19234.7457 * -763.99)},
			{-77823.33, 5657.44, Math.floor(-77823.33 * 5657.44)}
		};
	}
	
}
