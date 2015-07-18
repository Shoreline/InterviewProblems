package linkedin;

/**
 * Given a list of houses and the cost of painting each house, the houses can be
 * painted in three colors RED, GREEN and BLUE, two neighboring houses can’t be
 * painted in the same color, calculate the total minimum cost for painting all
 * houses.
 *
 */
/*
 * 1) Dynamic programming problem.
 * 
 * 2)Maintain an 2D array of called min_cost, each column represent a color and
 * each row represent a houses.
 * 
 * 3) min_cost[i][0] represents that, when the i-th house is painted Red, the
 * min cost of 0-th to i-th houses. Thus we have the following:
 * 
 * //since the current color cannot be the same as the previous one
 * 
 * min_cost{i} = min(
 * 
 * cost[i][R] + min(cost{i-1, B}, cost{i-1, G}),
 * 
 * cost[i][B] + min(cost{i-1, R}, cost{i-1, G}),
 * 
 * cost[i][G] + min(cost{i-1, R}, cost{i-1, B}) )
 */
public class PaintHouseWithColor {
    class Solution {
	// cost is a #_of_house x 3 array
	public int minPaintCost(int[][] cost) {
	    if (cost == null || cost.length == 0)
		return 0;
	    int[][] dp = new int[cost.length][3];
	    dp[0][0] = cost[0][0];
	    dp[0][1] = cost[0][1];
	    dp[0][2] = cost[0][2];
	    for (int i = 1; i < cost.length; ++i) {
		dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
		dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
		dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
	    }
	    return Math.min(dp[dp.length - 1][0], Math.min(dp[dp.length - 1][1], dp[dp.length - 1][2]));
	}
    }
}
