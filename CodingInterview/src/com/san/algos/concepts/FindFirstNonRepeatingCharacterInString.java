package com.san.algos.concepts;

import java.util.Arrays;

/***
 * 
 * 1) Scan the string from left to right and construct the count array.
	2) Again, scan the string from left to right and check for count of each
 	character, if you find an element who's count is 1, return it.
 *
 */
public class FindFirstNonRepeatingCharacterInString {

	public static void main(String args[]) {
		String s = "eeggeksForGeeks";
		int[] countArray = new int[123]; //A starts with 65 and lower case z ends at 122
		Arrays.fill(countArray, 0);
		for(int i = 0; i <s.length(); i++) {
			countArray[s.charAt(i)] ++;
		} 
		for(int i = 0; i <s.length(); i++) {
			if(countArray[s.charAt(i)] == 1) {
				System.out.println(s.charAt(i));
				break;
			}
		}
	}
}
