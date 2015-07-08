package array;

/**
 * House Robber
 * 
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 */

public class HouseRobber {
    /*
     * DP. Reduced 1D DP array to two variables
     */
    public class Solution {
	public int rob(int[] nums) {
	    if (nums == null || nums.length == 0) {
		return 0;
	    }

	    int max = nums[0];
	    int pre = 0;
	    int prepre = 0;

	    for (int i = 0; i < nums.length; i++) {
		int cur = Math.max(nums[i] + prepre, pre);
		max = Math.max(max, cur);
		prepre = pre;
		pre = cur;
	    }

	    return max;
	}
    }
}
