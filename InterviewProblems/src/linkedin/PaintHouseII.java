package linkedin;

/**
 * Paint Hourse II
 * 
 * There are a row of n houses, each house can be painted with one of the k
 * colors. The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the
 * same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x
 * k cost matrix. For example, costs[0][0] is the cost of painting house 0 with
 * color 0; costs[1][2] is the cost of painting house 1 with color 2, and so
 * on... Find the minimum cost to paint all houses.
 * 
 * Note: All costs are positive integers.
 * 
 * Follow up: Could you solve it in O(nk) runtime?
 *
 */
public class PaintHouseII {
    /*
     * O(nk) time, O(k) space
     * 
     * min and secondMin are two smallest values. Be noticed that min may equal
     * to secondMin.
     */
    public class Solution_DP2 {
	public int minCostII(int[][] costs) {
	    if (costs == null || costs.length == 0 || costs[0].length == 0) {
		return 0;
	    }

	    int[] dp = new int[costs[0].length]; // dp[num of colors]
	    int preMin = Integer.MAX_VALUE;
	    int pre2ndMin = Integer.MAX_VALUE;

	    for (int i = 0; i < costs.length; i++) {
		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;

		for (int j = 0; j < costs[0].length; j++) {
		    if (i == 0) {
			dp[j] = costs[i][j];
		    } else {
			dp[j] = costs[i][j] + (dp[j] == preMin ? pre2ndMin : preMin);
		    }

		    if (dp[j] <= secondMin) {
			int tmp = min;
			min = Math.min(min, dp[j]);
			secondMin = Math.max(tmp, dp[j]);
		    }
		}

		preMin = min;
		pre2ndMin = secondMin;
	    }

	    int res = Integer.MAX_VALUE;
	    for (int totalCost : dp) {
		res = Math.min(res, totalCost);
	    }
	    return res;
	}
    }

    /*
     * O(2nk) time, o(nk) space
     */
    public class Solution_DP1 {
	public int minCostII(int[][] costs) {
	    if (costs == null || costs.length == 0 || costs[0].length == 0) {
		return 0;
	    }
	    int[][] dp = new int[costs.length][costs[0].length];

	    for (int i = 0; i < costs.length; i++) {
		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		if (i > 0) {
		    for (int j = 0; j < costs[0].length; j++) {
			if (dp[i - 1][j] <= secondMin) {
			    int tmp = min;
			    min = Math.min(min, dp[i - 1][j]);
			    secondMin = Math.max(tmp, dp[i - 1][j]);
			}
		    }
		}

		for (int j = 0; j < costs[0].length; j++) {
		    if (i == 0) {
			dp[i][j] = costs[i][j];
		    } else {
			dp[i][j] = costs[i][j] + (dp[i - 1][j] == min ? secondMin : min);
		    }
		}
	    }

	    int res = Integer.MAX_VALUE;
	    for (int totalCost : dp[dp.length - 1]) {
		res = Math.min(res, totalCost);
	    }
	    return res;
	}
    }

    /*
     * reuse costs array, O(1) space, O(nk) time
     */
    class Solution_DP3 {
	public int minCostII(int[][] costs) {
	    if (costs == null || costs.length == 0)
		return 0;

	    int n = costs.length, k = costs[0].length;
	    // min1 is the index of the 1st-smallest cost till previous house
	    // min2 is the index of the 2nd-smallest cost till previous house
	    int min1 = -1, min2 = -1;

	    for (int i = 0; i < n; i++) {
		int last1 = min1, last2 = min2;
		min1 = -1;
		min2 = -1;

		for (int j = 0; j < k; j++) {
		    if (j != last1) {
			// current color j is different to last min1
			costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
		    } else {
			costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
		    }

		    // find the indices of 1st and 2nd smallest cost of painting
		    // current house i
		    if (min1 < 0 || costs[i][j] < costs[i][min1]) {
			min2 = min1;
			min1 = j;
		    } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
			min2 = j;
		    }
		}
	    }

	    return costs[n - 1][min1];
	}
    }
}
