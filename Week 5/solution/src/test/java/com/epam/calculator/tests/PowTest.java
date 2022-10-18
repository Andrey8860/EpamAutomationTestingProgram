package com.epam.calculator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowTest extends BaseTest {
	
	@Test(dataProvider = "powerValues", groups = "Exponentiation")
	public void powerTest(double base, double exponent, double expectedResult) {
		Assert.assertEquals(calculator.pow(base, exponent), expectedResult,  0.0001,
				"Base was " + base + ", exponent was " + exponent + ";");
	}
	
	@DataProvider(name = "powerValues")
	public Object[][] powerValues() {
		return new Object[][] {
			{0, 0, 1},
			{1, 0, 1},
			{0, 1, 0},
			{5, 1, 5},
			{-5, 5, -3125},
			{5, 5, 3125},
			{1, -1, 1},
			{-1, -1, -1},
			{3.3, 3.5, 65.28280},
			{-3.3, 3.5, Double.NaN},
			{3.3, -3.5, 0.01531},
			{-3.3, -3.5, Double.NaN}
		};
	}
	
}
