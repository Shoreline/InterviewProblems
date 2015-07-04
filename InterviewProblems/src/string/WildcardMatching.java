package string;

/**
 * Wildcard Matching
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character.
 * 
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * 
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * 
 * isMatch("aa","a") -> false
 * 
 * isMatch("aa","aa") -> true
 * 
 * isMatch("aaa","aa") -> false
 * 
 * isMatch("aa", "*") -> true
 * 
 * isMatch("aa", "a*") -> true
 * 
 * isMatch("ab", "?*") -> true
 * 
 * isMatch("aab", "c*a*b") -> false
 */
public class WildcardMatching {
    /*
     * Both s and p can contain '*' and/or '?'
     * 
     * DP: http://blog.csdn.net/linhuanmars/article/details/21198049
     * http://m4tiku.duapp.com/report?pid=123
     */
    public class Solution_DP {
	public boolean isMatch(String s, String p) {
	    boolean[] preFlag = new boolean[s.length() + 1];
	    boolean[] curFlag = new boolean[s.length() + 1];

	    int minCount = 0;
	    for (int i = 0; i < p.length(); i++) {
		if (p.charAt(i) != '*') {
		    minCount++;
		}
	    }
	    if (minCount > s.length()) {
		return false;
	    }

	    preFlag[0] = true;
	    for (int i = 0; i < p.length(); i++) {
		for (int j = 0; j <= s.length(); j++) {
		    if (p.charAt(i) == '?') {
			curFlag[j] = j == 0 ? false : preFlag[j - 1];
		    } else if (p.charAt(i) == '*') {
			curFlag[j] = j == 0 ? preFlag[j]
				: (preFlag[j] || curFlag[j - 1]);
		    } else {
			curFlag[j] = (j == 0 || p.charAt(i) != s.charAt(j - 1)) ? false
				: preFlag[j - 1];
		    }
		}
		boolean[] temp = preFlag;
		preFlag = curFlag;
		curFlag = temp;
	    }
	    return preFlag[s.length()];
	}
    }

    /*
     * memory limit exceeded. Cannot use 2D dp array.
     */
    public class Solution_DP_didnotpass {
	public boolean isMatch(String s, String p) {
	    if ((s == null && p == null) || s.length() == 0 && p.length() == 0) {
		return true;
	    }

	    int nonStar = 0;
	    for (int i = 0; i < p.length(); i++) {
		if (p.charAt(i) != '*') {
		    nonStar++;
		}
	    }
	    if (nonStar > s.length()) {
		return false;
	    }

	    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
	    dp[0][0] = true;

	    for (int i = 0; i < s.length(); i++) {

		for (int j = 1; j < p.length(); j++) {
		    if (i > 0 && p.charAt(j - 1) != '?'
			    && p.charAt(j - 1) != '*') {
			dp[i][j] = p.charAt(j - 1) == s.charAt(i - 1)
				&& dp[i - 1][j - 1];
		    } else if (i > 0 && p.charAt(j - 1) == '?') {
			dp[i][j] = dp[i - 1][j - 1];
		    } else if (p.charAt(j - 1) == '*') {
			if (dp[i][j - 1]) {
			    dp[i][j] = true;
			}
			if (i > 0) {
			    dp[i][j] = dp[i - 1][j - 1];
			}
		    }
		}
	    }

	    return dp[s.length()][p.length()];
	}
    }

    /*
     * very tricky
     * 
     * shall use a dp[lenS+1][lenS+1] 2d array.
     * 
     * if only use
     */
    public class Solution {
	public boolean isMatch(String s, String p) {
	    boolean[] preFlag = new boolean[s.length() + 1];
	    boolean[] curFlag = new boolean[s.length() + 1];
	    int minCount = 0;
	    for (int i = 0; i < p.length(); i++) {
		if (p.charAt(i) != '*') {
		    minCount++;
		}
	    }
	    if (minCount > s.length()) {
		return false;
	    }
	    /*
	     * since use rolling array to reduce space cost -> cannot initialize
	     * boundary conditions of a 2D dp array have to deal with boundary
	     * conditions with if
	     */

	    // important: the fist 0 char of s matches the first 0 char of p: ""
	    // matches ""
	    preFlag[0] = true;

	    /*
	     * first loop only scan lenP times, not lenP+1 times, because
	     * preFlag[] is equivalent to doing one scan
	     */

	    for (int i = 0; i < p.length(); i++) {
		for (int j = 0; j < s.length() + 1; j++) {
		    if (p.charAt(i) == '?') {
			curFlag[j] = j == 0 ? false : preFlag[j - 1];
		    } else if (p.charAt(i) == '*') {
			curFlag[j] = j == 0 ? preFlag[j]
				: (preFlag[j] || curFlag[j - 1]); // check j-1
								  // not j!
		    } else {
			curFlag[j] = (j == 0 || p.charAt(i) != s.charAt(j - 1)) ? false
				: preFlag[j - 1];
		    }
		}
		boolean[] temp = preFlag;
		preFlag = curFlag;
		curFlag = temp;
	    }
	    return preFlag[s.length()];
	}
    }

}
