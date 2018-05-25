package com.san.algos.concepts;

public class BitManipulation {
	
	public static String getBinary(int n){
		return Integer.toBinaryString(n);
	} 
	public static void main(String args[]){
		
		System.out.println("hello there " + getBinary( (0 << 3) ) );
		System.out.println(getBinary(1) + " - " + ~1 + " - " + getBinary(~1) );
		System.out.println(~(1 << 3) + " - " + getBinary(~(1 << 3)) );
		System.out.println( (8 | 4 ) + " - " + getBinary((8 | 4)));
		int allOnes = ~0; 
		System.out.println(allOnes + " - " + getBinary(allOnes));
		int left = allOnes << 5;
		int right = (1 << 2) - 1;
		System.out.println(getBinary(left) + " " + getBinary(right) );
		System.out.println(getBinary(left | right));
	}
}
