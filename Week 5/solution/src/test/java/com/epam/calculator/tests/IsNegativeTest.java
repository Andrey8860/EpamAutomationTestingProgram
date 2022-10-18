package com.epam.calculator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsNegativeTest extends BaseTest {
	
	@Test(dataProvider = "isNumberNegativeValues", groups = "Positive / Negative Boolean Methods")
	public void isNegativeTest(long number, boolean expectedResult) {
		Assert.assertEquals(calculator.isNegative(number), expectedResult, 
				"Number to check if it is negative: " + number + ";");
	}
	
	@DataProvider(name = "isNumberNegativeValues")
	public Object[][] isNumberNegativeValues() {
		return new Object[][] {
			{Long.MIN_VALUE, true},
			{Long.MAX_VALUE, false},
			{0, false},
			{1, false},
			{-1, true}
		};
	}
	
}
