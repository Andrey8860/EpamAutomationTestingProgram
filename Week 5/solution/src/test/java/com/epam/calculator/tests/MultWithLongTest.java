package com.epam.calculator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultWithLongTest extends BaseTest {
	
	@Test(dataProvider = "multiplicationValues", groups = "Basic Math Operations")
	public void multWithLongTest(long multiplicand, long multiplier, long expectedResult) {
		Assert.assertEquals(calculator.mult(multiplicand, multiplier), expectedResult, 
				"Multiplicand was " + multiplicand + ", multiplier was " + multiplier + ";");
	}
	
	@DataProvider(name = "multiplicationValues")
	public Object[][] multiplicationValues() {
		return new Object[][] {
			{0, 0, 0 * 0},
			{20, 0, 20 * 0},
			{0, 30, 0 * 30},
			{5, 5, 5 * 5},
			{19234, 763, 19234 * 763},
			{-77823, -5657, -77823 * -5657},
			{19234, -763, 19234 * -763},
			{-77823, 5657, -77823 * 5657}
		};
	}
	
}
