package com.san.algos.concepts;

public class ArrayQuestions {
	public int[] array = new int[10];
	private void init(){
		for(int i = 0; i < array.length; i++){
			array[i] = i+1;
		}
	}
	
	public void findKthNumberOfElements(int n){
		int contiguousSum = 0;
		for(int i = 0; i < n; i++){
			contiguousSum += array[i];
			System.out.print(array[i] + " ");
		}
		int index = 0;
		System.out.println();
		System.out.println(contiguousSum);
		for(int i = n; i < array.length; i++){
			
			contiguousSum -= array[index];
			contiguousSum += array[i];
			System.out.println(array[i] + " " + contiguousSum);
			index++;
		}
	}
	
	
	public static void main(String[] args){
		ArrayQuestions q = new ArrayQuestions();
		q.init();
		q.findKthNumberOfElements(3);
		
	}
}
