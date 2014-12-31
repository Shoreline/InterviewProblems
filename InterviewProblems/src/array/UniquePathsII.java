package array;

public class UniquePathsII {
    /**
     * Unique Paths II
     * 
     * Follow up for "Unique Paths":
     * 
     * Now consider if some obstacles are added to the grids. How many unique
     * paths would there be?
     * 
     * An obstacle and empty space is marked as 1 and 0 respectively in the
     * grid.
     * 
     * For example,
     * 
     * There is one obstacle in the middle of a 3x3 grid as illustrated below. [
     * 
     * [0,0,0],
     * 
     * [0,1,0],
     * 
     * [0,0,0]
     * 
     * ] The total number of unique paths is 2.
     * 
     * Note: m and n will be at most 100.
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	// It is still possible that the starting point has obstacle!
	if (obstacleGrid == null || obstacleGrid.length == 0
		|| obstacleGrid[0][0] == 1)
	    return 0;

	int m = obstacleGrid.length;
	int n = obstacleGrid[0].length;
	int[][] dp = new int[m][n];

	dp[0][0] = 1;

	for (int i = 1; i < m; i++) {
	    if (obstacleGrid[i][0] == 1) {
		dp[i][0] = 0;
		continue;
	    }
	    dp[i][0] = dp[i - 1][0];
	}

	for (int i = 1; i < n; i++) {
	    if (obstacleGrid[0][i] == 1) {
		dp[0][i] = 0;
		continue;
	    }
	    dp[0][i] = dp[0][i - 1];
	}

	for (int i = 1; i < m; i++) {
	    for (int j = 1; j < n; j++) {
		if (obstacleGrid[i][j] == 1) {
		    dp[i][j] = 0;
		    continue;
		}
		dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
	    }
	}

	return dp[m - 1][n - 1];
    }
}
