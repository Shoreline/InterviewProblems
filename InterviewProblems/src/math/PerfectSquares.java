package math;

import java.util.Arrays;

/**
 * Perfect Squares
 * 
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 *
 */

/*
 * http://bookshadow.com/weblog/2015/09/09/leetcode-perfect-squares/
 */
public class PerfectSquares {
    /*
     * there is a O(sqrtN) solution based on number theory
     */

    /*
     * Time: O(n * sqrt n); space: O(N)
     * 
     * dp[i]: the minimum number of perfect square numbers which sum to i
     */
    public class Solution_DP {
	public int numSquares(int n) {
	    int[] dp = new int[n + 1];
	    Arrays.fill(dp, Integer.MAX_VALUE); // shall let dp[i]=i

	    // in case of overflow, do not use i*i <= n
	    for (int i = 1; i <= n / i; i++) {
		dp[i * i] = 1;
	    }

	    for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= (n - i) / j; j++) {
		    dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
		}
	    }

	    return dp[n];
	}
    }

    /*
     * TLE for n = 9990
     */
    public class Wrong2 {
	public int numSquares(int n) {
	    int[] dp = new int[n + 1];
	    Arrays.fill(dp, Integer.MAX_VALUE);

	    for (int i = 1; i <= n / i; i++) {
		dp[i * i] = 1;
	    }

	    for (int i = 2; i <= n; i++) {
		for (int j = 1; j < i; j++) {
		    dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
		}
	    }

	    return dp[n];
	}
    }

    /*
     * Cannot be solved by greedy method
     */
    public class Wrong {
	public int numSquares(int n) {
	    if (n <= 0) {
		return 0;
	    }
	    if (n == 1) {
		return 1;
	    }

	    int max = 1;
	    while ((max + 1) <= n / (max + 1)) {
		max++;
	    }

	    int res = 0;
	    while (n > 0) {
		res += n / (max * max);
		n %= (max * max);
		max--;
	    }

	    return res;
	}
    }
}
