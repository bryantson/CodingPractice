/**
 * Problem 1.6: 
 * 	Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 *  write a method to rotate the image by 90 degrees. Can you do this in place?
 *
 * 	@author Bryant Son
 * 	@since  07/19/2015
 */

package com.bryantson.codingpractice.chapter1;

import java.lang.StringBuilder;

class Problem1_6Practice {
	
	/**
	 * Returns the rotated grid representing 4 bytes for each cell (thus, int) by 90 degrees.
	 * 
	 * @param grid is the 2-D grid containing 4 bytes for each cell
	 * @return rotated 2-D grid by 90 degree
	 */
	public int[][] getRotatedMatrix(int[][] grid) {
		// Return an empty grid if the grid is not really two dimensional grid
		if (grid.length == 0 || grid[0].length == 0) {
			return grid;
		}
		
		int M = grid.length;
		int N = grid[0].length;

		int[][] result = new int[N][M];

		int lastM = M - 1;
		
		for (int r = 0; r < M; ++ r) {
			for (int c = 0; c < N; ++ c) {
				result[c][lastM - r] = grid[r][c];
			}
		}
		return result;
	}	
	
	/**
	 * Returns the string representation of 2-D grid
	 * 
	 * @param grid is the 2-D grid of int
	 * @return the string representation of grid for each print
	 */
	public String getPrintableGrid(int[][] grid) {
		StringBuilder result = new StringBuilder();
		for (int r = 0, m = grid.length; r < m; ++ r) {
			result.append("|");
			for (int c = 0, n = grid[0].length; c < n; ++ c) {
				result.append(grid[r][c]);
				result.append("|");
			}
			result.append("\n");
		}
		
		return result.toString();
	}
}
