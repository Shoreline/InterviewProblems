package string;

public class DistinctSubsequences {
    /**
     * Distinct Subsequences
     * 
     * Given a string S and a string T, count the number of distinct
     * subsequences of T in S.
     * 
     * A subsequence of a string is a new string which is formed from the
     * original string by deleting some (can be none) of the characters without
     * disturbing the relative positions of the remaining characters. (ie, “ACE”
     * is a subsequence of “ABCDE” while “AEC” is not).
     * 
     * Here is an example: S = “rabbbit”, T = “rabbit” Return 3.
     */

    /*
     * 本题题意是给你两个字符串x和z. 问你在x中有多少个z.可以简单的DP加上递推。对与a[i][j]代表长度j个母串中，出现多少个长度为i个子串。
     * 如果第i个字母和j个字母不相同
     * ，则可以转化为a[i][j]=a[i][j-1];可以理解为长度为i的子串在长度为j的母串和长度为j-1的母串出现次数相同。
     * 如果第i个字母和j个字母相同
     * ，这可以转化为a[i][j]=a[i][j-1]+a[i-1][j-1]；理解为加上i-1的子串在j-1的子串出现次数。
     * 初始化a[0][0]~a[0][s1.length()]为1,即0长度的子串在0的母串中出现次数为1。
     * 子串长度100，母串10000，最多次数10的100次方，用java大数。
     */

    /*
     * DP thoughts
     */

    public static int numDistinct(String S, String T) {
	int[][] dp = new int[T.length() + 1][S.length() + 1];

	for (int i = 0; i <= S.length(); i++) {
	    dp[0][i] = 1;
	    dp[i][0] = 0; // it is unnecessary, but helps us understand
	}

	for (int i = 1; i <= T.length(); i++) {
	    for (int j = 1; j <= S.length(); j++) {
		if (S.charAt(j - 1) == T.charAt(i - 1)) {
		    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
		} else {
		    dp[i][j] = dp[i][j - 1];
		}
	    }
	}

	return dp[T.length()][S.length()];
    }
}
