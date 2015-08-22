/**
 * Problem2_1PracticeTest
 * 		Tests and verifies the different cases for Problem2_1Practice
 * 
 * @author Bryant J. Son
 * @since  08/22/2015
 */

package com.bryantson.codingpractice.chapter2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.bryantson.codingpractice.chapter1.Problem1_2Practice;

public class Problem2_1PracticeTest {
	private Problem2_1Practice problem2_1Practice;
	private int expected;
	
	@Before
	public void setUp() throws Exception {
		this.problem2_1Practice = new Problem2_1Practice(1);
		this.problem2_1Practice.append(2);
		this.problem2_1Practice.append(3);
	}

	@Test
	public void testRemoveDuplicatesOfRedundantSet_ReturnsRemovedSize() {
		expected = 3;

		this.problem2_1Practice.append(1);
		this.problem2_1Practice.append(2);
		this.problem2_1Practice.append(3);
		this.problem2_1Practice.removeDuplicatesWithBuffer();
			
		assertEquals(expected, this.problem2_1Practice.size());
	}
	
	@Test
	public void testRemoveDuplicatesOfNonRedundantSet_ReturnsAddedSize() {
		expected = 6;
		this.problem2_1Practice.append(4);
		this.problem2_1Practice.append(5);
		this.problem2_1Practice.append(6);
		this.problem2_1Practice.removeDuplicatesWithBuffer();
		assertEquals(expected, this.problem2_1Practice.size());
	}
	
	@Test
	public void testRemoveDupicatesComplicatedSet_ReturnsCorrectValue() {
		expected = 7;
		this.problem2_1Practice.append(4);
		this.problem2_1Practice.append(5);
		this.problem2_1Practice.append(4);
		this.problem2_1Practice.append(6);
		this.problem2_1Practice.append(7);
		this.problem2_1Practice.append(1);
		this.problem2_1Practice.append(2);
		this.problem2_1Practice.removeDuplicatesWithBuffer();
		assertEquals(expected, this.problem2_1Practice.size());
	}

	@Test
	public void testRemoveDuplicatesOfRedundantSetWithoutBuffer_ReturnsRemovedSize() {
		expected = 3; 
		
		this.problem2_1Practice.append(1);
		this.problem2_1Practice.append(2);
		this.problem2_1Practice.append(3);
		this.problem2_1Practice.removeDuplicatesWithoutBuffer();
		assertEquals(expected, this.problem2_1Practice.size());
	}
	
	@Test
	public void testRemoveDuplicatesOfNonRedundantSetWithoutBuffer_ReturnsAddedSize() {
		expected = 6; 
		
		this.problem2_1Practice.append(4);
		this.problem2_1Practice.append(5);
		this.problem2_1Practice.append(6);
		this.problem2_1Practice.removeDuplicatesWithoutBuffer();
		assertEquals(expected, this.problem2_1Practice.size());
	}
	
	@Test
	public void testRemoveDupicatesComplicatedSetWithoutBuffer_ReturnsCorrectValue() {
		expected = 7;
		this.problem2_1Practice.append(4);
		this.problem2_1Practice.append(5);
		this.problem2_1Practice.append(4);
		this.problem2_1Practice.append(6);
		this.problem2_1Practice.append(7);
		this.problem2_1Practice.append(1);
		this.problem2_1Practice.append(2);
		this.problem2_1Practice.removeDuplicatesWithoutBuffer();
		assertEquals(expected, this.problem2_1Practice.size());
	}
}
