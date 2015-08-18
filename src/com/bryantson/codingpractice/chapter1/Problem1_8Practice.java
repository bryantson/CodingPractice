/**
 * Problem 1.8: 
 * 	Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings,
 *  s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (e.g., "waterbottle"
 *  is a rotation of "erbottlewat")
 *
 * 	@author Bryant Son
 * 	@since  08/17/2015
 */

package com.bryantson.codingpractice.chapter1;

import java.lang.StringBuilder;

public class Problem1_8Practice {
	
	/**
	 * Returns true if s1 is the rotated String of s2 string.
	 * @param s1 is a string
	 * @param s2 is a string
	 * @return true if s1 is the rotated string of s2. False, otherwise.
	 */
	public boolean isRotatedString(String s1, String s2) {
		int lenS1 = s1.length();
		int lenS2 = s2.length();

		if(lenS1 != lenS2) {
			return false;
		}

		StringBuilder head = new StringBuilder();
		StringBuilder tail = new StringBuilder();

		int countS1 = 0;

		for(int i=0; i < lenS1; ++ i) {
			if(s1.charAt(countS1) == s2.charAt(i)) {
				head.append(s2.charAt(i));
				++ countS1;
			}
			else {
				tail.append(head);
				head = new StringBuilder();
				tail.append(s2.charAt(i));
				countS1 = 0;
			}
		}

		return ((head.length() + tail.length()) == lenS2) && (s2.indexOf(tail.toString()) != -1);
	
	}
}
