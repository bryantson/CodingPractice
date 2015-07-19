/**
 * Problem1_2PracticeTest
 * 		Tests and verifies the different cases for Problem1_2Practice
 * 
 * @author Bryant J. Son
 * @since  07/19/2015
 */


package com.bryantson.codingpractice.chapter1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Problem1_2PracticeTest {
	private Problem1_2Practice problem1_2Practice;
	private String testStr;
	private String expected;
	
	@Before
	public void setUp() throws Exception {
		this.problem1_2Practice = new Problem1_2Practice();
	}

	@Test
	public void testReverse_ReturnsOriginalStringIfEmptyString() {
		expected = "";
		testStr = "";
		assertEquals(expected, problem1_2Practice.reverse(testStr));
	}
	
	@Test
	public void testReverse_ReturnsOriginalStringIfStringHasOneCharacter() {
		expected = "a";
		testStr = "a";
		assertEquals(expected, problem1_2Practice.reverse(testStr));
	}	
	
	
	@Test
	public void testReverse_ReturnsReverseStringForComplexString() {
		expected = "edcba";
		testStr = "abcde";
		assertEquals(expected, problem1_2Practice.reverse(testStr));
	}	

}
