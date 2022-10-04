package com.epam.calculator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumWithLongTest extends BaseTest {
	
	@Test(dataProvider = "additionValues", groups = "Basic Math Operations")
	public void sumWithDoubleTest(long firstAddend, long secondAddend, long expectedResult) {
		Assert.assertEquals(calculator.sum(firstAddend, secondAddend), expectedResult, 
				"First addend was " + firstAddend + ", second addend was " + secondAddend + ";");
	}
	
	@DataProvider(name = "additionValues")
	public Object[][] additionValues() {
		return new Object[][] {
			{0, 0, 0},
			{1, 0, 1},
			{-1, 1, 0},
			{-1, -1, -2},
			{25534, 7891, 33425},
			{-25534, 7891, -17643},
			{25534, -7891, 17643},
			{-25534, -7891, -33425}
		};
	}
}
