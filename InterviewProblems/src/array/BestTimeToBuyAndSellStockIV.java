package array;

/**
 * Best Time to Buy and Sell Stock IV
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 *
 */

/*
 * Optimization: if k > prices.length/2, then it is guaranteed that we can reach
 * the maximum profit. (The number of transactions needed is the largest while
 * the prices are up,down,up,down,up,down,....Which still just need at most
 * prices.length/2 +1transactions)
 */
public class BestTimeToBuyAndSellStockIV {
    /*
     * also work??
     */
    public class Solution1d {
	public int maxProfit(int k, int[] prices) {
	    if (prices == null || prices.length < 2) {
		return 0;
	    }

	    if (k > prices.length / 2) {
		int res = 0;
		for (int i = 1; i < prices.length; i++) {
		    res += Math.max(prices[i] - prices[i - 1], 0);
		}
		return res;
	    }

	    int[] local = new int[k + 1];
	    int[] global = new int[k + 1];
	    for (int i = 0; i < prices.length - 1; i++) {
		int diff = prices[i + 1] - prices[i];
		for (int j = k; j >= 1; j--) {
		    local[j] = Math.max(global[j - 1] + diff, local[j] + diff);
		    global[j] = Math.max(local[j], global[j]);
		}
	    }
	    return global[k];
	}
    }

    public class Solution {
	public int maxProfit(int k, int[] prices) {
	    if (prices == null || prices.length < 2) {
		return 0;
	    }

	    if (k > prices.length / 2) {
		int res = 0;
		for (int i = 1; i < prices.length; i++) {
		    res += Math.max(prices[i] - prices[i - 1], 0);
		}
		return res;
	    }

	    int[] local = new int[k + 1];
	    int[] global = new int[k + 1];
	    for (int i = 0; i < prices.length - 1; i++) {
		int diff = prices[i + 1] - prices[i];
		for (int j = k; j >= 1; j--) {
		    local[j] = Math.max(global[j - 1] + (diff > 0 ? diff : 0), local[j] + diff);
		    global[j] = Math.max(local[j], global[j]);
		}
	    }
	    return global[k];
	}
    }

    /*
     * 2D DP
     * 
     * Same thought as III. Optimized cases when k is too large.
     */
    public class Solution_2 {
	public int maxProfit(int k, int[] prices) {
	    if (prices == null || prices.length < 2) {
		return 0;
	    }

	    if (k > prices.length / 2) {
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
		    int diff = prices[i] - prices[i - 1];
		    profit = diff > 0 ? profit + diff : profit;
		}
		return profit;
	    }

	    int[][] global = new int[prices.length][k + 1];
	    int[][] local = new int[prices.length][k + 1];

	    for (int i = 1; i < prices.length; i++) {
		int diff = prices[i] - prices[i - 1];
		for (int j = 1; j <= k; j++) {
		    local[i][j] = Math.max(local[i - 1][j] + diff, global[i - 1][j - 1] + Math.max(diff, 0));
		    global[i][j] = Math.max(global[i - 1][j], local[i][j]);
		}
	    }

	    return global[prices.length - 1][k];
	}
    }
}
