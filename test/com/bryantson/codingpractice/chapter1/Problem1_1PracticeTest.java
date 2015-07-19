/**
 * Problem1_1PracticeTest
 * 		Tests and verifies the different cases for Problem1_1Practice
 * 
 * @author Bryant J. Son
 * @since  07/19/2015
 */

package com.bryantson.codingpractice.chapter1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Problem1_1PracticeTest {
	private Problem1_1Practice problem1_1Practice;
	private String testStr;
	
	@Before
	public void setUp() throws Exception {
		this.problem1_1Practice = new Problem1_1Practice();
	}

	@Test
	public void testIsUniqueStringWithDS_ReturnsTrueIfStringIsEmpty() {
		testStr = "";
		assertTrue(problem1_1Practice.isUniqueStringWithDS(testStr));
	}

	@Test
	public void testIsUniqueStringWithDS_ReturnsTrueIfStringHasSingleCharacter() {
		testStr = "a";
		assertTrue(problem1_1Practice.isUniqueStringWithDS(testStr));
	}
	
	@Test
	public void testIsUniqueStringWithDS_ReturnsTrueIfStringHasNonRepeatingCharacter() {
		testStr = "abcd";
		assertTrue(problem1_1Practice.isUniqueStringWithDS(testStr));
	}
	
	@Test
	public void testIsUniqueStringWithDS_ReturnsTrueIfStringHasRepeatingCharacter() {
		testStr = "abacd";
		assertFalse(problem1_1Practice.isUniqueStringWithDS(testStr));
	}
}
