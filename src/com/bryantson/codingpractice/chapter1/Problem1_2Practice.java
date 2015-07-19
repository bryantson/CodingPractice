
/**
 * Problem 1.2: 
 * 	Implement a function void reverse in C or C++ which reverses a null terminated String. 
 * (I am just going to do in Java)
 *
 * 	@author Bryant Son
 * 	@since  07/19/2015
 */

package com.bryantson.codingpractice.chapter1;

import java.lang.StringBuilder;

public class Problem1_2Practice {

	/**
	 * Returns the reversed string of passed string "str"
	 * @param str is the input string
	 * @return the string that is the reversed string of str
	 */
	public String reverse(String str) {
		// Return original string if the string is either empty or has a single character:
		if(str == null || str.length() < 2) {
			return str;
		}

		StringBuilder result = new StringBuilder();
		
		// Counts from the end of the string to the beginning of string and append to the result string:
		for(int i = str.length() - 1; i >= 0; -- i) {
			result.append(String.valueOf(str.charAt(i)));
		}
		return result.toString();
	}
}
