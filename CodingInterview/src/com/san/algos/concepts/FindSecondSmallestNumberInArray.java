package com.san.algos.concepts;
/**
 * 
 * Find Second smallest number in an array
 *
 */
public class FindSecondSmallestNumberInArray {
	public static void main (String[] args) {
		int[] array = new int[]{2, 5, 7, 3, 8, 9, 10};
		int minA, minB;
		minA = Integer.MAX_VALUE;
		minB = Integer.MAX_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(minA > array[i]){
				minB = minA;
				minA = array[i];
			}
			if( array[i] < minB && array[i] > minA){
				minB = array[i];
			}
		}
		for(int i = 0; i < array.length; i++) {
										
		}
		System.out.println(minB);
	}
}
