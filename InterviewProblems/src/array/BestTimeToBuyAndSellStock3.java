package array;

public class BestTimeToBuyAndSellStock3 {
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

    /*
     * O(n*n)
     * 
     * For every day, compute: 1) the best transaction before this day and 2)
     * the best transaction after this day
     */

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

    // first round solution
    public static int maxProfitB(int[] prices) {
	if (prices.length < 2) {
	    return 0;
	}

	int maxProfit = 0;
	int minPrice = prices[0];

	int[] Max1 = new int[prices.length];
	for (int i = 0; i < prices.length; i++) {
	    if (prices[i] - minPrice > maxProfit) {
		maxProfit = prices[i] - minPrice;
	    }

	    if (prices[i] < minPrice) {
		minPrice = prices[i];
	    }
	    Max1[i] = maxProfit;
	}

	int[] Max2 = new int[prices.length];
	maxProfit = 0;
	int maxPrice = prices[prices.length - 1];

	for (int i = prices.length - 1; i >= 0; i--) {
	    if (maxPrice - prices[i] > maxProfit) {
		maxProfit = maxPrice - prices[i];
	    }

	    if (maxPrice < prices[i]) {
		maxPrice = prices[i];
	    }
	    Max2[i] = maxProfit;
	}

	maxProfit = 0;
	for (int i = 0; i < prices.length; i++) {
	    System.out.println(Max1[i] + " " + Max2[i]);
	    if (Max1[i] + Max2[i] > maxProfit) {
		maxProfit = Max1[i] + Max2[i];
	    }
	}

	return maxProfit;
    }

}
