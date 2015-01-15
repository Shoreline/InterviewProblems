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
     * Some examples: isMatch("aa","a") → false 
     * isMatch("aa","aa") → true
     * isMatch("aaa","aa") → false 
     * isMatch("aa", "a*") → true 
     * isMatch("aa", ".*") → true 
     * isMatch("ab", ".*") → true 
     * isMatch("aab", "c*a*b") → true
     */

    /*
     * Understand the problem correctly. '*' means the number of the character
     * ahead of it, can be 0 to N
     * 
     * '\0' (char c = 0) is a special control char, use it for null
     * 
     * corner case: s = "", p = "a*b*c*"; they still match
     */
    class solution2 {
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

    /*
     * Recursion shall be enough.
     * 
     * many corner cases.
     * 
     * not finished
     */
    class solution1 {
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
}
