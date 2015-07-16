/**
 * Problem1_3PracticeTest
 * 		Tests and verifies the different cases for Problem1_3Practice
 * 
 * @author Bryant J. Son
 * @since  07/15/2015
 */
package com.bryantson.codingpractice.chapter1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.bryantson.codingpractice.chapter1.Problem1_3Practice;

public class Problem1_3PracticeTest {
	private Problem1_3Practice problem1_3Practice;
	private String testStr1;
	private String testStr2;
	
	@Before
	public void setUp() throws Exception {
		this.problem1_3Practice = new Problem1_3Practice();
	}

	@Test
	public void testIsPermutation_ReturnsFalseWhenLengthsAreDifferent() {
		testStr1 = "a";
		testStr2 = "aaa";
		assertFalse(problem1_3Practice.isPermutation(testStr1, testStr2));
	}
	
	@Test
	public void testIsPermutation_ReturnsTrueWhenEmptyString() {
		testStr1 = "";
		testStr2 = "";
		assertTrue(problem1_3Practice.isPermutation(testStr1, testStr2));
	}
	
	@Test
	public void testIsPermutation_ReturnsFalseWhenStringIsDifferent() {
		testStr1 = "abba";
		testStr2 = "abca";
		assertFalse(problem1_3Practice.isPermutation(testStr1, testStr2));
	}
	
	@Test
	public void testIsPermutation_ReturnTrueWhenStringIsEqual() {
		testStr1 = "abba";
		testStr2 = "abba";
		assertTrue(problem1_3Practice.isPermutation(testStr1, testStr2));
	}
	
	@Test
	public void testIsPermutation_ReturnsTrueWhenStringsArePermutation() {
		testStr1 = "abcd";
		testStr2 = "dcba";
		assertTrue(problem1_3Practice.isPermutation(testStr1, testStr2));
	}

}
