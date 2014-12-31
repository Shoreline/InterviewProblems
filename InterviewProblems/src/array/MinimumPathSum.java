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

    // 1D DP
    public int minPathSum3(int[][] grid) {
	if (grid == null || grid.length == 0 || grid[0].length == 0)
	    return 0;

	// Initialization

	int[] dp = new int[grid[0].length];

	dp[0] = grid[0][0];

	for (int i = 1; i < grid[0].length; i++) {
	    dp[i] = grid[0][i] + dp[i - 1];
	}

	// filling the DP table
	for (int i = 1; i < grid.length; i++) {
	    dp[0] = dp[0] + grid[i][0];
	    for (int j = 1; j < grid[0].length; j++) {
		dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
	    }
	}
	return dp[dp.length - 1];
    }

    public int minPathSum2(int[][] grid) {
	if (grid == null || grid.length == 0 || grid[0].length == 0)
	    return 0;

	// Initialization
	int[] column = new int[grid.length];
	int[] row = new int[grid[0].length];

	row[0] = grid[0][0];
	column[0] = grid[0][0];
	for (int i = 1; i < grid.length; i++) {
	    column[i] = grid[i][0] + column[i - 1];
	}
	for (int i = 1; i < grid[0].length; i++) {
	    row[i] = grid[0][i] + row[i - 1];
	}

	// filling the DP table
	for (int i = 1; i < grid.length; i++) {

	    for (int j = 1; j < grid[0].length; j++) {
		// dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
		if (j == 1) {
		    row[j] = Math.min(row[j] + grid[i][j], column[i]
			    + grid[i][j]);
		} else {
		    row[j] = Math.min(row[j] + grid[i][j], row[j - 1]
			    + grid[i][j]);
		}
	    }
	}

	return row[grid[0].length - 1];
    }

    // This solution use O(M*N) space and O(N^2) time
    public int minPathSum1(int[][] grid) {
	if (grid == null || grid.length == 0 || grid[0].length == 0)
	    return 0;

	// Initialization
	int[][] dp = new int[grid.length][grid[0].length];
	dp[0][0] = grid[0][0];
	for (int i = 1; i < grid.length; i++) {
	    dp[i][0] = dp[i - 1][0] + grid[i][0];
	}
	for (int i = 1; i < grid[0].length; i++) {
	    dp[0][i] = dp[0][i - 1] + grid[0][i];
	}

	// filling the DP table
	for (int i = 1; i < grid.length; i++) {
	    for (int j = 1; j < grid[0].length; j++) {
		dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
	    }
	}

	return dp[grid.length - 1][grid[0].length - 1];
    }
}
