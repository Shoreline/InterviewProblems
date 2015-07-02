package array;

/**
 * Remove Duplicates from Sorted Array
 * 
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2].
 */

/*
 * Move all unique elements to the left part of array
 */
public class RemoveDuplicatesFromSortedArray {
    public class Solution {
	public int removeDuplicates(int[] nums) {
	    if (nums == null || nums.length == 0) {
		return 0;
	    }
	    int len = 1;
	    for (int i = 1; i < nums.length; i++) {
		if (nums[i] != nums[i - 1]) {
		    nums[len] = nums[i];
		    len++;
		}
	    }

	    return len;
	}
    }
}
