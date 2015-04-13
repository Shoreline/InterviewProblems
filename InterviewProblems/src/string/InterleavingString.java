package string;

/**
 * Interleaving String
 * 
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true.
 * 
 * When s3 = "aadbbbaccc", return false.
 */

public class InterleavingString {

    /*
     * dp[i][j]: whether the first i characters in s1 and first j characters in
     * s2 can form the first i+j characters of s3
     * 
     * Check the rolling array version, no need additional initialization
     * process
     */
    public class Solution_DP {
	public boolean isInterleave(String s1, String s2, String s3) {
	    // missing deal with s1,s2,s3 is null cases...
	    if (s1.length() + s2.length() != s3.length()) {
		return false;
	    }

	    boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

	    dp[0][0] = true;
	    for (int i = 1; i <= s1.length(); i++) {
		// dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
		dp[i][0] = dp[i - 1][0]
			&& (s1.charAt(i - 1) == s3.charAt(i - 1));
	    }

	    for (int j = 1; j <= s2.length(); j++) {
		// dp[0][j] = s2.substring(0, j).equals(s3.substring(0, j));
		dp[0][j] = dp[0][j - 1]
			&& (s2.charAt(j - 1) == s3.charAt(j - 1));
	    }

	    /*
	     * easy to make mistake: in if check s3.charAt(i+j-1), not
	     * s3.charAt(i+j-2)!
	     */
	    for (int i = 1; i <= s1.length(); i++) {
		for (int j = 1; j <= s2.length(); j++) {
		    if (s1.charAt(i - 1) == s3.charAt(i + j - 1)
			    && dp[i - 1][j]
			    || s2.charAt(j - 1) == s3.charAt(i + j - 1)
			    && dp[i][j - 1]) {
			dp[i][j] = true;
		    } else {
			dp[i][j] = false;
		    }

		}
	    }

	    return dp[s1.length()][s2.length()];
	}
    }

    /*
     * Saves space.
     */
    class Solution_DP_RollingArray {
	public boolean isInterleave(String s1, String s2, String s3) {
	    if (s1.length() + s2.length() != s3.length())
		return false;
	    String minWord = s1.length() > s2.length() ? s2 : s1;
	    String maxWord = s1.length() > s2.length() ? s1 : s2;
	    boolean[] res = new boolean[minWord.length() + 1];
	    res[0] = true;
	    for (int i = 0; i < minWord.length(); i++) {
		res[i + 1] = res[i] && minWord.charAt(i) == s3.charAt(i);
	    }
	    for (int i = 0; i < maxWord.length(); i++) {
		res[0] = res[0] && maxWord.charAt(i) == s3.charAt(i);
		for (int j = 0; j < minWord.length(); j++) {
		    res[j + 1] = res[j + 1]
			    && maxWord.charAt(i) == s3.charAt(i + j + 1)
			    || res[j]
			    && minWord.charAt(j) == s3.charAt(i + j + 1);
		}
	    }
	    return res[minWord.length()];
	}
    }

    /*
     * Interesting way of initialization
     */
    class Solution_DP_2 {
	public boolean isInterleave(String s1, String s2, String s3) {
	    if (s3.length() != s1.length() + s2.length())
		return false;

	    boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
	    dp[0][0] = true;

	    for (int i = 1; i <= s1.length()
		    && s1.charAt(i - 1) == s3.charAt(i - 1); i++)
		dp[i][0] = true;

	    for (int i = 1; i <= s2.length()
		    && s2.charAt(i - 1) == s3.charAt(i - 1); i++)
		dp[0][i] = true;

	    for (int i = 1; i <= s1.length(); i++) {
		for (int j = 1; j <= s2.length(); j++) {
		    char c = s3.charAt(i + j - 1);
		    if (c == s1.charAt(i - 1) && dp[i - 1][j])
			dp[i][j] = true;

		    if (c == s2.charAt(j - 1) && dp[i][j - 1])
			dp[i][j] = true;
		}
	    }
	    return dp[s1.length()][s2.length()];
	}
    }

    /*
     * Tricky sanity check
     * 
     * My solution... follow one of high hand's solutions. cannot pass the large
     * set
     */
    public boolean isInterleaveMe(String s1, String s2, String s3) {

	if (s1 == null || s2 == null || s3 == null)
	    return false;

	int length1 = s1.length();
	int length2 = s2.length();
	int length3 = s3.length();

	if (length1 + length2 != length3)
	    return false;

	return isInterleaveMe(s1, s2, s3, 0, 0);

    }

    private boolean isInterleaveMe(String s1, String s2, String s3, int i, int j) {

	// when pass the end of both s1 and s2
	if (i + j == s3.length())
	    return true;

	if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
	    if (isInterleaveMe(s1, s2, s3, i + 1, j))
		return true;
	}

	if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
	    if (isInterleaveMe(s1, s2, s3, i, j + 1))
		return true;
	}

	return false;
    }

    /*
     * High hand's solution. Bottom-up DP. It can be solved faster by using
     * Top-down DP?
     * 
     * very good discussion here, many other solutions:
     * http://www.mitbbs.com/article_t1/JobHunting/32202217_0_1.html
     */

    /*
     * 
     */
    public boolean isInterleave(String s1, String s2, String s3) {
	if (s1 == null || s2 == null || s3 == null)
	    return false;

	int l1 = s1.length();
	int l2 = s2.length();
	int l3 = s3.length();
	if (l1 + l2 != l3)
	    return false;

	boolean[][] dp = new boolean[l1 + 1][l2 + 1];
	dp[l1][l2] = true;

	for (int i = l1; i >= 0; i--)
	    for (int j = l2; j >= 0; j--) {
		if (i < l1 && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j])
		    dp[i][j] = true;

		if (j < l2 && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1])
		    dp[i][j] = true;
	    }

	return dp[0][0];
    }
}
