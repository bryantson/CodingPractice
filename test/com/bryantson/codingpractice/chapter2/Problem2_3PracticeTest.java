/**
 * Problem2_3PracticeTest
 * 		Tests and verifies the different cases for Problem2_3Practice
 * 
 * @author Bryant J. Son
 * @since  08/24/2015
 */


package com.bryantson.codingpractice.chapter2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Problem2_3PracticeTest {
	private Problem2_3Practice problem2_3Practice;
	private int expectedBefore;
	private int expectedAfter;
	private int middle;
	private int size;
	
	@Before
	public void setUp() throws Exception {
		this.problem2_3Practice = new Problem2_3Practice(1);
	}
	
	@Test
	public void testRemoveMiddleOfList_SingleLengthChangesNothing() {	
		size = problem2_3Practice.size();
		middle = size / 2;
		
		expectedBefore = 1;
		assertEquals(expectedBefore, problem2_3Practice.getKthNode(middle).data);
		problem2_3Practice.removeMiddleOfList();
		size = problem2_3Practice.size();
		middle = size / 2;

		expectedAfter = 1;
		assertEquals(expectedAfter, problem2_3Practice.getKthNode(middle).data);
	}

	@Test
	public void testRemoveMiddleOfList_OddLengthReturnsCorrectly() {
		this.problem2_3Practice.append(2);
		this.problem2_3Practice.append(3);
		this.problem2_3Practice.append(4);
		this.problem2_3Practice.append(5);
		
		size = problem2_3Practice.size();
		middle = size / 2;
		
		expectedBefore = 3;
		assertEquals(expectedBefore, problem2_3Practice.getKthNode(middle).data);
		problem2_3Practice.removeMiddleOfList();
		size = problem2_3Practice.size();
		middle = size / 2;
		
		expectedAfter = 4;
		assertEquals(expectedAfter, problem2_3Practice.getKthNode(middle).data);
	}
	
	@Test
	public void testRemoveMiddleOfList_EvenLengthReturnsCorrectly() {
		this.problem2_3Practice.append(2);
		this.problem2_3Practice.append(3);
		this.problem2_3Practice.append(4);
		
		size = problem2_3Practice.size();
		middle = size / 2;
		
		expectedBefore = 3;
		assertEquals(expectedBefore, problem2_3Practice.getKthNode(middle).data);
		problem2_3Practice.removeMiddleOfList();
		size = problem2_3Practice.size();
		middle = size / 2;
		
		expectedAfter = 2;
		assertEquals(expectedAfter, problem2_3Practice.getKthNode(middle).data);
	}

}
