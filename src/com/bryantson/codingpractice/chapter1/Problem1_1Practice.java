/**
 * Problem 1.1: 
 * 	Implement an algorithm to determine if a string has all unique
 * 	characters. What if you cannot use additional data structures?	
 *
 * 	@author Bryant Son
 * 	@since  07/19/2015
 */

package com.bryantson.codingpractice.chapter1;

import java.util.Map;
import java.util.HashMap;

class Problem1_1Practice {
	
	/**
	 * Returns true if a string has all unique characters
	 * 
	 * @param str is the input string that may has repeating characters
	 * @return true if the string contains all unique characters. False, otherwise.
	 */
	public boolean isUniqueStringWithDS(String str) {
		Map<Character, Integer> mapChars = new HashMap<Character, Integer>();

		// Return true if the string is empty or has a single character:
		if(str.length() < 2) {
			return true;
		}

		// Loop through the string to determine the repeating character:
		for(int i=0, n = str.length(); i < n; ++ i) {
			// If the character is already seen:
			if(mapChars.containsKey(str.charAt(i))) {
				return false;
			}
			// If not seen, store the character for check:
			else {
				mapChars.put(str.charAt(i), Integer.valueOf(0));
			}
		}
		return true;
	}

}
