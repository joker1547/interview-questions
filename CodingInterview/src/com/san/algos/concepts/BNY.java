package com.san.algos.concepts;
import java.util.Scanner;

public class BNY {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int range = in.nextInt();
		int digit = in.nextInt();
		for(int i = 0; i <= range; i++){
//			if(String.valueOf(i).contains(digit)){
//				System.out.println(i);
//			}
			int number = i;
			while( number > 0){
				if(number % 10 == digit){
					System.out.println(i);
					break;
				}
				number = number / 10;
			}
	
		}
		
	}
}
