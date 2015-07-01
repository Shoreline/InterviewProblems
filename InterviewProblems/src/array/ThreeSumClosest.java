package array;

import java.util.Arrays;

/**
 * 3 Sum Closet
 * 
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 */

/*
 * Very similar to the 3 sum problem.
 */
public class ThreeSumClosest {
    public class Solution {
	public int threeSumClosest(int[] nums, int target) {
	    if (nums == null || nums.length < 3) {
		return Integer.MIN_VALUE;
	    }
	    int res = nums[0] + nums[1] + nums[2];
	    Arrays.sort(nums);
	    for (int i = 0; i < nums.length - 2; i++) {
		int j = i + 1;
		int k = nums.length - 1;
		while (j < k) {
		    int sum = nums[i] + nums[j] + nums[k];
		    if (sum == target) {
			return target;
		    } else if (sum < target) {
			j++;
		    } else {
			k--;
		    }
		    if (Math.abs(target - sum) < Math.abs(target - res)) {
			res = sum;
		    }
		}
	    }

	    return res;
	}
    }
}
