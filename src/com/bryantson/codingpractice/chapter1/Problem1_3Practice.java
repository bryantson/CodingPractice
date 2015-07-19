/**
 * Problem1_3Practice
 * 	Given two strings, write a method to decide if one is a permutation of the other
 *
 * @author Bryant J. Son
 * @since 07/19/2015
 */

package com.bryantson.codingpractice.chapter1;

import java.util.Map;
import java.util.HashMap;

public class Problem1_3Practice {

	/**
	 * <p>
	 * 	Returns true if two given strings are permutation of each other. 
	 * </p>
	 * <p>
	 * 	For example, the permutation string of "abc" is "abc", "acb", "bac", "bca", "cab", "cba"
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

		Map<String, Integer> mapChar = new HashMap<String, Integer>();
		
		String key;
		
		// Look through the first string to store all characters:	
		for (int i = 0; i < nStr1; ++ i) {
			key = String.valueOf(str1.charAt(i));
			
			if(!mapChar.containsKey(key)) {
				mapChar.put(key, Integer.valueOf(1));
			}
			else {
				mapChar.put(key , Integer.valueOf(mapChar.get(key) + 1));
			}
		}

		// Go through the second string to match the occurring characters:
		for (int i = 0; i < nStr2; ++ i) {
			key = String.valueOf(str2.charAt(i));

			if (!mapChar.containsKey(key) || mapChar.get(key).equals(Integer.valueOf(0))) {
				return false;
			}
			mapChar.put(key, Integer.valueOf(mapChar.get(key) - 1));
		}

		// Go through the map to see if all characters appear only once:
		for (String iKey : mapChar.keySet()) {
			if (!mapChar.get(iKey).equals(Integer.valueOf(0))) {
				return false;
			}
		}

		return true;
	}


}