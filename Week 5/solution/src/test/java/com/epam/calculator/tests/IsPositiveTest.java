package com.epam.calculator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsPositiveTest extends BaseTest {
	
	@Test(dataProvider = "isNumberPositiveValues", groups = "Positive / Negative Boolean Methods")
	public void isPositiveTest(long number, boolean expectedResult) {
		Assert.assertEquals(calculator.isPositive(number), expectedResult, 
				"Number to check if it is Positive: " + number + ";");
	}
	
	@DataProvider(name = "isNumberPositiveValues")
	public Object[][] isNumberPositiveValues() {
		return new Object[][] {
			{Long.MIN_VALUE, false},
			{Long.MAX_VALUE, true},
			{0, true},
			{1, true},
			{-1, false}
		};
	}
	
}
