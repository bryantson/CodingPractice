/**
 * Problem1_4Practice
 * 	Write a method to replace all spaces in a string with '%20'. You may assume that the string 
 *  has sufficient space at the end of the string to hold the additional characters, and that you are given the
 *  'true' length of the string. (Note: if implementing in Java, please use a character array so that you can
 *  perform this operation in place.)
 *  
 *  EXAMPLE:
 *  Input: "Mr John Smith    ", 13
 *  Output: "Mr%20John%20Smith"
 *
 * @author Bryant J. Son
 * @since 07/19/2015
 */
package com.bryantson.codingpractice.chapter1;

import java.lang.StringBuilder;

public class Problem1_4Practice {
	
	/**
	 * Returns the string that replaces all spaces with a string "%20" but restrict to the length "n" for the result.
	 * @param str is some string with a possible empty characters
	 * @param n is the true length of the return string
	 * @return string replaced the empty characters with a string "%20"
	 */
	public String replaceWithPercent20(String str, int n) {
		if(n == 0) {
		 	return "";
		}

		// Create the StringBuilder to store the return string:
		StringBuilder result = new StringBuilder();
		
		// Loop through the true length:
		for (int i = 0; i < n; ++ i) {
			String val = String.valueOf(str.charAt(i));
			
			// Append "%20" if sees the empty character. Append a character, otherwise.
			if (val.equals(" ")) {
				result.append("%20");
			}
			else {
				result.append(val);
			}
		}
		return result.toString();	
	}

}
