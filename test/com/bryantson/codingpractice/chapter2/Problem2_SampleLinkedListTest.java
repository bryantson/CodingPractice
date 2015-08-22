/**
 * Problem2_SampleLinkedListTest
 * 		Tests and verifies the different cases for SampleLinkedList
 * 
 * @author Bryant J. Son
 * @since  08/22/2015
 */


package com.bryantson.codingpractice.chapter2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.bryantson.codingpractice.chapter2.SampleLinkedList;

public class Problem2_SampleLinkedListTest {
	private SampleLinkedList sampleLinkedList;
	private int expected;
	
	@Before
	public void setUp() throws Exception {
		this.sampleLinkedList = new SampleLinkedList(1);
		this.sampleLinkedList.append(2);
		this.sampleLinkedList.append(3);
	}

	@Test
	public void testAppend_ReturnsSize5() {
		expected = 5;
		this.sampleLinkedList.append(4);
		this.sampleLinkedList.append(5);
		assertEquals(5, this.sampleLinkedList.size());
	}
	
	@Test
	public void testRemove_ReturnsSize2() {
		expected = 2;
		this.sampleLinkedList.removeNode(2);
		assertEquals(expected, this.sampleLinkedList.size());
	}
	
	@Test
	public void testRemoveNotExistingElement_ReturnsSize3() {
		expected = 3;
		this.sampleLinkedList.removeNode(4);
		assertEquals(expected, this.sampleLinkedList.size());
	}

}
