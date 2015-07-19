/**
 * Problem1_4PracticeTest
 * 		Tests and verifies the different cases for Problem1_4Practice
 * 
 * @author Bryant J. Son
 * @since  07/19/2015
 */

package com.bryantson.codingpractice.chapter1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Problem1_4PracticeTest {
	private Problem1_4Practice problem1_4Practice;
	private String testStr;
	private int testN;

	@Before
	public void setUp() throws Exception {
		this.problem1_4Practice = new Problem1_4Practice();
	}

	@Test
	public void testReplaceWithPercent20_EmptyStringZeroLengthReturnsEmptyString() {
		String expected = "";
		testStr = "";
		testN = 0;
		assertEquals(expected, problem1_4Practice.replaceWithPercent20(testStr, testN));
	}
	
	@Test
	public void testReplaceWithPercent20_NonEmptyStringZeroLengthReturnsEmptyString() {
		String expected = "";
		testStr = "Test String   ";
		testN = 0;
		assertEquals(expected, problem1_4Practice.replaceWithPercent20(testStr, testN));
	}
	
	@Test
	public void testReplaceWithPercent20_EmptyStringNonZeroLengthReturnsPercent20BySize() {
		String expected = "%20%20%20%20%20";
		testStr = "               ";
		testN = 5;
		assertEquals(expected, problem1_4Practice.replaceWithPercent20(testStr, testN));
	}
	
	@Test
	public void testReplaceWithPercent20_NonEmptyStringNonZeroLengthReturnsSomeValue() {
		String expected = "My%20Precious";
		testStr = "My Precious";
		testN = 11;
		assertEquals(expected, problem1_4Practice.replaceWithPercent20(testStr, testN));
	}
	
	@Test
	public void testReplaceWithPercent20_NonEmptyStringNonZeroLengthReturnsSomeValue2() {
		String expected = "My%20Pre";
		testStr = "My Precious";
		testN = 6;
		assertEquals(expected, problem1_4Practice.replaceWithPercent20(testStr, testN));
	}
	
	@Test
	public void testReplaceWithPercent20_NonEmptyStringNonZeroLengthReturnsSomeValue3() {
		String expected = "%20My%20Precious%20";
		testStr = " My Precious ";
		testN = 13;
		assertEquals(expected, problem1_4Practice.replaceWithPercent20(testStr, testN));
	}
	
	@Test
	public void testReplaceWithPercent20_NonEmptyStringNonZeroLengthReturnsSomeValue4() {
		String expected = "Mr%20John%20Smith";
		testStr = "Mr John Smith     ";
		testN = 13;
		assertEquals(expected, problem1_4Practice.replaceWithPercent20(testStr, testN));
		
	}
}
