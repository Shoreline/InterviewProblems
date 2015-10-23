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
	    if (prices == null || prices.length == 0) {
		return 0;
	    }

	    int min = prices[0];
	    int profit = 0;
	    for (int i = 1; i < prices.length; i++) {
		min = Math.min(prices[i], min);
		profit = Math.max(prices[i] - min, profit);
	    }

	    return profit;
	}
    }
}
