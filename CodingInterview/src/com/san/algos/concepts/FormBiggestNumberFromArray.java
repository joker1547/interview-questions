package com.san.algos.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of numbers, arrange them in a way that yields the largest value. 
 * For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 
 * gives the largest value. And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, 
 * then the arrangement 998764543431 gives the largest value.
 * @author subrsa
 *A simple solution that comes to our mind is to sort all numbers in descending order, 
 *but simply sorting doesn’t work. For example, 548 is greater than 60, but in output 60 comes before 548. 
 *As a second example, 98 is greater than 9, but 9 comes before 98 in output.

So how do we go about it? The idea is to use any comparison based sorting algorithm. 
In the used sorting algorithm, instead of using the default comparison, write a comparison function myCompare() 
and use it to sort numbers. Given two numbers X and Y, how should myCompare() decide 
which number to put first – we compare two numbers XY (Y appended at the end of X) and 
YX (X appended at the end of Y). If XY is larger, then X should come before Y in output, 
else Y should come before. For example, let X and Y be 542 and 60. To compare X and Y, we compare 54260 and 60542. 
Since 60542 is greater than 54260, we put Y first.

Following is the implementation of the above approach. To keep the code simple, 
numbers are considered as strings, and vector is used instead of normal array.

 */
public class FormBiggestNumberFromArray {
	public static void findLargestNumber(List<String> array) {
		Collections.sort(array, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				String left = o1 + o2;
				String right = o2 + o1;
				return -1 * left.compareTo(right);
			}			
		});
		System.out.println(Arrays.toString(array.toArray(new String[array.size()])));
	}
	public static void main(String[] args) {
		List<String> array = new ArrayList<String>();
		array.add("54");
		array.add("546");
		array.add("548");
		array.add("60");
		array.add("9");
		findLargestNumber(array);
	}
}
