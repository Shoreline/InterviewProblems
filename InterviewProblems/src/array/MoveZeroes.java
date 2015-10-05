package array;

/**
 * Move Zeroes
 * 
 * Total Accepted: 16131 Total Submissions: 38951 Difficulty: Easy
 * 
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
 * should be [1, 3, 12, 0, 0].
 * 
 * Note: You must do this in-place without making a copy of the array. Minimize
 * the total number of operations.
 *
 */
public class MoveZeroes {
    public class Solution {
	public void moveZeroes(int[] nums) {
	    if (nums == null || nums.length == 0) {
		return;
	    }
	    int ptr1 = 0;
	    int ptr2 = 0;
	    while (ptr2 < nums.length) {
		if (nums[ptr2] != 0) {
		    int tmp = nums[ptr2];
		    nums[ptr2] = 0;
		    nums[ptr1] = tmp;
		    ptr1++;
		}
		ptr2++;
	    }
	}
    }
}
