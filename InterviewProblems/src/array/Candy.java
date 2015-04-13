package array;

/**
 * Candy 
 * 
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. What is the minimum candies you must give?	
 */

/*
 * Two scans from left and right hand side.
 * 
 * Similar to Trap rain water.
 */
public class Candy {
    public class Solution {
	public int candy(int[] ratings) {
	    if (ratings == null || ratings.length == 0) {
		return 0;
	    }

	    int[] minLeftSide = new int[ratings.length];
	    minLeftSide[0] = 1;
	    for (int i = 1; i < ratings.length; i++) {
		minLeftSide[i] = (ratings[i] > ratings[i - 1] ? minLeftSide[i - 1] + 1
			: 1);
	    }

	    int res = 0;

	    int minRightSide = 1;

	    res += Math.max(minLeftSide[ratings.length - 1], 1);

	    for (int i = ratings.length - 2; i >= 0; i--) {
		minRightSide = (ratings[i] > ratings[i + 1] ? minRightSide + 1
			: 1);

		int candys = Math.max(minLeftSide[i], minRightSide);
		res += candys;
	    }

	    return res;
	}
    }
}
