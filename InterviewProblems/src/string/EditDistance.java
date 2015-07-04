package string;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character b) Delete a character c) Replace a character
 */

/*
 * dp[i][j]: the minDistance of the first i characters in word1 and first j
 * characters in word2
 */

public class EditDistance {

    /*
     * find the LCS first? -no. LCS cannot guarantee the best solution
     * 
     * 2D dp is the right way
     */
    public class Solution {
	public int minDistance(String word1, String word2) {
	    int len1 = word1.length();
	    int len2 = word2.length();
	    if (len1 == 0 || len2 == 0) {
		return len1 == 0 ? len2 : len1;
	    }

	    int[][] dp = new int[len1 + 1][len2 + 1];

	    for (int i = 0; i <= len1; i++) {
		for (int j = 0; j <= len2; j++) {
		    if (i == 0) {
			dp[i][j] = j;
		    } else if (j == 0) {
			dp[i][j] = i;
		    } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
			dp[i][j] = dp[i - 1][j - 1];
		    } else {
			dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
				Math.min(dp[i - 1][j], dp[i][j - 1]));
		    }

		}
	    }

	    return dp[len1][len2];
	}

    }

    class Solution_2013 {
	public int minDistance(String word1, String word2) {
	    /*
	     * 1. deal with abnormal input cases
	     */
	    if (word1.length() == 0)
		return word2.length();
	    if (word2.length() == 0)
		return word1.length();

	    /*
	     * 2. build dp array
	     */
	    int[][] dp = new int[word1.length() + 1][word2.length() + 1];

	    /*
	     * 3. Initialize boundary conditions for dp array
	     */
	    for (int i = 0; i <= word1.length(); i++) {
		dp[i][0] = i;
	    }
	    for (int i = 0; i <= word2.length(); i++) {
		dp[0][i] = i;
	    }

	    /*
	     * 4.Fill out the rest blank of dp array
	     */
	    for (int i = 1; i <= word1.length(); i++) {
		for (int j = 1; j <= word2.length(); j++) {
		    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
			dp[i][j] = dp[i - 1][j - 1];
		    } else {
			int min = Math.min(
				Math.min(dp[i - 1][j], dp[i][j - 1]),
				dp[i - 1][j - 1]);
			dp[i][j] = min + 1;
		    }
		}
	    }

	    /*
	     * return the last element of dp array as result
	     */
	    return dp[word1.length()][word2.length()];
	}
    }

    /*
     * try using rolling array to save space, but incorrect answer?
     */
    public class WrongAttempt {
	public int minDistance(String word1, String word2) {
	    int len1 = word1.length();
	    int len2 = word2.length();
	    if (len1 == 0) {
		return len2;
	    } else if (len2 == 0) {
		return len1;
	    }

	    /*
	     * dp[i][j]: the minDistance of the first i characters in word1 and
	     * first j characters in word2
	     */
	    int dp[] = new int[len2 + 1];

	    for (int j = 0; j <= len2; j++) {
		dp[j] = j;
	    }
	    int pre = dp[0]; // previous d[i-1][j-1];

	    for (int i = 1; i <= len1; i++) {
		dp[0] = i;
		for (int j = 1; j <= len2; j++) {
		    int temp = dp[j];
		    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
			dp[j] = pre;
		    } else {
			dp[j] = 1 + Math.min(pre, Math.min(dp[j], dp[j - 1]));
		    }
		    pre = temp;
		}

	    }

	    return dp[len2];
	}
    }
}
