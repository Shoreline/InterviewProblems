package array;

/**
 * Unique Paths II
 * 
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
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

/*
 * Be careful of the initialization
 */
public class UniquePathsII {
    public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	    if (obstacleGrid == null || obstacleGrid.length == 0
		    || obstacleGrid[0].length == 0) {
		return 0;
	    }

	    int[] dp = new int[obstacleGrid[0].length];
	    for (int i = 0; i < obstacleGrid.length; i++) {
		for (int j = 0; j < obstacleGrid[0].length; j++) {
		    if (obstacleGrid[i][j] == 1) {
			dp[j] = 0;
		    } else if (i == 0 && j == 0) {
			dp[j] = 1;
		    }
		    // else if(i ==0){
		    // dp[j]=dp[j-1];
		    // }
		    else if (j == 0) {
			dp[j] = dp[j];
		    } else {
			dp[j] = dp[j] + dp[j - 1];
		    }

		}
	    }

	    return dp[dp.length - 1];
	}
    }

    public class Solution2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	    if (obstacleGrid == null || obstacleGrid.length < 1
		    || obstacleGrid[0].length < 1) {
		return 0;
	    }

	    int[] dp = new int[obstacleGrid[0].length];
	    dp[0] = (obstacleGrid[0][0] == 1 ? 0 : 1);
	    for (int i = 1; i < dp.length; i++) {
		// if!=0 must use dp[i-1], not 1!
		dp[i] = (obstacleGrid[0][i] == 1 ? 0 : dp[i - 1]);
	    }

	    for (int i = 1; i < obstacleGrid.length; i++) {
		// if!=0 must use dp[0], not 1!
		dp[0] = (obstacleGrid[i][0] == 1 ? 0 : dp[0]);
		for (int j = 1; j < obstacleGrid[0].length; j++) {
		    dp[j] = (obstacleGrid[i][j] == 1 ? 0 : dp[j] + dp[j - 1]);
		}
	    }
	    return dp[dp.length - 1];
	}
    }

    public class Solution_Bad {
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
}
