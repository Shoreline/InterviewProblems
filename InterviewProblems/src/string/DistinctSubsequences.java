package string;

/**
 * Distinct Subsequences
 * 
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"; Return 3.
 */

public class DistinctSubsequences {
    /*
     * DP
     * 
     * dp[i][j]: distinct subsequences of the first i characters in S and first
     * j characters in T. i, j can be 0.
     * 
     * The index of the i-th char in S is i-1. Similar for j-th char in T
     * 
     * if S.charAt(i-1)!=T.charAt(j-1): dp[i][j] = dp[i-1][j] The i-th char of S
     * has no effect in this case, even if it may match other char in T before
     * the j-th char
     * 
     * otherwise, dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] (two cases: let
     * S.charAt(i) match T.charAt(j) or not)
     */
    public class Solution {
	public int numDistinct(String s, String t) {
	    if (s == null || t == null || s.length() < t.length()) {
		return 0;
	    }

	    int[][] dp = new int[s.length() + 1][t.length() + 1];

	    for (int i = 0; i <= s.length(); i++) {
		for (int j = 0; j <= t.length(); j++) {
		    if (i == 0 && j == 0) {
			dp[i][j] = 1;
		    } else if (i == 0) {
			dp[i][j] = 0;
		    } else if (j == 0) {
			dp[i][j] = 1;
		    } else {
			if (s.charAt(i - 1) == t.charAt(j - 1)) {
			    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
			} else {
			    dp[i][j] = dp[i - 1][j];
			}

		    }
		}
	    }
	    return dp[s.length()][t.length()];
	}
    }

    /*
     * rolling array
     */
    class Solution_optimized {
	public int numDistinct(String S, String T) {
	    if (T.length() == 0) {
		return 1;
	    }
	    if (S.length() == 0)
		return 0;
	    int[] res = new int[T.length() + 1];
	    res[0] = 1;
	    for (int i = 0; i < S.length(); i++) {
		for (int j = T.length() - 1; j >= 0; j--) {
		    res[j + 1] = (S.charAt(i) == T.charAt(j) ? res[j] : 0)
			    + res[j + 1];
		}
	    }
	    return res[T.length()];
	}
    }
}
