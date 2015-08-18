/**
 * Problem1_7PracticeTest
 * 		Tests and verifies the different cases for Problem1_7Practice
 * 
 * @author Bryant J. Son
 * @since  08/17/2015
 */

package com.bryantson.codingpractice.chapter1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Problem1_7PracticeTest {
	private Problem1_7Practice problem1_7Practice;
	private int[][] matrixActual;
	private int[][] matrixExpected;
	
	@Before
	public void setUp() throws Exception {
		this.problem1_7Practice = new Problem1_7Practice();
	}

	@Test
	public void testMatrixWithNonZeroElement_ReturnsSameMatrix() {
	  matrixExpected = getTestMatrix1();
		matrixActual = problem1_7Practice.getMatrixResetIfZero(matrixExpected);
		assertTrue(problem1_7Practice.equal(matrixExpected, matrixActual));
	}
	
	@Test
	public void testMatrixWithNonZeroElement_ReturnsZeroMatrix() {
		int[][] tempMatrix = getTestMatrix2();
		matrixExpected = new int[tempMatrix.length][tempMatrix[0].length];
		matrixActual = problem1_7Practice.getMatrixResetIfZero(tempMatrix);
		assertTrue(problem1_7Practice.equal(matrixExpected, matrixActual));
	}
	
	/** 
	 * Return a 2-D matrix with all non-zero element
	 * @return
	 */
	public int[][] getTestMatrix1() {
		int[][] result = new int[2][3];
		result[0][0] = 1;
		result[0][1] = 2;
		result[0][2] = 3;
		result[1][0] = 4;
		result[1][1] = 5;
		result[1][2] = 6;
		return result;
	}
	
	/** 
	 * Return a 2-D matrix with one zero element
	 * @return
	 */
	public int[][] getTestMatrix2() {
		int[][] result = new int[2][3];
		result[0][0] = 1;
		result[0][1] = 2;
		result[0][2] = 3;
		result[1][0] = 0;
		result[1][1] = 5;
		result[1][2] = 6;
		return result;
	}


}
