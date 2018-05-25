package com.san.algos.concepts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class QuickSort {

    public static int[] getLeft(int[] array, int pivot){
        List<Integer> left = new ArrayList<Integer>();
        
        for(int i = 0; i < array.length; i++){
            if(array[i] < pivot)
            {
                left.add(array[i]);
            }
        }
        int[] leftArray = new int[left.size()];
        
        Iterator iterator = left.iterator();
        int count = 0;
        while(iterator.hasNext()){
        	leftArray[count++] = (int)iterator.next();
        }
        return leftArray;//ArrayUtils.toPrimitive( left.toArray(leftArray));
    }
    public static int[] getRight(int[] array, int pivot){
        List<Integer> right = new ArrayList<Integer>();
        
        for(int i = 0; i < array.length; i++){
            if(array[i] > pivot)
            {
                right.add(array[i]);
            }
        }
        int[] rightArray = new int[right.size()];
        Iterator iterator = right.iterator();
        int count = 0;
        while(iterator.hasNext()){
        	rightArray[count++] = (int)iterator.next();
        }
        return rightArray;
    }
    public static int[] getEquals(int[] array, int pivot){
        List<Integer> right = new ArrayList<Integer>();
        
        for(int i = 0; i < array.length; i++){
            if(array[i] == pivot)
            {
                right.add(array[i]);
            }
        }
        
        int[] rightArray = new int[right.size()];
        Iterator iterator = right.iterator();
        int count = 0;
        while(iterator.hasNext()){
        	rightArray[count++] = (int)iterator.next();
        }
        return rightArray;
    }
    public static int[] quicksort(int[] array){
        if(array.length == 1)
            return array;
        else if(array.length > 1){
            int pivot = array[0];
            
            int[] left = getLeft(array, pivot);
            int[] equals = getEquals(array, pivot);
            int[] right = getRight(array, pivot);
            int[] sortedLeft = quicksort(left);
            int[] sortedRight = quicksort(right);
            
            int[] sortedArray = new int[equals.length + sortedLeft.length + sortedRight.length];
            System.out.println(Arrays.toString(sortedArray));
            return sortedArray;
        }    
        return null;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[] array = new int[a];
        for(int i= 0; i < a; i++){
            array[i] = in.nextInt();            
        }               
        int[] sortedArray = quicksort(array);

    }
}