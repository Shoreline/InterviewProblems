package linkedin;

/**
 * Find the size of longest palindrome subset of an array
 * 
 * Given a sequence, find the length of the longest palindromic subsequence in
 * it. For example, if the given sequence is “BBABCBCAB”, then the output should
 * be 7 as “BABCBAB” is the longest palindromic subseuqnce in it. “BBBBB” and
 * “BBCBB” are also palindromic subsequences of the given sequence, but not the
 * longest ones.
 *
 */

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-
 * subsequence/
 * 
 * dp[i][j] the LPS size of [s[i],...,s[j]] (str.substring(i,j+1))
 * 
 * dp[i][j] =
 * 
 * 1) dp[i+1][j-1] + 2 | if s[i] == s[j];
 * 
 * 2) Math.max( dp[i+1][j], dp[i][j-1] ) | if s[i] != s[j]
 * 
 * *note: the lower diagonal values of table are useless and not filled
 * 
 * 
 * Another thought: get the LCS of str and str_reversed
 */
public class LongestPalindromicSubsequence {
    class Method {
	int getLPSsize(String str) {
	    if (str == null || str.length() == 0) {
		return 0;
	    }
	    int[][] dp = new int[str.length()][str.length()];

	    // similar dp as isPalindrome
	    for (int i = str.length() - 1; i >= 0; i--) {
		for (int j = i; j < str.length(); j++) {
		    if (i == j) {
			dp[i][j] = 1;
		    } else if (str.charAt(i) == str.charAt(j)) {
			/*
			 * if j-i==1, dp[i+1][j-1]==0, because the lower
			 * diagonal of dp[][] are always empty
			 */
			dp[i][j] = 2 + dp[i + 1][j - 1];
		    } else {
			dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
		    }
		}
	    }
	    return dp[0][str.length() - 1];
	}
    }

}
