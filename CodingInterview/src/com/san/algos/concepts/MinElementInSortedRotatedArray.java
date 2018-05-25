package com.san.algos.concepts;

public class MinElementInSortedRotatedArray {
	 public int findMin(int[] nums, int low, int high) {
	        if(high < low)
	            return nums[0];
	        if(high == low)
	            return nums[low];
	        int mid = (high + low)/2;
	        if(mid > low && nums[mid] < nums[mid-1])
	            return nums[mid];
	        if(mid < high && nums[mid+1] < nums[mid])
	           return nums[mid+1];
	        if(nums[high] > nums[mid]) //left half
	            return findMin(nums, low, mid-1);
	        return findMin(nums, mid+1, high);
	            
	    }
	    public int findMin(int[] nums) {
	        if(nums.length <= 0)
	            return Integer.MAX_VALUE;
	        if(nums.length == 1)
	            return nums[0];
	        if(nums.length == 2){
	            return Math.min(nums[0], nums[1]);
	        }
	        return findMin(nums, 0, nums.length - 1 ); //0, 0 1 element array
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
