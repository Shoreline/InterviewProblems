package array;

public class MinimumPathSum {
    /**
     * Minimum Path Sum
     * 
     * Given a m x n grid filled with non-negative numbers, find a path from top
     * left to bottom right which minimizes the sum of all numbers along its
     * path.
     * 
     * Note: You can only move either down or right at any point in time.
     */

    /*
     * classic DP, top-down
     */

    /*
     * solved in-place. But original data in grid is lost
     */
    class Solution_DP_InPlace {
	public int minPathSum(int[][] grid) {
	    if (grid == null || grid.length == 0 || grid[0].length == 0)
		return 0;

	    // Initialization
	    for (int i = 1; i < grid[0].length; i++) {
		grid[0][i] = grid[0][i] + grid[0][i - 1];
	    }

	    // filling the DP table
	    for (int i = 1; i < grid.length; i++) {

		grid[i][0] = grid[i][0] + grid[i - 1][0];

		for (int j = 1; j < grid[0].length; j++) {

		    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1])
			    + grid[i][j];
		}
	    }

	    return grid[grid.length - 1][grid[0].length - 1];
	}
    }

    // 2D Top down DP; using 1D rolling array
    class Solution_DP_RollingArray {
	public int minPathSum(int[][] grid) {
	    if (grid == null || grid.length == 0 || grid[0].length == 0)
		return 0;

	    int[] dp = new int[grid[0].length];

	    // Initialization
	    dp[0] = grid[0][0];
	    for (int i = 1; i < grid[0].length; i++) {
		dp[i] = grid[0][i] + dp[i - 1];
	    }

	    // filling the DP table
	    for (int i = 1; i < grid.length; i++) {
		dp[0] = dp[0] + grid[i][0]; // avoid if-else in next for loop
		for (int j = 1; j < grid[0].length; j++) {
		    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
		}
	    }
	    return dp[dp.length - 1];
	}
    }
}
