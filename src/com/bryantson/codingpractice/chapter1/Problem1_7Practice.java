/**
 * Problem 1.7: 
 * 	Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 *  column are set to 0.
 *
 * 	@author Bryant Son
 * 	@since  08/17/2015
 */

package com.bryantson.codingpractice.chapter1;

public class Problem1_7Practice {
	
	/**
	 * Returns the 2-D matrix all set to zero if any element of matrix is 0
	 * @param matrix is 2-D matrix of int
	 * @return 2-D matrix of int all set to zero if any element is zero. Same matrix from input, otherwise.
	 */
	public int[][] getMatrixResetIfZero(int[][] matrix) {
		int M = matrix.length;
		int N = matrix[0].length;

		for(int r = 0; r < M; ++ r) {
			for(int c = 0; c < N; ++ c) {
				if (matrix[r][c] == 0) {
					return new int[M][N];
				}
			}
		}
		return matrix;
	}
	
	/**
	 * Returns true if two 2-D matrices of int are equal
	 * @param matrix1 is first 2-D matrix
	 * @param matrix2 is second 2-D matrix
	 * @return true if two matrices are same. False, otherwise.
	 */
	public boolean equal(int[][] matrix1, int[][] matrix2) {
		if ((matrix1.length != matrix2.length) || (matrix1[0].length != matrix2[0].length)) {
			return false;
		}
		
		for(int r = 0, M = matrix1.length; r < M; ++ r) {
			for(int c = 0, N = matrix1[0].length; c < N; ++ c) {
				if(matrix1[r][c] != matrix2[r][c]) {
					return false;
				}
			}
		}
		
		return true;
	}

}
