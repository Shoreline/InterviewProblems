package array;

import java.util.ArrayList;

public class Triangle {
    /**
     * Triangle
     * 
     * Given a triangle, find the minimum path sum from top to bottom. Each step
     * you may move to adjacent numbers on the row below.
     * 
     * For example, given the following triangle
     * 
     * [ [2], [3,4], [6,5,7], [4,1,8,3] ]
     * 
     * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     * 
     * Note: Bonus point if you are able to do this using only O(n) extra space,
     * where n is the total number of rows in the triangle.
     */

    /*
     * Regular DP, second time pass.
     */
    public int minimumTotalB(ArrayList<ArrayList<Integer>> triangle) {
	if (triangle == null || triangle.size() == 0
		|| triangle.get(0).size() == 0) {
	    return 0;
	}

	int[][] dp = new int[triangle.size()][triangle.size()];

	dp[0][0] = triangle.get(0).get(0);
	// corner case! if the triangle has only one level:
	if (triangle.size() == 1)
	    return dp[0][0];

	int min = Integer.MAX_VALUE;
	for (int i = 1; i < triangle.size(); i++) {
	    for (int j = 0; j <= i; j++) {
		int value = triangle.get(i).get(j);
		if (j == 0) {
		    dp[i][j] = value + dp[i - 1][j];
		} else if (j == i) {
		    dp[i][j] = value + dp[i - 1][j - 1];
		} else {
		    dp[i][j] = value + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
		}

		if (i == triangle.size() - 1) {
		    min = Math.min(min, dp[i][j]);
		}
	    }
	}

	return min;

    }

    /*
     * To use only O(n) space, we need to reuse a 1D array as dp cache
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	if (triangle == null || triangle.size() == 0
		|| triangle.get(0).size() == 0) {
	    return 0;
	}

	int[] dp2 = new int[triangle.size()];

	dp2[0] = triangle.get(0).get(0);
	// corner case! if the triangle has only one level:
	if (triangle.size() == 1)
	    return dp2[0];

	int min = Integer.MAX_VALUE;
	for (int i = 1; i < triangle.size(); i++) {
	    // This time start from the end of each level!
	    for (int j = i; j >= 0; j--) {
		int value = triangle.get(i).get(j);
		if (j == i) {
		    dp2[j] = value + dp2[j - 1];
		} else if (j == 0) {
		    dp2[j] = value + dp2[j];
		} else {
		    dp2[j] = value + Math.min(dp2[j], dp2[j - 1]);
		}

		if (i == triangle.size() - 1) {
		    min = Math.min(dp2[j], min);
		}
	    }
	}

	return min;
    }
}
