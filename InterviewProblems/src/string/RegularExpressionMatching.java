package string;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * 
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") -> false isMatch("aa","aa") -> true
 * isMatch("aaa","aa") -> false isMatch("aa", "a*") -> true isMatch("aa", ".*")
 * -> true isMatch("ab", ".*") -> true isMatch("aab", "c*a*b") -> true
 */
public class RegularExpressionMatching {

    /*
     * DP: http://bangbingsyb.blogspot.com/2014/11/leetcode-regular-expression-
     * matching.html
     * 
     * O(M*N) time and O(M*N) space
     * 
     * dp[i][j]: if the first i characters in s and the first j characters in p
     * is a match
     */
    public class Solution {
	public boolean isMatch(String s, String p) {
	    if ((s == null && p == null) || s.length() == 0 && p.length() == 0) {
		return true;
	    }

	    int lenS = s.length();
	    int lenP = p.length();
	    boolean[][] dp = new boolean[lenS + 1][lenP + 1];
	    dp[0][0] = true;

	    for (int i = 0; i <= lenS; i++) {
		for (int j = 1; j <= lenP; j++) {
		    if (p.charAt(j - 1) != '.' && p.charAt(j - 1) != '*' && i > 0 && s.charAt(i - 1) == p.charAt(j - 1)
			    && dp[i - 1][j - 1]) {
			dp[i][j] = true;
		    } else if (p.charAt(j - 1) == '.' && i > 0 && dp[i - 1][j - 1]) {
			dp[i][j] = true;
		    } else if (p.charAt(j - 1) == '*' && j > 1) {
			// matches 1 or 0 of preceding character: p.charAt(j-1)
			if (dp[i][j - 1] || dp[i][j - 2]) {
			    dp[i][j] = true;
			}

			/*
			 * if * matches multiple preceding characters in s. Like
			 * s="abcc" and p="abc*" while i=4 and j=4: 1) The first
			 * j characters of p must also already matched the first
			 * i-1 and the first i-2 characters of s.
			 */
			if (i > 0 && dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
			    dp[i][j] = true;
			}
		    }
		}
	    }

	    return dp[lenS][lenP];
	}
    }

    /*
     * Understand the problem correctly. '*' means the number of the character
     * ahead of it, can be 0 to N. (so there must be a character ahead of '*')
     * 
     * '\0' (char c = 0) is a special control char, use it for null
     * 
     * corner case: s = "", p = "a*b*c*"; they still match
     */
    public class Solution_recursion2 {
	public boolean isMatch(String s, String p) {
	    if (p == null || p.isEmpty()) {
		return s == null || s.isEmpty();
	    }

	    if (p.length() > 1 && p.charAt(1) == '*') {
		return isMatch(s, p.substring(2)) || s != null && s.length() > 0
			&& (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p);
	    } else {
		return s != null && s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
			&& isMatch(s.substring(1), p.substring(1));
	    }
	}
    }

    class Solution_recursion {
	public boolean isMatch(String s, String p) {
	    if ((s == null && p == null) || s.length() == 0 && p.length() == 0) {
		return true;
	    }

	    if (p.length() == 0 && s.length() > 0) {
		return false;
	    }

	    char s0 = (s.length() > 0 ? s.charAt(0) : 0);
	    char p0 = p.charAt(0);
	    char p1 = (p.length() > 1 ? p.charAt(1) : 0);

	    if (p1 == '*') {
		if (isMatch(s, p.substring(2))) {
		    return true;
		}

		int i = 0;
		while (i < s.length() && (p0 == '.' || p0 == s.charAt(i))) {
		    if (isMatch(s.substring(i + 1), p.substring(2))) {
			return true;
		    }
		    i++;
		}

		return false;
	    } else if (s.length() != 0 && (p0 == '.' || p0 == s0)) {
		return isMatch(s.substring(1), p.substring(1));
	    } else {
		return false;
	    }
	}
    }

}
