package com.epam.calculator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumWithDoubleTest extends BaseTest {
	
	@Test(dataProvider = "additionValues", groups = "Basic Math Operations")
	public void sumWithDoubleTest(double firstAddend, double secondAddend, double expectedResult) {
		Assert.assertEquals(calculator.sum(firstAddend, secondAddend), expectedResult,  0.0001,
				"First addend was " + firstAddend + ", second addend was " + secondAddend + ";");
	}
	
	@DataProvider(name = "additionValues")
	public Object[][] additionValues() {
		return new Object[][] {
			{0, 0, 0},
			{1, 0, 1},
			{-1, 1, 0},
			{-1, -1, -2},
			{25.5, 5.3, 30.8},
			{25.5, -5.3, 20.2},
			{-25.5, 5.3, -20.2},
			{-25.5, -5.3, -30.8}
		};
	}
}
