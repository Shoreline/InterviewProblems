package array;

public class BestTimeToBuyAndSellStock2 {
    /**
     * Best Time to Buy and Sell Stock II
     * 
     * Say you have an array for which the ith element is the price of a given
     * stock on day i.
     * 
     * Design an algorithm to find the maximum profit. You may complete as many
     * transactions as you like (ie, buy one and sell one share of the stock
     * multiple times). However, you may not engage in multiple transactions at
     * the same time (ie, you must sell the stock before you buy again).
     */

    /*
     * No need to mimic buy/sell behaviors: 从头到尾扫描prices，如果i比i-1大，那么price[i] –
     * price[i-1]就可以计入最后的收益中。这样扫描一次O(n)就可以获得最大收益了。
     */
    public int maxProfit(int[] prices) {
	// Start typing your Java solution below
	// DO NOT write main() function
	if (prices == null || prices.length < 2)
	    return 0;

	int profitSum = 0;

	for (int i = 1; i < prices.length; i++) {
	    int delta = prices[i] - prices[i - 1];

	    if (delta > 0) {
		profitSum += delta;
	    }
	}
	return profitSum;
    }

    /*
     * The solution below detects the pattern of profitable transaction
     * 
     * If we are asked to give minimum number of transactions, this shall be
     * useful
     */
    public static int maxProfitB(int[] prices) {
	if (prices == null || prices.length < 2) {
	    return 0;
	}

	int maxProfit = 0;
	int buyTime = -1;

	for (int i = 0; i < prices.length; i++) {
	    if (i == prices.length - 1) {
		if (buyTime >= 0) {
		    maxProfit += (prices[i] - prices[buyTime]);
		}
		break;
	    }

	    if (prices[i] > prices[i + 1] && buyTime >= 0) {
		maxProfit += (prices[i] - prices[buyTime]);
		buyTime = -1;
	    } else if (prices[i] < prices[i + 1]) {
		if (buyTime < 0) {
		    buyTime = i;
		}
	    }
	}

	return maxProfit;
    }

}
