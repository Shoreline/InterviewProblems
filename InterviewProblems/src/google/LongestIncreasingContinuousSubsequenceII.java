package google;

/**
 * (滑雪问题）
 * 
 * Give you an integer matrix (with row size n, column size m)，find the longest
 * increasing continuous subsequence in this matrix. (The definition of the
 * longest increasing continuous subsequence here can start at any row or column
 * and go up/down/right/left any direction).
 *
 * Example Given a matrix:
 * 
 * [ [1 ,2 ,3 ,4 ,5],
 * 
 * [16,17,24,23,6],
 * 
 * [15,18,25,22,7],
 * 
 * [14,19,20,21,8],
 * 
 * [13,12,11,10,9] ]
 * 
 * return 25
 * 
 * Challenge O(nm) time and memory.
 */

/*
 * The increasing continuous subsequence is at least 1
 * 
 * dp[i][j] = max( dp[neighbor] ) + 1 | condition: input[neighbor]>input[i][j]
 */
public class LongestIncreasingContinuousSubsequenceII {
    public class Solution {
	public int longestIncreasingContinuousSubsequenceII(int[][] A) {
	    int res = 0;
	    if (A == null || A.length == 0 || A[0].length == 0) {
		return res;
	    }
	    
	    int[][] dp = new int[A.length][A[0].length];
	    for (int i = 0; i < A.length; i++) {
		for (int j = 0; j < A[0].length; j++) {
		    if (dp[i][j] == 0) {
			res = Math.max(res, dfs(A, dp, i, j));
		    }
		}
	    }
	    return res;
	}

	private int dfs(int[][] input, int[][] dp, int i, int j) {
	    if (dp[i][j] != 0) {
		return dp[i][j];
	    }
	    int left = 0, right = 0, up = 0, down = 0;
	    if (j + 1 < input[0].length && input[i][j + 1] > input[i][j]) {
		right = dfs(input, dp, i, j + 1);
	    }
	    if (j > 0 && input[i][j - 1] > input[i][j]) {
		left = dfs(input, dp, i, j - 1);
	    }
	    if (i + 1 < input.length && input[i + 1][j] > input[i][j]) {
		down = dfs(input, dp, i + 1, j);
	    }
	    if (i > 0 && input[i - 1][j] > input[i][j]) {
		up = dfs(input, dp, i - 1, j);
	    }
	    dp[i][j] = Math.max(Math.max(up, down), Math.max(left, right))
		    + 1;
	    return dp[i][j];
	}
    }
}
