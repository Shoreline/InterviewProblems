package array;

/**
 * Maximum Product Subarray
 * 
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 *
 */

/*
 * Remember to handle [ -2, 3, -4]
 */
public class MaximumProductSubarray {
    public class Solution {
	public int maxProduct(int[] nums) {
	    if (nums == null || nums.length == 0) {
		return Integer.MIN_VALUE;
	    }

	    int[] dp1 = new int[nums.length]; // local max
	    int[] dp2 = new int[nums.length]; // local min
	    int max = nums[0];
	    dp1[0] = nums[0];
	    dp2[0] = nums[0];

	    for (int i = 1; i < nums.length; i++) {
		dp1[i] = Math.max(nums[i],
			Math.max(dp1[i - 1] * nums[i], dp2[i - 1] * nums[i]));
		dp2[i] = Math.min(nums[i],
			Math.min(dp1[i - 1] * nums[i], dp2[i - 1] * nums[i]));

		max = Math.max(max, dp1[i]);
	    }

	    return max;
	}
    }
}
