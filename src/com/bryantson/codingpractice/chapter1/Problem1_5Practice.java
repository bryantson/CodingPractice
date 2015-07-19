/**
 * Problem1_5Practice
 * 	Implement a method to perform basic string compression using the counts of repeated character. For example,
 *  the string "aabcccccaaa" would become "a2b1c5a3". If the "compressed" string would not become smaller than the original string,
 *  your method should return the original string. You can assume that the string has only upper and lower case letters (a - z).
 *  
 * @author Bryant J. Son
 * @since 07/19/2015
 */
package com.bryantson.codingpractice.chapter1;

import java.lang.StringBuilder;

public class Problem1_5Practice {

	/**
	 * Returns the compressed string using the basic method of using the counts of a repeated characters.
	 * 
	 * @param str is the uncompressed, plain string
	 * @return a compressed string if the result size is smaller than the original string. Return original string, otherwise.
	 */
	public String getCompressedString(String str) {
		// Calculates the original string length:
		int n = str.length();

		// If the string is empty or has a single character, return the original string:
		if (n < 2) {
			return str;
		}

		// Keeps track of the repeated string:
		String currentChar = String.valueOf(str.charAt(0));
		int countChar   = 0;

		StringBuilder result = new StringBuilder();

		// Loop through each character:
		for (int i = 0; i < n; ++ i) {
			// Keeps track of the original string:
			String key = String.valueOf(str.charAt(i));

			// If the current character is same, increment the counter:
			if (key.equals(currentChar)) {
				++ countChar;
			}
			// If the current character changed, append the character and the count and change the current char and reset count to 1:
			else {
				result.append(currentChar);
				result.append(countChar);
				
				// Change the currentChar and reset count:
				currentChar = key;
				countChar   = 1;
			}
		}
		// Append the last character and count:
		result.append(currentChar);
		result.append(countChar);

		
		String finalResult = result.toString();
		
		// Return the compressed string if the size is smaller than the original. Return original string, otherwise.
		return (finalResult.length() >= n) ? str : finalResult;

	}
}
