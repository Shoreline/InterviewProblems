package string;

public class RegularExpressionMatching {
    /**
     * Implement regular expression matching with support for '.' and '*'.
     * 
     * '.' Matches any single character.
     * 
     * '*' Matches zero or more of the preceding element.
     * 
     * The matching should cover the entire input string (not partial).
     * 
     * The function prototype should be: bool isMatch(const char *s, const char
     * *p)
     * 
     * Some examples:
     * 
     * isMatch("aa","a") → false
     * 
     * isMatch("aa","aa") → true
     * 
     * isMatch("aaa","aa") → false
     * 
     * isMatch("aa", "a*") → true
     * 
     * isMatch("aa", ".*") → true
     * 
     * isMatch("ab", ".*") → true
     * 
     * isMatch("aab", "c*a*b") → true
     */

    /*
     * My thoughts: two pointers, starting form the end of each String
     */

    /*
     * A high hand: http://blog.csdn.net/hopeztm/article/details/7992253
     * 
     * 其实核心的思路是一个动态规划
     * 
     * dp[i][j]表示字串 s[i...len(s)], p[j...len(p)] 是否可以匹配。
     * 
     * 那么状态转移方程如下：
     * 
     * dp[i][j] =
     * 
     * c1. p[j+1] != *. if s[i] == p[j] dp[i][j] = dp[i+1][j+1]
     * 
     * else dp[i][j] = false
     * 
     * c2 p[j+1] == '*' (这个情况下，要扩展 *, dp[i][j] 从拓展的情况下，选择一个是真的结果）
     * 
     * if( s[i] == p[j] || p[j] == '.' && (*s) != 0) 当s[i] 和 p[j] 一样的时候，例如 aba,
     * a*b这个时候，i = 0, j = 0, 自然可以匹配a a
     * 
     * 如果p[j] == . 因为他可以匹配任何字符，所以和相等关系有基本一样的方式。
     * 
     * 并且每一步匹配都要递增 i 的值，如果有成立的，则返回true，否则到匹配终了，返回通配符匹配完成后的结果。
     */

    /*
     * Recursion shall be enough.
     * 
     * many corner cases.
     * 
     * not finished
     */
    public boolean isMatch(String s, String p) {
	if (s == null || p == null) {
	    return false;
	}
	if (p.length() == 0) {
	    return true;
	}

	return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int m, String p, int n) {

	if (m == s.length() && n == p.length()) {
	    return true;
	}

	if (s.charAt(m) == p.charAt(n) || p.charAt(n) == '.') {
	    return isMatch(s, m + 1, p, n + 1);
	} else {
	    if (p.charAt(n) == '*') {
		if (p.length() == n + 1)
		    return true;

	    }
	}

	return false;
    }
}
