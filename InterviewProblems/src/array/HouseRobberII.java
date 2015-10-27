package array;

/**
 * House Robber II
 * 
 * Note: This is an extension of House Robber.
 * 
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This time,
 * all houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, the security system for these
 * houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 */
/*
 * Circular array
 * 
 * Similar to house robber I, can reuse its code.
 * 
 * Just consider the larger loot for two cases: (not strictly separated)
 * 
 * 1) allow to rob the first house -> not allow to rob the last house;
 * 
 * 2) not allow to rob the first house -> allow to rob the last house
 * 
 */
public class HouseRobberII {
    public class Solution {
	public int rob(int[] nums) {
	    if (nums == null || nums.length == 0) {
		return 0;
	    } else if (nums.length < 2) {
		return nums[0];
	    }

	    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}

	private int rob(int[] nums, int start, int end) {
	    int cur = 0;
	    int pre = 0;

	    for (int i = start; i <= end; i++) {
		int tmp = cur;
		cur = Math.max(cur, pre + nums[i]);
		pre = tmp;
	    }

	    return cur;
	}
    }

    public class Solution_2D_DP {
	public int rob(int[] nums) {
	    if (nums == null || nums.length == 0) {
		return 0;
	    } else if (nums.length < 2) {
		return nums[0];
	    }

	    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	    // wrong: return
	    // Math.max(rob(nums,0,nums.length-2)+nums[nums.length-1],
	    // rob(nums,1,nums.length-1) + nums[0]);
	}

	private int rob(int[] nums, int start, int end) {
	    if (end - start + 1 < 2) {
		return nums[start];
	    }

	    int[] dp = new int[nums.length];

	    dp[start] = nums[start];
	    dp[start + 1] = Math.max(nums[start], nums[start + 1]);

	    for (int i = start + 2; i <= end; i++) {
		dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
	    }

	    return dp[end];
	}
    }

    /*
     * Here try to split all cases into two categories: surely rob the first
     * house; or surely rob the last house. Which does not cover all situations,
     * like [1,3,1] that we do not want to rob either of them
     */
    public class Wrong_Method {
	public int rob(int[] nums) {
	    if (nums == null || nums.length == 0) {
		return 0;
	    } else if (nums.length == 1) {
		return nums[0];
	    }

	    int max = nums[0];
	    int prepreMax = nums[0];
	    int preMax = 0;
	    for (int i = 2; i < nums.length - 1; i++) {
		int curMax = Math.max(preMax, prepreMax + nums[i]);
		max = Math.max(max, curMax);
		prepreMax = preMax;
		preMax = curMax;
	    }

	    max = Math.max(max, nums[nums.length - 1]);
	    prepreMax = nums[nums.length - 1];
	    preMax = 0;
	    for (int i = 1; i < nums.length - 2; i++) {
		int curMax = Math.max(preMax, prepreMax + nums[i]);
		max = Math.max(max, curMax);
		prepreMax = preMax;
		preMax = curMax;
	    }

	    return max;
	}
    }
}
