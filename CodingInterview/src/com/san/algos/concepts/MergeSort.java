package com.san.algos.concepts;

import java.util.Arrays;

public class MergeSort {

	public void mergeSort(int[] array, int left, int right){
		if(left >= right)
			return;
		int middle = (right + left ) / 2;
	    //System.out.println( middle  );
		mergeSort( array, left, middle);
		mergeSort(array, middle + 1, right);
		merge(array, left, middle, right);
		
	}
	
	public void merge(int[] array, int left, int middle, int right){
		int [] helper = new int[array.length];
		for(int i = left; i <= right; i++){
			helper[i] = array[i];			
		}
		int leftIndex = left;
		int rightIndex = middle+1;
		int arrayIndex = left;
		
		while(leftIndex <= middle && rightIndex <= right){			
			if(helper[leftIndex] < helper[rightIndex]){
				array[arrayIndex] = helper[leftIndex];
				leftIndex++;
			}
			else{
				array[arrayIndex] = helper[rightIndex];
				rightIndex++;
			}
			arrayIndex++;
		}
		
		while(leftIndex <= middle){
			array[arrayIndex] = helper[leftIndex];
			leftIndex++;
			arrayIndex++;
		}
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{3, 4,5, 0, 7, 7, 9, 19, 10, 12, 11};
		MergeSort sort = new MergeSort();
		sort.mergeSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
		
	}

}
