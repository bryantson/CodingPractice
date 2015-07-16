/**
 * Problem1_3Practice
 * 	Given two strings, write a method to decide if one is a permutation of the other
 *
 * @author Bryant J. Son
 * @since 07/15/2015
 */

package com.bryantson.codingpractice.chapter1;

public class Problem1_3Practice {

	/**
	 * <p>
	 * 	Returns true if two given strings are permutation of each other. 
	 * </p>
	 * <p>
	 * 	For example, "abcd" is the permutation string of "dcba"
	 * </p>
	 * 
	 * @param str1 and str2 are two parameters to compare to
	 * @return true if str1 is the permutation string of str2. False, otherwise.
	 */
	public boolean isPermutation(String str1, String str2) {
		int nStr1 = str1.length();
		int nStr2 = str2.length();

		// Cannot be the permutation if String lengths are differet:
		if (nStr1 != nStr2) {
			return false;
		}

		// Must be permutation if the String is empty:
		if (nStr1 == 0) {
			return true;
		}

		int iStr2 = nStr2 - 1;

		for (int iStr1 = 0; iStr1 < nStr1; ++ iStr1) {
			String currentValStr1 = String.valueOf(str1.charAt(iStr1));
			String currentValStr2 = String.valueOf(str2.charAt(iStr2));
			
			// Return false if a character is not equal:
			if (!currentValStr1.equals(currentValStr2)) {
				return false;
			}

			// Decrement the index to move to left character:
			-- iStr2;
		}

		return true;
	}

	public static void main(String[] args) {
		Problem1_3Practice prob = new Problem1_3Practice();

		String testStr1 = "";
		String testStr2 = "";
		System.out.println(prob.isPermutation(testStr1, testStr2));

		testStr1 = "a";
		testStr2 = "ab";
		System.out.println(prob.isPermutation(testStr1, testStr2));

		testStr1 = "abba";
		testStr2 = "abca";
		System.out.println(prob.isPermutation(testStr1, testStr2));

		testStr1 = "abba";
		testStr2 = "abba";
		System.out.println(prob.isPermutation(testStr1, testStr2));

		testStr1 = "abcd";
		testStr2 = "dcba";
		System.out.println(prob.isPermutation(testStr1, testStr2));
	}



}
