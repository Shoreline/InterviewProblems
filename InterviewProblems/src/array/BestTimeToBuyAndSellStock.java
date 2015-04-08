package array;

/**
 * Best Time to Buy and Sell Stock
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Equivalent to: Find i and j that maximizes Aj �C Ai, where i < j.
 */

public class BestTimeToBuyAndSellStock {
    /*
     * simple. 
     */
    public class Solution {
	public int maxProfit(int[] prices) {
	    if (prices == null || prices.length < 2) {
		return 0;
	    }

	    int res = 0;
	    int preMin = prices[0];

	    for (int i = 1; i < prices.length; i++) {
		res = Math.max(res, prices[i] - preMin);
		preMin = Math.min(preMin, prices[i]);
	    }

	    return res;
	}
    }
}
