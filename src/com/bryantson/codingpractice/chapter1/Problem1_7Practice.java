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
