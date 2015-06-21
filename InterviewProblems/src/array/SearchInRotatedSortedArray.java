package array;

/**
 * Search In Rotated Sorted Array
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 */

/*
 * idea: In each iteration, identify the sorted half of the remaining part of
 * the array. Then with two simple comparisons (involves target and nums[low],
 * nums[high]) we can know whether the target is in this half
 * 
 * time complexity: O(lgN)
 */

public class SearchInRotatedSortedArray {
    public class Solution {
	public int search(int[] nums, int target) {
	    if (nums == null) {
		return -1;
	    }

	    int low = 0;
	    int high = nums.length - 1;

	    while (low <= high) {
		int mid = (low + high) / 2;

		if (nums[mid] == target)
		    return mid;

		if (nums[mid] >= nums[low]) {
		    // {lowEnd ~ mid} is the sorted half

		    // see if target is in this half
		    if (nums[low] <= target && target < nums[mid]) {
			// target is in this half
			high = mid - 1;
		    } else {
			low = mid + 1;
		    }
		} else {
		    // {mid ~ highEnd} is the sorted half

		    if (nums[mid] < target && target <= nums[high]) {
			low = mid + 1;
		    } else {
			high = mid - 1;
		    }
		}
	    }

	    return -1;
	}
    }
}
