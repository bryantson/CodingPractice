/**
 * Problem2_2PracticeTest
 * 		Tests and verifies the different cases for Problem2_2Practice
 * 
 * @author Bryant J. Son
 * @since  08/24/2015
 */

package com.bryantson.codingpractice.chapter2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Problem2_2PracticeTest {
	private Problem2_2Practice problem2_2Practice;
	private Node sampleHead;
	private int expected;
	
	@Before
	public void setUp() throws Exception {
		problem2_2Practice = new Problem2_2Practice();
		this.sampleHead = new Node(1);
	}
	
	@Test
	public void testGetKthFromLastWithLengthAndZeroK_OneNodeReturnsOriginal() {
		expected = 1;
		assertEquals(expected, problem2_2Practice.getKthFromLastWithLength(0, this.sampleHead).data);
	}
	
	@Test
	public void testGetKthFromLastWithLength_OneNodeReturnsOriginal() {
		expected = 1;
		assertEquals(expected, problem2_2Practice.getKthFromLastWithLength(1, this.sampleHead).data);
	}

	@Test
	public void testGetKthFromLastWithLength_MultipleNodeReturnsCorrect() {
		expected = 5;
		this.sampleHead.append(2);
		this.sampleHead.append(3);
		this.sampleHead.append(4);
		this.sampleHead.append(5);
		this.sampleHead.append(6);
		this.sampleHead.append(7);
		
		assertEquals(expected, problem2_2Practice.getKthFromLastWithLength(3, this.sampleHead).data);
	}
	
	@Test
	public void testGetKthFromLastWithLength_MultipleNodeKExceedLenReturnsCorrect() {
		expected = 1;
		this.sampleHead.append(2);
		this.sampleHead.append(3);
		this.sampleHead.append(4);
		this.sampleHead.append(5);
		this.sampleHead.append(6);
		this.sampleHead.append(7);
		
		assertEquals(expected, problem2_2Practice.getKthFromLastWithLength(9, this.sampleHead).data);
	}
	
	@Test
	public void testGetKthFromLastWithPointerAndZeroK_OneNodeReturnsOriginal() {
		expected = 1;
		assertEquals(expected, problem2_2Practice.getKthFromLastWithPointer(0, this.sampleHead).data);
	}
	
	@Test
	public void testGetKthFromLastWithPointer_OneNodeReturnsOriginal() {
		expected = 1;
		assertEquals(expected, problem2_2Practice.getKthFromLastWithPointer(1, this.sampleHead).data);
	}

	@Test
	public void testGetKthFromLastWithPointer_MultipleNodeReturnsCorrect() {
		expected = 5;
		this.sampleHead.append(2);
		this.sampleHead.append(3);
		this.sampleHead.append(4);
		this.sampleHead.append(5);
		this.sampleHead.append(6);
		this.sampleHead.append(7);
		
		assertEquals(expected, problem2_2Practice.getKthFromLastWithPointer(3, this.sampleHead).data);
	}
	
	@Test
	public void testGetKthFromLastWithPointer_MultipleNodeKExceedLenReturnsCorrect() {
		expected = 1;
		this.sampleHead.append(2);
		this.sampleHead.append(3);
		this.sampleHead.append(4);
		this.sampleHead.append(5);
		this.sampleHead.append(6);
		this.sampleHead.append(7);
		
		assertEquals(expected, problem2_2Practice.getKthFromLastWithPointer(9, this.sampleHead).data);
	}
}
