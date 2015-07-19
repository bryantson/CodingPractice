/**
 * Problem1_6PracticeTest
 * 		Tests and verifies the different cases for Problem1_6Practice
 * 
 * @author Bryant J. Son
 * @since  07/19/2015
 */


package com.bryantson.codingpractice.chapter1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Problem1_6PracticeTest {
	private Problem1_6Practice problem1_6Practice;
	private int[][] testGrid;
	private int M;
	private int N;
	private int[][] rotatedGrid;
	private String expected;
	
	@Before
	public void setUp() throws Exception {
		this.problem1_6Practice = new Problem1_6Practice();
	}
	

	@Test
	public void testGetRotatedGrid_ReturnRotatedEmptyGrid() {
		expected = "";
		M = 0;
		N = 0;
		testGrid = new int[M][N];

		rotatedGrid = problem1_6Practice.getRotatedMatrix(testGrid);

		assertEquals(expected, problem1_6Practice.getPrintableGrid(rotatedGrid));
	}
	
	@Test
	public void testGetRotatedGrid_ReturnRotated1By1Grid() {
		expected = "|1|\n";
		M = 1;
		N = 1;
		testGrid = new int[M][N];
		testGrid[0][0] = 1;

		rotatedGrid = problem1_6Practice.getRotatedMatrix(testGrid);

		assertEquals(expected, problem1_6Practice.getPrintableGrid(rotatedGrid));
	}
	

	@Test
	public void testGetRotatedGrid_ReturnRotated1By2Grid() {
		expected = "|1|\n|2|\n";
		M = 1;
		N = 2;
		testGrid = new int[M][N];
		testGrid[0][0] = 1;
		testGrid[0][1] = 2;

		rotatedGrid = problem1_6Practice.getRotatedMatrix(testGrid);

		assertEquals(expected, problem1_6Practice.getPrintableGrid(rotatedGrid));
	}
	
	@Test
	public void testGetRotatedGrid_ReturnRotated2By1Grid() {
		expected = "|2|1|\n";
		M = 2;
		N = 1;
		testGrid = new int[M][N];
		testGrid[0][0] = 1;
		testGrid[1][0] = 2;

		rotatedGrid = problem1_6Practice.getRotatedMatrix(testGrid);

		assertEquals(expected, problem1_6Practice.getPrintableGrid(rotatedGrid));
	}
	
	
	@Test
	public void testGetRotatedGrid_ReturnRotated4By3Grid() {
		expected = "|10|7|4|1|\n|11|8|5|2|\n|12|9|6|3|\n";
		M = 4;
		N = 3;
		testGrid = new int[M][N];
		testGrid[0][0] = 1;
		testGrid[0][1] = 2;
		testGrid[0][2] = 3;
		testGrid[1][0] = 4;
		testGrid[1][1] = 5;
		testGrid[1][2] = 6;
		testGrid[2][0] = 7;
		testGrid[2][1] = 8;
		testGrid[2][2] = 9;
		testGrid[3][0] = 10;
		testGrid[3][1] = 11;
		testGrid[3][2] = 12;
		rotatedGrid = problem1_6Practice.getRotatedMatrix(testGrid);

		assertEquals(expected, problem1_6Practice.getPrintableGrid(rotatedGrid));
	}
	


}
