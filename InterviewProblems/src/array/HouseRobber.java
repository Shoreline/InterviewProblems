package array;

/**
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
     * DP
     * 
     */
    public class Solution {
	public int rob(int[] num) {
	    if (num == null || num.length == 0) {
		return 0;
	    } else if (num.length < 2) {
		return num[0];
	    }

	    int[] dp = new int[num.length];
	    dp[0] = num[0];
	    dp[1] = Math.max(dp[0], num[1]);

	    for (int i = 2; i < num.length; i++) {
		dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i]);
	    }

	    return dp[dp.length - 1];
	}
    }
}
