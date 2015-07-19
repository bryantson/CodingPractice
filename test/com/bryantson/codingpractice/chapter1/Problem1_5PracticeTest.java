/**
 * Problem1_5PracticeTest
 * 		Tests and verifies the different cases for Problem1_5Practice
 * 
 * @author Bryant J. Son
 * @since  07/19/2015
 */

package com.bryantson.codingpractice.chapter1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Problem1_5PracticeTest {
	private Problem1_5Practice problem1_5Practice;
	private String testStr;
	
	@Before
	public void setUp() throws Exception {
		this.problem1_5Practice = new Problem1_5Practice();
	}

	@Test
	public void testGetCompressedString_EmptyStringReturnsSameString() {
		String expected = "";
		testStr = "";
		assertEquals(expected, problem1_5Practice.getCompressedString(testStr));
	}
	
	@Test
	public void testGetCompressedString_SingleCharacterStringReturnsSameString() {
		String expected = "a";
		testStr = "a";
		assertEquals(expected, problem1_5Practice.getCompressedString(testStr));
	}
	
	@Test
	public void testGetCompressedString_SameStringReturnsSameString() {
		String expected = "abcd";
		testStr = "abcd";
		assertEquals(expected, problem1_5Practice.getCompressedString(testStr));
	}
	
	@Test
	public void testGetCompressedString_CompressibleStringReturnsCompressedString() {
		String expected = "aab";
		testStr = "aab";
		assertEquals(expected, problem1_5Practice.getCompressedString(testStr));
	}
	
	@Test
	public void testGetCompressedString_CompressibleStringReturnsCompressedString2() {
		String expected = "a5b1";
		testStr = "aaaaab";
		assertEquals(expected, problem1_5Practice.getCompressedString(testStr));
	}
	
	@Test
	public void testGetCompressedString_CompressibleStringReturnsCompressedString3() {
		String expected = "aabb";
		testStr = "aabb";
		assertEquals(expected, problem1_5Practice.getCompressedString(testStr));
	}
	
	@Test
	public void testGetCompressedString_CompressibleStringReturnsCompressedString4() {
		String expected = "a2b1c5a3";
		testStr = "aabcccccaaa";
		assertEquals(expected, problem1_5Practice.getCompressedString(testStr));
	}
	
	

}
