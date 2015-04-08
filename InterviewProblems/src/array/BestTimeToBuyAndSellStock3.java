package array;

/**
 * Best Time to Buy and Sell Stock III
 * 
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most
 * two transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie,
 * you must sell the stock before you buy again).
 */

public class BestTimeToBuyAndSellStock3 {

    /*
     * DP, time O(kN), space O(2kN)
     * 
     * Can reduce space to O(2N) 
     * 
     * global[i][j]: the maximum profit after day i and j transactions
     * local[i][j]:  the maximum profit after day i and j transactions. Particularly, the j-th sell must happen on day i.
     * 
     * A transaction can be to buy and sell on the same day -> profit is 0
     * 
     * Initialization:
     * global[0][j] = 0: after the 0-th day, profit always 0 (all buys and sells happen on the same day)
     * global[i][0] = 0: obviously, with 0 transaction the profit will always be 0
     * Same for local[][].
     * 
     * global[i][j] = Math.max( global[i-1][j], local[i][j] )
     * Two possible situations: ( these situations may have overlap, which is fine. As long as they can cover all possible cases)
     * 1) the last sell is not finished on day i: global[i-1][j]
     * 2) the last sell is finished on day i: local[i][j]
     * 
     * local[i][j] = Math.max( global[i-1][j-1] + Math.max(dailyDiff,0), local[i-1][j] + dailyDiff )
     * Two possible situations:
     * 1) The j-th buy happens on or before day i-1: local[i-1][j] + dailyDiff
     * Since local[i][j] must sell on day j, so we have to extend the j-th sell of local[i-1][j] and include dailyDiff. No matter dailyDiff is positive or negative
     * 
     * 2) The j-th buy happens on or after day i-1: global[i-1][j-1] + Math.max(dailyDiff,0)
     * If dailyDiff is negative, we can choose to both buy and sell on day j 
     * 
     */
    public class Solution_N {
	public int maxProfit(int[] prices) {
	    if (prices == null || prices.length < 2) {
		return 0;
	    }

	    int k = 2;
	    int[][] global = new int[prices.length][k + 1];
	    int[][] local = new int[prices.length][k + 1];

	    for (int i = 1; i < prices.length; i++) {
		int dailyDiff = prices[i] - prices[i - 1];
		for (int j = 1; j <= k; j++) {
		    local[i][j] = Math.max(
			    global[i - 1][j - 1] + Math.max(dailyDiff, 0),
			    local[i - 1][j] + dailyDiff);
		    global[i][j] = Math.max(local[i][j], global[i - 1][j]);
		}
	    }

	    return global[global.length - 1][k];
	}
    }

    /*
     * O(n*n)
     * 
     * For every day, compute: 1) the best transaction before this day and 2)
     * the best transaction after this day
     */
    class Solution_N2 {
	public int maxProfit(int[] prices) {
	    // Start typing your Java solution below
	    // DO NOT write main() function
	    if (prices == null || prices.length < 2)
		return 0;

	    int[] profits1 = new int[prices.length];
	    int[] profits2 = new int[prices.length];

	    int curLow = Integer.MAX_VALUE;
	    int maxProfit1 = 0;
	    for (int i = 0; i < prices.length; i++) {
		curLow = Math.min(curLow, prices[i]);
		int profit1 = prices[i] - curLow;
		maxProfit1 = Math.max(maxProfit1, profit1);
		profits1[i] = maxProfit1;
	    }

	    int curHigh = Integer.MIN_VALUE;
	    int maxProfit2 = 0;
	    for (int i = prices.length - 1; i >= 0; i--) {
		curHigh = Math.max(curHigh, prices[i]);
		int profit2 = curHigh - prices[i];
		maxProfit2 = Math.max(profit2, maxProfit2);
		profits2[i] = maxProfit2;
	    }

	    int maxProfit = 0;
	    for (int i = 0; i < prices.length; i++) {
		/*
		 * for profits2, i start from large to small: so still plus
		 * profits2[i], not profits[prices.length-1-i]
		 */
		int profit = profits1[i] + profits2[i];
		maxProfit = Math.max(profit, maxProfit);
	    }

	    return maxProfit;
	}
    }
}
