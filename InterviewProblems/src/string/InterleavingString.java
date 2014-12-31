package string;

public class InterleavingString {
    /**
     * Interleaving String
     * 
     * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and
     * s2.
     * 
     * For example, Given: s1 = "aabcc", s2 = "dbbca",
     * 
     * When s3 = "aadbbcbcac", return true.
     * 
     * When s3 = "aadbbbaccc", return false.
     */

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
