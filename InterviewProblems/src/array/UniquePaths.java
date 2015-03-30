package array;

public class UniquePaths {
    /**
     * Unique Paths
     * 
     * A robot is located at the top-left corner of a m x n grid (marked 'Start'
     * in the diagram below).
     * 
     * The robot can only move either down or right at any point in time. The
     * robot is trying to reach the bottom-right corner of the grid (marked
     * 'Finish' in the diagram below).
     * 
     * How many possible unique paths are there?
     * 
     * Note: m and n will be at most 100.
     */
    /*
     * rolling array to cache DP status
     */
    public class Solution_DP {
	public int uniquePaths(int m, int n) {
	    if (m <= 0 || n <= 0) {
		return 0;
	    }

	    int[] dp = new int[n];
	    for (int i = 0; i < n; i++) {
		dp[i] = 1;
	    }

	    for (int i = 1; i < m; i++) {
		dp[0] = 1;
		for (int j = 1; j < n; j++) {
		    dp[j] = dp[j] + dp[j - 1];
		}
	    }

	    return dp[dp.length - 1];
	}
    }

    /*
     * This solution uses too much space
     */
    class Solution_DP_Bad {
	public int uniquePaths(int m, int n) {
	    if (m <= 0 || n <= 0) {
		return 0;
	    }
	    int[][] dp = new int[m][n];

	    for (int i = 0; i < m; i++)
		dp[i][0] = 1;
	    for (int i = 0; i < n; i++)
		dp[0][i] = 1;

	    for (int i = 1; i < m; i++) {
		for (int j = 1; j < n; j++) {
		    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
		}
	    }

	    return dp[m - 1][n - 1];
	}
    }
}
