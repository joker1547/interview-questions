package com.san.algos.concepts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CodeSprint10 {
	public static long max;
	public static int seq;
	public static void printAllSubArrays(long[] a, int k, List<String> memo){
		if(a.length < k)
			return;
		int index = 0;
		memo.add(Arrays.toString(a));
		if(a.length == k){	
			long bitAnd = a[0];
			for(int i = 0; i < a.length; i++){
			 	System.out.print(a[i] + " ");
			 	bitAnd = bitAnd & a[i];
			}
			if(max < bitAnd){
				max = bitAnd;
				seq = 1;
			}
			else if(max == bitAnd && max > 0){
				seq++;
			}
			System.out.println(bitAnd);			
		}
		else{
			long[] subArray = new long[a.length - 1];	
			
			for(int i = 0; i < a.length; i++){							
				for(int m = 0; m < i; m++){
					subArray[index] = a[m];
					index++;
				}
				for(int m = i+1; m < a.length; m++ ){
					subArray[index] = a[m];
					index++;
				}
				if(subArray.length >= k && !memo.contains(Arrays.toString(subArray)))
					printAllSubArrays(subArray, k, memo);
				index = 0;
			}	
		}
		
		
	}
	
	public static void subArrayNonRecursion(long[]a, int k){
		long bitAnd = 0;
		
		for(int i = 0; i < a.length; i++){			
			for(int j = i+1; j < a.length; j++){
				bitAnd = a[i];
				System.out.print(a[i] + " "); 
				for(int m = 0; m < k-1; m++){
					if(j+m < a.length){
						System.out.print(a[j+m] + " ");
						bitAnd = bitAnd & a[j+m];
					}
					else{
						bitAnd = 0;
						break;						
					}
				}
				if(max < bitAnd){
					max = bitAnd;
					seq = 1;
				}
				else if(max == bitAnd && max != 0){
					seq++;
				}
				System.out.println(bitAnd);
			}
		}
	}
	public static void swap(int[]a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static boolean isArrayHappy(int[] a, int k){
		if(a.length <= k){
			return false;
		}
		int count = 0;
		if(a.length >= 2 && a[0] < a[1]){
			count++;
		}
		for(int i = 1; i < a.length-1; i++){
			if(a[i-1] > a[i] || a[i+1] > a[i]){
				count++;
			}
			if(count >= k) 
				return true;
		}
		if(a[a.length-2] > a[a.length-1])
			count++;
		if(count >= k) 
			return true;
		return false;
	}
	
	public static void printPermutations(int[] a, Map<String, Integer> memo, int m){
		if(a.length <= 0)
			return;
		if(memo.containsKey(Arrays.toString(a)))
			return;
		
		if(isArrayHappy(a, m)){
			memo.put(Arrays.toString(a), 1);
			System.out.print(Arrays.toString(a));
			System.out.println( " happy");
		}
		
		//int[] b =  Arrays.copyOf(a, a.length);
		int k = 0;
		for(int i = 0; i < a.length; i++){
			swap(a, i, k); //swap first with each i
			if(!memo.containsKey(Arrays.toString(a)))
				printPermutations(a, memo, m);
			swap(a, k, i);//swap back.
		}
	}
	
	public static int factorial(int n){
		if(n <= 1)
			return 1;
		return n * factorial(n-1);
	}
	
	public static void printCombos(long[] a, int k){
		List<String> memo = new ArrayList<String>();
		printAllSubArrays(a, k, memo);
//		System.out.println(max);
//		System.out.println(seq);
//		long s = (long) (seq % (Math.pow(10, 9) + 7));
	//	subArrayNonRecursion(a, k);
		System.out.println(max + " " + seq);
	}
	public static void main(String[] args){
		//int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};	
		//int k = 3;
		//long[] a = {21, 19, 22, 20};		
		//int k = 7;
		//Map<String, Integer> memo = new HashMap<String, Integer>();
		//printPermutations(a, memo, 3);
		//System.out.println(factorial(10));
		//printCombos(a, k);
		Scanner in = new Scanner(System.in);
		List<Long> list = new ArrayList<Long>();
		long n = in.nextLong();
		long m = in.nextLong();
		System.out.println(n);
		System.out.println(m);
		for(int i = 0; i <= n; i++){
			list.add(new Long(0));
		}
		long max = 0;
		for(int i = 0; i < m; i++){
			long a = in.nextLong();
			long b = in.nextLong();
			long k = in.nextLong();
			for(long j = a; j <= b; j++){
				long c = list.get((int)j); 
				System.out.println(c  +"  " + (c +k));
				list.remove((int)j);
				if((c+k) > max) max = c+k;
				list.add((int) j, c+k);
				
			}		
		}
		System.out.println(Arrays.toString(list.toArray()));
		System.out.println(max);
	}
}
