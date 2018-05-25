package com.san.algos.concepts;

public class MaxDifference {

	//Optimal solution is to have to two variables tracking minPrice and maxPrice.
	public int getMaxProfit(int[]a){
		int profit = 0;
		int prevPrice = a[0];
		for(int i = 0; i < a.length; i++){
			for( int j = i+1; j < a.length; j++){
				int margin = a[j] - a[i];
				if(margin > profit) profit = margin;
				
			}
		}
		return profit;
	}
	
	public int getMaxProfitOptimal(int[]a){
		int maxProfit = 0;
		int minPrice = a[0];
		for(int i = 1; i < a.length; i++){
			if(a[i] < minPrice){
				minPrice = a[i]; 
			}
			else{
				if( (a[i]-minPrice) > maxProfit ){
					maxProfit = a[i]-minPrice;
				}
			}
		}
		return maxProfit;
	}
	public static void main(String[] args){
		MaxDifference d = new MaxDifference();
		int [] a = {7, 1, 5, 3, 6, 4};
		
		System.out.println(d.getMaxProfit(a));
		System.out.println(d.getMaxProfitOptimal(a));
	}
}
