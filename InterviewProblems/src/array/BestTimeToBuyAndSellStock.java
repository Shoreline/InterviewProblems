package array;

public class BestTimeToBuyAndSellStock {
    /**
     * Best Time to Buy and Sell Stock
     * 
     * Say you have an array for which the ith element is the price of a given
     * stock on day i.
     * 
     * If you were only permitted to complete at most one transaction (ie, buy
     * one and sell one share of the stock), design an algorithm to find the
     * maximum profit.
     * 
     * Equivalent to: Find i and j that maximizes Aj ¨C Ai, where i < j.
     */
    /*
     * Second round: one time pass
     */

    public static int maxProfit(int[] prices) {
	if (prices == null || prices.length < 2) {
	    return 0;
	}

	int maxProfit = Integer.MIN_VALUE;
	int curMinPrice = Integer.MAX_VALUE;

	for (int i = 0; i < prices.length; i++) {
	    if (prices[i] < curMinPrice) {
		curMinPrice = prices[i];
	    }

	    int profit = prices[i] - curMinPrice;

	    if (profit > maxProfit) {
		maxProfit = profit;
	    }

	}

	return maxProfit;
    }
}
