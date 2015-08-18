/**
 * Problem1_8PracticeTest
 * 		Tests and verifies the different cases for Problem1_8Practice
 * 
 * @author Bryant J. Son
 * @since  08/17/2015
 */

package com.bryantson.codingpractice.chapter1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Problem1_8PracticeTest {
	private Problem1_8Practice problem1_8Practice;
	private String testStr1;
	private String testStr2;
	
	@Before
	public void setUp() throws Exception {
		this.problem1_8Practice = new Problem1_8Practice();
	}

	@Test
	public void testDifferentSizeString_ReturnsFalse() {
		testStr1 = "eatearh";
		testStr2 = "eareat";
		assertFalse(problem1_8Practice.isRotatedString(testStr1, testStr2));
	}
	
	@Test
	public void testSameString_ReturnsTrue() {
		testStr1 = "waterbottle";
		testStr2 = "waterbottle";
		assertTrue(problem1_8Practice.isRotatedString(testStr1, testStr2));
	}
	
	@Test
	public void testRotatedString1_ReturnsTrue() {
		testStr1 = "waterbottle";
		testStr2 = "erbottlewat";
		assertTrue(problem1_8Practice.isRotatedString(testStr1, testStr2));
	}
	
	@Test
	public void testRotatedString2_ReturnsTrue() {
		testStr1 = "eatear";
		testStr2 = "eareat";
		assertTrue(problem1_8Practice.isRotatedString(testStr1, testStr2));
	}

}
