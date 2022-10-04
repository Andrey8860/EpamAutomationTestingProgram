package com.epam.calculator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubWithDoubleTest extends BaseTest {
	
	@Test(dataProvider = "subtractionValues", groups = "Basic Math Operations")
	public void subWithDoubleTest(double minuend, double subtrahend, double expectedResult) {
		Assert.assertEquals(calculator.sub(minuend, subtrahend), expectedResult,  0.0001,
				"Minuend was " + minuend + ", subtrahend was " + subtrahend + ";");
	}
	
	@DataProvider(name = "subtractionValues")
	public Object[][] subtractionValues() {
		return new Object[][] {
			{0, 0, 0},
			{1, 0, 1},
			{0, 1, -1},
			{-1, 1, -2},
			{-1, -1, 0},
			{25.5, 5.3, 20.2},
			{25.5, -5.3, 30.8},
			{-25.5, 5.3, -30.8},
			{-25.5, -5.3, -20.2}
		};
	}
}
