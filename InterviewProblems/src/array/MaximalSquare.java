package array;

/**
 * Maximal Square
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing all 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0
 * 
 * 1 0 1 1 1
 * 
 * 1 1 1 1 1
 * 
 * 1 0 0 1 0
 * 
 * Return 4.
 *
 */

/*
 * DP.
 * 
 * dp[i][j]: the 边长 of the square ends at (i,j).
 * 
 * dp[i][j] = 1 + min( dp[i-1][j], dp[i][j-1], dp[i-1][j-1] )
 * 
 * To save space: use two rolling 1D arrays: use pre[] and cur[].
 */
public class MaximalSquare {
    public class Solution {
	public int maximalSquare(char[][] matrix) {
	    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
		return 0;
	    }

	    int[] dp = new int[matrix[0].length];
	    int max = 0;
	    for (int i = 0; i < matrix.length; i++) {
		int preij = 0; // saves dp[i-1][j-1], if dp is a 2d array
		for (int j = 0; j < matrix[0].length; j++) {
		    int tmp = dp[j];
		    if (matrix[i][j] == '0') {
			dp[j] = 0;
		    } else if (i == 0 || j == 0) {
			dp[j] = 1;
		    } else {
			dp[j] = Math.min(preij, Math.min(dp[j - 1], dp[j])) + 1;
		    }
		    preij = tmp;
		    max = Math.max(max, dp[j]);
		}
	    }

	    return max * max;
	}
    }

    /*
     * straightforward dp using a 2d array
     */
    public class Solution_DP {
	public int maximalSquare(char[][] matrix) {
	    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
		return 0;
	    }
	    int[][] dp = new int[matrix.length][matrix[0].length];
	    int max = 0;
	    for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
		    if (matrix[i][j] == '0') {
			dp[i][j] = 0;
		    } else {
			dp[i][j] = 1 + Math.min(i > 0 && j > 0 ? dp[i - 1][j - 1] : 0,
				Math.min(i > 0 ? dp[i - 1][j] : 0, j > 0 ? dp[i][j - 1] : 0));
		    }

		    max = Math.max(max, dp[i][j]);
		}
	    }

	    return max * max;
	}
    }

    public class Solution_DP2 {
	public int maximalSquare(char[][] matrix) {
	    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
		return 0;
	    }

	    int[] pre = new int[matrix[0].length];
	    int max = 0;

	    for (int i = 0; i < matrix.length; i++) {

		int[] cur = new int[matrix[0].length];

		for (int j = 0; j < matrix[0].length; j++) {

		    if (matrix[i][j] == '0') {
			cur[j] = 0;
		    } else {
			if (j == 0) {
			    cur[j] = 1;
			} else {
			    cur[j] = 1 + Math.min(Math.min(pre[j], pre[j - 1]), cur[j - 1]);
			}
		    }

		    max = Math.max(max, cur[j] * cur[j]);
		}

		pre = cur;
	    }

	    return max;
	}

    }
}
